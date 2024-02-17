package models;
import java.util.ArrayList;
public class CarritoCompras {
    ArrayList<Producto> productos = new ArrayList<>();

    public boolean agregarProducto(Producto producto) {
        boolean status = productos.add(producto);
        return status;
    }

    public double calcularTotal() {
        double total =0;
        int size = productos.size();
        for (int i =0;i<size; i++ ){
            Producto producto = productos.get(i);
            int cantidad = Integer.parseInt(producto.getCantidad());
            total += producto.getPrecio()*cantidad;
        }
        return total;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
