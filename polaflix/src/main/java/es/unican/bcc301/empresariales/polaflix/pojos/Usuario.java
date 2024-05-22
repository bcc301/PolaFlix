package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Usuario {

	private long id;
	private String email; 
	private String nombreUsuario;
	private String contraseña;
	private String cuentaBancaria;
	private boolean granConsumidor;

	private List<Factura> facturas;
	private List<Serie> seriesTerminadas;
	private List<Serie> seriesEmpezadas;
	private List<Serie> seriesPendientes;
	private List<Capitulo> capitulosVistos;
	private List<Serie> visualizacionesSeries;

	public Usuario(String email, long id, String nombreUsuario, String contraseña, String cuentaBancaria, boolean granConsumidor) {
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.cuentaBancaria = cuentaBancaria;
		this.granConsumidor = granConsumidor;

		facturas = new LinkedList<>();
		seriesTerminadas = new ArrayList<>();
		seriesEmpezadas = new ArrayList<>();
		seriesPendientes = new ArrayList<>();
		capitulosVistos = new ArrayList<>();
		visualizacionesSeries = new ArrayList<>();
	}

	/* METODOS DE NEGOCIO */

	public Serie buscarSerie(String nombreSerie) { return null; }

	public void agregarSerieAEspacioPersonal(Serie s) {}

	public void verCapitulo(Capitulo cap) {}

	public Factura buscarFactura(int mes, int año) {return null;}

	// TODO: queda pendiente el metodo verFacturas() que no se si hara falta

	
	/* GETTERS Y SETTERS */

	@Override
	public boolean equals(Object o) {
		
		Usuario u;

		if (!(o instanceof Usuario)) {
			return false;
		} else {
			u = (Usuario) o;
		}

		return this.id == u.getId();
	}

	@Override
	public int hashCode() {
		return this.email.hashCode() + this.nombreUsuario.hashCode();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public boolean isGranConsumidor() {
		return granConsumidor;
	}

	public void setGranConsumidor(boolean granConsumidor) {
		this.granConsumidor = granConsumidor;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<Serie> getSeriesTerminadas() {
		return seriesTerminadas;
	}

	public void setSeriesTerminadas(List<Serie> seriesTerminadas) {
		this.seriesTerminadas = seriesTerminadas;
	}

	public List<Serie> getSeriesEmpezadas() {
		return seriesEmpezadas;
	}

	public void setSeriesEmpezadas(List<Serie> seriesEmpezadas) {
		this.seriesEmpezadas = seriesEmpezadas;
	}

	public List<Serie> getSeriesPendientes() {
		return seriesPendientes;
	}

	public void setSeriesPendientes(List<Serie> seriesPendientes) {
		this.seriesPendientes = seriesPendientes;
	}

	public List<Capitulo> getCapitulosVistos() {
		return capitulosVistos;
	}

	public void setCapitulosVistos(List<Capitulo> capitulosVistos) {
		this.capitulosVistos = capitulosVistos;
	}

	public List<Serie> getVisualizacionesSeries() {
		return visualizacionesSeries;
	}

	public void setVisualizacionesSeries(List<Serie> visualizacionesSeries) {
		this.visualizacionesSeries = visualizacionesSeries;
	}

}
