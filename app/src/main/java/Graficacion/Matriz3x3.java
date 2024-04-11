package Graficacion;

import java.util.List;

public class Matriz3x3 {
    private double[][] matriz = new double[3][3];

    public Matriz3x3() {
        // Constructor para la matriz identidad
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = (i == j) ? 1 : 0;
            }
        }
    }

    public static Matriz3x3 traslacion(double dx, double dy) {
        Matriz3x3 m = new Matriz3x3();
        m.matriz[0][2] = dx;
        m.matriz[1][2] = dy;
        return m;
    }

    public static Matriz3x3 escalado(double sx, double sy) {
        Matriz3x3 m = new Matriz3x3();
        m.matriz[0][0] = sx;
        m.matriz[1][1] = sy;
        return m;
    }

    public static Matriz3x3 rotacion(double angulo) {
        Matriz3x3 m = new Matriz3x3();
        double rad = Math.toRadians(angulo);
        m.matriz[0][0] = Math.cos(rad);
        m.matriz[0][1] = -Math.sin(rad);
        m.matriz[1][0] = Math.sin(rad);
        m.matriz[1][1] = Math.cos(rad);
        return m;
    }

    public static Matriz3x3 sesgado(double sx, double sy) {
        Matriz3x3 m = new Matriz3x3();
        m.matriz[0][1] = sx;
        m.matriz[1][0] = sy;
        return m;
    }

    public void aplicarATodosLosPuntos(List<Punto> puntos) {
        for (Punto punto : puntos) {
            double xNuevo = matriz[0][0] * punto.getPx() + matriz[0][1] * punto.getPy() + matriz[0][2];
            double yNuevo = matriz[1][0] * punto.getPx() + matriz[1][1] * punto.getPy() + matriz[1][2];
            punto.setPx((int) xNuevo);
            punto.setPy((int) yNuevo);
        }
    }

    // public  static Matriz31 MultiplicarMatriz33por31(){
         
     //}


}

