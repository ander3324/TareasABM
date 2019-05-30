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
import javafx.scene.control.TableView;
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
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDel;
    @FXML
    private TableView<Tarea> tbvTareas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatos();
    }

    private void cargarDatos() {
        tbvTareas.getItems().clear();
        tbvTareas.getItems().addAll(TareasABM.repo.getTareas());
    }

    @FXML
    private void nuevo_OnAction(ActionEvent event) {
        TareasABM.repo.setTarea(new Tarea());
        VentanasUtil.abrirDialogo(btnDel.getScene().getWindow(), "/view/frmABMTareas.fxml", "Nueva Tarea");
        cargarDatos();
    }

    @FXML
    private void modificar_OnAction(ActionEvent event) {
        if (!tbvTareas.getSelectionModel().getSelectedItem().equals(null)) {
            TareasABM.repo.setTarea(tbvTareas.getSelectionModel().getSelectedItem());
            VentanasUtil.abrirDialogo(btnDel.getScene().getWindow(), "/view/frmABMTareas.fxml", "Modificar Tarea");
            cargarDatos();
        } else {
            Alert alert
                    = new Alert(Alert.AlertType.WARNING, "No hay tarea seleccionada...");
            alert.showAndWait();
        }

    }

    @FXML
    private void borrar_OnAction(ActionEvent event) {
        Alert alert
                = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de borrar la tarea?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                TareasABM.repo.removeTarea(tbvTareas.getSelectionModel().getSelectedItem());
                cargarDatos();
            }
        });
    }

}
