import java.util.Objects;
import java.util.Scanner;

public class Entrada {

    static Scanner in = new Scanner(System.in).useDelimiter("\n");


    public static void main(String[] args) {
        Biblioteca bNacionalEsp = new Biblioteca();
        bNacionalEsp.setNombre("Biblioteca Naciónal de España");
        bNacionalEsp.setDirector("Óscar");
        bNacionalEsp.setTematica("todas");
        boolean appActivo = true;
        System.out.println("\nHola, bienvenidos a la app de bibliotecas.");

        while (appActivo) {
            System.out.println("""
                    \s
                         \
                     1 - Entrar o añade biblioteca
                    \s
                         \
                     2 - Salir del app
                    \s
                         \
                     3 - Para buscar a un libro, escribe el ISBN (SIN los 3 primeros números "97x"):  \s""");
            System.out.print("\n -> ");

//            input = Integer.toString((int) choiceCopy);
            // Spanish: 10 digit 978-84
            // Spanish: 13 digit 979-13
//            if(input.length()>1){ //check if menu selection 1,2,3   OR  ISBN (10 or 13 digits) entered
//                choice = 4;
//            }
            long choice, choiceEsISBN = 0;
            choice = in.nextLong();
            if (choice > 10) {
                choiceEsISBN = gestionarISBNinput(choice);
                choice = 4;
            }
            String input;

            System.out.printf("choice/case = %d\n",choice);
            switch ((int) choice) {
                case 1:
                    System.out.println("case1:");
                    System.out.println("Escribe el nombre de la biblioteca que buscas:");
                    String nombre_biblioteca = "";
                    nombre_biblioteca += in.next();
//                    System.out.println("nombre_biblioteca = " + nombre_biblioteca);
//                    System.out.println("bNacionalEsp.getNombre(); = " + bNacionalEsp.getNombre());
                    if (Objects.equals(nombre_biblioteca, bNacionalEsp.getNombre())) {
                        bNacionalEsp.Mostrar();
//                    {
//                        System.out.printf("\nBienvenidos a la biblioteca %s.\n", nombre_biblioteca);
//                        System.out.println("""
//
//                                [Director]
//                                [Nombre_catalogo]
//                                """);
//                    }
                    }else {
                        System.out.println("No se ha encontrada la biblioteca que buscas.");
                        System.out.println("Añade la biblioteca  \"" + nombre_biblioteca + "\" ? [pulsar 's' o 'S' para confirmar u otra tecla para salir]");
                        input = in.next();
                        if (!Objects.equals(input, "s") && !Objects.equals(input, "S")) {
                            break;
                        }
//                      else {
                        Biblioteca b1 = new Biblioteca();
                        b1.Crear(nombre_biblioteca);
                        b1.CrearYMostrar("Jose", "Comedia");
                        b1.Mostrar();
//                      }
                    }
                    break;
                case 2:
                    appActivo = false;
                    break;
                case 3: //buscar libro por ISBN, 10 o más digitos
//                    input = ISBN
                    System.out.println("case 3:");
                    System.out.println("Escribe el ISBN del libro que buscas (SIN los 3 primeros números 97x):  ");
                    choice= in.nextInt();
                    choiceEsISBN = gestionarISBNinput(choice);
                case 4: //buscar libro por ISBN, 10 o más digitos
//                    input = ISBN
                    System.out.println("case 4:\n");
                    System.out.println("---------------------------------------------------------------------- ");
                    System.out.printf(" El ISBN “%d” no corresponde a ningun libro en nuestra colección.\n",choiceEsISBN);
                    System.out.println("\n Entra a una biblioteca para añade un libro.");
                    break;
                default:
                    System.out.println("case not yet implemented");
            }
            System.out.println("----------------------------------------------- ");
//          exit app
        }
        System.out.println("Vuele pronto.");
    }

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

