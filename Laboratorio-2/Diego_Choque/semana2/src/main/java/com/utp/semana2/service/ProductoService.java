package com.utp.semana2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.utp.semana2.dto.ProductoRequest;
import com.utp.semana2.exception.ProductoNoEncontradoException;
import com.utp.semana2.model.Producto;

@Service
public class ProductoService {

    // Almacenamiento en memoria seguro para hilos concurrentes
    private final Map<Long, Producto> productos = new ConcurrentHashMap<>();
    private final AtomicLong secuencia = new AtomicLong(0);

    // Constructor: cargamos datos iniciales de prueba actualizados y desarrollados
    // del ejercicios 5
    public ProductoService() {
        crear(new ProductoRequest("Laptop Lenovo", 3500.00, 8));
        crear(new ProductoRequest("Mouse Logitech", 80.00, 25));
        crear(new ProductoRequest("Teclado mecánico", 240.00, 12));
        crear(new ProductoRequest("Auriculares HyperX", 180.00, 15)); // Producto inicial adicional
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos.values());
    }

    public Producto buscarPorId(Long id) {
        Producto producto = productos.get(id);
        if (producto == null) {
            throw new ProductoNoEncontradoException(id);
        }
        return producto;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        String texto = nombre.toLowerCase();
        return productos.values().stream()
                .filter(p -> p.getNombre().toLowerCase().contains(texto))
                .toList();
    }

    // Desarrollo de Endpoint para listar productos con stock bajo
    public List<Producto> buscarPorStockBajo(int limite) {
        return productos.values().stream()
                .filter(p -> p.getStock() <= limite)
                .toList();
    }

    // Desarrollo de Endpoint para listar productos por rango de precio mayor
    public List<Producto> buscarPorPrecioMayor(double precio) {
        return productos.values().stream()
                .filter(p -> p.getPrecio() > precio)
                .toList();
    }

    public Producto crear(ProductoRequest request) {
        validar(request);
        Long nuevoId = secuencia.incrementAndGet();
        Producto producto = new Producto(
                nuevoId,
                request.nombre(),
                request.precio(),
                request.stock());
        productos.put(nuevoId, producto);
        return producto;
    }

    public Producto actualizar(Long id, ProductoRequest request) {
        validar(request);
        Producto producto = buscarPorId(id);
        producto.setNombre(request.nombre());
        producto.setPrecio(request.precio());
        producto.setStock(request.stock());
        return producto;
    }

    public void eliminar(Long id) {
        Producto eliminado = productos.remove(id);
        if (eliminado == null) {
            throw new ProductoNoEncontradoException(id);
        }
    }

    // Se agrego validación Validación que el nombre al menos tenga 3 caracteres
    private void validar(ProductoRequest request) {
        if (request.nombre() == null || request.nombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio.");
        }
        if (request.nombre().trim().length() < 3) {
            throw new IllegalArgumentException("El nombre del producto debe tener al menos 3 caracteres.");
        }
        if (request.precio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        if (request.stock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }
}