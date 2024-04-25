package Ejercicio_02;

import javax.naming.SizeLimitExceededException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AA_Principal {
    public static void main(String[] args) {
        HashMap<String, String> matriculas = new HashMap<String, String>();
        matriculas.put("001", "Pedro");
        matriculas.put("002", "Ana");
        matriculas.put("003", "Juan");
        matriculas.put("004", "Fer");
        matriculas.put("005", "Tefy");

        //Contamos la cantidad de tuplas
        int cont = 0;
        for (Map.Entry<String, String> e : matriculas.entrySet()){
            cont++;
        }
        System.out.println(cont);

        //Buscamos el alumno por num_exp
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un expediente");
        String exp = sc.next();
        boolean existe = false;
        for(Map.Entry<String, String> e : matriculas.entrySet()){
            String cod = e.getKey();
            if(cod.equalsIgnoreCase(exp)){
                existe = true;
            }
        }
        if(existe){
            System.out.println(matriculas.get(exp));
        }
        else{
            System.out.println("No existe dicho expediente");
        }

        //Permitimos eliminar una tupla por num_exp
        System.out.println("Introduce un exp para borrar tupla");
        String elimina = sc.next();
        matriculas.remove(elimina);
        for(Map.Entry<String, String> e : matriculas.entrySet()){
            String cod = e.getKey();
            String prov = e.getValue();
            System.out.println("Exp: "+cod+" "+prov);
        }
        //Permitimos eliminar una tupla por num_exp nombre
        System.out.println("Introduce un nombre para borrar tupla");
        String borra = "";
        boolean borrar = false;
        String eliminanom = sc.next();
        for(Map.Entry<String, String> e : matriculas.entrySet()){
            String nom = e.getValue();
            if(eliminanom.equalsIgnoreCase(nom)){
                borra = e.getKey();
                borrar = true;
            }
        }
        if (borrar){
            matriculas.remove(borra);
        }
        else{
            System.out.println("No hay un alumno con ese nombre");
        }
        for(Map.Entry<String, String> e : matriculas.entrySet()){
            String cod = e.getKey();
            String prov = e.getValue();
            System.out.println("Exp: "+cod+" "+prov);
        }

    }
}
