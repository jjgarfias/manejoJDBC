package test;

import datos.PersonaJDBC;
import domain.Persona;
import java.util.List;

/**
 *
 * @author Jaime Garfias
 */
public class ManejoPersonas {
    
    public static void main(String[] args){
        PersonaJDBC personaJDBC = new PersonaJDBC();
        List<Persona> personas = personaJDBC.select();
        
        for(Persona persona: personas){
            System.out.println("persona: " +persona);
        }
        
    }
    
}
