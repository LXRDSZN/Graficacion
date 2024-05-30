/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficacion;

import static Graficacion.Keyframe.tiposTransf.ESCALADO;
import static Graficacion.Keyframe.tiposTransf.TRASLACION;
import static Graficacion.VentanaPrincipal.figuraSeleccionada;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.google.common.primitives.Floats;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
    public void AgregarKeyframe(Keyframe k)throws IllegalArgumentException{
        boolean encontrado = Arrays.stream(listakeyframes.toArray()).anyMatch(x -> ((Keyframe)x).numerodefotogramas ==k.numerodefotogramas);
        if(encontrado){
            throw  new  IllegalArgumentException("Error:ya esiste el fotograma en este keyframe");
        }
        listakeyframes.addElement(k);
        ordenarkeyFrames();
    }
    public void ordenarkeyFrames(){
        List<Object> lista_ordenada = Arrays.asList(listakeyframes.toArray());
        lista_ordenada.sort(Comparator.comparing(x -> ((Keyframe)x).numerodefotogramas));
        listakeyframes.clear();
        
        for(Object k : lista_ordenada){
            listakeyframes.addElement((Keyframe)k);
        }
    }
    
    public void actualizarPUntoskeyFrames(){
        if(listakeyframes.size()>1){
            for (int i = 1; i < listakeyframes.size(); i++) {
                Keyframe k = listakeyframes.elementAt(i);
                Keyframe anterior = listakeyframes.elementAt(i-1);
                
                k.listaPuntos.clear();
                
                switch (k.transformacion) {
                    case TRASLACION:
                    {
                        Matriz3x3 m = Matriz3x3.traslacion(k.param[0], k.param[1]);
                        
                        for (int j = 0; i < anterior.listaPuntos.size(); j++) {
                            Punto p = anterior.listaPuntos.get(i);
                            Punto nuevo = new Punto(p.Px, p.Py);
                            nuevo.tranformar(m);
                            
                            k.listaPuntos.addElement(nuevo);
                        }
                        break;
                    }
                    case ESCALADO:
                    {
                            Matriz3x3 m = Matriz3x3.escalado(k.param[0], k.param[1]);
                        
                        for (int j = 0; i < anterior.listaPuntos.size(); j++) {
                            Punto p = anterior.listaPuntos.get(i);
                            Punto nuevo = new Punto(p.Px, p.Py);
                            nuevo.tranformar(m);
                            
                            k.listaPuntos.addElement(nuevo);
                        }
                        break;
                    }
                    case ROTACION:
                    {
                            Matriz3x3 m = Matriz3x3.rotacion(k.param[0]);
                        
                        for (int j = 0; i < anterior.listaPuntos.size(); j++) {
                            Punto p = anterior.listaPuntos.get(i);
                            Punto nuevo = new Punto(p.Px, p.Py);
                            nuevo.tranformar(m);
                            
                            k.listaPuntos.addElement(nuevo);
                        }
                        break;
                    }
                    case  SESGADO_X:
                    {
                            Matriz3x3 m = Matriz3x3.sesgado(k.param[0], k.param[1]);
                        
                        for (int j = 0; i < anterior.listaPuntos.size(); j++) {
                            Punto p = anterior.listaPuntos.get(i);
                            Punto nuevo = new Punto(p.Px, p.Py);
                            nuevo.tranformar(m);
                            
                            k.listaPuntos.addElement(nuevo);
                        }
                        break;
                    }
                    case SESGADO_Y:
                    {
                            Matriz3x3 m = Matriz3x3.sesgado(k.param[0], k.param[1]);
                        
                        for (int j = 0; i < anterior.listaPuntos.size(); j++) {
                            Punto p = anterior.listaPuntos.get(i);
                            Punto nuevo = new Punto(p.Px, p.Py);
                            nuevo.tranformar(m);
                            
                            k.listaPuntos.addElement(nuevo);
                        }
                        break;
                    }
                    default:
                        throw new AssertionError();
                }
            }
        }
       
    }
    
    public Keyframe getkeyframeAnterior(int numerodefotogramas){
        Keyframe k = listakeyframes.get(0);
        if(listakeyframes.size() > 1 && numerodefotogramas >0){
            for(int i = 0; i <listakeyframes.size();i++ ){
                k = listakeyframes.get(i);
                    if(i <  listakeyframes.size()
                            && numerodefotogramas >= listakeyframes.get(i).numerodefotogramas
                            && numerodefotogramas < listakeyframes.get(i+1).numerodefotogramas){
                        break;
                    }
            }
        }
        return k;
    } 
    public Keyframe  getkeyframeSiguiente(Keyframe anterior){
        int idx_anterior = listakeyframes.indexOf(anterior);
        if (idx_anterior < listakeyframes.size()-1){
            return listakeyframes.get(idx_anterior);
        }
        else{
            return null;
        }
    }
    public void EliminarKeyrame(Keyframe k) throws IllegalArgumentException{
        int idx = listakeyframes.indexOf(k);
        if(idx >0){
            listakeyframes.removeElement(k);
        }else{
            throw new  IllegalArgumentException("Error No se puede eliminar el keyframe");
        }
        ordenarkeyFrames();
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
    public void ActualizarAnimacion(int numerodefotogramas){
        Keyframe anterior = getkeyframeAnterior(numerodefotogramas);
        Keyframe siguiente = getkeyframeSiguiente(anterior);
        System.out.print("anterior "+ anterior.numerodefotogramas);
        if(siguiente != null){
              System.out.print("siguiente:  "+ siguiente.numerodefotogramas);
              int diff_fotogramas = siguiente.numerodefotogramas - anterior.numerodefotogramas;
              float fraccion = ((float)numerodefotogramas-(float)anterior.numerodefotogramas)/(float)diff_fotogramas;
              System.out.print("diff:  "+ diff_fotogramas+ ". fraccion "+fraccion);

        }
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
    