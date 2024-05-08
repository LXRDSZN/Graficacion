
package Graficacion;

import com.badlogic.gdx.ApplicationListener;
import javax.swing.DefaultListModel;


/**
 *
 * @author lxrdszn
 */
//clase crea una cola para una lista de figuras
public class Obj3D implements ApplicationListener{
    VentanaPrincipal v;
    public DefaultListModel<Figura3d> listaFiguras3d;
    public Obj3D(VentanaPrincipal Ventana) {
        this.v = Ventana;
        listaFiguras3d = new DefaultListModel<>();
    }

    @Override
    public void create() {
        
    }
    @Override
    public void resize(int i, int i1) {
       
    }
    @Override
    public void render() {
        
    }
    @Override
    public void pause() {
        
    }
    @Override
    public void resume() {
        
    }
    @Override
    public void dispose() {
        
    }
}

//clase para el contructor que añadera una lista de figuras
 class Figura3d extends Figura {

    public Figura3d(String Nombre) {
        super(Nombre); 
    }

    @Override
    public String getNombre() {
        return super.getNombre(); 
    }

    @Override
    public void setNombre(String Nombre) {
        super.setNombre(Nombre);
    }

    @Override
    public String toString() {
        return getNombre(); 
    }


}