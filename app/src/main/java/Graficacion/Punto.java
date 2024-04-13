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
    public float Px;
    public float Py;

     //cambio de int a float
    public Punto(float Px, float Py) {
        this.Px = Px;
        this.Py = Py;
    }

    public void tranformar(Matriz3x3 mt){

        Matriz3x1 res = Matriz3x3.multmat33por31(mt,getMatriz());

        Px = (float) res.matriz[0];
        Py = (float) res.matriz[1];


    }

    public Matriz3x1 getMatriz(){

        return new Matriz3x1(Px,Py,1);

    }

    public float getPy() {
        return Py;
    }

    public void setPy(int py) {
        Py = py;
    }

    public float getPx() {
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








}
