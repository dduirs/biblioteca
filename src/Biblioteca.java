public class Biblioteca {

    public Biblioteca(String nombre, String director, String tematica) {
        this.nombre = nombre;
        this.director = director;
        this.tematica = tematica;
    }
    public Biblioteca(){

    }

    private String nombre;
    private String director;
    private String tematica;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }


    public void Nombrar(String nombre_bib){
        nombre = nombre_bib;
        System.out.printf("%s creado.\n", nombre);
    }

    public void Mostrar(){
        System.out.printf("Bienvenidos a la %s\n", nombre);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ");
        System.out.println("  Director = " + director);
        System.out.println("  Temática = " + tematica);
        System.out.println("----------------------------------------------- ");
    }
    public void DefinirYMostrar(String director_bib, String tematica_bib){
        System.out.printf("Bienvenidos a la %s\n", nombre);
//        setDirector(director_bib);
        this.director = director;
//        setTematica(tematica_bib);
        this.tematica = tematica;
        System.out.println("director = " + director);
        System.out.println("temática = " + tematica);
    }

//+ construir catálogo: int(max. cantidad libros)
//+ mostrar todos los libros disponibles
//+ añade temática

}
