package n3exercici1;

import java.util.Objects;

public class Butaca {

    private int nombreFila;
    private int nombreSeient;
    private String nomPersonaReserva;

    // Constructor with all attributes
    public Butaca(int nombreFila, int nombreSeient, String nomPersonaReserva) {
        this.nombreFila = nombreFila;
        this.nombreSeient = nombreSeient;
        this.nomPersonaReserva = nomPersonaReserva;
    }

    // Getters
    public int getNombreFila() {
        return nombreFila;
    }

    public int getNombreSeient() {
        return nombreSeient;
    }

    public String getNomPersonaReserva() {
        return nomPersonaReserva;
    }


    /* This method compares two instances of seat by row and number of seat at row */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Butaca butaca = (Butaca) o;
        return nombreFila == butaca.nombreFila && nombreSeient == butaca.nombreSeient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreFila, nombreSeient);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Fila: ").append(nombreFila);
        sb.append(", Seient: ").append(nombreSeient);
        sb.append(", Persona: ").append(nomPersonaReserva);
        return sb.toString();
    }


}
