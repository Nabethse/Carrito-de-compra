package models;

public class Empresa {
    public Comprador comprador;
   private Administrador administrador;
     public Inventario inventario;

    public Empresa() {
        comprador = new Comprador("user_01");
        administrador = new Administrador("user_02");
        inventario = administrador.inventario;
    }
}
