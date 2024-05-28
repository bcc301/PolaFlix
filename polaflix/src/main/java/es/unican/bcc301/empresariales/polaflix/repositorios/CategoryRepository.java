package es.unican.bcc301.empresariales.polaflix.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unican.bcc301.empresariales.polaflix.pojos.Categoria;




@Repository("categoriaRepo")
public interface CategoryRepository extends JpaRepository<Categoria, String> {
    
    Categoria findByName(String name);
}