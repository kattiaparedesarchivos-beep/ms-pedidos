package com.examen.pedidos.service;

import com.examen.pedidos.dto.PedidoRequestDTO;
import com.examen.pedidos.entity.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido crearPedido(PedidoRequestDTO dto);

    List<Pedido> listarPedidos();

    Pedido buscarPorId(Long id);

    Pedido actualizarEstado(Long id, String estado);

    void eliminar(Long id);
}