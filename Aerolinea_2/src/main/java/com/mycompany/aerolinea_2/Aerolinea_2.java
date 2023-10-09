package com.mycompany.aerolinea_2;

import javax.swing.JOptionPane;

/**
 *
 * @author felipeaguilerafuentealba
 */
public class Aerolinea_2 {

    public static void main(String[] args) {

        Vuelo vuelo = new Vuelo();
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1.- Ver asientos disponibles \n"
                        + "2.- Comprar asiento \n"
                        + "3.- Anular vuelo \n"
                        + "4.- Salir \n"
                        + "Elige una opción", "Áerolinea Delta 123",
                        JOptionPane.QUESTION_MESSAGE));

                switch (opcion) {
                    case 1:
                        vuelo.verAsientosDisponibles();
                        break;

                    case 2:
                        Persona pasajero = new Persona();

                        pasajero.setNombre(leerNombre());
                        pasajero.setRut(leerRut());
                        pasajero.setTelefono(leerTelefono());

                        int asiento = leerAsiento();

                        vuelo.comprarAsiento(pasajero, asiento);

                        break;

                    case 3:
                        vuelo.anularVuelo();
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Programa finalizado");
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "ERROR" + n.getMessage());
            }

        } while (opcion != 4);
    }

    //Metodos propios
    private static String leerNombre() {
        return JOptionPane.showInputDialog("Ingrese el nombre del Pasajero");
    }

    private static String leerRut() {
        return JOptionPane.showInputDialog("Ingresa el RUT del Pasajero");
    }

    private static String leerTelefono() {
        return JOptionPane.showInputDialog("Ingresa el número de Teléfono del Pasajero");
    }

    private static int leerAsiento() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de Asiento del Pasajero"));
    }
}
