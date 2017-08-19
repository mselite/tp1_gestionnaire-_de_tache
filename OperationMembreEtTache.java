
package gestionnairedetache;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import java.util.Scanner;

/**
 *
 * @author Msani
 */

public class OperationMembreEtTache {
    
    private Vector<Membre> listeMembre;
    private Vector<Tache> listeTache;
    private Vector<Assignation> listeAssignation;
    //Fichier f = new Fichier();

   // OperationMembreEtTache c = new OperationMembreEtTache();
    Membre m;
    Tache t;
    
    Scanner keyb = new Scanner(System.in);
    
    public OperationMembreEtTache() {
    	
    	listeMembre = new Vector();
    	listeTache = new Vector();
    	listeAssignation = new Vector();
        
         
    }
   
    /*********************************** LES OPERATIONS SUR MEMBRE ***********************************/
    
    
    // METHODE DE CREATION ET D'AJOUT D'UN MEMBRE
    
    public void creerEtAjouterMembre()
    {
    	int choix;
    	Membre newMembre = new Membre();
    	Membre verifierExistance;
    	verifierExistance = rechercheMembre(newMembre.getId());
        
    	if(verifierExistance == null) {
                System.out.println();
	    	System.out.println("Voulez-vous enregistrez ce Membre ?");
                System.out.println();
	        System.out.print("Choisissez 1 pour oui et 0 pour nom :");
	        choix = Keyboard.getEntier();
	    	
	        if(choix == 1) {
	        	listeMembre.addElement(newMembre);
                        System.out.println();
                        System.out.println("Le membre a bien ete ajouter");
	    	}
	    	else if(choix == 0) {
	    		
	    	}
    	}
    	else {
                System.out.println();
    		System.out.println("Le membre existe deja");
    	}
    }

    
    // METHODE DE RECHERCHE D'UN MEMBRE EN FONCTION DE SON ID
    
    public Membre rechercheMembre(int id) {
    	
    	Membre membreRechercher = null;
    	 for(int i = 0; i < listeMembre.size(); i++)
         {
         	membreRechercher = (Membre)listeMembre.elementAt(i);

             if(id == membreRechercher.getId())
             {
             	return membreRechercher;
             }  
             else {
             	
             }
         }        
    	 
    	return membreRechercher = null;
    }
    
    
    // METHODE DE MODIFICATION D'UN MEMBRE
    
    public void modiferMembre() {
        
    	int choix, nouveauId, choix2;
    	String nouveauNom;
    	Membre personneAmodifier;
        System.out.println();
    	
        if(!listeMembre.isEmpty()){
            
            afficherListeMembre();
            System.out.println();
            System.out.print("Entrez l'ID du membre a modifier : ");
            choix = Keyboard.getEntier();
            personneAmodifier = rechercheMembre(choix);
   
            if(personneAmodifier != null) {

                    System.out.print("Pour le modifier entrer le nouveau ID : ");
                    nouveauId = Keyboard.getEntier();
                   
                    System.out.print("Entrez le nouveau Nom : ");
                    nouveauNom = Keyboard.getString();

                   // do{
                        System.out.println();
                        System.out.println("Voulez-vous vraiment effectuer la modification ?");
                        System.out.print("Choisissez 1 pour confirmer la modification ou 0 pour annuler : ");
                        choix2 = Keyboard.getEntier();
                        if(choix2 == 1){
                            personneAmodifier.setId(nouveauId);
                            personneAmodifier.setNom(nouveauNom);
                            System.out.println();
                            System.out.println("Le Membre a ete bien modifier !");
                        }
                        else if(choix2 == 0) {
                            System.out.println();
                            System.out.println("La Modification a ete annuler !");
                    }
                    //}while(choix2 != 1 || choix2 != 0);
            }
            else {
                    System.out.print("Le membre que vous voulez modifier n'existe pas");
            }
        }
        else{
            System.out.println("Impossible d'effectuer une modification"
                    + " car aucun membre n'a ete creer !");
        }
    }
    
    
    //METHODE DE SUPPRESSION D'UN MEMBRE
    
