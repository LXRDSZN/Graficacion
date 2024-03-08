/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficacion;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author libookami
 */
public class Punto {
    public int Px;
    public int Py;

    public Punto(int Px, int Py) {
        this.Px = Px;
        this.Py = Py;
    }
    
    @Override
    public String toString() {
        return "("+Px+","+Py+")";
    }
    
    public void dibujar(ShapeRenderer rend)
    {
        rend.setColor(Color.GOLD);
        rend.circle(Px * Figura.escala, Py * Figura.escala, 10);
    }
}
