package ar.edu.uade.banco;

public enum Moneda {
    PESO("P"),
    DOLAR("D");

    private final String nombreCorto;

    private Moneda(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public boolean permiteDescubierto() {
        return this == PESO;
    }

    public String getNombreCorto() {
        return this.nombreCorto;
    }
}
