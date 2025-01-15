package gestorAplicacion.enrutadorWiMax;

import java.util.ArrayList;

public class Servidor {
    private String sede;
    private boolean saturado = false;
    private ProveedorInternet proveedor;
    private Plano coordenadas;  
    private static ArrayList<Servidor> servidoresTotales = new ArrayList<>();
    private ArrayList<Router> routers = new ArrayList<>();

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
}
