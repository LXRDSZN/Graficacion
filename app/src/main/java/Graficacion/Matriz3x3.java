package Graficacion;

import java.util.Arrays;
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


    public static Matriz3x1 multmat33por31(Matriz3x3 m33, Matriz3x1 m31){

        Matriz3x1 m = new Matriz3x1();
        m.matriz[0] = m33.matriz[0][0] * m31.matriz[0] + m33.matriz[1][0] * m31.matriz[1] + m33.matriz[2][0] * m31.matriz[2];
        m.matriz[1] = m33.matriz[0][1] * m31.matriz[0] + m33.matriz[1][1] * m31.matriz[1] + m33.matriz[2][1] * m31.matriz[2];
        m.matriz[2] = m33.matriz[0][2] * m31.matriz[0] + m33.matriz[1][2] * m31.matriz[1] + m33.matriz[2][2] * m31.matriz[2];

        m.matriz[0] = m33.matriz[0][0] * m31.matriz[0] + m33.matriz[0][1] * m31.matriz[1] + m33.matriz[0][2] * m31.matriz[2];
        m.matriz[1] = m33.matriz[1][0] * m31.matriz[0] + m33.matriz[1][1] * m31.matriz[1] + m33.matriz[1][2] * m31.matriz[2];
        m.matriz[2] = m33.matriz[2][0] * m31.matriz[0] + m33.matriz[2][1] * m31.matriz[1] + m33.matriz[2][2] * m31.matriz[2];

        // Imprimiendo cada componente de la matriz y del vector, así como los resultados intermedios

        System.out.println("Componentes de la matriz 3x3:");
        System.out.println("[" + m33.matriz[0][0] + ", " + m33.matriz[0][1] + ", " + m33.matriz[0][2] + "]");
        System.out.println("[" + m33.matriz[1][0] + ", " + m33.matriz[1][1] + ", " + m33.matriz[1][2] + "]");
        System.out.println("[" + m33.matriz[2][0] + ", " + m33.matriz[2][1] + ", " + m33.matriz[2][2] + "]");

        System.out.println("Componentes del vector 3x1:");
        System.out.println("[" + m31.matriz[0] + ", " + m31.matriz[1] + ", " + m31.matriz[2] + "]");

        System.out.println("Resultados de la multiplicación:");
        System.out.println("X = " + m.matriz[0]);
        System.out.println("Y = " + m.matriz[1]);
        System.out.println("Homogenea = " + m.matriz[2]);

        return m;



    }


}

