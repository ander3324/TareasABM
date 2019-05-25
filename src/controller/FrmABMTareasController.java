/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Tarea;
import tareasabm.TareasABM;

/**
 * FXML Controller class
 *
 * @author ander
 */
public class FrmABMTareasController implements Initializable {

    @FXML
    private TextField txtDescripcion;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void guardar_OnAction(ActionEvent event) {
        if (txtDescripcion.getText().isEmpty()) {
            Alert alert
                    = new Alert(Alert.AlertType.ERROR, "La Descripción no puede estar vacía...");
            alert.showAndWait();
        } else {
            
            //Crear tarea y guardar en repositorio...
            Tarea t = new Tarea();
            t.setDescripcion(txtDescripcion.getText());
            t.setNro(TareasABM.repo.getTareas().size() + 1);
            TareasABM.repo.addTarea(t);
            
            Alert alert
                    = new Alert(Alert.AlertType.INFORMATION, "Tarea Guardada Correctamente...");
            alert.showAndWait();
            cerrarVentana();
        }
    }
    
    @FXML
    private void cancelar_OnAction(ActionEvent event) {
        Alert alert
                = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de cancelar?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                cerrarVentana();
            }
        });

    }

    void cerrarVentana() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

}
