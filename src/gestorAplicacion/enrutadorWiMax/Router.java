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

  public Router(int up, int down, boolean online, Antena antenaAsociada,Plano coordenadas,int g) {
    
    super(g);

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
    this.coordenadas=coordenadas;
    this.antenaAsociada=antenaAsociada;
    velocidad=250;
    sede=antenaAsociada.getSede();
  }

  public Router(){
    super(3);
    IP="";
    velocidad=250;
  }
  
  //METODOS

  public ArrayList<Integer> actualizarVelocidad(Cliente cliente) {
    int megasUp = cliente.getPlan().get(0);
    int megasDown = cliente.getPlan().get(1);
    Router routerCliente = cliente.getModem();
    ArrayList<Dispositivo> dispositivos = Dispositivo.getDispositivosTotales();
    ArrayList<Dispositivo> dispositivosCliente = verificarDispositivos(dispositivos, routerCliente);
    ArrayList<Integer> listaActualizada = new ArrayList<Integer>();
    if (dispositivosCliente.size() == 0) {
        megasUp=26;
        megasDown=18;
    } else {
      for (Dispositivo dispoActual : dispositivosCliente) {
       
          if (antenaAsociada.verificarZonaCobertura(this,antenaAsociada)){
            if (dispoActual.getNombre().equals("Celular")) {
              megasUp -= 4;
              megasDown -= 10;
            }
            if (dispoActual.getNombre().equals("Computador")) {
              megasUp -= 8;
              megasDown -= 20;
            }
            if (dispoActual.getNombre().equals("Televisor")) {
              megasUp -= 10;
              megasDown -= 30;
            }
          }else{
              megasUp=26;
              megasDown=18;
              break;
          }
        }

      }
      listaActualizada.add(megasDown);
      listaActualizada.add(megasUp);
      return listaActualizada;
    }
  //SETTERS Y GETTERS

  public String getIP() {
    return IP;
  }

  public int getUp() {
    return up;
  }

  public void setUp(int up) {
    this.up = up;
  }

  public int getDown() {
    return down;
  }

  public void setDown(int down) {
    this.down = down;
  }

  public boolean isOnline() {
    return online;
  }

  public void setOnline(boolean online) {
    this.online = online;
  }

  public int getPing() {
    return ping;
  }

  public void setPing(int ping) {
    this.ping = ping;
  }

  public Plano getCoordenadas() {
    return coordenadas;
  }

  public void setCoordenadas(Plano coordenadas) {
    this.coordenadas = coordenadas;
  }

  public Servidor getServidorAsociado() {
    return servidorAsociado;
  }

  public void setServidorAsociado(Servidor servidorAsociado) {
    this.servidorAsociado = servidorAsociado;
  }

  public Antena getAntenaAsociada() {
    return antenaAsociada;
  }

  public void setAntenaAsociada(Antena antenaAsociada) {
    this.antenaAsociada = antenaAsociada;
  }

  public String getSede() {
    return sede;
  }

  public void setSede(String sede) {
    this.sede = sede;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }
  

}