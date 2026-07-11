/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;
import java.io.*;
import java.util.*;
/**
 *
 * @author PC
 */
public class ArchivoTXT {
    public static void exportarTXT(List<Vehiculo> lista, String archivo) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("===== LISTADO DE VEHICULOS =====");
            bw.newLine();
            bw.write("Cantidad de vehiculos: " + lista.size());
            bw.newLine();
            bw.write("================================");
            bw.newLine();
            bw.newLine();

            for (Vehiculo v : lista) {
                bw.write("Tipo: " + v.obtenerTipo());
                bw.newLine();

                bw.write("Marca: " + v.getMarca());
                bw.newLine();

                bw.write("Año: " + v.getAnio());
                bw.newLine();

                bw.write("Precio: $" + v.getPrecio());
                bw.newLine();

                bw.write("Color: " + v.getColor());
                bw.newLine();

                bw.write("Estado: " + v.getEstado());
                bw.newLine();

                bw.write("Electrico: " + v.isElectrico());
                bw.newLine();

                if (v instanceof Vehi_Auto) {
                    Vehi_Auto a = (Vehi_Auto) v;
                    bw.write("Automatico: " + a.isAutomatico());
                    bw.newLine();
                    bw.write("Caballos de fuerza: " + a.getCaballosDeFuerza());
                    bw.newLine();
                }

                else if (v instanceof Vehi_Moto) {
                    Vehi_Moto m = (Vehi_Moto) v;
                    bw.write("Sidecar: " + m.isSidecar());
                    bw.newLine();
                    bw.write("Cilindrado: " + m.getCilindrado());
                    bw.newLine();
                }

                else if (v instanceof Vehi_Camion) {
                    Vehi_Camion c = (Vehi_Camion) v;
                    bw.write("Ejes: " + c.getEjes());
                    bw.newLine();
                    bw.write("Capacidad de carga: " + c.getCargaCapacidad());
                    bw.newLine();
                }
                bw.write("----------------------------------------");
                bw.newLine();
            }
            System.out.println("TXT exportado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar TXT.");
        }
    }
    
    
    
    
}
