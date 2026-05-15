package com.examen.ms_pedidos.service;

import com.examen.ms_pedidos.dto.PedidoRequestDTO;
import com.examen.ms_pedidos.entity.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido crearPedido(PedidoRequestDTO dto);

    List<Pedido> listarPedidos();

    Pedido buscarPorId(Long id);

    Pedido actualizarEstado(Long id, String estado);

    void eliminar(Long id);
}