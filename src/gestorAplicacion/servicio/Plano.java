package gestorAplicacion.servicio;

import java.awt.geom.*;

public class Plano {
    private int coorX;
    private int coorY;
    private Rectangle2D sede;
    private Ellipse2D zonaCobertura;
    private static Rectangle2D cuadrante;

    public Plano(int coorX, int coorY){
        this.coorX = coorX;
        this.coorY = coorY;
        cuadrante = new Rectangle2D.Double(0, 100, 100, 100);
    }

    public static Rectangle2D crearSede (int alto, int ancho, int coorX, int coorY){
        return new Rectangle2D.Double(coorX, coorY, ancho, alto);
    }

    public Ellipse2D crearZonaCobertura (int diametro, int centroX, int centroY){
        Ellipse2D.Double z=new Ellipse2D.Double();
        z.setFrameFromCenter(centroX, centroY, centroX+diametro/2, centroY+diametro/2);
        return z;
    }

    public Point2D crearPuntoOrdenado(int x, int y){
        return new Point2D.Double(x,y);
    }

    public int getY() {
        return coorY;
    }
    
    public void setY(int y) {
        this.coorY = y;
    }
    
    public int getX() {
        return coorX;
    }
    
    public void setX(int x) {
        this.coorX = x;
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
