package proyectoJUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
    	
    	Scanner scanner = new Scanner(System.in);

        String[] letra = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                          "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
                          "U", "V", "W", "X", "Y", "Z"};

        String[] numero = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        List<String> reservas = new ArrayList<String>();
        String reserva;

        int cantidadVuelos = (int) (Math.random() * 6) + 5;
        Vuelo[] vuelos = new Vuelo[cantidadVuelos];
        String[] destinos = {"Buenos Aires", "Lima", "Bogotá", "Sao Paulo", "Ciudad de México", "Madrid", "Miami", "Nueva York", "Los Ángeles", "Toronto", "Londres", "París", "Roma", "Berlín", "Tokio", "Pekín", "Seúl", "Sídney", "Melbourne", "Auckland"};
        for (int i = 0; i < cantidadVuelos; i++) {
            String id = letra[(int) (Math.random() * letra.length)] + numero[(int) (Math.random() * numero.length)] + numero[(int) (Math.random() * numero.length)];
            String origen = "Santiago de Chile";
            String destino = destinos[(int) (Math.random() * destinos.length)];
            int duracion = (int) (Math.random() * 1000) + 1;
            int asientos = (int) (Math.random() * 100) + 1;
            vuelos[i] = new Vuelo(id, origen, destino, duracion, asientos);
        }

        System.out.println("Bienvenido al aeropuerto de Santiago de Chile");
        System.out.println("Ingrese su nombre y apellido para comenzar");

        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su apellido:");
        String apellido = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido);

        System.out.println("Bienvenido " + cliente.getNombre() + " " + cliente.getApellido());

        System.out.println("Seleccione una opción:");
        System.out.println("1. Reservar un vuelo");
        System.out.println("2. Cancelar una reserva");
        System.out.println("3. Salir");
        
        int opcion = Integer.parseInt(scanner.nextLine());

        while (opcion != 3) {
            switch (opcion) {

                case 1:
                    System.out.println("Seleccione un vuelo:");

                    for (int i = 0; i < vuelos.length; i++) {
                        System.out.println((i + 1) + ". " + vuelos[i].getId() + " " + vuelos[i].getOrigen() + " - " + vuelos[i].getDestino());
                    }

                    int vueloSeleccionado = Integer.parseInt(scanner.nextLine());
                    System.out.println("Seleccione la cantidad de asientos:");
                    vuelos[vueloSeleccionado - 1].mostrarAsientos();
                    int cantidad = Integer.parseInt(scanner.nextLine());

                    if (vuelos[vueloSeleccionado - 1].reservarAsiento(cantidad)) {
                        String buffer = "[" + cliente.getNombre() + " " + cliente.getApellido() + ", " + (int) Math.floor(Math.random() * 100000) + "]";
                        reserva = "[pasajero: " + cliente.getNombre() + " " + cliente.getApellido() +", asientos: " + cantidad + ", vuelo: " + vuelos[vueloSeleccionado - 1].getId() + "]";
                        reservas.add(reserva);
                        System.out.println(buffer);
                    } else {
                        System.out.println("No hay asientos disponibles");
                    }
                    break;

                case 2:
                    System.out.println("Seleccione una reserva:");

                    for (int i = 0; i < reservas.size(); i++) {
                        System.out.println((i + 1) + ". " + reservas.get(i));
                    }

                    int reservaSeleccionada = Integer.parseInt(scanner.nextLine());
                    String reservaCancelada = reservas.remove(reservaSeleccionada - 1);
                    System.out.println("Reserva cancelada: " + reservaCancelada);
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
            System.out.println("Seleccione una opción:");
            System.out.println("1. Reservar un vuelo");
            System.out.println("2. Cancelar una reserva");
            System.out.println("3. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Gracias por usar nuestro servicio");
        scanner.close();


    }
}
