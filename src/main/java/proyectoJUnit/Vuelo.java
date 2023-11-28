package proyectoJUnit;

public class Vuelo {
    private String id;
    private String origen;
    private String destino;
    private int duracion;
    private int asientos;
    private int asientosDisponibles;

    public Vuelo(String id, String origen, String destino, int duracion, int asientos) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.asientos = asientos;
        this.asientosDisponibles = asientos;
    }

    public String getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    // public int getDuracion() {
    //     return duracion;
    // }

    public int getAsientos() {
        return asientos;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public void mostrar() {
        System.out.println("Vuelo " + id + " de " + origen + " a " + destino + " (" + duracion + " minutos)");
    }

    public void mostrarAsientos() {
        System.out.println("Vuelo " + id + " de " + origen + " a " + destino + " (" + duracion + " minutos)");
        System.out.println("Asientos disponibles: " + asientosDisponibles);
    }

    public Boolean reservarAsiento(int cantidad) {
        if (asientosDisponibles >= cantidad) {
            asientosDisponibles -= cantidad;
            System.out.println("Reserva exitosa");
            return true;
        } else {
            return false;
        }
    }

    public void cancelarReserva(int cantidad) {
        if (asientosDisponibles + cantidad <= asientos) {
            asientosDisponibles += cantidad;
            System.out.println("Cancelación exitosa");
        } else {
            System.out.println("No se puede cancelar esa cantidad de asientos");
        }
    }

    public void mostrarInfo() {
        System.out.println("Vuelo " + id + " de " + origen + " a " + destino + " (" + duracion + " minutos)");
        System.out.println("Asientos disponibles: " + asientosDisponibles);
        System.out.println("Asientos ocupados: " + (asientos - asientosDisponibles));
    }

}
