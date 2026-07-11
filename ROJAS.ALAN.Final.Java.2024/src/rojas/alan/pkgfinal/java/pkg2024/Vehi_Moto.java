/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;

/**
 *
 * @author PC
 */
public class Vehi_Moto extends Vehiculo{

    private boolean sidecar;
    private int cilindrado;
    
    
    public Vehi_Moto (String marca, int anio, int precio, EnumColor color, EnumEstado estado, boolean electrico, boolean sidecar, int cilindrado) {
        super(marca, anio, precio, color, estado, electrico); //super llama metodos de superclase (padre)
        this.sidecar = sidecar;
        this.cilindrado = cilindrado;
    }
    
    
    
    // === Comportamientos ===
    // principalmente respuestas a estos
    // override dice al compiler que debe hacer override sobre un metodo padre, dando error sino, permitiendo modificarlo si esta bien
    @Override
    public String obtenerTipo() {
        return "Moto";
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
        if (sidecar == true) {
            tipo = "con sidecar";
        } else {
            tipo = "sin sidecar";
        }
        return "Moto " + marca + " " + tipo + " con cilindrado " + cilindrado + "cc";
        
    }
    
    // === getters ===
    public boolean isSidecar() {
        return sidecar;
    }
    public int getCilindrado() {
        return cilindrado;
    }
    
    // === setters ===
    public void setSidecar(boolean sidecar) {
        this.sidecar = sidecar;
    }
    public void setCilindrado(int cilindrado) {
        this.cilindrado = cilindrado;
    }

    
    
}
