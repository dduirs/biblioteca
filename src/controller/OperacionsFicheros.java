package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OperacionsFicheros {

    public void crearFichero(){
//        File fichero = new File("src/recursos/libros.obj");
        File fichero = new File("src/recursos/escritura/mensaje.txt");

        if(!fichero.exists()){
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                System.out.println("Error en la creación del fichero.");
                throw new RuntimeException(e);
            }
        }else {
            System.out.println(fichero.exists());
        }
    }

    public void crearDirectorio(){
        File fichero = new File("src/recursos/escritura");

        if(!fichero.exists()){
            fichero.mkdir();
        }else {
            System.out.println(fichero.exists());
        }
    }

    public void obtenerInformacion(String path){
        File file = new File(path);
        String nombre = file.getName();
        boolean fichero = file.isFile();
        String ruta = file.getAbsolutePath();
//        lectura -> R --> 4
//        escrita -> W --> 2
//        ejecucion -> X --> 1
//        chomod 777
        boolean permisoLectura = file.canWrite();
        File parent = file.getParentFile();
        System.out.println("nombre = " + nombre);
        System.out.println("fichero = " + fichero);
        System.out.println("ruta = " + ruta);
        System.out.println("permisoLectura = " + permisoLectura);
        System.out.println("parent.getAbsolutePath() = " + parent.getAbsolutePath());
        System.out.println();
    }

    public void listarFichero(String path){
        File file = new File(path);
        if(file.exists() && file.isDirectory()){
//            String[] ficheros = file.list();
            File[] ficheros = file.listFiles();
            for(File fichero: ficheros){
//                System.out.println(fichero.getAbsolutePath());
                obtenerInformacion(fichero.getAbsolutePath());
            }
        }else{

        }
    }

    public void realizarEscritura(String path){
        File file = new File(path);
        FileWriter fileWriter = null; //no inicializar hamas
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("\nHola");
        } catch (IOException e) {
            System.out.println("Error en la IO del fichero.");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del flujo.");
            }
        }

//        if(file.exists() && file.isFile())
    }
}