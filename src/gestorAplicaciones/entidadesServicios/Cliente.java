package gestorAplicaciones.entidadesServicios;

import.java.util.*;
import.gestorAplicaciones.enrutadorWiMax.Router;
import.gestorAplicaciones.enrutadorWiMax.Servidor;
import.gestorAplicaciones.servicio.Plano;
import.gestorAplicaciones.enrutadorWiMax.Antena;

public class Cliente                      {
  private String nombre;
  private final long ID;
  private Router modem;
  private ProveedorInternet proveedor;
  private ArrayList<Integer> plan;
  private String nombrePlan;
  private Factura factura;

  public Cliente(String nombre, long id, Router modem, ProveedorInternet proveedor,
                ArrayList<Integer> plan, String nombrePlan, Factura factura) {
    this.ID = id;
    this.nombre = nombre;
    this.modem = modem;
    this.proveedor = proveedor;
    this.plan = plan;
    this.nombrePlan = nombrePlan;
    this.factura = factura;
    proveedor.getClientes().add(this);
  }

  public Cliente(String nombre, long id, Router modem, ProveedorInternet proveedor,
                ArrayList<Integer> plan, String nombrePlan) {
    this.ID = id;
    this.nombre = nombre;
    this.modem = modem;
    this.proveedor = proveedor;
    this.plan = plan;
    this.nombrePlan = nombrePlan;
    proveedor.getClientes().add(this);
  }

  public Cliente(String nombre, long id, ProveedorInternet proveedor) {
    this.nombre = nombre;
    ID = id;
    this.proveedor = proveedor;
    proveedor.getClientes().add(this);
  }

    
                
  
}
