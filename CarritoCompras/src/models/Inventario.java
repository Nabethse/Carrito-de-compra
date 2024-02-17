package models;
import java.util.ArrayList;
public class Inventario {
   private ArrayList<Producto> productos = new ArrayList<>();

    public boolean addProducto(Producto producto) {
       boolean status = productos.add(producto);
       return status;
    }
    public  ArrayList<Producto> getProductos(){
        return productos;
    }
}

