package gestorAplicacion.enrutadorWiMax;

import java.util.*;
import java.util.stream.*;
import gestorAplicacion.host.Cliente;
import gestorAplicacion.host.ProveedorInternet;
import gestorAplicacion.servicio.Plano;

public class Antena extends Cobertura{

    private int identificador;
    private Point2D coordenadas;
    private String sede;
    private Ellipse2D zonaCobertura;
    private ProveedorInternet proveedor;
    private static ArrayList<Antena> antenasTotales = new ArrayList<>(); 

  public Antena(int identificador, Plano coordenadas,String sede, int generacion, int radio, ProveedorInternet proveedor){
    super(generacion);
    this.identificador = identificador;
    this.coordenadas=new Point2D.Double(coordenadas.getX(),coordenadas.getY());
    this.sede=sede;
    this.proveedor=proveedor;
    zonaCobertura=(Ellipse2D)coordenadas.crearZonaCobertura(radio*2,coordenadas.getX(),coordenadas.getY());  
    antenasTotales.add(this);     
  }

  public static ArrayList<Antena> antenasSede(String sede){
    ArrayList<Antena> antenas = new ArrayList<>();
    for(Antena antena: antenasTotales){
      if(antena.getSede().equals(sede)){
        antenas.add(antena);
      }
    }
    return antenas;
  }
}