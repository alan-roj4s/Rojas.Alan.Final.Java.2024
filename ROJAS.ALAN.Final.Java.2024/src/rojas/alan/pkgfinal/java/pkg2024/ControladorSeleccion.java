/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;

/**
 *
 * @author PC
 */
public class ControladorSeleccion {
    @FXML
    private ChoiceBox<Vehiculo> choice_Vehi;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    // --- variables no fxml ---
    private Vehiculo vehiculoSeleccionado;
    
    // === metodos ===
    
    // --- al boton confirmar
    @FXML
    private void confirmar() {
        vehiculoSeleccionado = choice_Vehi.getValue();
        Stage ventana = (Stage) btnConfirmar.getScene().getWindow();
        ventana.close();
    }
    // --- cancelas;ltrf
    @FXML
    private void cancelar() {
        vehiculoSeleccionado = null;
        Stage ventana = (Stage) btnCancelar.getScene().getWindow();
        ventana.close();
    }
    
    
    
    // --- carga lista actual de vehiculos
    public void cargarVehiculos(GestionVehiculos gestion) {
        choice_Vehi.getItems().addAll(gestion.listar());
    }
    
    
    
    // === getters ===

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }
    
    
    
    
}
