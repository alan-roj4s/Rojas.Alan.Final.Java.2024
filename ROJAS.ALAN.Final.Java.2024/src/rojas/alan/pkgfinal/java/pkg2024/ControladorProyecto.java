/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rojas.alan.pkgfinal.java.pkg2024;

import java.util.ArrayList;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;
import javafx.scene.control.*;

public class ControladorProyecto {
    // === elementos que se importan ===
    // --- java ---
    private GestionVehiculos gestion = new GestionVehiculos(); // esencialmente trae a gestion
    
    // --- fxml ---
    @FXML 
    private TableView<Vehiculo> tabla; // pertenece a vehiculo, y es string / int / etc
    @FXML
    private TableColumn<Vehiculo, String> columnavehiculos;
    @FXML
    private TableColumn<Vehiculo, String> columnamarca;
    @FXML
    private TableColumn<Vehiculo, Integer> columnaanio;
    @FXML
    private TableColumn<Vehiculo, Integer> columnaprecio;
    @FXML
    private TableColumn<Vehiculo, EnumColor> columnacolor;
    @FXML
    private TableColumn<Vehiculo, EnumEstado> columnaestado;
    @FXML
    private TableColumn<Vehiculo, Boolean> columnaelectrico;
    // --- botoness
    @FXML
    private Button btnaniadir;
    @FXML
    private Button btneliminar;
    @FXML
    private Button btoneditar;
    @FXML
    private Button btnfiltrar;
    // --- botones del menuuu
    @FXML
    private MenuItem btnguardar;
    @FXML
    private MenuItem btnexportar;
    @FXML
    private MenuItem btncargarCSV;
    @FXML
    private MenuItem btncargarJSON;
    
    
    
