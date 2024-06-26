package es.unican.bcc301.empresariales.polaflix.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.unican.bcc301.empresariales.polaflix.pojos.Serie;
import es.unican.bcc301.empresariales.polaflix.repositorios.CategoriaRepositorio;
import es.unican.bcc301.empresariales.polaflix.repositorios.SerieRepositorio;

@RestController
@RequestMapping(value = "series")
public class SerieController {

    SerieRepositorio sr;
    CategoriaRepositorio cr;
    
    @Autowired
    public SerieController(SerieRepositorio sr, CategoriaRepositorio cr) {
        this.sr = sr;
        this.cr = cr;
    }

    // obtener serie mediante id 
    @GetMapping(value = "/{id}")
    @JsonView(JsonViews.SerieView.class)
    public ResponseEntity<Serie> obtenerSerieId(@PathVariable("id") long id) {
        Optional<Serie> serie = sr.findById(id);
        ResponseEntity<Serie> respuesta;

        if (serie.isPresent()) {
            respuesta = ResponseEntity.ok(serie.get());
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        return respuesta;
    }

    // obtener serie mediante inicial
    @GetMapping(params = "inicial")
    @JsonView(JsonViews.SerieView.class)
    public Iterable<Serie> obtenerSerieInicial(@RequestParam("inicial") char inicial) {
        return sr.findByInicial(inicial);
    }

    // obtener todas las series
    @GetMapping()
    @JsonView(JsonViews.SerieView.class)
    public Iterable<Serie> obtenerSeries() {
        return sr.findAll();
    }
}
