package com.mycompany.aerolinea_2;

/**
 *
 * @author felipeaguilerafuentealba
 */
public class Asiento {
    //Atributos

    private int nAsiento;
    private boolean disponible;
    private double precio;

    private static final double PRECIO_VIP = 240000.0;
    private static final double PRECIO_NORMAL = 78900.0;

    //Constructores
    public Asiento() {
    }

    public Asiento(int nAsiento) {
        this.nAsiento = nAsiento;
        this.disponible = true;
        this.precio = (nAsiento >= 31) ? PRECIO_VIP : PRECIO_NORMAL;
    }

    //Get y Set
    public int getnAsiento() {
        return nAsiento;
    }

    public void setnAsiento(int nAsiento) {
        this.nAsiento = nAsiento;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Metodos es vip
    public boolean esVip() {
        return nAsiento >= 31;
    }

    //Metodo Vender
    public void vender() {
        disponible = false;
    }
}
