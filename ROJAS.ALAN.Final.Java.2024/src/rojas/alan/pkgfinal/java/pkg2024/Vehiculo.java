/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;
import java.io.Serializable;
/**
 *
 * @author PC
 */
public abstract class Vehiculo implements Serializable, Comparable<Vehiculo> { // abstract, solo heredaciones la consiguen
    
    
    
    protected String marca;
    protected int anio; // protected, los hijos tienen acceso
    protected int precio;
    protected EnumColor color; // llamando los enums
    protected EnumEstado estado;
    protected boolean electrico;
    
    
    // === comportamientos ===
    public abstract String obtenerTipo(); // los hijos se establecen que vehiculo son
    public abstract boolean disponible(); // true si esta nuevo o usado
    public abstract String descripcion(); // aca se aplica una forma de polimorfismo
    
    
    // --- construct ---
    // 3. vacio / libre???
    public Vehiculo () {}
    
    //1. todo atributo
    public Vehiculo (String marca, int anio, int precio, EnumColor color, EnumEstado estado, boolean electrico) { // unico que se usa
        this.marca = marca;
        this.anio = anio;
        this.precio = precio;
        this.color = color;
        this.estado = estado;
        this.electrico = electrico;
    }
    
    //2. sin atributo electrico
    public Vehiculo (String marca, int anio, int precio, EnumColor color, EnumEstado estado) {
        this.marca = marca;
        this.anio = anio;
        this.precio = precio;
        this.color = color;
        this.estado = estado;
        this.electrico = false;
    }
    
    
    
    // === getters ===
    public String getMarca() {
        return marca;
    }
    public int getAnio() {
        return anio;
    }
    public int getPrecio() {
        return precio;
    }
    public EnumColor getColor() {
        return color;
    }
    public EnumEstado getEstado() {
        return estado;
    }
    public boolean isElectrico() {
        return electrico;
    }
    public String getTipo() {
        return obtenerTipo();
    }
    
    // === setters ===

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setColor(EnumColor color) {
        this.color = color;
    }
    public void setEstado(EnumEstado estado) {
        this.estado = estado;
    }
    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }
    
    
    
    // === comparable / MISC ===

    @Override // ordena por nombre de forma natural, relacionado a comparable
    public int compareTo(Vehiculo otro) {
        return this.marca.compareTo(otro.marca); 
    };
    
    @Override // un helper debido a que el controlador de seleccion no muestra buena info sin esto
    public String toString() {
        return obtenerTipo() + " - " + marca;
    }
    
    
}
