package gestorAplicacion.enrutadorWiMax;

import java.io.Serializable;
import java.util.ArrayList;

public class Servidor implements Red, Serializable{

  // Mejora tu plan y reporte lo usan 

    private String sede;
    private final double PORCENTAJE_EFICIENCIA;
    private boolean saturado = false;
    private ProveedorInternet proveedor;
    private Plano coordenadas;  
    private static ArrayList<Servidor> servidoresTotales = new ArrayList<>();
    private ArrayList<Router> routers = new ArrayList<>();
    private final int INDICE_SATURACION; //Numero de clientes que puede tener el servidor 
    private final int FLUJO_RED_NETO; // Lo que le resta a el servidor 


    public Servidor(boolean saturado, int INDICE_SATURACION, double pe){
        this.saturado=saturado;
        this.INDICE_SATURACION=INDICE_SATURACION;
        PORCENTAJE_EFICIENCIA = pe;
        this.FLUJO_RED_NETO=(int)(PORCENTAJE_EFICIENCIA*FLUJO_RED_PRELIMINAR);
        servidoresTotales.add(this);
  }
    public Servidor(){
        INDICE_SATURACION=0;
        PORCENTAJE_EFICIENCIA = 0;
        FLUJO_RED_NETO=0;
  }


  public static ArrayList<Servidor> buscarServidores(String localidad) {
    ArrayList<Servidor> serviSede = new ArrayList<Servidor>();
    for (Servidor servidor : servidoresTotales) {
      if ((servidor.getSede().equals(localidad)) && (!servidor.isSaturado())) {
        serviSede.add(servidor);
      }
    }
    return serviSede;
  }
  
  public  ArrayList<Servidor> verificarAdmin(ArrayList<ProveedorInternet> proveedores, String nombre){
    ArrayList<Servidor> servidoresProveedor = new ArrayList<>();
    for(ProveedorInternet proveedor: proveedores){
      if(proveedor.getNombre().equals(nombre)){
        for(Servidor servidor: servidoresTotales){
          if(servidor.getProveedor().getNombre().equals(nombre)){
            servidoresProveedor.add(servidor);
          }
        }
      }
    }
    return servidoresProveedor;
  }



}
