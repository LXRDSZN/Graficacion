
package Graficacion;

public class Keyframe {
    
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
    }
}