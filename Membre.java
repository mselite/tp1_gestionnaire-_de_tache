
package gestionnairedetache;

import static gestionnairedetache.GestionnaireDeTache.menu;

import java.util.Scanner;
import java.util.Vector;
import java.io.*;


/**
 *
 * @author Msani
 */
public class Membre  implements Serializable{
    
    private static final long serialVersionUID = 8309080721495266420L;
    Scanner keyb = new Scanner(System.in);
    static Vector<Membre> listeMembre;
    
    private String nom;
    private int id;
    int nbr;
    boolean isNbr;
    
    public Membre() {
       //do
       //{
            System.out.println();
            System.out.print("Entrez l'ID du membre a creer : ");
            id = Keyboard.getEntier();
        
        do
        {
            //System.out.println("Veuillez entrez un nom");
            System.out.print("Entrez le Nom du membre a creer : ");
            nom=Keyboard.getString();
        }while(nom.isEmpty());
    }
    
    public void afficherMembre()
    {
        System.out.println(id+"\t"+nom);   
    }
    
    /******************************** Les Methodes Getter et Setter *******************************/
    
    public String getNom()
    {
        return nom;
    }
    
     public int getId()
    {
        return id;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public void setId(int id) {
	this.id = id;
    }
    
}
