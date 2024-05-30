/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficacion;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import javax.swing.DefaultListModel;
import org.w3c.dom.ls.LSInput;

/**
 *
 * @author libookami
 */
public class Figura {
    
    private String Nombre;

    public DefaultListModel<Punto> listaPuntos;
     public DefaultListModel<Keyframe> listakeyframes;
    
    public static int escala = 20;

    public String getNombre() {
        return Nombre;
    }

  
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public void AgregarKeyframe(Keyframe k){
        listakeyframes.addElement(k);
    }
    public void EliminarKeyrame(Keyframe k) throws IllegalArgumentException{
        int idx = listakeyframes.indexOf(k);
        if(idx >0){
            listakeyframes.removeElement(k);
        }else{
            throw new  IllegalArgumentException("Error No se puede eliminar el keyframe");
        }
    }
    public Keyframe getKeyframeinicial(){
        return listakeyframes.get(0);
    }


    public Figura(String Nombre) {
        this.Nombre = Nombre;
        
        //k.listaPuntos = new DefaultListModel<>();
        listakeyframes = new DefaultListModel<>();
        float []  par = {0,0};
        Keyframe inical = new  Keyframe(0, Keyframe.tiposTransf.NINGUNO, this, par);
        listakeyframes.addElement(inical);
    }

    @Override
    public String toString() {
        return Nombre;
    }
    
    public void tranformar(Matriz3x3 mt){
        for (int i = 0; i < getKeyframeinicial().listaPuntos.size(); i++) {
            getKeyframeinicial().listaPuntos.get(i).tranformar(mt);
        }
    }
    public void dibujar(ShapeRenderer rend)
    {
        for (int i = 0; i < getKeyframeinicial().listaPuntos.size(); i++) {
            getKeyframeinicial().listaPuntos.get(i).dibujar(rend);
        }
    }
    
 }
    