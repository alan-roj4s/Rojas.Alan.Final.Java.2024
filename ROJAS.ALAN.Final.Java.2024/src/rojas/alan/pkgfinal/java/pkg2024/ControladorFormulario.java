/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;



public class ControladorFormulario {
    @FXML
    private ChoiceBox<String> choiceVehi;
    @FXML
    private TextField fieldMarca;
    @FXML
    private TextField fieldAnio;
    @FXML
    private TextField fieldPrecio;
    @FXML
    private ChoiceBox<EnumColor> fieldColor;
    @FXML
    private ChoiceBox<EnumEstado> fieldEstado;
    @FXML
    private CheckBox checkElectrico;
    @FXML
    private TextField fieldExtra1;
    @FXML
    private TextField fieldExtra2;
    @FXML
    private CheckBox checkExtra;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label text_Extra1;
    @FXML
    private Label text_Extra2;
    // -------
    private Vehiculo vehiculoCrear;
    private Vehiculo vehiculoEditar; // esto sera responsable para hacer saber el programa que modo se esta usando
    
    
    
    // === metodos ===
    // --- inicio ---
    @FXML
    public void initialize() {
        choiceVehi.getItems().addAll(
            "Auto",
            "Moto",
            "Camion"
        );
        fieldColor.getItems().addAll(EnumColor.values());
        fieldEstado.getItems().addAll(EnumEstado.values());
        
        fieldExtra1.setVisible(false);
        fieldExtra2.setVisible(false);

        checkExtra.setVisible(false);

        text_Extra1.setVisible(false);
        text_Extra2.setVisible(false);
    }
    
    // --- botones ---
    @FXML
    private void confirmar() {
        try {
            // --- excepciones (campos incompletos)
            if (choiceVehi.getValue() == null ||
                fieldMarca.getText().isEmpty() ||
                fieldAnio.getText().isEmpty() ||
                fieldPrecio.getText().isEmpty() ||
                fieldColor.getValue() == null ||
                fieldEstado.getValue() == null) {
                throw new ExcepcionPersonalizada("No se han llenado todos los campos.");
            } // mas especifico para los extras
            if (fieldExtra1.isVisible() && fieldExtra1.getText().isEmpty()) {
                throw new ExcepcionPersonalizada("No se han llenado todos los campos.");
            } if (fieldExtra2.isVisible() && fieldExtra2.getText().isEmpty()) {
                throw new ExcepcionPersonalizada("No se han llenado todos los campos.");
            }
            
            // variable que se usaran en el guardado de informacion
            int anio;
            int precio;
            int extra1 = 0; //esto esta constituido como la mierda
            int extra2 = 0;
            
            // --- campos generales
            try {
                anio = Integer.parseInt(fieldAnio.getText());
                precio = Integer.parseInt(fieldPrecio.getText());
            } catch (NumberFormatException e) {
                throw new ExcepcionPersonalizada("Formato no valido, por favor inserte un numero.");
            }
            if (anio <= 1671) { //verifique en la wiki el primer auto a vapor posiblemente creado
                throw new ExcepcionPersonalizada("Año no valido, por favor inserte un año valido. (Posterior a 1671.)");
            }
            if (precio <= 0) {
                throw new ExcepcionPersonalizada("Precio no valido, por favor inserte un precio mayor a 0");
            }
            
            
            // --- campos extras
            try {
                if (!fieldExtra1.getText().isEmpty()) {
                    extra1 = Integer.parseInt(fieldExtra1.getText());
                }
                if (fieldExtra2.isVisible()) {
                    extra2 = Integer.parseInt(fieldExtra2.getText());
                }
            } catch (NumberFormatException e) {
                throw new ExcepcionPersonalizada("Formato no valido, por favor inserte un numero.");
            } 
            
            if (fieldExtra1.isVisible() && extra1 <= 0) { // este codigo esta formateado como la chucha pero funciona
                throw new ExcepcionPersonalizada("Numero invalido, por favor introducir un numero mayor a 0.");
            }
            if (fieldExtra2.isVisible() && extra2 <= 0) {
                throw new ExcepcionPersonalizada("Numero invalido, por favor introducir un numero mayor a 0.");
            }
            
        vehiculoCrear = null;
        String tipo = choiceVehi.getValue();
        
        
        if (vehiculoEditar == null) {
            if (tipo.equals("Auto")) {
                vehiculoCrear = new Vehi_Auto(
                    fieldMarca.getText(),
                    anio,
                    precio,
                    fieldColor.getValue(),
                    fieldEstado.getValue(),
                    checkElectrico.isSelected(),
                    checkExtra.isSelected(),
                    extra1
                );
            } if (tipo.equals("Moto")) {
                vehiculoCrear = new Vehi_Moto(
                    fieldMarca.getText(),
                    anio,
                    precio,
                    fieldColor.getValue(),
                    fieldEstado.getValue(),
                    checkElectrico.isSelected(),
                    checkExtra.isSelected(),
                    extra1
                );
            } if (tipo.equals("Camion")) {
                vehiculoCrear = new Vehi_Camion(
                    fieldMarca.getText(),
                    anio,
                    precio,
                    fieldColor.getValue(),
                    fieldEstado.getValue(),
                    checkElectrico.isSelected(),
                    extra1,
                    extra2
                );
            }
        } else {

        // --- logica de actualizar odio javaa
        vehiculoEditar.setMarca(fieldMarca.getText());
        vehiculoEditar.setAnio(anio);
        vehiculoEditar.setPrecio(precio);
        vehiculoEditar.setColor(fieldColor.getValue());
        vehiculoEditar.setEstado(fieldEstado.getValue());
        vehiculoEditar.setElectrico(checkElectrico.isSelected());
        
        if (vehiculoEditar instanceof Vehi_Auto auto) {
            auto.setAutomatico(checkExtra.isSelected());
            auto.setCaballosDeFuerza(extra1);
        }
        if (vehiculoEditar instanceof Vehi_Moto moto) {
            moto.setSidecar(checkExtra.isSelected());
            moto.setCilindrado(extra1);
        }
        if (vehiculoEditar instanceof Vehi_Camion camion) {
            camion.setEjes(extra1);
            camion.setCargaCapacidad(extra2);
        }
        vehiculoCrear = vehiculoEditar;
    }
        
        
        
        System.out.println("Vehiculo creado: " + vehiculoCrear.getMarca());

        Stage ventana = (Stage) btnConfirmar.getScene().getWindow();
        ventana.close();
        } catch (ExcepcionPersonalizada e) {
        mostrarError(e.getMessage());
        }
    }
    @FXML
    private void cancelar() { // boton cancelar
        Stage ventana = (Stage) btnCancelar.getScene().getWindow();
        ventana.close();
    }
    
