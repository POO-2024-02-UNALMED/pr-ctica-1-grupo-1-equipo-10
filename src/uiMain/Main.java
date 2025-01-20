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

            




            }
        }
    }
  }

}
