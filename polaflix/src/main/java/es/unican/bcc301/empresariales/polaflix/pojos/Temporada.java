package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.Set;
import java.util.TreeSet;

public class Temporada implements Comparable<Temporada> {

    private long id;
    private int numTemporada;

    private Serie serie;
    private Set<Capitulo> capitulos;

    public Temporada(int numTemporada, Serie serie) {
        this.numTemporada = numTemporada;
        this.serie = serie;

        capitulos = new TreeSet<Capitulo>();
    }


    // metodos auxiliares

    @Override
    public int compareTo(Temporada temp) {
        return this.getNumTemporada() - temp.getNumTemporada();
    }


    @Override
    public boolean equals(Object o) {

        Temporada temp;

        if (!(o instanceof Temporada)) {
            return false;
        } else {
            temp = (Temporada) o;
        }

        return this.id == temp.getId();
    }


    @Override
    public int hashCode() {
        return this.serie.hashCode() * this.numTemporada * 17;
    }

    
    // getters y setters

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public int getNumTemporada() {
        return numTemporada;
    }


    public void setNumTemporada(int numTemporada) {
        this.numTemporada = numTemporada;
    }


    public Serie getSerie() {
        return serie;
    }


    public void setSerie(Serie serie) {
        this.serie = serie;
    }


    public Set<Capitulo> getCapitulos() {
        return capitulos;
    }


    public void setCapitulos(Set<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

}
