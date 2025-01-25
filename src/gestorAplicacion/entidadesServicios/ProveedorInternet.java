package gestorAplicacion.entidadesServicios;

import java.io.Serializable;
import java.util.*;
import gestorAplicacion.enrutadorHFC.Servidor;
import gestorAplicacion.servicio.Plan;
import gestorAplicacion.enrutadorHFC.Dispositivo;

//CLASE IMPORTANTE (SE RELACIONA CON EL CLIENTE), ATRIBUTOS
public class ProveedorInternet implements Serializable {
  private Plan planes;
  private String nombre;
  private ArrayList<Cliente> clientes = new ArrayList<>();
  private final int CLIENTES_MAX;
  private final int CLIENTES_BASIC;
  private final int CLIENTES_STANDARD;
  private final int CLIENTES_PREMIUM;
  private static ArrayList<ProveedorInternet> proveedoresTotales = new ArrayList<>();

  //CONSTRUCTORES (SON 2, SOBRECARGA)
  public ProveedorInternet (String nombre, int clientes_max, ArrayList<Integer> b, ArrayList<Integer> s, ArrayList<Integer> p, 
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

  //METODOS (SON 6, LOS DOS PRIMEROS CON SOBRECARGA: verificarCliente)
  
  //METODO INSTANCIA: FUNCIONALIDAD VISUALIZAR DISPOSITIVOS (COMPRUEBA QUE EL ID PASADO COMO PARÁMETRO COINCIDA CON ALGUN CLIENTE DEL ARREGLO CLIENTES TOTALES. VERIFICA QUE EL CLIENTE TENGA UN TIPO DE PLAN DETERMINADO)
  public Cliente verificarCliente (long id) {
    for (Cliente cliente : clientes) {
      if (cliente.getID() == id) {
        if (cliente.getNombrePlan().equals("PREMIUM")) {
          return cliente;
        } else if (cliente.getNombrePlan().equals("STANDARD")) {
          return cliente;
        } else {
          return null;
        }
      }
    }
    return null;
  }

  //METODO INSTANCIA: FUNCIONALIDAD MEJORA PLAN/TEST (COMPRUEBA QUE EL ID Y NOMBRE COINCIDAN CON UN CLIENTE DEL ARREGLO CLIENTES ASOCIADOS AL PROVEEDOR Y QUE EL CLIENTE TENGA MÁS DE 2 DISPOSITIVOS CONECTADODS)
  public Cliente verificarCliente (String nombre, long id) {
    for (Cliente cliente : clientes) {
      if ((cliente.getID() == id) && (cliente.getNombre().equals(nombre))) {
        if ((cliente.getModem().verificarDispositivos(Dispositivo.getDispositivosTotales(), cliente.getModem())).size()>2) {
          return cliente;
        }
      }
    }
    return null;
  }

  //METODO INSTANCIA: FUNCIONALIDAD ADQUISICION PLAN (OBTIENE LOS CLIENTES ASOCIADOS SEPARADOS POR EL TIPO DE PLAN INVOCANDO EL METODO buscarCliente. COMPRUEBA QUE HAYAN CUPOS EN CADA UNO DE LOS PLANES)
  public ArrayList<String> planesDisponibles (Cliente cliente) {
    ArrayList<Cliente> clientesBasic = cliente.buscarCliente(this.clientes, "BASIC");
    ArrayList<Cliente> clientesStandard = cliente.buscarCliente(this.clientes, "STANDARD");
    ArrayList<Cliente> clientesPremium = cliente.buscarCliente(this.clientes, "PREMIUM");
    ArrayList<String> planesD = new ArrayList<String>();

    if (clientesBasic.size() < this.CLIENTES_BASIC) {
      planesD.add("BASIC");
    }
    if (clientesStandard.size() < this.CLIENTES_STANDARD) {
      planesD.add("STANDARD");
    }
    if ((clientesPremium.size() < this.CLIENTES_PREMIUM)) {
      planesD.add("PREMIUM");
    }
    return planesD;
  }

  //METODO INSTANCIA: FUNCIONALIDAD ADQUISICION PLAN (PERMITE CREAR UN NUEVO CLIENTE CON LOS DATOS INDICADOS)
  public Cliente crearClienteNuevo (String nombre, long id) {
    Cliente cliente = new Cliente(nombre, id, this);
    return cliente;
  }

  //METODO ESTATICO: FUNCIONALIDAD ADQUISICION PLAN (MEDIANTE EL ARREGLO ESTÁTICO DE TODOS LOS SERVIDORES DE LA CLASE SERVIDOR, SE HALLAN LOS PROVEEDORES QUE PERTENEZCAN A UNA SEDE ESPECIFICA)
  public static ArrayList<ProveedorInternet> proveedorSede(String sede) {
    ArrayList<ProveedorInternet> proveedores = new ArrayList<>();
    for (Servidor servidor : Servidor.getServidoresTotales()) {
      if (servidor.getSede().equals(sede)) {
        proveedores.add(servidor.getProveedor());
      }
    }
    return proveedores;
  }

  //METODO ESTATICO: SE EJECUTA DESPUES DE LA DESERIALIZACION EN EL MAIN (OBTIENE LOS PROVEEDORES DE LOS SERVIDORES Y AGREGA ESTOS AL ARREGLO DE PROVEEDORES TOTALES)
  public static void proveedores() {
    for (Servidor servi : Servidor.getServidoresTotales()) {
      ProveedorInternet prove = servi.getProveedor();
      if (!proveedoresTotales.contains(prove)) {
        proveedoresTotales.add(prove);
      }
    }
  }

  //METODOS GET Y SET
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

  public ArrayList<Cliente> getClientes() {
    return clientes;
  }
  public void setClientes(ArrayList<Cliente> clientes) {
    this.clientes = clientes;
  }

  public int getCLIENTES_MAX() {
    return CLIENTES_MAX;
  }

  public int getCLIENTES_BASIC() {
    return CLIENTES_BASIC;
  }

  public int getCLIENTES_STANDARD() {
    return CLIENTES_STANDARD;
  }

  public int getCLIENTES_PREMIUM() {
    return CLIENTES_PREMIUM;
  }

  public static ArrayList<ProveedorInternet> getProveedoresTotales() {
    return proveedoresTotales;
  }
  public static void setProveedoresTotales(ArrayList<ProveedorInternet> proveedoresTotales) {
    ProveedorInternet.proveedoresTotales = proveedoresTotales;
  }


}

