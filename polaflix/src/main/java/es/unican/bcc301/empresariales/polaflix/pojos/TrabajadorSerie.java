package es.unican.bcc301.empresariales.polaflix.pojos;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import com.fasterxml.jackson.annotation.JsonView;

import es.unican.bcc301.empresariales.polaflix.rest.JsonViews;
import jakarta.persistence.Embeddable;

@Embeddable
public class TrabajadorSerie {
    
    @JsonView(JsonViews.SerieView.class)
    private String nombreTrabajador;
    @JsonView(JsonViews.SerieView.class)
    private Date fechaNacimiento;
    private int edad;


    public TrabajadorSerie () { }

    public TrabajadorSerie(String nombre, Date fechaNacimiento) {
        this.nombreTrabajador = nombre;
        this.fechaNacimiento = fechaNacimiento;
        //edad = calculaEdad(); //TODO descomentar con datos reales
    }


    // metodos auxiliares

    private int calculaEdad() {
        LocalDate fechaNacLocalDate = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(fechaNacLocalDate, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {

        TrabajadorSerie ts;

        if (!(o instanceof TrabajadorSerie)) {
            return false;
        } else {
            ts = (TrabajadorSerie) o;
        }

        return this.nombreTrabajador.equals(ts.getNombre()) && this.fechaNacimiento.equals(ts.getFechaNacimiento());
    }

    @Override
    public int hashCode() {
        return this.nombreTrabajador.hashCode();
    }

    public String getNombre() {
        return nombreTrabajador;
    }

    public void setNombre(String nombre) {
        this.nombreTrabajador = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