    public void supprimerMembre(){
    	int id, choix;
    	Membre membreAsupprimer;
        System.out.println();
        
        if(!listeMembre.isEmpty()){
            
            afficherListeMembre();
            System.out.println();
            System.out.print("Veuillez Entrez l'ID du membre a supprimer : ");
            id = Keyboard.getEntier();
            membreAsupprimer = rechercheMembre(id);

            if(membreAsupprimer != null){
                
                System.out.println();
                System.out.println("Voulez-vous vraiment supprimer le membre [" + 
                        membreAsupprimer.getNom() +"] ?");
                System.out.print("Entrez 1 pour confimer la suppression ou 0 pour annuler : ");
                choix = Keyboard.getEntier();
                
                if(choix == 1 ){
                    listeMembre.removeElement(membreAsupprimer);
                    System.out.println();
                    System.out.println("Le membre a bien ete supprimer");
                }
                else if (choix == 0){
                    System.out.println();
                    System.out.println("La suppression a ete annuler");
                }
            }
            else{
                System.out.println();
                System.out.println("Le membre n'exite pas");
            }
        }
        else{
            System.out.println("Impossible d'effectuer la suppression"
                    + " car aucun membre n'a ete creer !");
        }
    }
    
    //METHODE D'AFFICHAGE DE LA LISTE DES MEMBRES
    
    public void afficherListeMembre()
    {
        Membre membreAafficher;
        
        if(listeMembre.size() == 0)
            System.out.println("La liste est vide !");
        else
        {
	        System.out.println();
	        System.out.println("Id Membre" + "\t Nom Membre");   
	        for(int i = 0; i < listeMembre.size(); i++)
	        {
	        	membreAafficher=(Membre)listeMembre.elementAt(i);
	        	membreAafficher.afficherMembre();
	        }
        }     
    }
    
    // METHODE DE GESTION DU MENU DU MEMBRE
    
    public int menuMembre(){
        int choixMembre;
        System.out.println("------------------------------");
        System.out.println("| OPERATIONS SUR LES MEMBRES |");
        System.out.println("------------------------------");
        System.out.println("1. Creer et Ajouter un membre");
        System.out.println("2. Modifier un Membre");
        System.out.println("3. Supprimer un membre");
        System.out.println("4. Afficher la liste des membres");
        System.out.println("5. Retours au menu principal");
        System.out.println("--------------");
        System.out.print("Entrez votre choix : ");
        choixMembre = Keyboard.getEntier();
        
        return choixMembre;
    }
    
    public void operationMembre() throws IOException{
        
        int choix;
        do{
            System.out.println();
            choix = menuMembre();
      
            switch(choix)
            {
                case 1 : creerEtAjouterMembre();
                break;
                case 2 : modiferMembre();
                break;
                case 3 : supprimerMembre();
                break;
                case 4 : afficherListeMembre();
                break;
                case 5 :    continue;//System.exit(0);
               
            }
            
        }while(choix !=5 || choix < 0);
    }
    
    
    /***************************************** LES OPERATIONS SUR LA TACHE *****************************************/
    
    //METHODE DE GESTION DU MENU DE LA TACHE
    
    public int menuTache(){
        int choixTache;
      
        System.out.println("-------------------------");
        System.out.println("|OPERATION SUR LES TACHES| ");
        System.out.println("-------------------------");
        System.out.println("1. Creer et Ajouter une tache");
        System.out.println("2. Modifier une tache");
        System.out.println("3. Supprimer une tache");
        System.out.println("4. Afficher la liste des taches");
        System.out.println("5. Retours au menu principal");
        System.out.println("--------------------------");
        System.out.print("Entrez votre choix : ");
        choixTache = Keyboard.getEntier();
        System.out.println();
        
        return choixTache;
    }
    
    public void operationTache(){
        int choix;
        do{
            System.out.println();
            choix = menuTache();
      
            switch(choix)
            {
                case 1 : creerEtAjouterTache();
                break;
                case 2 : modiferTache();
                break;
                case 3 : supprimerTache();
                break;
                case 4 : afficherListeTache();
                break;
                case 5 :    continue;//System.exit(0);
               
            }
            
        }while(choix !=5);
    }
    
    // METHODE DE CREATION ET D'AJOUT D'UNE TACHE
    
