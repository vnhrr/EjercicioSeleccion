package Ejercicio_01;

import java.util.*;

public class AA_Principal {
    public static void main(String[] args) {
        //Almacenamos en un HashMap
        HashMap<String, String> cp = new HashMap<String, String>();
        cp.put("001", "Castellon");
        cp.put("002", "Valencia");
        cp.put("003", "Alicante");
        cp.put("004", "Teruel");
        cp.put("005", "Zaragoza");
        cp.put("006", "Huesca");
        cp.put("007", "Lleida");
        cp.put("008", "Barcelona");
        cp.put("009", "Tarragona");
        cp.put("010", "Girona");

        //Imorimimos datos
        for(Map.Entry<String, String> e : cp.entrySet()){
            String cod = e.getKey();
            String prov = e.getValue();
            System.out.println("CP: "+cod+" "+prov);
        }

        //Buscamos la provincia asociada a un CP
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un codigo de 3 digitos");
        String codigo = sc.next();
        boolean existe = false;
        for(Map.Entry<String, String> e : cp.entrySet()){
            String cod = e.getKey();
            if(cod.equalsIgnoreCase(codigo)){
                existe = true;
            }
        }
        if(existe){
            System.out.println(cp.get(codigo));
        }
        else{
            System.out.println("No hay provincia asociada a ese codigo");
        }


        //Eliminamos tuplas
        ArrayList<String> almacena = new ArrayList<String>();
        //Obtenemos las keys de los elementos a borrar
        for(Map.Entry<String, String> e : cp.entrySet()){
            String prov = e.getValue();
            if(prov.equalsIgnoreCase("barcelona")){
                almacena.add(e.getKey());
            }
            else if(prov.equalsIgnoreCase("alicante")){
                almacena.add(e.getKey());
            }
            else if(prov.equalsIgnoreCase("zaragoza")){
                almacena.add(e.getKey());
            }
        }
        //No podemos eliminar datos de un objeto que estamos recorriendo, asi que recorro el AL
        //pero borro datos en el HM
        for (String i : almacena){
            cp.remove(i);
        }
        //Imprimimos el HM
        for(Map.Entry<String, String> e : cp.entrySet()){
            String cod = e.getKey();
            String prov = e.getValue();
            System.out.println("CP: "+cod+" "+prov);
        }
    }
}
