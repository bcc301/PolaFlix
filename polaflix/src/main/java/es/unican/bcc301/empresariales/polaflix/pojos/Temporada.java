package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.ArrayList;
import java.util.List;

public class Temporada {

    private int numTemporada;

    private Serie serie;
    private List<Capitulo> capitulos;

    public Temporada(int numTemporada, Serie serie) {
        this.numTemporada = numTemporada;
        this.serie = serie;

        capitulos = new ArrayList<>();
    }


    /* GETTERS Y SETTERS */

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
    
}
