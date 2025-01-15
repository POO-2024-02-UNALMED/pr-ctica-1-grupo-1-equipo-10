package gestorAplicaciones.entidadesServicios;

import.java.util.*;
import.gestorAplicaciones.enrutadorWiMax.Servidor;
import.gestorAplicaciones.servicio.Plan;
import.gestorAplicaciones.enrutadorWiMax.Dispositivo;

public class ProveedorInternet                      {
  //atributos
  private Plan planes;
  private String nombre;
  private ArrayList<Cliente> clientes = new ArrayList<>();
  private final int CLIENTES_MAX;
  private final int CLIENTES_BASIC;
  private final int CLIENTES_STANDARD;
  private final int CLIENTES_PREMIUM;
  private static ArrayList<ProveedorInternet> proveedoresTotales = new ArrayList<>();

  public ProveedorInternet(String nombre, int clientes_max, ArrayList<Integer> b, ArrayList<Integer> s, ArrayList<Integer> p, 
                           int cmb, int cms, int cmp) {
    this(clientes_max, cmb, cms, cmp);
    this.nombre = nombre;
    this.planes = new Plan(b,s,p);
  }

  public ProveedorInternet(int clientes_max, int clientes_basic, int clientes_standard, int clientes_premium) {
    this.CLIENTES_MAX = clientes_max;
    this.CLIENTES_BASIC = clientes_basic;
    this.CLIENTES_STANDARD = clientes_standard;
    this.CLIENTES_PREMIUM = clientes_premium;
    proveedoresTotales.add(this);
  }

  public Plan getPlanes() {
    return planes;
  }

  public void setPlanes(Plan planes) {
    this.planes = planes;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
 
}