    // --- metodos no fxml ---
    public void cargar(Vehiculo vehiculo) {
        vehiculoEditar = vehiculo;
        fieldMarca.setText(vehiculo.getMarca());
        fieldAnio.setText(String.valueOf(vehiculo.getAnio()));
        fieldPrecio.setText(String.valueOf(vehiculo.getPrecio()));
        fieldColor.setValue(vehiculo.getColor());
        fieldEstado.setValue(vehiculo.getEstado());
        checkElectrico.setSelected(vehiculo.isElectrico());
        
        if (vehiculo instanceof Vehi_Auto auto) {
            choiceVehi.setValue("Auto");
            cambiarTipo();
            checkExtra.setSelected(auto.isAutomatico());
            fieldExtra1.setText(String.valueOf(auto.getCaballosDeFuerza()));
        }
        if (vehiculo instanceof Vehi_Moto moto) {
            choiceVehi.setValue("Moto");
            cambiarTipo();
            checkExtra.setSelected(moto.isSidecar());
            fieldExtra1.setText(String.valueOf(moto.getCilindrado()));
        }
        if (vehiculo instanceof Vehi_Camion camion) {
            choiceVehi.setValue("Camion");
            cambiarTipo();
            fieldExtra1.setText(String.valueOf(camion.getEjes()));
            fieldExtra2.setText(String.valueOf(camion.getCargaCapacidad()));
        }
        choiceVehi.setDisable(true); // <- deberia desactivar el poder cambiar el tipo de vehiculo
    }
    
    
    @FXML
    private void cambiarTipo() { // metodo especifico para mostrar los fields extra y no djear que el usuario interactue con
        // informacion que no le sirve y podria romper el codigo, de paso sirve para actualizar

        String tipo = choiceVehi.getValue();
        fieldExtra1.setVisible(true);
        fieldExtra2.setVisible(true);
        checkExtra.setVisible(true);
        text_Extra1.setVisible(true);
        text_Extra2.setVisible(true);

        if (tipo.equals("Auto")) {
            text_Extra1.setText("Caballos");
            text_Extra2.setText("");
            checkExtra.setText("Automático");
            fieldExtra2.setVisible(false);
            text_Extra2.setVisible(false);
            
        } if (tipo.equals("Moto")) {
            text_Extra1.setText("Cilindrado");
            text_Extra2.setText("");
            checkExtra.setText("Sidecar");
            fieldExtra2.setVisible(false);
            text_Extra2.setVisible(false);
            
        } if (tipo.equals("Camion")) {
            text_Extra1.setText("Ejes");
            text_Extra2.setText("Capacidad");
            checkExtra.setVisible(false);
        }
    }
    
    
    private void mostrarError(String mensaje) { // un metodo ayudante porque ESTOY CANSADO POR LA CHUCHA
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    
    // === getter ===

    public Vehiculo getVehiculoCreado() {
        return vehiculoCrear;
    } // para que puede enviar la info al fxml original
    
    
    
    
    
    
    
    
    
}


