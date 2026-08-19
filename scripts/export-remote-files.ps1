param(
    [string]$OutDir = "..\remote_files",
    [string]$Zip = "..\remote_files.zip",
    [switch]$All
)

function Write-ErrAndExit($msg) {
    Write-Host "ERROR: $msg" -ForegroundColor Red
    exit 1
}

if (-not (Get-Command git -ErrorAction SilentlyContinue)) {
    Write-ErrAndExit 'git not found in PATH. Install Git or run in an environment with git available.'
}

$repoRoot = (& git rev-parse --show-toplevel) 2> $null
if (-not $repoRoot) {
    Write-ErrAndExit 'Not inside a git repository. Run this script from within your repo.'
}

Set-Location $repoRoot

# detect remote default branch
$symref = (& git ls-remote --symref origin HEAD) 2> $null
$remoteBranch = $null
if ($symref) {
    $m = [regex]::Match($symref, 'ref: refs/heads/(?<b>[^\s]+)\s+HEAD')
    if ($m.Success) { $remoteBranch = $m.Groups['b'].Value }
}
if (-not $remoteBranch) { $remoteBranch = 'main' }

Write-Host "Remote default branch: $remoteBranch"

# fetch origin
Write-Host 'Fetching origin...'
& git fetch origin || Write-ErrAndExit 'git fetch failed.'

# create a temporary branch from remote (won't touch current branches)
$ts = (Get-Date).ToString('yyyyMMddHHmmss')
$tmpBranch = "remote-copy-$ts"
Write-Host "Creating temporary branch $tmpBranch from origin/$remoteBranch"
& git checkout -b $tmpBranch "origin/$remoteBranch" || Write-ErrAndExit 'Could not create temporary branch from remote.'

# determine local comparison branch (master or main)
$compareBranch = $null
if (& git rev-parse --verify master 2>$null) { $compareBranch = 'master' }
elseif (& git rev-parse --verify main 2>$null) { $compareBranch = 'main' }
else { $compareBranch = 'master' }

Write-Host "Comparing $compareBranch...$tmpBranch"

if ($All) {
    $files = @('.')
} else {
    $files = & git diff --name-only "$compareBranch...$tmpBranch"
    if (-not $files) { $files = @() }
}

if (-not (Test-Path $OutDir)) { New-Item -ItemType Directory -Path $OutDir | Out-Null }
else { Remove-Item -Recurse -Force $OutDir\* -ErrorAction SilentlyContinue }

if ($files.Count -eq 0 -and -not $All) {
    Write-Host 'No differing files found between branches.'
    Write-Host "If you want the entire remote tree, re-run with -All."
    Write-Host "Removing temporary branch $tmpBranch and exiting."
    & git checkout - >/dev/null 2>&1
    & git branch -D $tmpBranch >/dev/null 2>&1
    exit 0
}

if ($All) {
    Write-Host 'Exporting full remote tree to output folder...'
    & git --work-tree="$OutDir" checkout $tmpBranch -- . || Write-ErrAndExit 'Checkout to work-tree failed.'
} else {
    Write-Host 'Exporting changed files to output folder...'
    # prepare a safe list of files
    $fileArray = @()
    foreach ($f in $files) {
        if ($f -and $f.Trim() -ne '') { $fileArray += $f }
    }
    if ($fileArray.Count -eq 0) { Write-ErrAndExit 'No files to export.' }
    & git --work-tree="$OutDir" checkout $tmpBranch -- $fileArray || Write-ErrAndExit 'Checkout of specific files failed.'
}

Write-Host "Creating ZIP archive at: $Zip"
if (Test-Path $Zip) { Remove-Item $Zip -Force }
Compress-Archive -Path (Join-Path $OutDir '*') -DestinationPath $Zip -Force || Write-ErrAndExit 'Compression failed.'

Write-Host 'Cleanup: deleting temporary branch and restoring previous HEAD.'
& git checkout - >/dev/null 2>&1
& git branch -D $tmpBranch >/dev/null 2>&1

Write-Host "Done. Exported files are in: $OutDir and archive: $Zip"
