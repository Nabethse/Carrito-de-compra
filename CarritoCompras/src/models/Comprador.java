package models;

import java.util.Random;

public class Comprador  extends Usuario {
    public CarritoCompras carrito;

    public Comprador(String id) {
        super(id, "comprador");
        carrito = new CarritoCompras();
    }
    public String generarReferenciaPago() {
        Random random = new Random();
        int referenciaPago = random.nextInt(10000);

        return String.valueOf(referenciaPago);
    }
}

