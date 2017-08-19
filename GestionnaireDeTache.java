
package gestionnairedetache;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Msani
 */
public class GestionnaireDeTache {
    
   static Scanner keyb = new Scanner(System.in);
   static Membre m = null;
   static Tache t;
    
    public static void main(String[] args) throws IOException,ClassNotFoundException{
         int choix = 0;
        OperationMembreEtTache c = new OperationMembreEtTache();
        
        do
        {
        System.out.println();
            choix=menu();
            switch(choix)
            {
                case 1 : c.operationMembre();       
                break;
                case 2 : c.operationTache();
                break;
                case 3 : c.assignationTache();
                break;  
                case 4 : c.affichageTacheAssignerEnFonctionID();
                break;
                case 5 : c.AffichageTacheEnFonctionDuStatus();
                break;
                case 6 : c.afficherListeAssignation();
                break;  
                case 7 : System.out.println("Merci pour votre interaction, Au revoirs !");
                         System.exit(0);
                break;
            }
        }while(choix != 7);
    }
    
    /**menu vers les differentes partie du programme*/
    public static int menu()
    {
        
        int choix;
        System.out.println("MENU PRINCIPAL");
        System.out.println("--------------");
        System.out.println("1. Operation sur les membres");
        System.out.println("2. Operation sur les taches");
        System.out.println("3. Assignation de tache");
        System.out.println("4. Rechercher les taches assigne a un membre");
        System.out.println("5. Rechercher les taches en fonction de leur status");
        System.out.println("6. Afficher la liste des taches assignees");
        System.out.println("7. Sortir");
        System.out.println("--------------");
        System.out.print("votre choix : ");
        choix = Keyboard.getEntier();
        System.out.println();
        return choix;
    }
    
}
