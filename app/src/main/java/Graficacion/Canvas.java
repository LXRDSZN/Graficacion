/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficacion;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import javax.swing.DefaultListModel;

/**
 *
 * @author libookami
 */
public class Canvas implements ApplicationListener{
    VentanaPrincipal v;
    SpriteBatch batch;
    BitmapFont font;
    ShapeRenderer rend;
    //3D
    Environment env;
    ModelBatch batch3d;
    ModelBuilder builder3d;
    PerspectiveCamera cam;
    CameraInputController caminput;
    Model m1;
    ModelInstance m1instance;


    //Metodo para la colocacion de puntos 
    public void setEspaciado(int nuevoEspaciado) {
        int antiguoEspaciado = this.espaciado;
        this.espaciado = nuevoEspaciado;

        // Calcular el factor de escala
        float factorEscala = (float) nuevoEspaciado / antiguoEspaciado;

        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                // Recalcular las coordenadas de los puntos existentes
                for (int i = 0; i < listaFiguras.size(); i++) {
                    DefaultListModel<Punto> puntos = listaFiguras.get(i).listaPuntos;
                    for (int j = 0; j < puntos.size(); j++) {
                        Punto punto = puntos.get(j);
                        punto.Px = (int) (punto.Px * factorEscala);
                        punto.Py = (int) (punto.Py * factorEscala);
                    }
                }

                // Volver a dibujar los puntos en el lienzo con las nuevas coordenadas escaladas
                render();
            }
        });
    }
        public DefaultListModel<Figura> listaFiguras;
    //Creacion de Nombres para jlist1
    public Canvas(VentanaPrincipal Ventana) {
        this.v = Ventana;
        listaFiguras = new DefaultListModel<>();
        
        listaFiguras.addElement(new Figura(""));
    }
        private int espaciado = 20; 
    //Metodo para inicializar 2d
    void inicializar2d(){
        batch = new SpriteBatch();
        font = new BitmapFont();
        rend = new ShapeRenderer();
    }
    //Metodo para la creacion de renderizado 3d Para mostrar primitiva por defecto
    void inicializar3d(){
        env = new Environment();
        env.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        env.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
        
        DefaultShader.Config shader_config = new DefaultShader.Config();
        shader_config.numDirectionalLights = 1;
        shader_config.numPointLights = 0;
        shader_config.numBones = 16;
        
        batch3d = new ModelBatch(new DefaultShaderProvider(shader_config));
        
        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(10f,10,10f);
        cam.lookAt(0, 0, 0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();
        
        builder3d = new ModelBuilder();
        
        m1 = builder3d.createBox(0f, 0f, 0f, //Tamaño
                              new Material(ColorAttribute.createDiffuse(Color.GOLD)), //Color
                              VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        
        m1instance = new ModelInstance(m1);
        
        caminput = new CameraInputController(cam);
        Gdx.input.setInputProcessor(caminput);
        
    }
    //Mtodo Create para inicializar el renderizado 2d y 3 d
    @Override
    public void create() {
        System.out.println("Ejecutado create");
        inicializar2d();
        inicializar3d();
        batch = new SpriteBatch();
        font = new BitmapFont();
        rend = new ShapeRenderer();
        
    }

    @Override
    public void resize(int i, int i1) {
    }
    //renders 2d y 3d
    //render 2d Graficacion de puntos en 2d
    void render2d(){
        //Limpiar con color de fondo.
        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        rend.begin(ShapeRenderer.ShapeType.Line); // Iniciar el ShapeRenderer para dibujar líneas
        rend.setColor(Color.WHITE);
        
        // Dibujar líneas horizontales
        for (int y = 0; y <= Gdx.graphics.getHeight(); y += espaciado) {
            rend.line(0, y, Gdx.graphics.getWidth(), y);
        }

        // Dibujar líneas verticales
        for (int x = 0; x <= Gdx.graphics.getWidth(); x += espaciado) {
            rend.line(x, 0, x, Gdx.graphics.getHeight());
        }

        //}
        //rend.setColor(Color.RED);
        //rend.rectLine(120, 220, 300, 320, 5);
        rend.end();
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
    //render 3d Movimiento de camara
    void render3d(){
     //Limpiar con color de fondo.       
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        
        
        //mover camara con botones de 3D
        
        //mover camara con respecto a y
        if(v.jButton13.getModel().isPressed()){
            cam.position.y -= 0.1;
        }
        if(v.jButton16.getModel().isPressed()){
            cam.position.y +=0.1;
        }
        
        //Mover camara con respecto a x
        
         if(v.jButton14.getModel().isPressed()){
            cam.position.x -= 0.1;
        }
        if(v.jButton15.getModel().isPressed()){
            cam.position.x +=0.1;
        }
        //Mover camara con respecto al frente y atras
        
        if(v.jButton17.getModel().isPressed()){
            cam.position.z -= 0.1;
        }
        if(v.jButton18.getModel().isPressed()){
            cam.position.z +=0.1;
        }
        
        cam.update();
        caminput.update();
        
        batch3d.begin(cam);
        batch3d.render(m1instance,env);
        batch3d.end();
    }
    
    @Override
    public void render() {
        if(v.jRadioButton1.isSelected()){
            render2d();
        }else{
            render3d();
        }
    }
   // Método modificado para aceptar dimensiones como parámetros
    public void crearModelo(final String tipo, final float sx, final float sy, final float sz) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
          
                com.badlogic.gdx.graphics.Color colorDefault = new com.badlogic.gdx.graphics.Color(1, 1, 1, 1); // Blanco

                Model model;
                switch (tipo) {
                    case "CUBO":
                        model = builder3d.createBox(sx, sy, sz,
                                new Material(ColorAttribute.createDiffuse(colorDefault)),
                                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
                        break;
                    case "ESFERA":
                        model = builder3d.createSphere(sx, sy, sz, 32, 32,
                                new Material(ColorAttribute.createDiffuse(colorDefault)),
                                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
                        break;
                    case "CILINDRO":
                        model = builder3d.createCylinder(sx, sy, sz, 32,
                                new Material(ColorAttribute.createDiffuse(colorDefault)),
                                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
                        break;
                    case "CONO":
                        model = builder3d.createCone(sx, sy, sz, 32,
                                new Material(ColorAttribute.createDiffuse(colorDefault)),
                                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
                        break;
                    default:
                        System.out.println("Tipo no reconocido: " + tipo);
                        return;
                }
                m1instance = new ModelInstance(model);
            }
        });
    }
    public void eliminar(){
          Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
             
                if (m1instance != null) {
                m1.dispose();
                inicializar3d();       
                }
                
            }
        });
    }
    
    public void cambiarColorModelo(java.awt.Color awtColor) {
    Gdx.app.postRunnable(new Runnable() {
        @Override
        public void run() {
            com.badlogic.gdx.graphics.Color gdxColor = new com.badlogic.gdx.graphics.Color(
                awtColor.getRed() / 255f, 
                awtColor.getGreen() / 255f, 
                awtColor.getBlue() / 255f, 
                awtColor.getAlpha() / 255f
            );

            if (m1instance != null && m1instance.materials.size > 0) {
                m1instance.materials.get(0).set(ColorAttribute.createDiffuse(gdxColor));
            }
        }
    });


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
        m1.dispose();
    }
    
}
