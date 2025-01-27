// Maria Jose Monroy Mejia
// Valeria Moreno Rojas
// Justin Camilo Loaiza Lujan

package gestorAplicacion.enrutadorHFC;

import gestorAplicacion.host.Cliente;
import gestorAplicacion.host.ProveedorInternet;
import java.util.ArrayList;

public interface Red{
  
  //INTERFACE CREADA PARA QUE LA CLASE SERVIDOR LA IMPLEMENTE

  //CONSTANTES
  static final int FLUJO_RED_PRELIMINAR=500;

  //MÉTODOS
  //METODO POR DEFAULT-FUNCIONALIDAD REPORTE--VERIFICA ADMIN Y RETORNA SERVIDORES DE UN PROVEEDOR EN TODAS LAS LOCALIDADES
  default ArrayList<Servidor> verificarAdmin(ArrayList<ProveedorInternet> proveedores, String nombre){
    ArrayList<Servidor> servidoresProveedor = new ArrayList<>();
    for(ProveedorInternet proveedor: proveedores){
      if(proveedor.getNombre().equals(nombre)){
        for(Servidor servidor: Servidor.getServidoresTotales()){
          if(servidor.getProveedor().getNombre().equals(nombre)){
            servidoresProveedor.add(servidor);
          }
        }
      }
    }
    return servidoresProveedor;
  }
  ArrayList<Integer> distanciasOptimas(ArrayList<Cliente> clientes,ArrayList<Integer> listaIntensidadesClientes);

  //METODO ESTATICO-FUNCIONALIDAD REPORTE--CALCULA EL PROMEDIO DE LAS INTESIDADES NETAS---SE USA POR LIGADURA DINAMICA
  static int calcularPromedioIntensidad(ArrayList<Integer> intensidades) {
    return intensidades.stream().mapToInt(Integer::intValue).sum() / intensidades.size();
  }
}