    // === metodos ===
    @FXML
    public void initialize() { //codigo ni bien la app inicia, solo si se llama initialize, es muy peculiar
        // --- otorga una variable a cada columna al decir que llame el get respectivo
        columnavehiculos.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnamarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnaanio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        columnaprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnacolor.setCellValueFactory(new PropertyValueFactory<>("color"));
        columnaestado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnaelectrico.setCellValueFactory(new PropertyValueFactory<>("electrico"));   
        
        // === tooltip ===
        // un pequenio extra que al poner el mouse encima de un vehiculo, mostrara descripcion()
        tabla.setRowFactory(tv -> {
            TableRow<Vehiculo> fila = new TableRow<>();
            fila.setOnMouseEntered(event -> {
                if (!fila.isEmpty()) {
                    Tooltip tooltip = new Tooltip(fila.getItem().descripcion());
                    fila.setTooltip(tooltip);
                }
            }); 
            return fila;
        });
        
        // agreaga un $ al final
        columnaprecio.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("");
                } else {
                    setText("$" + item);
                }
            }
        });
        
        // muestra SI o NO en vez de true o false
        columnaelectrico.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("");
                } else {
                    setText(item ? "Si" : "No");
                }
            }
        });
    }
    
    
    
    
    private void actualizar() {
        tabla.getItems().clear();
        tabla.getItems().addAll(gestion.listar());
    }
    
    
    // === metodos boton ===
    @FXML
    private void agregarVehiculo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("formulario.fxml"));
            Parent root = loader.load();
            ControladorFormulario controlador = loader.getController();
            Stage ventana = new Stage();
            ventana.setTitle("Agregar vehiculo");
            ventana.setScene(new Scene(root));
            ventana.showAndWait();
            Vehiculo nuevo = controlador.getVehiculoCreado();
            if (nuevo != null) {
                gestion.agregar(nuevo);
                actualizar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void eliminarVehiculo() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("seleccion.fxml"));
            Parent root = loader.load();
            ControladorSeleccion controlador = loader.getController();
            controlador.cargarVehiculos(gestion);
            Stage ventana = new Stage();
            ventana.setTitle("Eliminar vehiculo");
            ventana.setScene(new Scene(root));
            ventana.showAndWait();
            Vehiculo seleccionado = controlador.getVehiculoSeleccionado();
            if (seleccionado != null) {
                gestion.eliminar(seleccionado);
                actualizar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void actualizarVehiculo() {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("seleccion.fxml"));
            Parent root = loader.load();
            ControladorSeleccion seleccion = loader.getController();
            seleccion.cargarVehiculos(gestion);
            Stage ventana = new Stage();
            ventana.setTitle("Editar vehiculo");
            ventana.setScene(new Scene(root));
            ventana.showAndWait();
            Vehiculo seleccionado = seleccion.getVehiculoSeleccionado();
            if (seleccionado != null) {
                FXMLLoader loader2 = new FXMLLoader(
                    getClass().getResource("formulario.fxml"));
                Parent root2 = loader2.load();
                ControladorFormulario formulario = loader2.getController();
                formulario.cargar(seleccionado);
                Stage ventana2 = new Stage();
                ventana2.setTitle("Editar vehiculo");
                ventana2.setScene(new Scene(root2));
                ventana2.showAndWait();

                actualizar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void filtrarVehiculos() {

        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("filtrar-ordenar.fxml"));
            Parent root = loader.load();
            ControladorFiltro controlador = loader.getController();
            Stage ventana = new Stage();
            ventana.setTitle("Filtrar y ordenar");
            ventana.setScene(new Scene(root));
            ventana.showAndWait();
            if (controlador.getTipoSeleccionado() == null) {
                return;
            }
            tabla.getItems().clear();

            
            // --- filtrado ---
            if (controlador.getTipoSeleccionado().equals("Todos")) {
                tabla.getItems().addAll(gestion.listar());
            }
            if (controlador.getTipoSeleccionado().equals("Auto")) {
                tabla.getItems().addAll(
                        gestion.filtrarTipo(
                                gestion.listar(),
                                Vehi_Auto.class));
            }
            if (controlador.getTipoSeleccionado().equals("Moto")) {
                tabla.getItems().addAll(
                        gestion.filtrarTipo(
                                gestion.listar(),
                                Vehi_Moto.class));
            }
            if (controlador.getTipoSeleccionado().equals("Camion")) {

                tabla.getItems().addAll(
                        gestion.filtrarTipo(
                                gestion.listar(),
                                Vehi_Camion.class));
            }

            
            // --- ordernarrr asfjoikp ---
            if (controlador.getCriterioSeleccionado().equals("Precio")) {
                tabla.getItems().sort(new CompararPrecio());
            }
            if (controlador.getCriterioSeleccionado().equals("Estado")) {
                tabla.getItems().sort(new CompararEstado());
            }


            // --- ascendencia y sobretodo descendencia
            if (controlador.getOrdenSeleccionado().equals("Descendente")) {
                javafx.collections.FXCollections.reverse(tabla.getItems());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    // ===== BOTONES DE SERIALIZACION DEL DOLOORRRR =====
    @FXML
    private void guardarDatos() {
        try {
            gestion.guardarSerializado("vehiculos.dat");
            ArchivoCSV.guardarCSV(gestion.listar(),"vehiculos.csv");
            ArchivoJSON.guardarJSON(gestion.listar(),"vehiculos.json");

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Guardar"); 
            alerta.setHeaderText(null);
            alerta.setContentText("Datos guardados correctamente.");
            alerta.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void exportar() {
        try {
            ArchivoTXT.exportarTXT(
                    gestion.listar(),
                    "vehiculos.txt");
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Exportar TXT");
            alerta.setHeaderText(null);
            alerta.setContentText("TXT exportado correctamente.");
            alerta.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void cargarCSV() {
        try {
            ArrayList<Vehiculo> lista = ArchivoCSV.cargarCSV("vehiculos.csv");
            gestion.reemplazarLista(lista);
            actualizar();
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Cargar CSV");
            alerta.setHeaderText(null);
            alerta.setContentText("Datos CSV cargados correctamente.");
            alerta.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void cargarJSON() {
        try {
            ArrayList<Vehiculo> lista = ArchivoJSON.cargarJSON("vehiculos.json");
            gestion.reemplazarLista(lista);

            actualizar();

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Cargar JSON");
            alerta.setHeaderText(null);
            alerta.setContentText("Datos JSON cargados correctamente.");
            alerta.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void cargarDAT() {
        try {
            gestion.cargarSerializado("vehiculos.dat");
            actualizar();

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Cargar DAT");
            alerta.setHeaderText(null);
            alerta.setContentText("Datos DAT cargados correctamente.");
            alerta.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