    public void creerEtAjouterTache()
    {
    	int choix;
    	Tache newTache = new Tache();
    	Tache verifierExistanceTache, elementListe;
    	verifierExistanceTache = rechercherTacheParId(newTache.getId());
        boolean existance = false;
    	
    	if(verifierExistanceTache == null) {
            if(!listeTache.isEmpty()){
                for(int index = 0; index < listeTache.size(); index++){
                    elementListe = listeTache.elementAt(index);
                    if(elementListe.getNom().equals(newTache.getNom()) 
                            && elementListe.getDescription().equals(newTache.getDescription()) 
                            && elementListe.getStatus().equals(newTache.getStatus())){
                        existance = true;
                        break;
                    }
                }
                if(existance){
                    System.out.println();
                    System.out.println("La Tache existe deja, il n'est pas possible d'avoir"
                            + " deux taches de meme caracteristiques. ");
                }else{
                    System.out.println();
	    	System.out.println("Voulez-vous Ajouter cette Tache ?");
                System.out.println();
	        System.out.print("Choisissez 1 pour oui et 0 pour nom :");
	        choix = Keyboard.getEntier();
	    	
	        if(choix == 1) {
	        	listeTache.addElement(newTache);
                        System.out.println();
                          System.out.println("La tache a bien ete ajouter !");
	    	}
                    else if(choix == 0) {
                            System.out.println("Vous avez annuler l'enregistrement !");
                    }
                }
            }else{
                System.out.println();
	    	System.out.println("Voulez-vous Ajouter cette Tache ?");
                System.out.println();
	        System.out.print("Choisissez 1 pour oui et 0 pour nom :");
	        choix = Keyboard.getEntier();
	    	
	        if(choix == 1) {
	        	listeTache.addElement(newTache);
                        System.out.println();
                          System.out.println("La tache a bien ete ajouter !");
	    	}
	    	else if(choix == 0) {
	    		System.out.println("Vous avez annuler l'enregistrement !");
	    	}
            }
                
    	}
    	else {
                System.out.println();
    		System.out.println("La tache existe deja");
    	} 
    }
    
    
    // METHODE DE RECHERCHE D'UNE TACHE EN FONCTION DE SON ID
    
    public Tache rechercherTacheParId(int idTache)
    {
     Tache tacheRechercher = null;
   	 for(int i = 0; i < listeTache.size(); i++)
        {
        	tacheRechercher = (Tache)listeTache.elementAt(i);

            if(idTache == tacheRechercher.getId())
            {
            	return tacheRechercher;
            }  
            
        }        
   	 
   	return tacheRechercher = null;
    }
    
    
    // METHODE DE RECHERCHE D'UNE TACHE EN FONCTION DE SON STATUS
    
    public Tache rechercherTacheParStatus(String statusTache)
    {
     Tache tacheRechercher = null;
   	 for(int i = 0; i < listeTache.size(); i++)
        {
        	tacheRechercher = (Tache)listeTache.elementAt(i);

            if(statusTache.equals(tacheRechercher.getStatus()))
            {
            	return tacheRechercher;
            }  
            
        }        
   	 
   	return tacheRechercher = null;
    }
    
    
    // METHODE DE MODIFICATION D'UNE TACHE
    
    public void modiferTache() {
        
    	int choix, nouveauId, choix2;
    	String nouveauNom = ""; 
    	String nouvelleDescription, nouveauStatus;
    	Tache tacheAmodifier;
        
        if(!listeTache.isEmpty()){
            afficherListeTache();
            System.out.println();
            System.out.print("Entrez l'ID de la tache a modifier :");
            choix = Keyboard.getEntier();
            tacheAmodifier = rechercherTacheParId(choix);

            if(tacheAmodifier != null) {

                    System.out.print("Pour la modifier entrer le nouveau ID : ");
                    nouveauId = Keyboard.getEntier();

                    System.out.print("Entrez le nouveau Nom : ");
                    nouveauNom = Keyboard.getString();

                    System.out.print("Entrez la nouvelle Description : ");
                    nouvelleDescription = Keyboard.getString();

                    System.out.print("Entrez le nouveau Status : ");
                    nouveauStatus = Keyboard.getString();

                    System.out.println();
                    System.out.println("Voulez-vous vraiment effectuer la modification ?");
                    System.out.print("Choisissez 1 pour confirmer la modification ou 0 pour annuler : ");
                    choix2 = Keyboard.getEntier();
                        
                        if(choix2 == 1){
                            tacheAmodifier.setId(nouveauId);
                            tacheAmodifier.setNom(nouveauNom);
                            tacheAmodifier.setDescription(nouvelleDescription);
                            tacheAmodifier.setStatus(nouveauStatus);
                            System.out.println();
                            System.out.println("La Tache a ete bien modifier !");
                        }
                        else if(choix2 == 0) {
                            System.out.println();
                            System.out.println("La Modification a ete annuler !");
                    }

            }
            else {
                    System.out.println("La Tache que vous voulez modifier n'existe pas");
            }
        }
        else{
            System.out.println("Impossible de d'effectuer une modification"
                    + " car aucune tache n'a ete creer !");
        }
    }
    
    
    // METHODE DE SUPPRESSION D'UNE TACHE
    
