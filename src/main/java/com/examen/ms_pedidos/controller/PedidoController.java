package com.examen.ms_pedidos.controller;

import com.examen.ms_pedidos.dto.PedidoRequestDTO;
import com.examen.ms_pedidos.entity.Pedido;
import com.examen.ms_pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // ✅ Crear pedido
    @PostMapping
    public ResponseEntity<Pedido> crear(@Valid @RequestBody PedidoRequestDTO dto) {
        return ResponseEntity.ok(service.crearPedido(dto));
    }

    // ✅ Listar pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(service.listarPedidos());
    }

    // ✅ Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // ✅ Actualizar estado (PATCH)
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Pedido> actualizarEstado(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {

        String estado = request.get("estado");
        return ResponseEntity.ok(service.actualizarEstado(id, estado));
    }

    // ✅ Eliminar pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
