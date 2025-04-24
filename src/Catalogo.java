import java.util.Set;

public class Catalogo extends Biblioteca{

//    + ID_Catálogo
//    + tamaño catálogo
//    + libros: int(ISBN)

    private int ID_Catalogo;
    private int tamano;
    private Set<Libro> libros;

    public Catalogo(String nombre, String director, String tematica, int ID_Catalogo, int tamano, Set<Libro> libros) {
        super(nombre, director, tematica);
        this.ID_Catalogo = ID_Catalogo;
        this.tamano = tamano;
        this.libros = libros;
    }

    public Catalogo(int ID_Catalogo, int tamano, Set<Libro> libros) {
        this.ID_Catalogo = ID_Catalogo;
        this.tamano = tamano;
        this.libros = libros;
    }

    public Catalogo(){
    }

    public int getID_Catalogo() {
        return ID_Catalogo;
    }

    public void setID_Catalogo(int ID_Catalogo) {
        this.ID_Catalogo = ID_Catalogo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
}
