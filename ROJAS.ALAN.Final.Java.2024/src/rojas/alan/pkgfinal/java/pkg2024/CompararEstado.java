/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;
import java.util.*;
/**
 *
 * @author PC
 */
public class CompararEstado implements Comparator<Vehiculo>{

    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
        return o1.getEstado().compareTo(o2.getEstado());
    }// este es unico en como ordena, pues usa el orden dentro del enum
    // si roto es primero en ese archivo, entonces sera primero en orden
    
}


// === COMENTARIOS PARA AUTO-EXPLICAR
// la mayor diferencia entre Comparable y Comparator
// Comparable define el orden natural de los objetos dentro de la clase
// Comparator define un orden personalizado con logica unica, y no la define por defecto