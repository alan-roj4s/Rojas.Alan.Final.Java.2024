/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;
import java.io.*;
import java.util.*;
import com.google.gson.Gson;
/**
 *
 * @author PC
 */
public class ArchivoSerializacion {
    // === serializar ===
    public void guardar(ArrayList<Vehiculo> lista, String archivo) {

        try (ObjectOutputStream salida =
                new ObjectOutputStream(new FileOutputStream(archivo))) {
            salida.writeObject(lista);
            System.out.println("Datos serializados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al serializar.");
        }
    }
    
    // === deserializar ===
    public ArrayList<Vehiculo> cargar(String archivo) {

        try (ObjectInputStream entrada =
                new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<Vehiculo>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar.");
        }
        return new ArrayList<>();
    }
}
