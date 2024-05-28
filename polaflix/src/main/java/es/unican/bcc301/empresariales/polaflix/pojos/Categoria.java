package es.unican.bcc301.empresariales.polaflix.pojos;

public class Categoria {

    private String nombre;
    private double precio;


    public Categoria(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }


    // metodos auxiliares

    @Override
    public boolean equals(Object o) {
        
        Categoria cat;

        if (!(o instanceof Categoria)) {
            return false;
        } else {
            cat = (Categoria) o;
        }

        return this.nombre.equals(cat.getNombre());
    }


    @Override
    public int hashCode() {
        return (int) this.precio * 17;
    }


    // getters y setters

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