    public void supprimerTache(){
    	int id, choix;
    	Tache tacheAsupprimer;
        System.out.println();
        
        if(!listeTache.isEmpty()){
            
            afficherListeTache();
            System.out.println();
            System.out.print("Veuillez Entrez l'ID de la tache a supprimer : ");
            id = Keyboard.getEntier();
            tacheAsupprimer = rechercherTacheParId(id);

            if(tacheAsupprimer != null){
                
                System.out.println();
                System.out.println("Voulez-vous vraiment supprimer la tache [" + 
                        tacheAsupprimer.getNom() +"] ?");
                System.out.print("Entrez 1 pour confimer la suppression ou 0 pour annuler : ");
                choix = Keyboard.getEntier();
                
                if(choix == 1 ){
                    listeTache.removeElement(tacheAsupprimer);
                    System.out.println();
                    System.out.println("La tache a bien ete supprimer");
                }
                else if (choix == 0){
                    System.out.println();
                    System.out.println("La suppression a ete annuler");
                }
            }
            else{
                System.out.println();
                System.out.println("La tache n'exite pas");
            }
        }
        else{
            System.out.println("Impossible de supprimer une tache car aucune tache n'a ete creer !");
        }	
    }
    
    // METHODE D'AFFICHAGE DE LA LISTE DE TOUTES LES TACHES
    
    public void afficherListeTache()
    {
        Tache tacheAafficher;
        
        if(listeTache.size() == 0)
            System.out.println("Liste vide !");
        
        else
        {
            System.out.println("Id Tache" + "\t Nom Tache" + "\t Description" + " \t Status");
	        for(int i = 0; i < listeTache.size(); i++)
	        {
	        	//System.out.println("Le nous avons "+listeTache.size()+" tache dans la liste");
	        	tacheAafficher=(Tache)listeTache.elementAt(i);
	        	tacheAafficher.afficherTache();
	        }
        }       
    }
  
    
    /***************************************** LES OPERATIONS SUR L'ASSIGNATIONS *****************************************/
    
    // METHODE D'ASSIGNATION D'UNE TACHE A UN MEMBRE
    
    public void assignationTache() {
    	
        
        if((!listeMembre.isEmpty()) && !listeTache.isEmpty()){
        
        System.out.println("Veuillez vous refferez aux deux listes "
                + "ci-dessous pour realiser votre assignation");
        System.out.println();
        
            System.out.println("Liste des membres : ");
            afficherListeMembre();
            System.out.println();
            System.out.println("-------------------------------------------------------");
            System.out.println("Liste des taches : ");
            afficherListeTache();
            System.out.println();
            Assignation tacheAssigner = new Assignation();
            Assignation element = null;
            Membre verifierExistanceMembre;
            Tache verifierExistanceTache;
            boolean existance = false;

            verifierExistanceMembre = rechercheMembre(tacheAssigner.getIdMembre());
            verifierExistanceTache = rechercherTacheParId(tacheAssigner.getIdTache());

            if(verifierExistanceMembre == null) {
                    System.out.println();
                    System.out.println("Le Membre n'existe pas, veuillez le creer afin de lui assigner une tache !");
            }

            else if(verifierExistanceTache == null) {
                    System.out.println();
                    System.out.println("La Tache n'existe pas, veuillez la creer afin de l'assigner");
            }

            else {

                    if(listeAssignation.isEmpty()){

                        listeAssignation.addElement(tacheAssigner);
                        System.out.println();
                        System.out.println("La Tache a bien ete assigner");

                    }
                    else{
                        for(int i = 0; i < listeAssignation.size(); i++){

                            element = listeAssignation.elementAt(i);
                            if((element.getIdMembre() == tacheAssigner.getIdMembre()) && 
                                    element.getIdTache() == tacheAssigner.getIdTache()){
                                existance = true;
                                break;
                            }

                        }

                        if(existance == true){
                            System.out.println("Cette tache est deja assigne a ce membre");
                        }
                        else{
                            listeAssignation.addElement(tacheAssigner);
                            System.out.println();
                            System.out.println("La Tache a bien ete assigner");
                        }
                    }

            }
        }else if(!listeMembre.isEmpty()){
            System.out.println("Vous ne pouvez pas effectuer cette operation car "
                    + "la liste des taches est vides. ");
        }
        else{
            System.out.println("Vous ne pouvez pas effectuer cette operation car "
                    + "la liste des membres est vides. ");
        }
    }
    
