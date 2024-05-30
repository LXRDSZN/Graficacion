
package Graficacion;

import javax.swing.DefaultListModel;
import org.lwjgl.input.Keyboard;
import java.lang.String;
public class Keyframe {
    public DefaultListModel<Punto> listaPuntos;
    
    public enum tiposTransf { NINGUNO, TRASLACION, ESCALADO,ROTACION,SESGADO_X,SESGADO_Y}
    
    int numerodefotogramas = 0;
    Figura figura ;
    tiposTransf transformacion = tiposTransf.NINGUNO;
     

     
    float[] param;
    public Keyframe(int num_fotograma,tiposTransf transf,Figura figura,float[] param){
        this.figura = figura;
        this.param = param;
        this.numerodefotogramas = num_fotograma;
        this.transformacion = transf;
        
        listaPuntos = new DefaultListModel<>();
    }

    @Override
    public String toString() {
        return numerodefotogramas + " : "+figura.getNombre()+" : "+transformacion.toString() + " : "+ param[0]+","+param[1]+puntosAstring();
    }
    public String puntosAstring(){
            String  puntos = "{";
            for (int i = 0 ; i < listaPuntos.getSize(); i++){
            puntos += " " + listaPuntos.get(i).getPx();
            puntos += ",";
            puntos += " " + listaPuntos.get(i).getPy();
            puntos += ",";
        }
         puntos += "}";
        return puntos;
    }

}