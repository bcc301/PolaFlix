package es.unican.bcc301.empresariales.polaflix.rest;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.unican.bcc301.empresariales.polaflix.pojos.Capitulo;
import es.unican.bcc301.empresariales.polaflix.pojos.Factura;
import es.unican.bcc301.empresariales.polaflix.pojos.Serie;
import es.unican.bcc301.empresariales.polaflix.pojos.Usuario;
import es.unican.bcc301.empresariales.polaflix.pojos.VisualizacionCapitulo;
import es.unican.bcc301.empresariales.polaflix.pojos.VisualizacionSerie;
import es.unican.bcc301.empresariales.polaflix.repositorios.SerieRepositorio;
import es.unican.bcc301.empresariales.polaflix.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {
    
    private UsuarioRepositorio ur;
    private SerieRepositorio sr;

    @Autowired
    public UsuarioController(UsuarioRepositorio ur, SerieRepositorio sr) {
        this.ur = ur;
        this.sr = sr;
    }


    // buscar usuario por id
    @GetMapping(value = "/{id}")
    @JsonView(JsonViews.UsuarioView.class)
    public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable("id") long id) {

        Optional<Usuario> usuario = ur.findById(id);
        ResponseEntity<Usuario> respuesta;

        if (usuario.isPresent()) {
            respuesta = ResponseEntity.ok(usuario.get());
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        return respuesta;
    }

    // buscar usuario por email
    @GetMapping(params = "email")
    @JsonView(JsonViews.UsuarioView.class)
    public ResponseEntity<Usuario> buscarUsuarioEmail(@RequestParam("email") String email) {
        
        Usuario usuario = ur.findByEmail(email);
        ResponseEntity<Usuario> respuesta;

        if (usuario != null) {
            respuesta = ResponseEntity.ok(usuario);
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        return respuesta;
    }

    // ver capitulo
    @PutMapping(value = "/{id}/capitulos-vistos/serie/{serieId}/temporada/{numTemporada}/capitulos/{numCapitulo}")
    @JsonView(JsonViews.VisualizacionCapituloView.class)
    @Transactional
    public ResponseEntity<VisualizacionSerie> verCapitulo(@PathVariable("id") long id, @PathVariable("serieId") long serieId, 
        @PathVariable("numTemporada") int numTemporada, @PathVariable("numCapitulo") int numCapitulo) {

            ResponseEntity<VisualizacionSerie> respuesta;
            Optional<Usuario> usuario = ur.findById(id);
            Optional<Serie> serie = sr.findById(serieId);

            if (!(usuario.isPresent())) {
                return ResponseEntity.notFound().build();
            }

            if (serie.isPresent()) {
                Capitulo cap = serie.get().getTemporada(numTemporada).getCapitulo(numCapitulo);
                if (cap == null) {
                    return ResponseEntity.notFound().build();
                }
                usuario.get().verCapitulo(cap);
                ur.save(usuario.get());
                respuesta = ResponseEntity.ok(usuario.get().getSerieVisualizaciones(serie.get()));

            } else {
                respuesta = ResponseEntity.notFound().build();
            }

            return respuesta;
    }

    // anadir serie a lista pendientes
    @PutMapping(value = "/{id}/series-pendientes/{serieId}")
    @JsonView(JsonViews.UsuarioView.class)
    @Transactional
    public ResponseEntity<Usuario> anadirSerieAPendientes(@PathVariable("id") long id, @PathVariable("serieId") long serieId) {

        Optional<Usuario> usuario = ur.findById(id);
        ResponseEntity<Usuario> respuesta;
        Optional<Serie> serie = sr.findById(serieId);

        if (!(usuario.isPresent())) {
            return ResponseEntity.notFound().build();
        }

        if (serie.isPresent()) {
            usuario.get().anadirSerieAPendientes(serie.get());
            ur.save(usuario.get());
            respuesta = ResponseEntity.ok(usuario.get());
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        return respuesta;
    }

    // obtener facturas
    @GetMapping(value = "/{id}/facturas")
    @JsonView(JsonViews.FacturaView.class)
    public ResponseEntity<Iterable<Factura>> obtenerFacturas(@PathVariable("id") long id) {
        
        Optional<Usuario> usuario = ur.findById(id);
        ResponseEntity<Iterable<Factura>> respuesta;

        if (usuario.isPresent()) {
            respuesta = ResponseEntity.ok(usuario.get().getFacturas());
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        return respuesta;
    }

    // obtener ultimo capitulo visto de una serie
    @GetMapping(value = "/{id}/ult-cap-visto/{serieId}")
    @JsonView(JsonViews.CapituloView.class)
    public ResponseEntity<Capitulo> getUltCapVisto(@PathVariable("id") long id, @PathVariable("serieId") long serieId) {
        
        Optional<Usuario> ususario = ur.findById(id);
        ResponseEntity<Capitulo> respuesta;

        if (!(ususario.isPresent())) {
            return ResponseEntity.notFound().build();
        }

        Optional<Serie> s = sr.findById(serieId);

        if (s.isPresent()) {
            respuesta = ResponseEntity.ok(ususario.get().getUltCapVisto(s.get()));
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        return respuesta;
    }

    // obtener las visualizaciones de un usuario
    @GetMapping(value = "/{id}/capitulos-vistos")
    @JsonView(JsonViews.VisualizacionesView.class)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Map<Serie, VisualizacionCapitulo>> getViews(@PathVariable("id") long id) {

        ResponseEntity<Map<Serie, VisualizacionCapitulo>> result;
        Optional<Usuario> u = ur.findById(id);

        if (!(u.isPresent())) {
            return ResponseEntity.notFound().build();
        } else {
            result = ResponseEntity.ok(u.get().getCapitulosVistos());
        }

        return result;
    }
    
    public UsuarioRepositorio getUr() {
        return ur;
    }

    public void setUr(UsuarioRepositorio ur) {
        this.ur = ur;
    }

    public SerieRepositorio getSr() {
        return sr;
    }

    public void setSr(SerieRepositorio sr) {
        this.sr = sr;
    }
}
