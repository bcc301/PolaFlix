package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class Usuario {

	private long id;
	private String email; 
	private String nombreUsuario;
	private String contraseña;
	private String cuentaBancaria;
	private boolean granConsumidor;

	private SortedSet<Factura> facturas;
	private Set<Serie> seriesTerminadas;
	private Set<Serie> seriesEmpezadas;
	private Set<Serie> seriesPendientes;
	private Map<Serie, VisualizacionCapitulo> capitulosVistos;
	private Map<Serie, Capitulo> visualizacionesSeries;

	public Usuario(String email, long id, String nombreUsuario, String contraseña, String cuentaBancaria, boolean granConsumidor) {
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.cuentaBancaria = cuentaBancaria;
		this.granConsumidor = granConsumidor;

		facturas = new TreeSet<Factura>();
		seriesTerminadas = new TreeSet<Serie>();
		seriesEmpezadas = new TreeSet<Serie>();
		seriesPendientes = new TreeSet<Serie>();
		capitulosVistos = new HashMap<Serie, VisualizacionCapitulo>();
		visualizacionesSeries = new HashMap<Serie, Capitulo>();
	}

	/* METODOS DE NEGOCIO */

	public Serie buscarSerie(String nombreSerie) { return null; }

	public void agregarSerieAEspacioPersonal(Serie s) {}

	public void verCapitulo(Capitulo cap) {}

	public Factura buscarFactura(int mes, int año) {return null;}

	// TODO: queda pendiente el metodo verFacturas() que no se si hara falta


	
	// metodos auxiliares

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


	// getters y setters

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

	public SortedSet<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(SortedSet<Factura> facturas) {
		this.facturas = facturas;
	}

	public Set<Serie> getSeriesTerminadas() {
		return seriesTerminadas;
	}

	public void setSeriesTerminadas(Set<Serie> seriesTerminadas) {
		this.seriesTerminadas = seriesTerminadas;
	}

	public Set<Serie> getSeriesEmpezadas() {
		return seriesEmpezadas;
	}

	public void setSeriesEmpezadas(Set<Serie> seriesEmpezadas) {
		this.seriesEmpezadas = seriesEmpezadas;
	}

	public Set<Serie> getSeriesPendientes() {
		return seriesPendientes;
	}

	public void setSeriesPendientes(Set<Serie> seriesPendientes) {
		this.seriesPendientes = seriesPendientes;
	}

	public Map<Serie, VisualizacionCapitulo> getCapitulosVistos() {
		return capitulosVistos;
	}

	public void setCapitulosVistos(Map<Serie, VisualizacionCapitulo> capitulosVistos) {
		this.capitulosVistos = capitulosVistos;
	}

	public Map<Serie, Capitulo> getVisualizacionesSeries() {
		return visualizacionesSeries;
	}

	public void setVisualizacionesSeries(Map<Serie, Capitulo> visualizacionesSeries) {
		this.visualizacionesSeries = visualizacionesSeries;
	}

}
