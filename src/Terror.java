public class Terror extends Libro{

    private int calificacion;

    public Terror(String autor, long ISGN, int numPaginas, String tematica, int calificacion) {
        super(autor, ISGN, numPaginas, tematica);
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