    //METHODE D'AFFICHAGE DE LA LISTE DES TACHES ASSIGNEES
    
    public void afficherListeAssignation()
    {
    	Assignation assignationAafficher;
        
        if(listeAssignation.size() == 0)
            System.out.println("Liste vide !");
        
        else
        {
            System.out.println("La liste contient "+listeAssignation.size()+" assignation");
            System.out.println();
            System.out.println("Id Membre"+"\t Id Tache");
	        for(int i = 0; i < listeAssignation.size(); i++)
	        {
	        	assignationAafficher=(Assignation)listeAssignation.elementAt(i);
	        	assignationAafficher.afficherAssignation();
	        }
        }       
    }
    
    // METHODE D'AFFICHAGE DE LA TACHE ASSIGNEE A UN MEMBRE EN FONCTION DE SON ID
    
    public void affichageTacheAssignerEnFonctionID() {
    	
    	Membre existanceMembre;
    	int idTache, idMembre;
    	Assignation assignation;
    	Tache tacheAafficher;
    	
    	System.out.print("Veuillez entrez l'ID du membre : ");
    	idMembre = Keyboard.getEntier();
        System.out.println();
    	
    	existanceMembre = rechercheMembre(idMembre);
    	
    	if(existanceMembre != null) {
            System.out.println("la tache assigner a " + existanceMembre.getNom() 
                                                     + " est :");
            System.out.println("-------------------------------------------------");
    		for(int i = 0; i < listeAssignation.size(); i++) {
    			assignation = (Assignation) listeAssignation.elementAt(i);
    				
    			if(assignation.getIdMembre() == idMembre) {
    					idTache = assignation.getIdTache();
    					tacheAafficher = rechercherTacheParId(idTache);
    					
    						if(tacheAafficher != null) {
                                                    tacheAafficher.afficherTache();
    						}
    		
    				}
    		
    		}
    	}
        else{
            System.out.println("Le membre n'existe pas");
        }
    }
    
    // METHODE D'AFFICHAGE D'UNE TACHE EN FONCTION DE STATUS ET DU MEMBRE AUQUEL ELLE EST ASSIGNEE
    
    public void AffichageTacheEnFonctionDuStatus(){
        
        int idTache, idMembre;
        String status;
        Membre existanceMembre, membre;
        Tache existanceTache, tacheAafficher;
        Assignation tacheAssigner;
        
        System.out.print("Veuillez entrez le status de la tache a Affiche : ");
        status = Keyboard.getString();
        existanceTache = rechercherTacheParStatus(status);
        
        if(existanceTache != null){
            
            System.out.println();
            System.out.println("Les taches ayant comme status [" + status + "] sont : " );
            System.out.println("-------------------------------------------------");
            
            for(int i = 0; i < listeTache.size(); i++){
                tacheAafficher = (Tache) listeTache.elementAt(i);
                
                if(tacheAafficher.getStatus().equals(status)){
                    idTache = tacheAafficher.getId();
                    
                    for(int j = 0; j < listeAssignation.size(); j++){
                        tacheAssigner = (Assignation) listeAssignation.elementAt(j);
                        
                        if(tacheAssigner.getIdTache() == idTache){
                            idMembre = tacheAssigner.getIdMembre();
                            existanceMembre = rechercheMembre(idMembre);
                            
                            if(existanceMembre != null){
                                for(int k = 0; k < listeMembre.size(); k++){
                                    membre = (Membre) listeMembre.elementAt(k);
                                    
                                    if(idMembre == membre.getId()){
                                        System.out.println();
                                        System.out.println("Nom Membre : " + "\t" + membre.getNom()); 
                                        System.out.print("Tache Assigner : " );
                                        tacheAafficher.afficherTache();
                                        System.out.println("-------------------------------------------------");
                                    }
                                }
                            }
                            else{
                                System.out.println("Le membre auquel la tache "+ tacheAssigner.getIdTache()
                                        +" a ete assigne a ete supprime");
                               
                            }
                        }
                        
                    }
                }
            }
            
        }
        else{
            System.out.println("La tache n'existe pas ");
        }
        
    }
    
}
