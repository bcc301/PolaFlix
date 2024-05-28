package es.unican.bcc301.empresariales.polaflix.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unican.bcc301.empresariales.polaflix.pojos.Serie;

@Repository("serieRepo")
public interface SerieRepositorio extends JpaRepository<Serie, Long> {
    
    List<Serie> findByInitial(char initial);
}
