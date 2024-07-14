package es.unican.bcc301.empresariales.polaflix.pojos;

import java.time.LocalDate;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import es.unican.bcc301.empresariales.polaflix.rest.JsonViews;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@JsonView(JsonViews.UsuarioView.class)
	private String email; 
	@JsonView(JsonViews.UsuarioView.class)
	private String nombreUsuario;
	@JsonIgnore
	private String contraseña;
	private boolean granConsumidor;

	@Embedded
	private CuentaBancaria cuentaBancaria;
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
	private SortedSet<Factura> facturas;
	@ManyToMany
	@JsonView(JsonViews.UsuarioView.class)
	private Set<Serie> seriesTerminadas;
	@ManyToMany
	@JsonView(JsonViews.UsuarioView.class)
	private Set<Serie> seriesEmpezadas;
	@ManyToMany
	@JsonView(JsonViews.UsuarioView.class)
	private Set<Serie> seriesPendientes;
	@OneToMany (cascade = CascadeType.ALL)
	@JsonView(JsonViews.SerieView.class)
	private Map<Serie, VisualizacionCapitulo> capitulosVistos;
	@ManyToMany
	private Map<Serie, VisualizacionSerie> visualizacionesSeries;

	public Usuario() { }
	public Usuario(String email, String nombreUsuario, String contraseña, CuentaBancaria cuentaBancaria, boolean granConsumidor) {
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
		visualizacionesSeries = new HashMap<Serie, VisualizacionSerie>();
	}

	// metodos auxiliares

	// metodo para anadir serie del catalogo a la lista de series pendientes
	public void anadirSerieAPendientes(Serie seriePendiente) {

		// comprobar que la serie no esta en pendientes
		if (this.seriesPendientes.contains(seriePendiente)) {
			return;
		}

		// si esta en alguna de las otras listas, borrarla para meterla en pendientes
		if (this.seriesEmpezadas.contains(seriePendiente)) {
			this.seriesEmpezadas.remove(seriePendiente);
		} 
		if (this.seriesTerminadas.contains(seriePendiente)) {
			this.seriesTerminadas.remove(seriePendiente);
		}

		// anadirla a la lista de pendientes
		this.seriesPendientes.add(seriePendiente);
	}


	// metodo para anadir serie del catalogo a la lista de series empezadas
	public void anadirSerieAEmpezadas(Serie serieEmpezada) {

		// comprobar que no esta en empezadas
		if (this.seriesEmpezadas.contains(serieEmpezada)) {
			return;
		}

		// si esta en alguna de las otras listas, borrarla para meterla en empezadas
		if (this.seriesPendientes.contains(serieEmpezada)) {
			this.seriesPendientes.remove(serieEmpezada);
		}
		if (this.seriesTerminadas.contains(serieEmpezada)) {
			this.seriesTerminadas.contains(serieEmpezada);
		}

		// anadir la serie a empezadas
		this.seriesEmpezadas.add(serieEmpezada);
	}


	// metodo para anadir serie del catalogo a lista de series terminadas
	public void anadirSerieATerminadas(Serie serieTerminada) {

		// comprobar que no esta en terminadas
		if (this.seriesTerminadas.contains(serieTerminada)) {
			return;
		}

		// si esta en alguna de las otras listas, borrarla para meterla en terminadas
		if (this.seriesEmpezadas.contains(serieTerminada)) {
			this.seriesEmpezadas.remove(serieTerminada);
		}
		if (this.seriesPendientes.contains(serieTerminada)) {
			this.seriesPendientes.remove(serieTerminada);
		}

		// anadir la serie a terminadas
		this.seriesTerminadas.add(serieTerminada);
	}

	// anadir factura a un usuario
	public void anadirFactura(Factura f) {

		if (f != null) {
			this.facturas.add(f);
		}
	}


	// metodo para actualizar la informacion necesaria cuando se vea un capitulo
	public void verCapitulo(Capitulo capVisto) {

		// comprobacion objeto no nulo
		if (capVisto == null) {
			return;
		}

		Factura ultimaFactura = null;

		// fecha ultima factura
		LocalDate fecha = LocalDate.now();
		fecha = fecha.withDayOfMonth(1);
		Date fechaUltFactura = Date.valueOf(fecha);

		// atributos del capitulo visto
		Serie serieCapVisto = capVisto.getSerie();
		Temporada tempCapVisto = capVisto.getTemporada();
		int numCapVisto = capVisto.getNumCapitulo();

		double precio = serieCapVisto.getCategoria().getPrecio();


		// crear la visualizacion del capitulo
		VisualizacionCapitulo visualizacionCap = new VisualizacionCapitulo(LocalDate.now(), 
		tempCapVisto.getNumTemporada(), precio, numCapVisto, 
				this.getFacturaActual(fechaUltFactura), this);
		
		// anadir la visualizacion a capitulos vistos del usuario
		this.capitulosVistos.put(serieCapVisto, visualizacionCap);

		// registrar que se ha comenzado a ver esta serie y actualizar ult cap visto de la serie
		VisualizacionSerie visualizacionSerie = this.visualizacionesSeries.get(serieCapVisto);
		if (visualizacionSerie == null) {
			// si era el primer capitulo que se veia de la serie, crear la visualizacion
			// de la serie con este capitulo como ultimo visto de la serie
			visualizacionSerie = new VisualizacionSerie(numCapVisto, tempCapVisto.getNumTemporada(), this, serieCapVisto);
			seriesEmpezadas.add(serieCapVisto);
		} else {
			visualizacionSerie.actualizarUltimoCapituloVisto(capVisto);
		}

		// si es el ultimo capitulo de la serie: serie terminada
		if (serieCapVisto.getNumTotalCapitulos() == (tempCapVisto.getCapitulos().size())) {
			seriesEmpezadas.remove(serieCapVisto);
			seriesTerminadas.add(serieCapVisto);
		}

		// añadir la visualizacion a la factura del usuario del mes actual

		// si todavia no existe la factura del mes actual, crearla
		ultimaFactura = this.facturas.last();
		if (this.facturas.isEmpty() || !(ultimaFactura.getFecha().equals(fechaUltFactura))) {
			// crear la factura actual y añadirsela al usuario
			ultimaFactura = new Factura(fechaUltFactura, this);
			this.facturas.add(ultimaFactura);
		}
		
		// anadir la visualizacion a la factura
		ultimaFactura.anadirVisualizacionCapituloAFactura(visualizacionCap);

	}


	// metodo para obtener la factura actual de un usuario (fecha = primer dia del mes) 
	public Factura getFacturaActual(Date fecha) {
		
		for (Factura f: this.facturas) {
			if (f.getFecha().equals(fecha)) {
				return f;
			}
		}
		
		return null;
	}

	// obtener las visualizaciones de una serie mediante su ultimo capitulo
	public VisualizacionSerie getSerieVisualizaciones(Serie serie) {
		return this.visualizacionesSeries.get(serie);
	}

	// obtener ultimo capitulo visto de la serie
	public Capitulo getUltCapVisto(Serie serie) {

		Capitulo ultCap;
		VisualizacionSerie visualizacionUltCap;

		visualizacionUltCap = this.visualizacionesSeries.get(serie);
		ultCap = visualizacionUltCap.getSerie().getTemporada(visualizacionUltCap.getNumTempUltCap()).getCapitulo(visualizacionUltCap.getNumUltCapVisto());

		return ultCap;
	}

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

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
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

	public Map<Serie, VisualizacionSerie> getVisualizacionesSeries() {
		return visualizacionesSeries;
	}

	public void setVisualizacionesSeries(Map<Serie, VisualizacionSerie> visualizacionesSeries) {
		this.visualizacionesSeries = visualizacionesSeries;
	}

}
