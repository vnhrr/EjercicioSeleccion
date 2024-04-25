package Ejercicio_03;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class AA_Principal {
    public static void main(String[] args) {
        HashMap<String, String> trabajadores = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        boolean error = false;


        do{
            System.out.println("Seleccione un opcion");
            System.out.println("1: añadir tranajador");
            System.out.println("2: Buscar por DNI");
            System.out.println("3: Burcar por nombre");
            System.out.println("4: Modificar trabajador");
            System.out.println("5: Eliminar trabajador");
            System.out.println("6: Salir");
            try{
                int opcion = sc.nextInt();
                if(opcion <= 6){
                    switch (opcion){
                        case 1://Introducimos trabajadores
                            boolean duplicado = true;
                            do {
                                System.out.println("Introduce DNI");
                                String dni = sc.next();
                                System.out.println("Nombre y apellidos");
                                String nom = sc.next();
                                sc.nextLine();
                                if(!trabajadores.containsKey(dni)){
                                    trabajadores.put(dni, nom);
                                    duplicado = false;
                                }else{
                                    System.out.println("Este dni o trabajador ya se encuentra registrado");
                                    duplicado = true;
                                }
                            }
                            while(duplicado);
                            break;

                        case 2://Buscamos trabajadores por DNI
                            System.out.println("Introduce DNI");
                            String dni = sc.next();
                            if(trabajadores.containsKey(dni)){
                                System.out.println(trabajadores.get(dni));
                                break;
                            }else{
                                System.out.println("No existe un trabajador con dicho dni");
                                break;
                            }

                        case 3://Buscamos trabajadores por nombre
                            String key = "";
                            System.out.println("Nombre y apellidos");
                            String nom3 = sc.next();
                            if(trabajadores.containsValue(nom3)){
                                for (Map.Entry<String, String> e : trabajadores.entrySet()){
                                    if(e.getValue().equalsIgnoreCase(nom3)){
                                        key = e.getKey();
                                        System.out.println(e.getKey()+" "+e.getValue());
                                    }
                                }
                                break;
                            }else{
                                System.out.println("No existe un trabajador con dicho nombre");
                                break;
                            }

                        case 4://Modificamos un trabajador
                            System.out.println("Introduce DNI");
                            String dni4 = sc.next();
                            if(trabajadores.containsKey(dni4)){
                                for (Map.Entry<String, String> e : trabajadores.entrySet()){
                                    if(e.getKey().equalsIgnoreCase(dni4)){
                                        System.out.println("Introduzca el nuevo valor");
                                        System.out.println("Nombre:");
                                        String nomnew = sc.next();
                                        e.setValue(nomnew);
                                    }
                                }
                                System.out.println("Introduzca los nuevos valores");
                                System.out.println("DNI:");
                                String dninew = sc.next();
                                System.out.println("Nombre:");
                                String nomnew = sc.next();
                                trabajadores.replace(dninew, nomnew);
                                break;
                            }else{
                                System.out.println("No existe un trabajador con dicho dni");
                                break;
                            }

                        case 5://Eliminamos un trabajador
                            System.out.println("Introduce DNI");
                            String dni5 = sc.next();
                            if(trabajadores.containsKey(dni5)){
                                trabajadores.remove(dni5);
                                break;
                            }else{
                                System.out.println("No existe un trabajador con dicho dni");
                                break;
                            }

                        case 6:
                            error = true;
                            break;
                    }
                }
                else{
                    error = false;
                    System.out.println("Introduzca un valor en rango");
                }
            }
            catch (InputMismatchException e){
                error = false;
            }
        }while (!error);
    }
}
