package com.examen.pedidos.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PedidoRequestDTO {

    @NotBlank(message = "El cliente no debe estar vacío")
    private String cliente;

    @NotBlank(message = "El correo no debe estar vacío")
    @Email(message = "Correo inválido")
    private String correoCliente;

    @NotNull(message = "El productoId es obligatorio")
    private Long productoId;

    @NotBlank(message = "El nombre del producto no debe estar vacío")
    private String nombreProducto;

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @NotNull(message = "El precio unitario es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private BigDecimal precioUnitario;
}