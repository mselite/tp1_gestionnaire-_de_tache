
package gestionnairedetache;
import java.util.Vector;
import java.util.Scanner;

/**
 *
 * @author Msani
 */
public class Assignation {
    
    Scanner keyb = new Scanner(System.in);
    private int idMembre;
    private int idTache;
	
	public Assignation(){
		
            System.out.println("Pour assigner une tache a un membre Veuillez entrez ");
            System.out.println();
            System.out.print("l'Id du membre auquel la tache sera assigner : ");
            idMembre = Keyboard.getEntier();
            
            System.out.print("l'Id de la tache qui sera assigner : ");
            idTache = Keyboard.getEntier();

	}
	
    public void afficherAssignation()
    {
        //System.out.println("ID Membre"+"\t ID Tache");
        System.out.println(idMembre+"\t"+idTache);
        
    }

	public int getIdMembre() {
		return idMembre;
	}

	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}

	public int getIdTache() {
		return idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}

}
