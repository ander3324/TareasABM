/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Tarea;

/**
 *
 * @author ander
 */
public class TareaRepo {
    
    private List<Tarea> tareas;
    private Tarea tarea;

    public TareaRepo() {
        tareas = new ArrayList<>();
        tarea = new Tarea();
        crearTareasPrueba();
    }
    
    public void addTarea(Tarea tarea) {
        getTareas().add(tarea);
    }
    
    public void removeTarea(Tarea tarea) {
        getTareas().remove(tarea);
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    
    private void crearTareasPrueba () {
        Tarea t1, t2, t3;
        t1 = new Tarea();
        t1.setNro(1);
        t1.setDescripcion("Tarea 1");
        t1.setFecha(new Date());
        t1.setFinalizada(false);
        
        t2 = new Tarea();
        t2.setNro(2);
        t2.setDescripcion("Tarea 2");
        t2.setFecha(new Date());
        t2.setFinalizada(false);
        
        t3 = new Tarea();
        t3.setNro(3);
        t3.setDescripcion("Tarea 3");
        t3.setFecha(new Date());
        t3.setFinalizada(false);
        
        tareas.add(t1);
        tareas.add(t2);
        tareas.add(t3);
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
     
}
