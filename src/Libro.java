public class Libro {
//+ autor: String
//+ ISBN: int(13)
//+ numeroPaginas: int
//+ temática: String

    private String autor;
    private long ISBN;
    private int numPaginas;
    private String tematica;

    public Libro(String autor, long ISBN, int numPaginas, String tematica) {
        this.autor = autor;
        this.ISBN = ISBN;
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

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
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

    public void mostrarDatos(){
        System.out.println("    Autor    = " + autor);
        System.out.println("    ISBN     = " + ISBN);
        System.out.println("    Paginas  = " + numPaginas);
        System.out.println("    Tematica = " + tematica);
        System.out.println();
    }
}

