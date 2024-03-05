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

/**
 *
 * @author libookami
 */
public class CanvasPanel implements ApplicationListener {
    
    VentanaPrincipal v;
    SpriteBatch batch;
    BitmapFont font;
    ShapeRenderer shapeRenderer;
    ShapeRenderer render;
    public CanvasPanel(VentanaPrincipal padre) {
        this.v = padre;
    }
    
    @Override
    public void create() {
        System.out.println("call create()");
        batch = new SpriteBatch();
        font = new BitmapFont();
        shapeRenderer = new ShapeRenderer();
        render = new ShapeRenderer();
    }

    @Override
    public void resize(int i, int i1) {
        System.out.println("call resize()");
        
    }

    @Override
    public void render() {
        //Limpiar con color de fondo.
        Gdx.gl.glClearColor(0.25f, 0.1f, 0.25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        font.draw(batch, "Hola mundo", (Integer)v.jSpinner1.getValue(), (Integer)v.jSpinner2.getValue());
        batch.end();
        
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(Color.CYAN);
        render.circle(200, 200, 10);
        render.end();
   
    }

    @Override
    public void pause() {
        System.out.println("call pause()");
    }

    @Override
    public void resume() {
        System.out.println("call resume()");
    }

    @Override
    public void dispose() {
        System.out.println("call dispose()");
        batch.dispose();
        font.dispose();
        shapeRenderer.dispose();
    }
    
}
