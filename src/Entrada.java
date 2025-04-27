import controller.OperacionsFicheros;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Entrada {

    static Scanner in = new Scanner(System.in).useDelimiter("\n");

    public static <string> void main(String[] args) {

        OperacionsFicheros opFichero = new OperacionsFicheros();
        opFichero.crearFichero();
        opFichero.crearDirectorio();
        opFichero.obtenerInformacion("src/recursos/libros.obj");
        opFichero.listarFichero("src/recursos/lectura");
        opFichero.realizarEscritura("src/recursos/escritura/mensaje.txt");

        int ID_Catalogo = 1;
        Biblioteca[] bibliotecas = new Biblioteca[2];
        Biblioteca bNacionalEsp = new Biblioteca();

        bNacionalEsp.setNombre("Biblioteca Naciónal de España");
        bNacionalEsp.setDirector("Óscar");
        bNacionalEsp.setTematica("todas");
        boolean appActivo = true;
        System.out.println("\nHola, bienvenidos a la app de bibliotecas.");
        long choice, choiceEsISBN = 0;

        while (appActivo) {
            Catalogo biblio1 = new Catalogo();
            System.out.println("""
                     ~ Menú principal de la app ~
                    \s
                         \
                     1 - Entrar o añadir biblioteca
                    \s
                         \
                     2 - Salir del app
                    \s
                         \
                     3 - Para buscar a un libro, escribe el ISBN (SIN los 3 primeros números "97x"):  \s""");
            System.out.print("\n  -> ");
//            input = Integer.toString((int) choiceCopy);
            // Spanish: 10 digit 978-84
            // Spanish: 13 digit 979-13
//            if(input.length()>1){ //check if menu selection 1,2,3   OR  ISBN (10 or 13 digits) entered
//                choice = 4;
//            }
            choice = in.nextLong();
            if (choice > 10) {
                choice = 4;
            }
            String input;
            System.out.printf("choice/case = %d\n",choice);
//            byte catalo_libros = 00;
            boolean biblio_exists = false;
            switch ((int) choice) {
                case 1:
                    System.out.println("case1:");
                    System.out.println("|  Escribe el nombre de la biblioteca que buscas:");
                    System.out.print("->  ");
                    String nombre_biblioteca = "";
//                    TODO: handle input Mismatch exception
                    nombre_biblioteca += in.next();
//                    System.out.println("nombre_biblioteca = " + nombre_biblioteca);
//                    System.out.println("bNacionalEsp.getNombre(); = " + bNacionalEsp.getNombre());
//                    TODO: Comprobar si existe el nombre de la biblioteca en una lista?
                    for(Biblioteca b : bibliotecas) {
                        try {
                            if (Objects.equals(nombre_biblioteca, b.getNombre())) {
                                bNacionalEsp.Mostrar();//TODO: change
                                biblio_exists = true;
                                bibliotecas[1] = biblio1;
                            }
                        }catch(NullPointerException e){
                            System.out.println("Null exception "+e.getMessage());
                            break;
                        }
                    }
//                    {
//                        System.out.printf("\nBienvenidos a la biblioteca %s.\n", nombre_biblioteca);
//                        System.out.println("""
//
//                                [Director]
//                                [Nombre_catalogo]
//                                """);
//                    }
                    if(!biblio_exists){
                        System.out.println("|  No se ha encontrada la biblioteca que buscas.");
                        System.out.println("||  ¿Añade la biblioteca  \"" + nombre_biblioteca + "\"?" +
                                "\n|||   Pulsar 's' o 'S' para confirmar u otra tecla para salir:");
                        System.out.print("||->  ");
//                    TODO: handle input Mismatch exception
                        input = in.next();
                        if (!Objects.equals(input, "s") && !Objects.equals(input, "S")) {
                            break;
                        }
                        System.out.print("Escribe el nombre del director/a: ");
                        String director = in.next();
                        System.out.print("Escribe la tematica, o \"n\" si no hay: ");
                        String tematica = in.next();
                        if(Objects.equals(tematica, "n") || Objects.equals(tematica, "N")){
                            biblio1.Nombrar(nombre_biblioteca);
                            biblio1.setDirector(director);
                        }else{
                            biblio1.setNombre(nombre_biblioteca);
                            biblio1.setDirector(director);
                            biblio1.setTematica(tematica);
//                            biblio1 = new Catalogo(nombre_biblioteca,director, tematica);
                            biblio1.Mostrar();
                        }
//                        Libro libro1 = new Libro("Harry", 9788446047674L, 10, "Policiaca");
//                        System.out.print("libro1 = ");
//                        libro1.mostrarDatos();
                        biblio_exists = true;
                    }
                    boolean dentroBibloteca = true;
                    while (dentroBibloteca){
//      TODO: check if any catalogue and/or books, modify menu accordingly.
                        if(biblio_exists) {
                            System.out.println("    ~ Menú de gestión de la biblioteca ~");
//                            byte catalo_libros = 00;
//                            System.out.println("byte catalo_libros = (00, 10, 11)");
//                            catalo_libros = in.nextByte();
//                            System.out.println("byte catalo_libros = "+catalo_libros);
//                            switch (catalo_libros) { // Menu dinamico
//                                case 00: //catalo 0, libros 0
//                                    bibMenuItems(catalo_libros);
//                                    break;
//                                case 10: //catalo 1, libros 0
//                                    bibMenuItems(catalo_libros);
//
//                                    break;
//                                case 11: //catalo 1, libros 1
//                                    bibMenuItems(catalo_libros);
//                                    //             TODO:  5 - buscar, añade o borrar  libro del catálogo:  Enter ISBN:
//                                    break;
//                            }
                            System.out.println("""
                            \s
                                 \
                             1 - Construir catálogo\s
                            \s
                                 \
                             2 - Salir de la biblioteca\s
                            \s
                                 \
                             3 - Para buscar, añadir o borrar a un libro del catálogo
                            \s
                                 \
                             4 - Consultar el tamaño del catálogo\s
                            \s
                                 \
                             5 - Mostrar todos los libros disponibles del catálogo\s""");

                            int caseBibMenu = 0;
                            System.out.print("\n  -> ");
                            caseBibMenu = in.nextInt();
                            switch (caseBibMenu){   //Menu de la biblioteca
                                case 1: //Construir catálogo
//                                    if(biblio1.getClass().equals(Catalogo.class)){ //TODO: check if catalogue exists
//                                    }else{
                                        System.out.println(" Escribe el tamano del catalogo: ");
                                        int tamano = in.nextInt();
                                        biblio1.setID_Catalogo(ID_Catalogo);
                                        biblio1.setTamano(tamano);
//                                        biblio1 = new Catalogo(ID_Catalogo,tamano);
                                        ID_Catalogo += 1;
//                                    }
                                    biblio1.Mostrar();
                                    break;
                                case 2: //Salir
                                    dentroBibloteca = false;
                                    System.out.println("    Saliendo del gestor de la biblioteca...");
                                    break;
                                case 3: // Para buscar, añadir o borrar a un libro del catálogo, escribe el ISBN
                                    System.out.println("Escribe el ISBN (SIN los 3 primeros números '97x'): ");
                                    choice = in.nextLong();
                                    Libro libroTemp = new Libro();
                                    String inputConfirm;
                                    if(biblio1.BuscarLibro(choice)!= null){
                                        libroTemp = biblio1.BuscarLibro(choice);
                                        System.out.println("Libro disponible = ");
                                        libroTemp.mostrarDatos();
                                        System.out.println("Quieres borrar el libro del catalogo?");
                                        System.out.println(" s para confirmar, n para salir");
                                        inputConfirm = in.next();
                                        if (Objects.equals(inputConfirm, "s")) {
                                           if(biblio1.EliminarLibro(choice)){
                                               System.out.println("Borrado correctamente");
                                           }else{
                                               System.out.println("Habia un error. El libro no ha borrado correctamente");
                                           }
                                        }
                                    }else {
                                        try {
                                            Libro libro = new Libro();
                                            libro.setISBN(choice);
                                            libroTemp.setISBN(choice);
                                            libro = biblio1.BuscarLibro(libro.getISBN());
                                            if (libro == null) {
                                                if(!biblio1.TieneEspacio()){
                                                    System.out.println("Libro no encontrado. El catalogo esta lleno.");
                                                }else {
                                                    System.out.println("Libro no encontrado. ¿Quieres añadir este libro con ISBN " + libroTemp.getISBN() + "?");
                                                    System.out.println(" s para confirmar, n para salir");
                                                    inputConfirm = in.next();
                                                    if (Objects.equals(inputConfirm, "s")) {
                                                        System.out.println("Escribe el nombre del autor: ");
                                                        inputConfirm = in.next();
                                                        libroTemp.setAutor(inputConfirm);
                                                        System.out.println("Escribe numero de paginas: ");
                                                        inputConfirm = in.next();
                                                        libroTemp.setNumPaginas(Integer.parseInt(inputConfirm));
                                                        System.out.println("Escribe tematica: ");
                                                        inputConfirm = in.next();
                                                        libroTemp.setTematica(inputConfirm);
                                                        biblio1.setLibroNuevo(libroTemp);
                                                        System.out.println("Libro " + libroTemp.getISBN() + " anadido");
                                                    }
                                                }
                                            }
                                        } catch (NullPointerException e) {
                                            System.out.println("Null exception: " + e.getMessage());
                                        }
                                    }
                                    break;
                                case 4: // Consultar el tamaño del catálogo
                                    System.out.println("Tamano del catalogo = " + biblio1.getTamano());
                                    break;
                                case 5: // Mostrar todos los libros disponibles del catálogo
                                    System.out.println("Libros del catalogo = ");
                                    for(Libro l : biblio1.getLibros()){
                                        if(l != null){
                                            l.mostrarDatos();
                                        }
                                    }
                                    break;
                                default:
                                    dentroBibloteca = false;
                                    System.out.println("    Saliendo del gestor de la biblioteca...");
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    appActivo = false;
                    break;
//                case 3: //buscar libro por ISBN, 10 o más digitos
//                    input = ISBN
//                    System.out.println("case 3:");
//                    System.out.println("Escribe el ISBN del libro que buscas (SIN los 3 primeros números 97x):  ");
////                  TODO: handle InputMismatchException when long 13 digit ISBN e.g."9788446047674" entered
//                    choice = in.nextLong();
//                    choiceEsISBN = gestionarISBNinput(choice);

                case 3: // Para buscar, añadir o borrar a un libro del catálogo, escribe el ISBN
                    System.out.println("Escribe el ISBN (SIN los 3 primeros números '97x'): ");
                    choice = in.nextLong();
                    Libro libroTemp = new Libro();
                    String inputConfirm;
                    if(biblio1.BuscarLibro(choice)!= null){
                        libroTemp = biblio1.BuscarLibro(choice);
                        System.out.println("Libro disponible = ");
                        libroTemp.mostrarDatos();
                        System.out.println("Quieres borrar el libro del catalogo?");
                        System.out.println(" s para confirmar, n para salir");
                        inputConfirm = in.next();
                        if (Objects.equals(inputConfirm, "s")) {
                            if(biblio1.EliminarLibro(choice)){
                                System.out.println("Borrado correctamente");
                            }else{
                                System.out.println("Habia un error. El libro no ha borrado correctamente");
                            }
                        }
                    }else {
                        try {
                            Libro libro = new Libro();
                            libro.setISBN(choice);
                            libroTemp.setISBN(choice);
                            libro = biblio1.BuscarLibro(libro.getISBN());
                            if (libro == null) {
                                if(!biblio1.TieneEspacio()){
                                    System.out.println("Libro no encontrado. El catalogo esta lleno.");
                                }else {
                                    System.out.println("Libro no encontrado. ¿Quieres añadir este libro con ISBN " + libroTemp.getISBN() + "?");
                                    System.out.println(" s para confirmar, n para salir");
                                    inputConfirm = in.next();
                                    if (Objects.equals(inputConfirm, "s")) {
                                        System.out.println("Escribe el nombre del autor: ");
                                        inputConfirm = in.next();
                                        libroTemp.setAutor(inputConfirm);
                                        System.out.println("Escribe numero de paginas: ");
                                        inputConfirm = in.next();
                                        libroTemp.setNumPaginas(Integer.parseInt(inputConfirm));
                                        System.out.println("Escribe tematica: ");
                                        inputConfirm = in.next();
                                        libroTemp.setTematica(inputConfirm);
                                        biblio1.setLibroNuevo(libroTemp);
                                        System.out.println("Libro " + libroTemp.getISBN() + " anadido");
                                    }
                                }
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Null exception: " + e.getMessage());
                        }
                    }
                    break;
//                case 4: //buscar libro por ISBN, 10 o más digitos
////                    input =
//                    try{
//                        Libro libro = new Libro();
//                        Libro libroTemp = new Libro();
//                        String inputConfirm;
//                        libro.setISBN(8446047674L);
//                        libroTemp.setISBN(3446047675L);
////                                        libro = biblio1.BuscarLibro(choiceEsISBN);
//                        libro = biblio1.BuscarLibro(libro.getISBN());
//                        if(libro == null){
//                            System.out.println("Libro no encontrado. ¿Quieres añadir este libro con ISBN "+libroTemp.getISBN()+"?");
//                            System.out.println(" s para confirmar, n para salir");
//                            inputConfirm = in.next();
//                            if(Objects.equals(inputConfirm, "s")){
//                                biblio1.setLibroNuevo(libroTemp);
//                            }
//                        }
//                        System.out.println("libro.getISBN() = " + libro.getISBN());
//                        System.out.println("biblio1 = " + biblio1.BuscarLibro(8446047674L));
//                        libro.mostrarDatos();
//                    }catch(NullPointerException e){
//                        System.out.println("Null exception: "+e.getMessage());
//                    }
//                    System.out.println("case 4:\n");
//                    System.out.println("---------------------------------------------------------------------- ");
//                    System.out.printf(" El ISBN “%d” no corresponde a ningún libro en nuestra colección.\n",choiceEsISBN);
//                    System.out.println("\n Entra a una biblioteca para añade un libro.");
//                    break;
                default:
                    break;
//                    System.out.println("case not yet implemented");
            }
            System.out.println("----------------------------------------------- ");
//          exit app
        }
        System.out.println("Vuele pronto.");
    }

//    private static void bibMenuItems(int catalo_libros) {
//        int item = catalo_libros;
//        if(item == 00){
//            System.out.println("""
//                    \s
//                         \
//                     1 - Construir catálogo\s""");
//        }
//        else{
//            System.out.println("""
//                    \s
//                         \
//                     1 - Consultar el tamaño del catálogo\s""");
//        }
//        System.out.println("""
//                 \s
//                      \
//                  2 - Salir de la biblioteca\s""");
//
//        if (item == 11) {
//            System.out.println("""
//                    \s
//                         \
//                     3 - Para buscar, añadir o borrar a un libro del catálogo, escribe el ISBN (SIN los 3 primeros números "97x")
//                    \s
//                         \
//                     4 - Mostrar todos los libros disponibles del catálogo\s""");
//        }
//    }

//    TODO: handle 13 digit ISBNs, remove 978/9 and then search for matched ISBN in catalogue
//    TODO: make ISBN checksum checker
    private static long gestionarISBNinput(long choice){
        StringBuilder original = new StringBuilder();
        long choiceEsISBN;
        choiceEsISBN = choice;
        int i = 0;
        long lastDigit;
        lastDigit = choiceEsISBN % 10;
//        System.out.println("    check digit "+i+" = " + lastDigit);
        if (choice > 1000000000) { //844 604 767
            do {
                choiceEsISBN /= 10;
                i++;
                lastDigit = choiceEsISBN % 10;
//            System.out.println("    lastDigit "+i+" = " + lastDigit);
                original.insert(0, lastDigit);
            } while (choiceEsISBN > 979999999);
//                int test10 = 1205;
//                System.out.println("test10  % 10 = "+test10 % 10);
//                input = Integer.toString((int) choiceEsISBN);
//        System.out.println(i + " 0's removed\n");
//        System.out.println("original number = " + choice);
            System.out.println("original "+i+" end digits of long (not incl. check digit) = " + original);
//        while (i > 0) {
////                    System.out.print("0");
//            i--;
//        }
        }else { //    052551031(4)    8446047674
            String firstLtr = null;
            original.insert(0, choiceEsISBN);
            if (choice > 9999999 && choice < 100000000) {
                System.out.println("choiceEsISBN = " + choiceEsISBN);
                original.insert(0, choiceEsISBN);
                System.out.println("original = " + original);
                //          String strExpectFirst = original.substring(1,original.length());

                do {
                    choiceEsISBN /= 10;
                    i++;
                    lastDigit = choiceEsISBN % 10;
//            System.out.println("    lastDigit "+i+" = " + lastDigit);
                    original.insert(0, lastDigit);
                } while (choiceEsISBN > 9999999);
            } else {
                firstLtr = original.substring(0, 1);
                System.out.println("firstLtr is NOT 0 = " + firstLtr);
//                TODO: add 978 and 0 back to front of number i
                do {
                    choiceEsISBN /= 10;
                    i++;
                    lastDigit = choiceEsISBN % 10;
//            System.out.println("    lastDigit "+i+" = " + lastDigit);
                    original.insert(0, lastDigit);
                } while (choiceEsISBN > 99999998);
            }
        }
        System.out.println();
        return choiceEsISBN;
    }

}

