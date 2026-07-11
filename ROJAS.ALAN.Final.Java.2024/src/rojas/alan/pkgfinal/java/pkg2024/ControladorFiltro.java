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
public class ControladorFiltro {
    // --- fxml cluai
    @FXML
    private ChoiceBox<String> choiceVehiculo;
    @FXML
    private ChoiceBox<String> choiceOrden;
    @FXML
    private RadioButton radioNinguno;
    @FXML
    private RadioButton radioPrecio;
    @FXML
    private RadioButton radioEstado;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    // --- variables no fmlx
    private String tipoSeleccionado;
    private String ordenSeleccionado;
    private String criterioSeleccionado;
    
    
    // === metodos FXML ===
    @FXML
    public void initialize() {
        choiceVehiculo.getItems().addAll(
                "Todos",
                "Auto",
                "Moto",
                "Camion"
        );
        choiceOrden.getItems().addAll(
                "Ascendente",
                "Descendente"
        );
        choiceVehiculo.setValue("Todos");
        choiceOrden.setValue("Ascendente");
        radioNinguno.setSelected(true);
    }
    // --- botones
    @FXML
    private void confirmar() {
        tipoSeleccionado = choiceVehiculo.getValue();
        ordenSeleccionado = choiceOrden.getValue();
        if (radioPrecio.isSelected())
            criterioSeleccionado = "Precio";
        else if (radioEstado.isSelected())
            criterioSeleccionado = "Estado";
        else
            criterioSeleccionado = "Ninguno";
        Stage ventana = (Stage) btnConfirmar.getScene().getWindow();
        ventana.close();
    }

    @FXML
    private void cancelar() {
        tipoSeleccionado = null;
        Stage ventana = (Stage) btnCancelar.getScene().getWindow();
        ventana.close();
    }

    
    
    // === getters ===

    public String getTipoSeleccionado() {
        return tipoSeleccionado;
    }
    public String getOrdenSeleccionado() {
        return ordenSeleccionado;
    }
    public String getCriterioSeleccionado() {
        return criterioSeleccionado;
    }
    
    
    // === NOTAS DE AUTO-EXPLICACION
    // esta no sera una nota larga, es mas que nada explicar que
    // este controlador lo que hace principalmente es solo recordar lo que el usuario eligio y retornarlo
    
}
