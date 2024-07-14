package es.unican.bcc301.empresariales.polaflix;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.unican.bcc301.empresariales.polaflix.pojos.Capitulo;
import es.unican.bcc301.empresariales.polaflix.pojos.Categoria;
import es.unican.bcc301.empresariales.polaflix.pojos.CuentaBancaria;
import es.unican.bcc301.empresariales.polaflix.pojos.Serie;
import es.unican.bcc301.empresariales.polaflix.pojos.Temporada;
import es.unican.bcc301.empresariales.polaflix.pojos.TrabajadorSerie;
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

        // anadir temporadas a la serie 1
        Temporada t1s1 = new Temporada(1, s1);
        Temporada t2s1 = new Temporada(2, s1);
        s1.anadirTemporada(t1s1);
        s1.anadirTemporada(t2s1);

        // anadir capitulos a las temporadas de la serie 1
        Capitulo cap1t1s1 = new Capitulo("Capitulo 1, T1", 1, "www.enlace-cap1t1s1.es", "Capitulo introductorio de la serie 1", t1s1);
        Capitulo cap2t1s1 = new Capitulo("Capitulo 2, T1", 2, "www.enlace-cap2t1s1.es", "Capitulo final de la primera temporada", t1s1);
        Capitulo cap1t2s1 = new Capitulo("Capitulo 1, T2", 1, "www.enlace-cap1t2s1.es", "Primer capitulo de la segunda temporada.", t2s1);
        Capitulo cap2t2s1 = new Capitulo("Capitulo 2, T2", 2, "www.enlace-cap2t2s1.es", "Capitulo final.", t2s1);
        t1s1.anadirCapitulo(cap1t1s1);
        t1s1.anadirCapitulo(cap2t1s1);
        t2s1.anadirCapitulo(cap1t2s1);
        t2s1.anadirCapitulo(cap2t2s1);

        // anadir temporadas a la serie 2
        Temporada t1s2 = new Temporada(1, s2);
        s2.anadirTemporada(t1s2);

        // anadir capitulos a la temporada de la serie 2
        Capitulo cap1t1s2 = new Capitulo("Capitulo 1", 1, "www.enlace-cap1t1s2.es", "Capitulo introductorio de la serie 2", t1s2);
        Capitulo cap2t1s2 = new Capitulo("Capitulo 2", 2, "www.enlace-cap2t1s2.es", "Capitulo desarrollo de la serie 2", t1s2);
        Capitulo cap3t1s2 = new Capitulo("Capitulo 3", 3, "www.enlace-cap3t1s2.es", "Capitulo final de la serie 2", t1s2);
        t1s2.anadirCapitulo(cap1t1s2);
        t1s2.anadirCapitulo(cap2t1s2);
        t1s2.anadirCapitulo(cap3t1s2);

        // anadir temporadas a la serie 3
        Temporada t1s3 = new Temporada(1, s3);
        Temporada t2s3 = new Temporada(2, s3);
        Temporada t3s3 = new Temporada(3, s3);
        s3.anadirTemporada(t1s3);
        s3.anadirTemporada(t2s3);
        s3.anadirTemporada(t3s3);

        // anadir capitulos a las temporadas de la serie 3
        Capitulo cap1t1s3 = new Capitulo("Capitulo 1, T1", 1, "www.enlace-cap1t1s3.es", "Capitulo completado: primera temporada.", t1s3);
        Capitulo cap1t2s3 = new Capitulo("Capitulo 1, T2", 1, "www.enlace-cap1t2s3.es", "Capitulo completado: segunda temporada.", t2s3);
        Capitulo cap1t3s3 = new Capitulo("Capitulo 1, T3", 1, "www.enlace-cap1t3s3.es", "Capitulo completado: tercera temporada.", t3s3);
        t1s3.anadirCapitulo(cap1t1s3);
        t2s3.anadirCapitulo(cap1t2s3);
        t3s3.anadirCapitulo(cap1t3s3);

        // anadir creadores y actores a las series
        Date fecha1 = new Date(1245);
        Date fecha2 = new Date(54321);
        Date fecha3 = new Date(6789);

        TrabajadorSerie creador1 = new TrabajadorSerie("Nacho Cano", fecha1);
        TrabajadorSerie creador2 = new TrabajadorSerie("Daniel Carvajal", fecha2);
        TrabajadorSerie creador3 = new TrabajadorSerie("Marco Carola", fecha3);
        TrabajadorSerie act1 = new TrabajadorSerie("José Pedrerol", fecha1);
        TrabajadorSerie act2 = new TrabajadorSerie("Alaska", fecha2);
        TrabajadorSerie act3 = new TrabajadorSerie("Vinisiu JR", fecha3);
        TrabajadorSerie act4 = new TrabajadorSerie("Ismael Torron", fecha1);
        TrabajadorSerie act5 = new TrabajadorSerie("Jose Luis T.", fecha2);
        TrabajadorSerie act6 = new TrabajadorSerie("Enrique Setien", fecha3);

        s1.anadirCreador(creador1);
        s1.anadirActor(act1);
        s1.anadirActor(act2);

        s2.anadirCreador(creador2);
        s2.anadirActor(act3);
        s2.anadirActor(act4);

        s3.anadirCreador(creador3);
        s3.anadirActor(act5);
        s3.anadirActor(act6);

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
