package com.mycompany.aerolinea_2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author felipeaguilerafuentealba
 */
public class Vuelo {
    //Arreglo que almacena los 42 asientos del avión

    private Asiento[] asientos = new Asiento[42];

    //Constructor
    public Vuelo() {
        //Instanciando el arreglo
        asientos = new Asiento[42];
        //Recorro el arreglo
        for (int i = 0; i < 42; i++) {
            asientos[i] = new Asiento(i + 1);
        }
    }

    //Metodos
    public void verAsientosDisponibles() {
        JFrame frame = new JFrame("Asientos Disponibles");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane);
        frame.add(panel);

        StringBuilder asientosStr = new StringBuilder();

        for (int i = 0; i < asientos.length; i++) {
            if (i % 6 == 0) {
                asientosStr.append("\n"); // Cambiar de fila después de cada 6 asientos
            }
            if (i % 6 < 3) {
                asientosStr.append(" "); // Espacio entre las dos columnas de asientos
            }
            if (i == 30) {
                asientosStr.append("\n--------------------\n"); // Separar asientos VIP
            }

            if (asientos[i].isDisponible()) {
                asientosStr.append(asientos[i].getnAsiento()).append(" ");
            } else {
                asientosStr.append("X ");
            }
        }

        textArea.setText(asientosStr.toString());

        frame.setVisible(true);
    }

    public void comprarAsiento(Persona pasajero, int numeroAsiento) {
        Asiento asiento = buscarAsiento(numeroAsiento);

        if (asiento != null && asiento.isDisponible()) {
            // Preguntar al pasajero si es VIP
            String[] opciones = {"Sí", "No"};
            int respuesta = JOptionPane.showOptionDialog(null, "¿Es usted un pasajero VIP?", "Confirmación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            double precioPasaje = asiento.getPrecio();
            String tipoPasajero = "Normal";

            if (respuesta == JOptionPane.YES_OPTION) {
                // Si el pasajero es VIP, aplicar el descuento del 15%
                precioPasaje *= 0.85;
                tipoPasajero = "VIP";
            }

            asiento.vender();

            JOptionPane.showMessageDialog(null, "Vendido asiento " + numeroAsiento + " para " + pasajero.getNombre()
                    + "\nTipo de Pasajero: " + tipoPasajero
                    + "\nPrecio del Pasaje: $" + precioPasaje);

        } else {
            JOptionPane.showMessageDialog(null, "Asiento no disponible");
        }
    }

    public void anularVuelo() {
        // Marcar todos como disponibles
        for (Asiento asiento : asientos) {
            asiento.setDisponible(true); // Marcar como disponible
        }

        JOptionPane.showMessageDialog(null, "Vuelo anulado");
    }

    private Asiento buscarAsiento(int numeroAsiento) {
        for (Asiento a : asientos) {
            if (a.getnAsiento() == numeroAsiento) {
                return a;
            }
        }

        return null; // No encontrado
    }

}
