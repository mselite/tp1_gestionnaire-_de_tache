
package gestionnairedetache;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Msani
 */
public class Keyboard {
    
public static String getString() // Lire un String
{
    String string = "";
    char charactere ='\0';
    try {
             while ((charactere = (char) System.in.read()) !='\n')
             {
              if (charactere != '\r')  string = string + charactere;

             }
       }
     catch (IOException e)
            {
              System.out.println("Erreur de saisi : " + e.getMessage());
            }
     return string;
} // fin de S()

 public static int getEntier() {

        Scanner keyboard = new Scanner(System.in);
        int identifiant;
        do {
            while (!keyboard.hasNextInt()) {

                System.out.println("Vous n'avez pas entre un entier");
                System.out.print("Veuillez entrer un entier  : ");
                keyboard.next();
            }
            identifiant = keyboard.nextInt();
            if(identifiant < 0)
                System.out.print("Veuillez entrez un entier positif : ");

        } while (identifiant < 0);

        return identifiant;
    } 
    
}

