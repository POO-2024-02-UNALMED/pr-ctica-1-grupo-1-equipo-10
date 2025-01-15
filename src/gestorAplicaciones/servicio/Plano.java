package gestorAplicaciones.servicio;

import java.awt.geom.*;

public class Plano {
    private int corX;
    private int corY;
    private Rectangle2D sede;
    private Ellipse2D zonaCobertura;
    private static Rectangle2D cuadrante;

    public Plano(int corX, int corY){
        this.corX = corX;
        this.corY = corY;
        cuadrante = new Rectangle2D.Double(0, 100, 100, 100);
    }

    public static Rectangle2D crearSede (int alto, int ancho, int corX, int corY){
        return new Rectangle2D.Double(corX, corY, ancho, alto);
    }

    public Ellipse2D crearZonaCobertura (int diametro, int centroX, int centroY){
        Ellipse2D.Double z=new Ellipse2D.Double();
        z.setFrameFromCenter(centroX, centroY, centroX+diametro/2, centroY+diametro/2);
        return z;
    }


    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public Rectangle2D getSede() {
        return sede;
    }
    
    public void setSede(Rectangle2D sede) {
        this.sede = sede;
    }
    
    public Ellipse2D getZonaCobertura() {
        return zonaCobertura;
    }
    
    public void setZonaCobertura(Ellipse2D zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }
    
    public static Rectangle2D getCuadrante() {
        return cuadrante;
    }
    
    public static void setCuadrante(Rectangle2D cuadrante) {
        Plano.cuadrante = cuadrante;
    }
}
