/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;


import com.google.gson.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author PC
 */
public class ArchivoJSON {
    // === guardar json ===
    public static void guardarJSON(List<Vehiculo> lista, String archivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray arreglo = new JsonArray();
        for (Vehiculo v : lista) {
            JsonObject objeto = new JsonObject();

            objeto.addProperty("tipo", v.obtenerTipo());

            objeto.addProperty("marca", v.getMarca());
            objeto.addProperty("anio", v.getAnio());
            objeto.addProperty("precio", v.getPrecio());
            objeto.addProperty("color", v.getColor().toString());
            objeto.addProperty("estado", v.getEstado().toString());
            objeto.addProperty("electrico", v.isElectrico());

            if (v instanceof Vehi_Auto) {
                Vehi_Auto a = (Vehi_Auto) v;
                objeto.addProperty("automatico", a.isAutomatico());
                objeto.addProperty("caballosDeFuerza", a.getCaballosDeFuerza());
            }

            else if (v instanceof Vehi_Moto) {
                Vehi_Moto m = (Vehi_Moto) v;
                objeto.addProperty("sidecar", m.isSidecar());
                objeto.addProperty("cilindrado", m.getCilindrado());
            }

            else if (v instanceof Vehi_Camion) {
                Vehi_Camion c = (Vehi_Camion) v;
                objeto.addProperty("ejes", c.getEjes());
                objeto.addProperty("cargaCapacidad", c.getCargaCapacidad());
            }
            arreglo.add(objeto);
        }
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(arreglo, writer);
            System.out.println("JSON guardado.");
        }

        catch(IOException e){
            System.out.println("Error al guardar JSON.");
        }
    }
    
    // === cargar JSON ===
    public static ArrayList<Vehiculo> cargarJSON(String archivo){
        ArrayList<Vehiculo> lista = new ArrayList<>();
        Gson gson = new Gson();
        
        try(FileReader reader = new FileReader(archivo)){
            JsonArray arreglo = gson.fromJson(reader, JsonArray.class);
            
            for(JsonElement elemento : arreglo){
                JsonObject objeto = elemento.getAsJsonObject();
                String tipo = objeto.get("tipo").getAsString();
                String marca = objeto.get("marca").getAsString();
                int anio = objeto.get("anio").getAsInt();
                int precio = objeto.get("precio").getAsInt();
                EnumColor color = EnumColor.valueOf(objeto.get("color").getAsString());
                EnumEstado estado = EnumEstado.valueOf(objeto.get("estado").getAsString());
                boolean electrico = objeto.get("electrico").getAsBoolean();
                
                if(tipo.equals("Auto")){
                    boolean automatico = objeto.get("automatico").getAsBoolean();
                    int caballos = objeto.get("caballosDeFuerza").getAsInt();
                    lista.add(new Vehi_Auto(
                            marca,
                            anio,
                            precio,
                            color,
                            estado,
                            electrico,
                            automatico,
                            caballos));
                }

                else if(tipo.equals("Moto")){
                    boolean sidecar = objeto.get("sidecar").getAsBoolean();
                    int cilindrado = objeto.get("cilindrado").getAsInt();
                    lista.add(new Vehi_Moto(
                            marca,
                            anio,
                            precio,
                            color,
                            estado,
                            electrico,
                            sidecar,
                            cilindrado));
                }

                else if(tipo.equals("Camion")){
                    int ejes = objeto.get("ejes").getAsInt();
                    int carga = objeto.get("cargaCapacidad").getAsInt();
                    lista.add(new Vehi_Camion(
                            marca,
                            anio,
                            precio,
                            color,
                            estado,
                            electrico,
                            ejes,
                            carga));
                }
            }
            System.out.println("JSON cargado.");
        }
        catch(IOException e){
            System.out.println("Error al cargar JSON.");
        }
        return lista;
    }
    
    
    
}
