package com.examen.ms_pedidos.service;

import com.examen.ms_pedidos.dto.PedidoRequestDTO;
import com.examen.ms_pedidos.entity.Pedido;
import com.examen.ms_pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido crearPedido(PedidoRequestDTO dto) {

        Pedido pedido = new Pedido();

        pedido.setCliente(dto.getCliente());
        pedido.setCorreoCliente(dto.getCorreoCliente());
        pedido.setProductoId(dto.getProductoId());
        pedido.setNombreProducto(dto.getNombreProducto());
        pedido.setCantidad(dto.getCantidad());
        pedido.setPrecioUnitario(dto.getPrecioUnitario());

        // 🔥 CÁLCULO IMPORTANTE DEL EXAMEN
        pedido.setTotal(dto.getPrecioUnitario()
                .multiply(BigDecimal.valueOf(dto.getCantidad())));

        pedido.setEstado("REGISTRADO");
        pedido.setFechaPedido(LocalDateTime.now());

        return repository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return repository.findAll();
    }

    @Override
    public Pedido buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    @Override
    public Pedido actualizarEstado(Long id, String estado) {
        Pedido pedido = buscarPorId(id);
        pedido.setEstado(estado);
        return repository.save(pedido);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}