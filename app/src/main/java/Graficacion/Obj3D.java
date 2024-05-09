
package Graficacion;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.color;
import javax.swing.DefaultListModel;


/**
 *
 * @author lxrdszn
 */
//clase crea una cola para una lista de figuras
public class Obj3D implements ApplicationListener{
    Canvas color3D;
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
    
    private String tipo;
    private float sx, sy, sz;  // Dimensiones en los ejes x, y, z
    private Color color;       // Utilizando java.awt.Color

    // Constructor
    public Obj3D(String tipo, float sx, float sy, float sz, Color color) {
        this.tipo = tipo;
        this.sx = sx;
        this.sy = sy;
        this.sz = sz;
        this.color = color;
    }

    // Métodos getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getSx() {
        return sx;
    }

    public void setSx(float sx) {
        this.sx = sx;
    }

    public float getSy() {
        return sy;
    }

    public void setSy(float sy) {
        this.sy = sy;
    }

    public float getSz() {
        return sz;
    }

    public void setSz(float sz) {
        this.sz = sz;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

