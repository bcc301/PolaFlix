package es.unican.bcc301.empresariales.polaflix.pojos;

public class VisualizacionSerie implements Comparable<VisualizacionSerie> {

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

    @Override
    public int compareTo(VisualizacionSerie vs) {

        if (this.numTempUltCap == vs.numTempUltCap) {
            return this.numUltCapVisto - vs.getNumUltCapVisto();
        } else {
            return this.numTempUltCap - vs.getNumTempUltCap();
        }
    }


    @Override
    public boolean equals(Object o) {

        VisualizacionSerie vs;

        if (!(o instanceof VisualizacionSerie)) {
            return false;
        } else {
            vs = (VisualizacionSerie) o;
        }

        return this.usuario.equals(vs.getUsuario()) &&
            this.serie.equals(vs.getSerie()) &&
                this.numUltCapVisto == vs.getNumTempUltCap() &&
                    this.numTempUltCap == vs.getNumTempUltCap();
    }

    @Override
    public int hashCode() {
        return this.usuario.hashCode() + this.serie.hashCode() *
            this.numTempUltCap * this.numUltCapVisto;
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
