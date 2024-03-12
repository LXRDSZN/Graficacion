/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficacion;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import javax.swing.DefaultListModel;

/**
 *
 * @author libookami
 */
public class Canvas implements ApplicationListener{

    SpriteBatch batch;
    BitmapFont font;
    ShapeRenderer rend;
    
    
    
    public DefaultListModel<Figura> listaFiguras;

    public Canvas() {
        listaFiguras = new DefaultListModel<>();
        
        listaFiguras.addElement(new Figura("Figu1"));
        //listaFiguras.addElement(new Figura("Figu2"));
        //listaFiguras.addElement(new Figura("Figu3"));
    }
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        rend = new ShapeRenderer();
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void render() {
        //Limpiar con color de fondo.
        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        rend.begin(ShapeRenderer.ShapeType.Line); // Iniciar el ShapeRenderer para dibujar líneas

        rend.setColor(Color.WHITE);
        // Dibujar líneas horizontales
        for (int y = 0; y <= Gdx.graphics.getHeight(); y += 20) {
            rend.line(0, y, Gdx.graphics.getWidth(), y);
        }

        // Dibujar líneas verticales
        for (int x = 0; x <= Gdx.graphics.getWidth(); x += 20) {
            rend.line(x, 0, x, Gdx.graphics.getHeight());
        }

        rend.end(); // Finalizar el dibujo de líneas horizontales y verticales

        rend.begin(ShapeRenderer.ShapeType.Line); // Iniciar el ShapeRenderer para dibujar las líneas que unen los puntos

        rend.setColor(Color.BLUE); // Color de la línea

        // Dibujar líneas que unen los puntos de cada figura
        for (int i = 0; i < listaFiguras.size(); i++) {
            Figura figura = listaFiguras.get(i);
            DefaultListModel<Punto> puntos = figura.listaPuntos;

            if (puntos.size() > 1) {
                for (int j = 0; j < puntos.size() - 1; j++) {
                    Punto puntoActual = puntos.get(j);
                    Punto puntoSiguiente = puntos.get(j + 1);

                    rend.line(puntoActual.Px * Figura.escala, puntoActual.Py * Figura.escala,
                            puntoSiguiente.Px * Figura.escala, puntoSiguiente.Py * Figura.escala);
                }

                // Unir el último punto con el primero para cerrar la figura
                Punto primerPunto = puntos.get(0);
                Punto ultimoPunto = puntos.get(puntos.size() - 1);
                rend.line(ultimoPunto.Px * Figura.escala, ultimoPunto.Py * Figura.escala,
                        primerPunto.Px * Figura.escala, primerPunto.Py * Figura.escala);
            }
        }

        rend.end(); // Finalizar el dibujo de las líneas que unen los puntos

        rend.begin(ShapeRenderer.ShapeType.Filled); // Iniciar el ShapeRenderer para dibujar los puntos

        rend.setColor(Color.RED); // Color de los puntos

        // Dibujar los puntos de cada figura
        for (int i = 0; i < listaFiguras.size(); i++) {
            Figura figura = listaFiguras.get(i);
            DefaultListModel<Punto> puntos = figura.listaPuntos;

            for (int j = 0; j < puntos.size(); j++) {
                Punto punto = puntos.get(j);
                rend.circle(punto.Px * Figura.escala, punto.Py * Figura.escala, 10);
            }
        }

        rend.end(); // Finalizar el dibujo de los puntos
    }



    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        rend.dispose();
    }
    
}
