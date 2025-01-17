package gestorAplicacion.enrutadorWiMax;
import java.util.*;

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
}