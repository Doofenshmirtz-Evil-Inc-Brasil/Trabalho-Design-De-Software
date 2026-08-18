/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: ShipmentController.java
 *
 * Finalidade:
 * API REST (Aula 08): expõe o caso de uso de criação de remessa (CreateShipmentUseCase,
 * já existente desde as aulas de domínio) como um endpoint HTTP, consumido pelo frontend Angular.
 *
 * Leitura recomendada em aula:
 * 1) note que a lógica de negócio (CreateShipmentUseCase) não muda — só ganha uma porta HTTP;
 * 2) essa separação entre "o que o sistema faz" e "como se chega até ele" é uma decisão arquitetural.
 */
package br.edu.nexuslog.api;

import br.edu.nexuslog.application.CreateShipmentUseCase;
import br.edu.nexuslog.domain.Shipment;
import br.edu.nexuslog.events.ShipmentEventPublisher;
import br.edu.nexuslog.service.SimpleFreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final CreateShipmentUseCase createShipmentUseCase = new CreateShipmentUseCase();

    @Autowired
    private SimpleFreightService freightService;

    @Autowired
    private ShipmentEventPublisher eventPublisher;

    @PostMapping
    public ResponseEntity<Shipment> criar(@RequestBody CriarShipmentRequest request) {
        Shipment shipment = createShipmentUseCase.execute(
            request.id(), request.customerName(), request.weightKg());
        eventPublisher.publicarShipmentCriado(shipment);
        return ResponseEntity.ok(shipment);
    }

    @GetMapping("/{id}/frete")
    public ResponseEntity<Double> calcularFrete(
            @PathVariable String id,
            @RequestParam String customerName,
            @RequestParam double weightKg,
            @RequestParam String freightType) {
        Shipment shipment = new Shipment(id, customerName, weightKg);
        double preco = freightService.calculate(shipment, freightType);
        return ResponseEntity.ok(preco);
    }

    public record CriarShipmentRequest(String id, String customerName, double weightKg) {}
}
