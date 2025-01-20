package uiMain;

import java.util.*;

import baseDatos.Deserializador;
import baseDatos.Serializador;

import java.awt.geom.*;
import gestorAplicacion.enrutadorWiMax.Antena;
import gestorAplicacion.enrutadorWiMax.Cobertura;
import gestorAplicacion.enrutadorWiMax.Dispositivo;
import gestorAplicacion.enrutadorWiMax.Router;
import gestorAplicacion.enrutadorWiMax.Servidor;
import gestorAplicacion.entidadesServicios.Cliente;
import gestorAplicacion.entidadesServicios.ProveedorInternet;
import gestorAplicacion.servicio.Factura;
import gestorAplicacion.servicio.Plano;
import gestorAplicacion.servicio.Mes;

public class Main {

    
  public static void main(String[] args) {

    ProveedorInternet proveedorActual = null;
    Scanner sc = new Scanner(System.in);

    boolean Vcontrol1 = false;

    while (Vcontrol1 == false) {

        System.out.println("\n ________      ________       ________       _______       ___    ___  ___      _________     \r\n" + //
                       "|\\   ____\\    |\\   ___  \\    |\\   ___  \\    |\\   ____\\    |\\  \\  /  / |\\  \\    |\\   __   \\    \r\n" + //
                       "\\ \\  \\___|    \\ \\  \\ |\\  \\   \\ \\  \\\\ \\  \\   \\ \\  \\ _      \\ \\  \\/  /  \\ \\  \\   \\ \\  \\__\\  \\   \r\n" + //
                       " \\ \\  \\        \\ \\  \\ \\\\  \\   \\ \\  \\\\ \\  \\   \\ \\   __\\     \\ |     |   \\ \\  \\   \\ \\   ___  \\  \r\n" + //
                       "  \\ \\  \\____    \\ \\  \\_\\\\  \\   \\ \\  \\\\ \\  \\   \\ \\  \\____    /  /\\\\  \\   \\ \\  \\   \\ \\  \\\\ \\  \\ \r\n" + //
                       "   \\ \\_______\\   \\ \\________\\   \\ \\__\\\\ \\__\\   \\ \\_______\\ /__/  \\\\__\\   \\ \\__\\   \\ \\__\\\\ \\__\\\r\n" + //
                       "    \\|_______|    \\|________|    \\|__| \\|__|    \\|_______| |__|   \\|__|   \\|__|    \\|__| \\|__|\r\n"+ "\n\tMenú Inicial" + "\n\n1. Registro y Adquisición de Plan."+ "\n2. Visualizar los dispositivos conectados." + "\n3. Mejora tu plan." + "\n4. Test." + "\n5. Reporte de fallas en el servidor." + "\n6. Salir." + "\n");
        System.out.print("Digita por favor el número de la opcion que deseas: ");
        int opc = sc.nextInt();
    
        if (opc == 1 || opc == 2 || opc == 3 || opc == 4 || opc == 5 || opc == 6) { //SE VERIFICA QUE LA OPCION ELEGIDA SEA VÁLIDA

            Vcontrol1 = true;

            switch (opc) {

              case 1: // FUNCIONALIDAD ADQUISICIÓN DE UN PLAN

              //SE SOLICITAN LOS DATOS AL USUARIO
              System.out.println("Adquisición de un plan" + "\nIngresa tu nombre: ");
              sc.nextLine();
              String nombre = sc.nextLine().toLowerCase();
              
              System.out.println("Ingresa tu número de cédula: ");
              long ID = sc.nextLong();
              
              System.out.println("Ingresa el nombre de tu sede: ");
              sc.nextLine();
              String sede = sc.nextLine().toUpperCase();
              
              
              boolean Vcontrol15 = false;
              while(Vcontrol15==false){
                  if((sede.equals("A") )|| (sede.equals("B") )||  (sede.equals("C")) || (sede.equals("D"))){ //SE VERIFICA QUE LA SEDE INGRESADA EXISTA
              
                      Vcontrol15=true;
              
                      //SE BUSCAN LOS PROVEEDORES DE LA SEDE ESPECIFICADA
                      ArrayList<ProveedorInternet> proveedorDispo = ProveedorInternet.proveedorSede(sede); //PRIMER METODO DE LA FUNCIONALIDAD
              
                      //SE MUESTRAN POR PANTALLA LOS PROVEEDORES DISPONIBLES
                      System.out.print("Los proveedores disponibles en tu sede son: " + "\n");
                      int indice = 1;
                      for (int i = 0; i < proveedorDispo.size(); i++) {
                          System.out.print(indice + ". " + proveedorDispo.get(i).getNombre());
                          System.out.print("\n");
                  
                          if(proveedorDispo.size()-1!=i){
                              indice++;
                          }
                      }
              
                      boolean valPlan = false;
                      while (valPlan == false) {
                  
                          System.out.print("Ingresa la opción que deseas elegir: ");
                          opc = sc.nextInt();
                  
                          if ((opc >= 1) && (opc <= indice)) { //SE VERIFICA QUE LA OPCION ESCOGIDA SEA CORRECTA Y SE ASIGNA AL APUNTADOR PROVEEDORACTUAL EL PROVEEDOR ESCOGIDO

                              proveedorActual = proveedorDispo.get(opc-1);
                              valPlan = true;
                          } else {
                              System.out.println("Por favor ingresa una opción válida.");
                          }
                      }
              
              
                      //SE CREA EL CLIENTE
                      Cliente clienteActual = proveedorActual.crearClienteNuevo(nombre, ID); //SEGUNDO METODO DE LA FUNCIONALIDAD
              
                      //SE COMPRUEBA QUE HAYAN CUPOS DISPONIBLES CON EL PROVEEDOR, EN CASO CONTRARIO SALE POR CONSOLA EL MENSAJE RESPECTIVO INDICANDO ESTO
                      if (proveedorActual.getClientes().size() < proveedorActual.getCLIENTES_MAX()) {
                  
                          System.out.println("Los planes disponibles del proveedor son: ");
                          ArrayList<String> planesDisponibles = proveedorActual.planesDisponibles(clienteActual); //TERCER METODO DE LA FUNCIONALIDAD
                  
                          //SE MUESTRAN POR CONSOLA LOS PLANES DISPONIBLES CON SUS CARACTERÍSTICAS
                          for (String planes : planesDisponibles) {
                              if (planes.equals("BASIC")) {
                                  System.out.println("BASIC" + "\nEl plan basic ofrece: " + "\nMegas de subida: "
                                      + proveedorActual.getPlanes().getBASIC().get(0) + "\nMegas de bajada: "
                                      + proveedorActual.getPlanes().getBASIC().get(1) + "\nEl precio del plan: "
                                      + proveedorActual.getPlanes().getBASIC().get(2));
                              } else if (planes.equals("STANDARD")) {
                                  System.out.println("STANDARD" + "\nEl plan standard ofrece: " + "\nMegas de subida: "
                                      + proveedorActual.getPlanes().getSTANDARD().get(0) + "\nMegas de bajada: "
                                      + proveedorActual.getPlanes().getSTANDARD().get(1) + "\nEl precio del plan: "
                                      + proveedorActual.getPlanes().getSTANDARD().get(2));
                              } else if (planes.equals("PREMIUM")) {
                                  System.out.println("PREMIUM" + "\nEl plan premium ofrece: " + "\nMegas de subida: "
                                      + proveedorActual.getPlanes().getPREMIUM().get(0) + "\nMegas de bajada: "
                                      + proveedorActual.getPlanes().getPREMIUM().get(1) + "\nEl precio del plan: "
                                      + proveedorActual.getPlanes().getPREMIUM().get(2));
                              }
                          }
                
                          //SE SOLICITA EL NOMBRE DEL PLAN QUE SE DESEA AQUIRIR Y SE VERIFICA QUE SEA UN NOMBRE CORRECTO
                          String planEscogido = "";
                          boolean valido = false;
                          int contadorRepe = 0;
                          while (valido == false) {
                              System.out.println("Ingresa el nombre del plan que deseas adquirir: ");
                              if (contadorRepe == 0) {
                                  sc.nextLine();
                              }
                              String planEscogido1 = sc.nextLine().toUpperCase();
                              if ((planEscogido1.equals("BASIC") || planEscogido1.equals("STANDARD")
                                      || planEscogido1.equals("PREMIUM"))) {
                                  if (proveedorActual.planesDisponibles(clienteActual).contains(planEscogido1)) {
                                      valido = true;
                                      planEscogido=planEscogido1;
                                  }
                              } else {
                                  System.out.println("Por favor ingresa un nombre correcto.");
                                  contadorRepe++;
                                  }
                          }
                
                
                          //LIMITES DE ACUERDO CON LA SEDE DEL CLIENTE
                
                          int LimInfX=0;
                          int LimSupX=0;
                          int LimInfY=0;
                          int LimSupY=0;
                
                          if(sede.equals("A")){ LimInfX=0; LimSupX=40 ; LimInfY=0; LimSupY=40; }
                          else if(sede.equals("B")){ LimInfX=0; LimSupX=40 ; LimInfY=60; LimSupY=100; }
                          else if(sede.equals("C")){ LimInfX=50; LimSupX=80 ; LimInfY=0; LimSupY=30;}
                          else if(sede.equals("D")){ LimInfX=60; LimSupX=100 ; LimInfY=40; LimSupY=80;}
                
                
                          System.out.print("Digita las coordenadas de tu ubicación, estas tienen un límite de acuerdo con tu sede." + "\nCoordenadas en el eje X:" + "\nLímite Inferior: " + LimInfX +" \nLímite Superior: " + LimSupX + "\nCoordenadas en el eje Y:" + "\nLímite Inferior: " + LimInfY + "\nLímite Superior: "  + LimSupY + "\n");
                          
                          //SE PIDEN LAS COORDENADAS, VALIDANDO QUE SE ENCUENTREN EN EL RANGO ESTABLECIDO
                          boolean ValSede = false;
                          int coordenadaX=0;
                          int coordenadaY=0;
                          while(ValSede==false){
                  
                              System.out.print("Ingresa la coordenada X: ");
                              coordenadaX = sc.nextInt();
                              System.out.print("Ingresa la coordenada Y: ");
                              coordenadaY = sc.nextInt();

                              if((coordenadaX>=LimInfX) && (coordenadaX<=LimSupX)){
                                  if((coordenadaY>=LimInfY) && (coordenadaY<=LimSupY)){
                                      ValSede=true;
                                  }else{
                                      System.out.print("Coordenadas fuera del rango permitido." + "\n");
                                  }
                              }else{
                                  System.out.print("Coordenadas fuera del rango permitido." + "\n");
                              }
                          }
                
                          //SE PROCEDE A CONFIGURAR EL PLAN AL CLIENTE
                          Factura facturaCliente = clienteActual.configurarPlan(planEscogido, clienteActual, sede,coordenadaX, coordenadaY); //CUARTO METODO DE LA FUNCIONALIDAD
                
                          if (facturaCliente instanceof Factura) { 
                              System.out.println("Tu plan ha sido configurado correctamente. A continuación puedes visualizar tu factura.");
                              facturaCliente = facturaCliente.generarFactura(clienteActual, proveedorActual); //QUINTO METODO DE LA FUNCIONALIDAD
                              System.out.print(facturaCliente + "\nRealiza el pago de tu membresía a continuación (Ingrese el valor a pagar): ");
                  
                              //SE SOLICITA EL PAGO DE AL FACTURA
                              boolean pagoVal = false;
                              while (pagoVal == false) {
                                  if (clienteActual.getFactura().accionesPagos(2) != null) {
                                      System.out.print("Tu adquisición del plan ha finalizado con éxito."); //EL PROCESO TERMINA CON EXITO
                                      pagoVal = true;
                                      Vcontrol1=false;
                                  } else {
                                      System.out.print("Por favor ingresa la totalidad del precio requerido: ");
                                  }
                              }
                  
                          } else {
                              System.out.print("Lo sentimos, no se logró tramitar el plan. Intenta en otro momento.");
                              Vcontrol1=false;
                              break;
                          }
                      } else {
                          System.out.println("Lo sentimos, este proveedor ya no cuenta con cupos disponibles.Intenta en otro momento.");
                          Vcontrol1=false;
                          break;
                      }
                  }else{
                  System.out.print("Sede incorrecta, por favor ingresa de nuevo el nombre de tu sede: ");
                  sede = sc.nextLine().toUpperCase();
                  }
              }
              
              break;

              




            }
        }
    }
  }

}
