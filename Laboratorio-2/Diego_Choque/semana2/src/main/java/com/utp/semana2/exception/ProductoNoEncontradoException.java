package com.utp.semana2.exception;

//Cambio del mensaje de error 
public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(Long id) {
        super("Producto no encontrado en el inventario con el identificador: " + id);
    }
}