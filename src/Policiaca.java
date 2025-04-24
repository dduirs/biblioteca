import java.util.List;

public class Policiaca extends Libro{

//    + trama: misterio o intriga
//    + personajes
    private String trama;
    private List<String> personajes;

    public Policiaca(String autor, long ISGN, int numPaginas, String tematica) {
        super(autor, ISGN, numPaginas, tematica);
    }

    public Policiaca(String autor, long ISGN, int numPaginas, String tematica, String trama, List<String> personajes) {
        super(autor, ISGN, numPaginas, tematica);
        this.trama = trama;
        this.personajes = personajes;
    }

    public Policiaca(){

    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public List<String> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<String> personajes) {
        this.personajes = personajes;
    }
}
