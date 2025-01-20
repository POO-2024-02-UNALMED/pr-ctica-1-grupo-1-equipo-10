package gestorAplicacion.enrutadorWiMax;

import java.util.*;
import java.util.stream.*;
import gestorAplicacion.host.Cliente;
import gestorAplicacion.host.ProveedorInternet;
import gestorAplicacion.servicio.Plano;
import java.awt.geom.*;

public class Antena extends Cobertura{

    private int identificador;
    private Point2D coordenadas;
    private String sede;
    private Ellipse2D zonaCobertura;
    private ProveedorInternet proveedor;
    private static ArrayList<Antena> antenasTotales = new ArrayList<>(); 


  //CONSTRUCTORES
  public Antena(int identificador, Plano coordenadas,String sede, int generacion, int radio, ProveedorInternet proveedor){
    super(generacion);
    this.identificador = identificador;
    this.coordenadas=new Point2D.Double(coordenadas.getX(),coordenadas.getY());
    this.sede=sede;
    this.proveedor=proveedor;
    zonaCobertura=(Ellipse2D)coordenadas.crearZonaCobertura(radio*2,coordenadas.getX(),coordenadas.getY());  
    antenasTotales.add(this);     
  }

  //METODOS

  //METODO INSTANCIA---BUSCA LAS ANTENAS QUE PERTENECEN A UNA SEDE EN ESPECIFICO-FUNCIONALIDAD TEST
  public static ArrayList<Antena> antenasSede(String sede){
    ArrayList<Antena> antenas = new ArrayList<>();
    for(Antena antena: antenasTotales){
      if(antena.getSede().equals(sede)){
        antenas.add(antena);
      }
    }
    return antenas;
  }

  //METODO INSTANCIA---BUSCA LAS ANTENAS QUE ESTAN EN UNA SEDE Y QUE PERTENECEN A UN PROVEEDOR ESPECIFICO--FUNCIONALIDAD MEJORA TU PLAN (PARA SETEAR UNA ANTENA DEL PROVEEDOR NUEVO CUANDO SE REALICE EL CAMBIO)
  public static Antena antenasSede(String sede, String proveedor){
    for(Antena antena: antenasTotales){
      if(antena.getSede().equals(sede)){
        if(antena.getProveedor().getNombre().equals(proveedor)){
          return antena;
        }
        
      }
    }
    return null;
  }

// metodos que faltan el de cobertura 
// el de el error 
// y el tostring.


  public static void antenas(){

    for(Antena antena: Antena.getAntenasTotales()){

      ProveedorInternet provee= antena.getProveedor();

      for(ProveedorInternet prove: ProveedorInternet.getProveedoresTotales()){

        if(provee.getNombre().equals(prove.getNombre())){
          antena.setProveedor(prove);
        }
      }

    }
  }


  public int getIdentificador() {
    return identificador;
  }

  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  public Point2D getCoordenadas() {
    return coordenadas;
  }

  public void setCoordenadas(Point2D coordenadas) {
    this.coordenadas = coordenadas;
  }

  public String getSede() {
    return sede;
  }

  public void setSede(String sede) {
    this.sede = sede;
  }

  public Ellipse2D getZonaCobertura() {
    return zonaCobertura;
  }

  public void setZonaCobertura(Ellipse2D zonaCobertura) {
    this.zonaCobertura = zonaCobertura;
  }

  public ProveedorInternet getProveedor() {
    return proveedor;
  }

  public void setProveedor(ProveedorInternet proveedor) {
    this.proveedor = proveedor;
  }

  public static ArrayList<Antena> getAntenasTotales() {
    return antenasTotales;
  }

  public static void setAntenasTotales(ArrayList<Antena> antenasTotales) {
    Antena.antenasTotales = antenasTotales;
  }

}



