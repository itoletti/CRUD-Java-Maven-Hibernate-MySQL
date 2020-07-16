
package com.itoletti.maven_crud;

import com.itoletti.dominio.Persona;
import dao.PersonaJpaController;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class principal {
    private static Scanner sc = new Scanner(System.in);
    private static Scanner scstr = new Scanner(System.in);
    private static Persona p;
    private static PersonaJpaController  personaDao = new PersonaJpaController();
    private static int opcion, dni, id_dir;
    
    public static void main(String[] args) throws Exception{
        do{
            System.out.println("=== === === === === === === === === === === === ===");
            System.out.println("---             Elija una opccion               ---");
            System.out.println("=== === === === === === === === === === === === ===");
            System.out.println("---     0 Finalizar programa                    ---");
            System.out.println("---     1 Mostrar persona por Id                ---");
            System.out.println("---     2 Insertar persona en la BD             ---");
            System.out.println("---     3 Actualizar un registro                ---");
            System.out.println("---     4 Eliminar un registro                  ---");
            System.out.println("---     5 Listar personas                       ---");
            System.out.println("=== === === === === === === === === === === === ===");
            opcion = sc.nextInt();
    //       PersonaJpaController  personaDao = new PersonaJpaController();
            switch (opcion){
                case 0:
                    System.out.println("Finalizó el uso");
                    break;
                case 1: //Mostrar una persona por dni
                    p = obtenerPersona(personaDao);
                    System.out.println(p);
                    break;
                case 2: //Insertar una perzona
                    p = cargarPersona();
                    try{
                        personaDao.setPersona(p);
                    }catch (Exception ex){
                        System.out.println("No se pudo actualizar el registro...");
                    }
                    break;
                case 3: //Actualizar una persona
                    p = obtenerPersona(personaDao);
                    System.out.println(p);
                    System.out.println("Ingresar nombre y apellido: ");
                    p = new Persona(dni,scstr.nextLine(), scstr.nextLine(), p.getId_dir());
                    try{
                        personaDao.updatePersona(p);
                    } catch (Exception ex){
                        System.out.println("No se pudo actualizar el registro...");
                    }
                    break;
                case 4: //Eliminar una persona
                    p = obtenerPersona(personaDao);
                    System.out.println("Persona a eliminar: ");
                    System.out.println(p);
                    try{
                        personaDao.deletePersona(dni);
                    } catch (Exception ex){
                        System.out.println("No se pudo eliminar el registro...");
                    }               
                    break;
                case 5: //Listar personas
                    List<Persona> personas = personaDao.listarPersonas();
                    for (Iterator <Persona> indice = personas.iterator();indice.hasNext();){
                        Persona nextPersona = indice.next();
                        System.out.println(nextPersona);
                    }   
                    break;
                default:
                    System.out.println("Opcion fuera de rango..."); 
            }
        } while (opcion != 0) ;
        personaDao.cerrar();
    }

    private static Persona obtenerPersona(PersonaJpaController personaDao){
        System.out.println("Ingrese un dni: ");
        dni = sc.nextInt();
        p = personaDao.findPersona(dni);
        return p;
    }
    
    private static Persona cargarPersona(){
       System.out.println("Ingrese un dni, nombre, apellido y id_dir :"); 
       Persona p = new Persona(sc.nextInt(), scstr.nextLine(), scstr.nextLine(), sc.nextInt());
       return p;
    }
    
    private static void clearPantalla(){
       //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}        
    }
}   
