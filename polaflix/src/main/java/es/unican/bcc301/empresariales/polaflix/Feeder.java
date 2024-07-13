package es.unican.bcc301.empresariales.polaflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.unican.bcc301.empresariales.polaflix.pojos.Categoria;
import es.unican.bcc301.empresariales.polaflix.pojos.CuentaBancaria;
import es.unican.bcc301.empresariales.polaflix.pojos.Serie;
import es.unican.bcc301.empresariales.polaflix.pojos.Usuario;
import es.unican.bcc301.empresariales.polaflix.repositorios.CategoriaRepositorio;
import es.unican.bcc301.empresariales.polaflix.repositorios.SerieRepositorio;
import es.unican.bcc301.empresariales.polaflix.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;

@Component
public class Feeder implements CommandLineRunner{

    @Autowired
	protected SerieRepositorio seriesRepo;
    @Autowired
	protected UsuarioRepositorio usuariosRepo;
	@Autowired
	protected CategoriaRepositorio categoriasRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        
        // rellenar la base de datos
        inyectarUsuarios();
        inyectarSeries();
        inyectarCategorias();

    }

    private void inyectarCategorias() {
        
        // crear las categorias
        Categoria estandar = new Categoria("Estandar", 0.5);
        Categoria silver = new Categoria("Silver", 1.0);
        Categoria gold = new Categoria("Gold", 1.5);
    
        // guardarlas en el repositorio
        categoriasRepo.save(estandar);
        categoriasRepo.save(silver);
        categoriasRepo.save(gold);
    }

    private void inyectarSeries() {
        
        // obtener las categorias del repositorio
        Categoria estandar = categoriasRepo.findByNombre("Estandar");
        Categoria silver = categoriasRepo.findByNombre("Silver");
        Categoria gold = categoriasRepo.findByNombre("Gold");

        // creacion de las series
        Serie s1 = new Serie("Aqui No Hay Quien Viva", 4, "Serie de humor española.", estandar);
        Serie s2 = new Serie("Mundo Maldini", 6, "Programa futbolístico.", silver);
        Serie s3 = new Serie("El Chiringuito de Juzgones", 8, "Programa de humor.", gold);

        // TODO: anadir temporadas a las series 

        // TODO: anadir capitulos a las temporadas 

        // TODO: anadir creadores y actores a las series

        // almacenar las series en el repositorio
        seriesRepo.save(s1);
        seriesRepo.save(s2);
        seriesRepo.save(s3);
    }   

    private void inyectarUsuarios() {
        
        // cuentas bancarias para los usuarios
        CuentaBancaria b1 = new CuentaBancaria("ES34 132412312341234");
        CuentaBancaria b2 = new CuentaBancaria("ES34 6798679867986798");
        CuentaBancaria b3 = new CuentaBancaria("ES34 4567456745674567");

        // creacion de los usuarios
        Usuario u1 = new Usuario("rodri@unican.es", "Rodrigo Maestro", null, b1, false);
        Usuario u2 = new Usuario("lamine@unican.es", "Lamine Yamal", null, b2, false);
        Usuario u3 = new Usuario("marc@unican.es", "Marc Cucurella", null, b3, false);

        // almacenar los usuarios en el repositorio
        usuariosRepo.save(u1);
        usuariosRepo.save(u2);
        usuariosRepo.save(u3);
    }

    
}
