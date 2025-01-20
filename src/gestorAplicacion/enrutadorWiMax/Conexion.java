package gestorAplicacion.enrutadorWiMax;

import gestorAplicacion.entidadesServicios.Cliente;

public class Conexion extends Router{

	private Cliente cliente;

	public Conexion(String ip, int up, int down, boolean online, int generacion, Cliente cliente, Servidor servidor) {
		super(up, down, online, servidor);
	    this.cliente=cliente;
	}

	//METODO HEREDADO DE ROUTER SOBREESCRITO CON CUAL SE APLICA LIGADURA DINÁMICA
	public int getVelocidad() {
    	int velocidadActual = ((cliente.getModem().actualizarVelocidad(cliente).get(0) + cliente.getModem().actualizarVelocidad(cliente).get(1)) / 2)*generacion*generacion;
		return velocidadActual;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}