/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficacion;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import javax.swing.DefaultListModel;

/**
 *
 * @author libookami
 */
public class Figura {
    
    private String Nombre;
    
    public DefaultListModel<Punto> listaPuntos;
    
    public static int escala = 20;

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Figura(String Nombre) {
        this.Nombre = Nombre;
        
        listaPuntos = new DefaultListModel<>();
        

        listaPuntos.addElement(new Punto(1, 1));
        listaPuntos.addElement(new Punto(2, 2));
        listaPuntos.addElement(new Punto(2, 1)); 
    }

    @Override
    public String toString() {
        return Nombre;
    }
    
    public void dibujar(ShapeRenderer rend)
    {
        for (int i = 0; i < listaPuntos.size(); i++) {
            listaPuntos.get(i).dibujar(rend);
        }
    }
}
