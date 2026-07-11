/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;

/**
 *
 * @author PC
 */
public class Vehi_Camion extends Vehiculo{

    private int ejes;
    private int cargaCapacidad;
    
    
    public Vehi_Camion (String marca, int anio, int precio, EnumColor color, EnumEstado estado, boolean electrico, int cargaCapacidad, int ejes) {
        super(marca, anio, precio, color, estado, electrico); //super llama metodos de superclase (padre)
        this.ejes = ejes;
        this.cargaCapacidad = cargaCapacidad;
    }
    
    
    
    // === Comportamientos ===
    // principalmente respuestas a estos
    // override dice al compiler que debe hacer override sobre un metodo padre, dando error sino, permitiendo modificarlo si esta bien
    @Override
    public String obtenerTipo() {
        return "Camion";
    }
    @Override
    public boolean disponible() {
        if (estado == EnumEstado.Roto) {
            return false;
        }
        if (estado == EnumEstado.En_reparacion) {
            return false;
        }
        else {
            return true;
        }
    }
    @Override
    public String descripcion() {
        return "Camion " + marca + " con " + ejes + " ejes y capacidad de " + cargaCapacidad + "Kg.";
    }
    
    // === getters ===
    public int getEjes() {
        return ejes;
    }
    public int getCargaCapacidad() {
        return cargaCapacidad;
    }
    
    // === setters ===
    public void setEjes(int ejes) {
        this.ejes = ejes;
    }
    public void setCargaCapacidad(int cargaCapacidad) {
        this.cargaCapacidad = cargaCapacidad;
    }
    
    
    
}
