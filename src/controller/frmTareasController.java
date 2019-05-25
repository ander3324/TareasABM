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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Tarea;
import tareasabm.TareasABM;
import util.VentanasUtil;

/**
 *
 * @author ander
 */
public class frmTareasController implements Initializable {

    private Label label;
    @FXML
    private ListView<Tarea> lstTareas;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatos();
    }

    private void cargarDatos() {
        lstTareas.getItems().clear();
        lstTareas.getItems().addAll(TareasABM.repo.getTareas());
    }

    @FXML
    private void nuevo_OnAction(ActionEvent event) {
        VentanasUtil.abrirDialogo(btnDel.getScene().getWindow(), "/view/frmABMTareas.fxml", "Nueva Tarea");
        cargarDatos();
    }

    @FXML
    private void modificar_OnAction(ActionEvent event) {
    }

    @FXML
    private void borrar_OnAction(ActionEvent event) {
         Alert alert
                = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de borrar la tarea?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                TareasABM.repo.removeTarea(lstTareas.getSelectionModel().getSelectedItem());
                cargarDatos();
            }
        });
    }

}
