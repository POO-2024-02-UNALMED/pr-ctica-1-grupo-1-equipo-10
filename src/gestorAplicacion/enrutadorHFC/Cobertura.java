// Maria Jose Monroy Mejia
// Valeria Moreno Rojas
// Justin Camilo Loaiza Lujan

package gestorAplicacion.enrutadorHFC;

import gestorAplicacion.host.Cliente;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cobertura implements Serializable{
  
  //ATRIBUTOS
  protected int generacion;
  protected int intensidadFlujo;

  //CONSTRUCTOR
  protected Cobertura(int g){
    generacion=g; 
  } 

  //METODOS 

  //METODOS ABSTRACTOS

  //METODO UTILIZADO EN SU MAYORIA POR LA CLASE ANTENA PARA LA FUNCIONALIDAD DEL TEST
  public abstract Antena rastrearGeneracionCompatible(ArrayList<Antena> antenasSede, Router r);

  //METODO UTILIZADO EN SU MAYORIA POR LA CLASE ROUTER PARA LA FUNCIONALIDAD MEJORA TU PLAN
  public abstract ArrayList<Object> intensidadFlujoOptima(ArrayList<Servidor> ss,Cliente c);
  
  //METODO UTILIZADO EN SU MAYORIA POR LA CLASE ROUTER PARA LA FUNCIONALIDAD REPORTE
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
