import java.util.ArrayList;
import java.util.Scanner;
import models.Producto;
import models.Empresa;
import models.Comprador;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Scanner scanner = new Scanner(System.in);

        int opcionMenuPrincipal;
        do {
            System.out.println("Bienvenido a la tienda online.");
            System.out.println("1. Comprador");
            System.out.println("2. Administrador");
            System.out.println("3. Salida");
            System.out.print("Selecciona una opción: ");
            opcionMenuPrincipal = scanner.nextInt();

            switch (opcionMenuPrincipal) {
                case 1:
                    menuComprador(scanner, empresa);
                    break;
                case 2:
                    menuAdministrador(scanner, empresa);
                    break;
                case 3:
                    System.out.println("Gracias por visitar la tienda online. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }
        } while (opcionMenuPrincipal != 3);
    }

    private static void menuComprador(Scanner scanner, Empresa empresa) {
        int opcionMenuComprador;
        do {
            System.out.println("\nMenú Comprador:");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar al carrito");
            System.out.println("3. Ver productos del carrito");
            System.out.println("4. Obtener referencia de pago");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcionMenuComprador = scanner.nextInt();

            switch (opcionMenuComprador) {
                case 1:
                    verProductos(empresa.inventario.getProductos());
                    break;
                case 2:
                    agregarAlCarrito(scanner, empresa);
                    break;
                case 3:
                    verProductosDelCarrito(empresa.comprador.carrito.getProductos());
                    break;
                case 4:
                    obtenerReferenciaDePago(empresa.comprador);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }
        } while (opcionMenuComprador != 5);
    }

    private static void menuAdministrador(Scanner scanner, Empresa empresa) {
        int opcionMenuAdmin;
        do {
            System.out.println("\nMenú Administrador:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Validar carrito");
            System.out.println("3. Mostrar carrito");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcionMenuAdmin = scanner.nextInt();

            switch (opcionMenuAdmin) {
                case 1:
                    agregarProducto(scanner, empresa);
                    break;
                case 2:
                    validarCarrito(empresa);
                    break;
                case 3:
                    verProductosDelCarrito(empresa.comprador.carrito.getProductos());
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }
        } while (opcionMenuAdmin != 4);
    }

    private static void verProductos(ArrayList<Producto> productos) {
        System.out.println("\nLista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecio());
        }
    }

    private static void agregarAlCarrito(Scanner scanner, Empresa empresa) {
        System.out.println("\nSeleccione el producto que desea agregar al carrito:");
        verProductos(empresa.inventario.getProductos());

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.next();
        System.out.print("Ingrese la cantidad: ");
        String cantidad = scanner.next();

        for (int i = 0; i < empresa.inventario.getProductos().size(); i++) {
            Producto producto = empresa.inventario.getProductos().get(i);
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                empresa.comprador.carrito.agregarProducto(new Producto(producto.getNombre(), producto.getPrecio(), cantidad));
                System.out.println("Producto agregado al carrito exitosamente.");
                return;
            }
        }

        System.out.println("Producto no encontrado en el inventario.");
    }

    private static void verProductosDelCarrito(ArrayList<Producto> productos) {
        System.out.println("\nProductos en el carrito:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
    }

    private static void obtenerReferenciaDePago(Comprador comprador) {
        String referenciaPago = comprador.generarReferenciaPago();
        System.out.println("Referencia de pago generada: " + referenciaPago);
    }

    private static void agregarProducto(Scanner scanner, Empresa empresa) {
        System.out.print("Ingrese el nombre del nuevo producto: ");
        String nombreProducto = scanner.next();
        System.out.print("Ingrese el precio del nuevo producto: ");
        double precioProducto = scanner.nextDouble();

        Producto nuevoProducto = new Producto(nombreProducto, precioProducto, "1");
        empresa.inventario.addProducto(nuevoProducto);

        System.out.println("Producto agregado al inventario exitosamente.");
    }

    private static void validarCarrito(Empresa empresa) {
        double total = empresa.comprador.carrito.calcularTotal();
        if (total > 0) {
            System.out.println("El total a pagar es: $" + total);
            System.out.println("Referencia de pago generada y enviada al comprador.");
        } else {
            System.out.println("El carrito está vacío.");
        }
    }
}

