public class Libro {
//+ autor: String
//+ ISBN: int(13)
//+ numeroPaginas: int
//+ temática: String

    private String autor;
    private long ISGN;
    private int numPaginas;
    private String tematica;

    public Libro(String autor, long ISGN, int numPaginas, String tematica) {
        this.autor = autor;
        this.ISGN = ISGN;
        this.numPaginas = numPaginas;
        this.tematica = tematica;
    }

    public Libro(){

    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getISGN() {
        return ISGN;
    }

    public void setISGN(long ISGN) {
        this.ISGN = ISGN;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}

