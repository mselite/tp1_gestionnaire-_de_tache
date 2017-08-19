
package gestionnairedetache;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Msani
 */

public class Tache implements Serializable {
    
    private static final long serialVersionUID = 8309080721495266420L;
    Scanner keyb = new Scanner(System.in);
    private Vector<Tache> listeTache;
    private String nom;
    private int id;
    private String description;
    private String status;
    Membre m;
    Tache t;
    OperationMembreEtTache c = new OperationMembreEtTache();
    
    public Tache() {
  
        System.out.print("Entrez l'ID de la tache a creer : ");
        id = Keyboard.getEntier();
        
        do
        {
            System.out.print("Nom de la tache : ");
            nom = Keyboard.getString();
        }while(nom.isEmpty());
        
        do
        {
            System.out.print("Description de la tache : ");
            description=Keyboard.getString();
        }while(description.isEmpty());
        
        do
        {
            System.out.print("Status de la tache : ");
            status=Keyboard.getString();
        }while(status.isEmpty());
    }
    
    public void afficherTache()
    {
        System.out.println(id + "\t \t" + nom + "\t \t" + description + "\t \t" + status);   
    }

    /**********************************  lES GETTER & SETTER  *********************************/

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getNom() {
            return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
