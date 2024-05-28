package es.unican.bcc301.empresariales.polaflix.pojos;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class TrabajadorSerie {
    
    @Id
    private String nombre;
    private Date fechaNacimiento;
    private int edad;

    public TrabajadorSerie(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        edad = calculaEdad();
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

        return this.nombre.equals(ts.getNombre()) && this.fechaNacimiento.equals(ts.getFechaNacimiento());
    }

    @Override
    public int hashCode() {
        return this.nombre.hashCode();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
