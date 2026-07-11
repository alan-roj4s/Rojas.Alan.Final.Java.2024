/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;

/**
 *
 * @author PC
 */
public class Vehi_Auto extends Vehiculo{

    private boolean automatico;
    private int caballosDeFuerza;
    
    
    public Vehi_Auto (String marca, int anio, int precio, EnumColor color, EnumEstado estado, boolean electrico, boolean automatico, int caballosDeFuerza) {
        super(marca, anio, precio, color, estado, electrico); //super llama metodos de superclase (padre)
        this.automatico = automatico;
        this.caballosDeFuerza = caballosDeFuerza;
    }
    
    
    
    // === Comportamientos ===
    // principalmente respuestas a estos
    // override dice al compiler que debe hacer override sobre un metodo padre, dando error sino, permitiendo modificarlo si esta bien
    @Override
    public String obtenerTipo() {
        return "Auto";
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
        String tipo ;
        if (automatico == true) {
            tipo = "automatica";
        } else {
            tipo = "manual";
        }
        return "Auto " + marca + " " + tipo + " con " + caballosDeFuerza + " caballos de fuerza.";
        
    }
    
    // === getters ===
    public boolean isAutomatico() {
        return automatico;
    }
    public int getCaballosDeFuerza() {
        return caballosDeFuerza;
    }
    
    // === setters ===
    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }
    public void setCaballosDeFuerza(int caballosDeFuerza) {
        this.caballosDeFuerza = caballosDeFuerza;
    }
    
    
}
