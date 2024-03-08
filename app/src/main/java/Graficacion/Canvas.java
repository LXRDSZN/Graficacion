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
        listaFiguras.addElement(new Figura("Figu2"));
        listaFiguras.addElement(new Figura("Figu3"));
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
        
        batch.begin();
        font.draw(batch, "Hola mundo", 100, 100);
        batch.end();
        
        rend.begin(ShapeRenderer.ShapeType.Line);
        rend.setColor(Color.WHITE);
        rend.line(0, 100, Gdx.graphics.getWidth(), 100);
        rend.line(100, 0, 100, Gdx.graphics.getHeight());
        rend.end();
        
        rend.begin(ShapeRenderer.ShapeType.Filled);
        
        for (int i = 0; i < listaFiguras.size(); i++) {
            listaFiguras.get(i).dibujar(rend);
        }
        
        rend.setColor(Color.RED);
        rend.rectLine(120, 220, 300, 320, 3);

        rend.end();
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
