package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Factura {

    private final long id;
	private double importeTotal;
	private LocalDate fecha;

	private ArrayList<VisualizacionSerie> entradasFactura;
	private Usuario usuario;

	public Factura(long id, LocalDate fecha, Usuario usuario) {
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.importeTotal = 0;
		this.entradasFactura = new ArrayList<>();
	}

	/* METODOS DE NEGOCIO */

	public void añadirVisualizacionCapituloAFactura(VisualizacionSerie visualizacion) {}

	/* GETTERS Y SETTERS */

	public int getMes() {
		return fecha.getMonthValue();
	}

	public int getYear() {
		return fecha.getYear();
	}

	public long getId() {
		return id;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<VisualizacionSerie> getEntradasFactura() {
		return entradasFactura;
	}

	public void setEntradasFactura(ArrayList<VisualizacionSerie> entradasFactura) {
		this.entradasFactura = entradasFactura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}
