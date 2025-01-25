package gestorAplicacion.enrutadorHFC;

import gestorAplicacion.host.Cliente;
import gestorAplicacion.host.ProveedorInternet;
import java.util.ArrayList;

interface Red{
  
  //INTERFACE CREADA PARA QUE LA CLASE SERVIDOR LA IMPLEMENTE

  static final int FLUJO_RED_PRELIMINAR=500;

  ArrayList<Servidor> verificarAdmin(ArrayList<ProveedorInternet> proveedores, String nombre);
  ArrayList<Integer> distanciasOptimas(ArrayList<Cliente> clientes,ArrayList<Integer> listaIntensidadesClientes);

}