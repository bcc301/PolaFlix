package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonView;

import es.unican.bcc301.empresariales.polaflix.rest.JsonViews;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Temporada implements Comparable<Temporada> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     @JsonView({JsonViews.SerieView.class, JsonViews.FacturaView.class, JsonViews.CapituloView.class})
    private int numTemporada;

    @ManyToOne
    @JsonView({JsonViews.FacturaView.class, JsonViews.CapituloView.class})
    private Serie serie;
    @OneToMany (mappedBy = "temporada", cascade = CascadeType.ALL)
    @JsonView(JsonViews.SerieView.class)
    private Set<Capitulo> capitulos;

    public Temporada() { }

    public Temporada(int numTemporada, Serie serie) {
        this.numTemporada = numTemporada;
        this.serie = serie;

        capitulos = new TreeSet<Capitulo>();
    }


    // metodos auxiliares

    // metodo para anadir un capitulo a la temporada
    public void anadirCapitulo(Capitulo c) {
        
        if (c != null) {
            this.capitulos.add(c);
        }
    }

    // metodo para obtener un capitulo dado su numero
    public Capitulo getCapitulo(int numCapitulo) {

        for (Capitulo cap: capitulos) {
            if (cap.getNumCapitulo() == numCapitulo) {
                return cap;
            }
        }

        return null;
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
