package gestorAplicacion.enrutadorHFC;

import gestorAplicacion.entidadesServicios.Cliente;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cobertura implements Serializable {

  protected int generacion;
  protected int intensidadFlujo;

  protected  Cobertura(int g){
    generacion=g;
}
//METODO UTILIZADO PRINCIPALMENTE POR LA CLASE ANTENA--FUNCIONALIDAD DEL TEST
  public abstract Antena rastrearGeneracionCompatible(ArrayList<Antena> antenasSede, Router r);

  //METODO UTILIZADO PRINCIPALMENTE POR LA CLASE ROUTER--FUNCIONALIDAD MEJORA TU PLAN
  public abstract ArrayList<Object> intensidadFlujoOptima(ArrayList<Servidor> ss,Cliente c);
  
  //METODO UTILIZADO PRINCIPALMENTE POR LA CLASE ROUTER--FUNCIONALIDAD REPORTE
  public abstract ArrayList<Integer> intensidadFlujoClientes(ArrayList<Cliente> ctes, Servidor servidor, boolean Reales);

  //METODO TOSTRING
  @Override
  public String toString(){
    return "";
  }

  //GETTERS Y SETTERS

  public int getGeneracion() {
    return generacion;
  }

  public void setGeneracion(int generacion) {
    this.generacion = generacion;
  }

  public int getIntensidadFlujo() {
    return intensidadFlujo;
  }

  public void setIntensidadFlujo(int intensidadFlujo) {
    this.intensidadFlujo = intensidadFlujo;
  }

}
