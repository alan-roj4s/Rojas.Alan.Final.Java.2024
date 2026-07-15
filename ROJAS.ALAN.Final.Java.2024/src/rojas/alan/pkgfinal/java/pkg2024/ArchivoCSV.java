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
public class ArchivoCSV {
    
    // === guardado CSV ===
    public static void guardarCSV(List<Vehiculo> lista, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // --- encabezadooo
            bw.write("Tipo,Marca,Anio,Precio,Color,Estado,Electrico,Atributo1,Atributo2");
            bw.newLine(); // esto va para abajo, creando una linea nueva
            for (Vehiculo v : lista) {
                bw.write(
                        v.obtenerTipo() + "," +
                        v.getMarca() + "," +
                        v.getAnio() + "," +
                        v.getPrecio() + "," +
                        v.getColor() + "," +
                        v.getEstado() + "," +
                        v.isElectrico()
                );
                
                // auto
                if (v instanceof Vehi_Auto) {
                    Vehi_Auto a = (Vehi_Auto) v;
                    bw.write("," +
                            a.isAutomatico() + "," +
                            a.getCaballosDeFuerza());
                }

                // moto
                else if (v instanceof Vehi_Moto) {
                    Vehi_Moto m = (Vehi_Moto) v;
                    bw.write("," +
                            m.isSidecar() + "," +
                            m.getCilindrado());
                }

                // camion
                else if (v instanceof Vehi_Camion) {
                    Vehi_Camion c = (Vehi_Camion) v;
                    bw.write("," +
                            c.getEjes() + "," +
                            c.getCargaCapacidad());
                }
                bw.newLine();
            }

            System.out.println("CSV guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar CSV.");
        }
    }
    
    // === cargado CSV ===
    public static ArrayList<Vehiculo> cargarCSV(String nombreArchivo) {
        ArrayList<Vehiculo> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            br.readLine(); // <-- cosa que se salta el encabezado, evitando romper el codigo
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String tipo = datos[0];
                String marca = datos[1];
                int anio = Integer.parseInt(datos[2]);
                int precio = Integer.parseInt(datos[3]);
                EnumColor color = EnumColor.valueOf(datos[4]);
                EnumEstado estado = EnumEstado.valueOf(datos[5]);
                boolean electrico = Boolean.parseBoolean(datos[6]);

                if (tipo.equals("Auto")) {
                    boolean automatico = Boolean.parseBoolean(datos[7]);
                    int caballos = Integer.parseInt(datos[8]);
                    lista.add(new Vehi_Auto(
                            marca,
                            anio,
                            precio,
                            color,
                            estado,
                            electrico,
                            automatico,
                            caballos
                    ));
                }

                else if (tipo.equals("Moto")) {
                    boolean sidecar = Boolean.parseBoolean(datos[7]);
                    int cilindrado = Integer.parseInt(datos[8]);
                    lista.add(new Vehi_Moto(
                            marca,
                            anio,
                            precio,
                            color,
                            estado,
                            electrico,
                            sidecar,
                            cilindrado
                    ));
                }

                else if (tipo.equals("Camion")) {
                    int ejes = Integer.parseInt(datos[7]);
                    int carga = Integer.parseInt(datos[8]);
                    lista.add(new Vehi_Camion(
                            marca,
                            anio,
                            precio,
                            color,
                            estado,
                            electrico,
                            ejes,
                            carga
                    ));
                }
            }
            System.out.println("CSV cargado correctamente.");
        } catch (IOException e) {

            System.out.println("Error al cargar CSV.");
        }
        return lista;
    }
}
