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
        
        //lineas hotizontales y verticales
        rend.begin(ShapeRenderer.ShapeType.Line);
        rend.setColor(Color.WHITE);
        // Dibujar líneas horizontales
        for (int y = 0; y <= Gdx.graphics.getHeight(); y += 20) {
            rend.line(0, y, Gdx.graphics.getWidth(), y);
            }
    
        // Dibujar líneas verticales
        for (int x = 0; x <= Gdx.graphics.getWidth(); x += 20) {
            rend.line(x, 0, x, Gdx.graphics.getHeight());
            }
        rend.end();       
        //fin de las lineas
       
        //insertar puntos
        rend.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < listaFiguras.size(); i++) {
            listaFiguras.get(i).dibujar(rend);
        }
        //generador de linea a punto x a punto xy
       // rend.setColor(Color.RED);
        //for(int l = 0;l <= listaFiguras.size(); l++){
            
          //  rend.rec
        //}
        //rend.setColor(Color.RED);
        //rend.rectLine(120, 220, 300, 320, 5);
        //rend.end();
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
