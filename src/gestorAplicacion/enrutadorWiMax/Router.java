package gestorAplicacion.enrutadorWiMax;

import java.util.*;
import gestorAplicacion.entidadesServicios.Cliente;
import gestorAplicacion.servicio.Plano;


public class Router extends Cobertura {
    private final String IP;
    private int up;
    private int down;
    private boolean online;
    private int ping;
    private Plano coordenadas;
    private Servidor servidorAsociado;
    private Antena antenaAsociada;
    private String sede;
    private int velocidad;



    public Router(int up, int down, boolean online, Servidor servidorAsociado) {
    
    super(3);
    Random random = new Random();
    int octeto1 = random.nextInt(256);
    int octeto2 = random.nextInt(256);
    int octeto3 = random.nextInt(256);
    int octeto4 = random.nextInt(256);
    String ip = octeto1 + "." + octeto2 + "." + octeto3 + "." + octeto4;

    IP = ip;
    this.up = up;
    this.down = down;
    this.online = online;
    sede=servidorAsociado.getSede();   
    this.servidorAsociado=servidorAsociado;
    velocidad=250;
    servidorAsociado.getRouters().add(this);
  }






}