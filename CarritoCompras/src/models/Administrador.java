package models;
import java.util.Random;

public class Administrador extends Usuario{
    Inventario inventario;

    public Administrador(String id) {
        super(id, "administrador");
        inventario = new Inventario();
    }
}

