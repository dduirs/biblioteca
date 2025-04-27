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

    public Catalogo(String nombre, String director, String tematica) {
        super(nombre, director, tematica);
    }

    public int getID_Catalogo() {
        return ID_Catalogo;
    }

    public void setID_Catalogo(int ID_Catalogo) {
        this.ID_Catalogo = ID_Catalogo;
    }

    @Override
    public int getTamano() {
        return tamano;
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
        int x = 0;
        for (Libro i : libros) {
            if (libros[x] == null) {
                this.libros[x] = libroNuevo;
                return;
            }
            x++;
        }
    }
//        if(this.libros[libros.length-1].getAutor() != null ){
//            this.libros[libros.length-1] = libroNuevo;
//        }
//        else{
//            System.out.println("EL catálogo esta lleno.\n");
//        }
//        libros[0] = libroNuevo;

    public boolean TieneEspacio(){
        int x = 0;
        for (Libro i : libros) {
            if (libros[x] == null) {
                return true;
            }
            x++;
        }
        return false;
    }

    @Override
    public void Mostrar(){
        System.out.printf("Bienvenidos a la %s\n", getNombre());
        System.out.println("━━━━━━━━━━━━━━━━━━━Catalogo━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ");
        System.out.println("  Director = " + getDirector());
        System.out.println("  Temática = " + getTematica());
        System.out.println("----------------------------------------------- ");
//        System.out.println("tamano de catalogo = " + tamano);
    }

    public Libro BuscarLibro(long ISBN){
        for(Libro i : libros){
            if(i != null) {
                if (i.getISBN() == ISBN) {
                    return i;
                }
            }
        }
        return null;
    }

    public boolean EliminarLibro(long ISBN){
        int x = 0;
        for (Libro i : libros) {
            if (i.getISBN() == ISBN) {
                libros[x] = null;
                return true;
            }
        x++;
        }
        return false;

    }
}
