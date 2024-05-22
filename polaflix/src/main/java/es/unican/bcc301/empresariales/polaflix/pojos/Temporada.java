package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.ArrayList;
import java.util.List;

public class Temporada implements Comparable<Temporada> {

    private long id;
    private int numTemporada;

    private Serie serie;
    private List<Capitulo> capitulos;

    public Temporada(int numTemporada, Serie serie) {
        this.numTemporada = numTemporada;
        this.serie = serie;

        capitulos = new ArrayList<>();
    }


    /* GETTERS Y SETTERS */

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

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }


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

}
