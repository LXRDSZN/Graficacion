/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficacion;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.List;

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

    public int getPy() {
        return Py;
    }

    public void setPy(int py) {
        Py = py;
    }

    public int getPx() {
        return Px;
    }

    public void setPx(int px) {
        Px = px;
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


    private List<Punto> puntos;

    public void transformar(Matriz3x3 matriz) {
        matriz.aplicarATodosLosPuntos(this.puntos);
    }





}
