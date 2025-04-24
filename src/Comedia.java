public class Comedia extends Libro{

    private String tipoHumor;

    public Comedia(String autor, long ISGN, int numPaginas, String tematica, String tipoHumor) {
        super(autor, ISGN, numPaginas, tematica);
        this.tipoHumor = tipoHumor;
    }

    public String getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(String tipoHumor) {
        this.tipoHumor = tipoHumor;
    }
}
