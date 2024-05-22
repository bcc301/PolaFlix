package es.unican.bcc301.empresariales.polaflix.pojos;

public class VisualizacionSerie {

    private int numUltCapVisto;
    private int numTempUltCap;

    private Usuario usuario;
    private Serie serie;

    public VisualizacionSerie(int numUltCapVisto, int numTempUltCap, Usuario usuario, Serie serie) {
        this.numUltCapVisto = numUltCapVisto;
        this.numTempUltCap = numTempUltCap;
        this.usuario = usuario;
        this.serie = serie;
    }

    /* METODOS DE NEGOCIO */
    public void actualizarUltimoCapituloVisto(Capitulo ultCap) {}

    /* GETTERS Y SETTERS */

    public int getNumUltCapVisto() {
        return numUltCapVisto;
    }

    public void setNumUltCapVisto(int numUltCapVisto) {
        this.numUltCapVisto = numUltCapVisto;
    }

    public int getNumTempUltCap() {
        return numTempUltCap;
    }

    public void setNumTempUltCap(int numTempUltCap) {
        this.numTempUltCap = numTempUltCap;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    
}
