package es.unican.bcc301.empresariales.polaflix.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unican.bcc301.empresariales.polaflix.pojos.Usuario;

@Repository("usuarioRepo")
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
    Usuario findByEmail(String email);
}
