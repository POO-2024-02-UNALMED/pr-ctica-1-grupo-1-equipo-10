package gestorAplicaciones.enrutadorWiMax;

public class Dispositivo implements Serializable{

	private Router modem;
	private String ipAsociada;
	private String nombre;
  	private String generacion;
	private static ArrayList<Dispositivo> dispositivosTotales = new ArrayList<>();

	public Dispositivo(Router modem,String nombre,String generacion) {
	    this.modem = modem;
	    this.nombre = nombre;
      	this.generacion=generacion;
	}

    public Router getModem() {
		return modem;
	}

	public void setModem(Router modem) {
		this.modem = modem;
	}
}
  