import java.util.Set;

public class Catalogo extends Biblioteca{

//    + ID_Catálogo
//    + tamaño catálogo
//    + libros: int(ISBN)

// + consulta tamaño catálogo
//+ añade libro al catálogo: int(ISBN)
//+ buscar libro del catálogo: int(ISBN)
//+ borrar libro del catálogo: int(ISBN)

    private int ID_Catalogo;
    private int tamano;
//    private Set<Libro> libros;
    private Libro libroNuevo;
    private Libro[] libros;

    public Catalogo(String nombre, String director, String tematica, int ID_Catalogo, int tamano) {
        super(nombre, director, tematica);
        this.ID_Catalogo = ID_Catalogo;
        this.tamano = tamano;
        Libro[] libros = new Libro[tamano];
    }

    public Catalogo(int ID_Catalogo, int tamano) {
        this.ID_Catalogo = ID_Catalogo;
        this.tamano = tamano;
        Libro[] libros = new Libro[tamano];
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
        return this.libros.length;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
        this.libros = new Libro[tamano];
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

    public Libro getLibroNuevo() {
        return libroNuevo;
    }

    public void setLibroNuevo(Libro libroNuevo) {
        this.libroNuevo = libroNuevo;
//        if(this.libros[libros.length-1].getAutor() != null ){
//            this.libros[libros.length-1] = libroNuevo;
//        }
//        else{
//            System.out.println("EL catálogo esta lleno.\n");
//        }
        libros[0] = libroNuevo;
    }

}
