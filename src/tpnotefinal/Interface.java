package tpnotefinal;
import java.time.LocalDate;
import java.util.*;


/**
 * Classe interface représentant l'interface graphique de l'application
 * @author mamrouc
 * 
 */
public class Interface {
	
	/**
	 * Méthode permettant de créer un compte utilisateur Adulte
	 */
	public static void creercompte(){
			boolean emailok=true;
			boolean pseudook=true;
			int choixqlacc;
			Scanner scanner2 = new Scanner(System.in);
			do{
				System.out.println("Voulez vous créer un compte : " + "\n" + "1 - Standard " + "\n" + "2 - Gold ");
				choixqlacc = scanner2.nextInt();
			}
			while(choixqlacc!=1 && choixqlacc!=2);
			System.out.println("Quel est votre pseudo ?");
			String choixnom = scanner2.next();
			do{
				pseudook=true;
				for(int i=0; i<JoueurHumain.listepseudo.size(); i++){
					if(JoueurHumain.listepseudo.get(i).getPseudo().equals(choixnom)){
						System.out.println("Ce pseudo est déjà utilisé !");
						pseudook=false;
						choixnom = scanner2.next();
						break;
					}
				}
			}
			while(!pseudook);
			System.out.println("Quel est votre email ?");
			String choixemail = scanner2.next();
			do{
				emailok=true;
				for(int i=0; i<JoueurHumain.listepseudo.size(); i++){
					if(JoueurHumain.listepseudo.get(i).getemail().equals(choixemail)){
						System.out.println("Cet email est déjà utilisé !");
						emailok=false;
						choixemail = scanner2.next();
						break;
					}
				}
			}
			while(!emailok);
			System.out.println("Quel est votre date de naissance ? format (AAAA-MM-DD)");
			String choixdate = scanner2.next();
			LocalDate datenaissance = LocalDate.parse(choixdate);
			int choix;
			if(choixqlacc==1) {
				Standard j1 = new Standard(choixnom, choixemail, datenaissance);
				JoueurHumain.listepseudo.add(j1);
				System.out.println("Quelle console(s) possedez-vous ?");
				while(true) {
					for(int i=0;i<Jeux.listemachine.size();i++) {
						System.out.println(i + " - " + Jeux.listemachine.get(i));
					}
					System.out.println(Jeux.listemachine.size() + " - Confirmer");
					Scanner scanner3 = new Scanner(System.in);
					choix=scanner3.nextInt();
					if(choix==Jeux.listemachine.size()) {
						break;
					}
					if(j1.machine.contains(Jeux.listemachine.get(choix))==false) {
						j1.machine.add(Jeux.listemachine.get(choix));
					}
				}
			}
			if(choixqlacc==2) {
				Gold j2 = new Gold(choixnom, choixemail, datenaissance);
				JoueurHumain.listepseudo.add(j2);
				System.out.println("Quelle console(s) possedez-vous ?");
				while(true) {
					for(int i=0;i<Jeux.listemachine.size();i++) {
						System.out.println(i + " - " + Jeux.listemachine.get(i));
					}
					System.out.println(Jeux.listemachine.size() + " - Confirmer");
					Scanner scanner3 = new Scanner(System.in);
					choix=scanner3.nextInt();
					if(choix==Jeux.listemachine.size()) {
						break;
					}
					if(j2.machine.contains(Jeux.listemachine.get(choix))==false) {
						j2.machine.add(Jeux.listemachine.get(choix));
					}
				}
			}
			System.out.println("Votre compte sous le nom de " + choixnom + " a été crée avec succès");
		}
			
	/**
	 * Méthode principale du programme permettant la liaison de toutes les méthodes.
	 */
	public static void demarrage() {
		System.out.println("Bienvenue dans votre application de gestion de collection de jeu.");
		System.out.println("Que voulez faire : ");
		int choixconnex;
		boolean connecte = false;
		do{
			System.out.println("1 - Connexion 		2 - Creation de compte 		3 - Quitter");	
			Scanner scanner = new Scanner(System.in);
			choixconnex = scanner.nextInt();
		}
		while(choixconnex!=1 && choixconnex!=2 && choixconnex!=3);
		switch(choixconnex){
		case 1 :
			do{
				JoueurHumain joueurco = new Standard(null, null, null);
				System.out.println("Veuillez entrez votre pseudo : ");
				Scanner scanner1 = new Scanner(System.in);
				String nom = scanner1.next();
				if(JoueurHumain.listepseudo!=null) {
					for(int i=0;i<JoueurHumain.listepseudo.size();i++) {
						if(nom.equals(JoueurHumain.listepseudo.get(i).getPseudo())) {
							connecte = true;
							joueurco = JoueurHumain.listepseudo.get(i);
							Connexion(joueurco);
						}
					}
					if(!connecte){
						System.out.println("Cet utilisateur n'existe pas");
					}
				}
			}
			while(connecte==false);
			break;
		case 2 :
			creercompte();
			demarrage();
			break;
		case 3 :
			System.out.println("A bientôt !");
			System.exit(0);
			break;
		}
	}

	/**
	 * Méthode permettant la connexion du joueur et par la suite l'actionnement de toutes les fonctionnalités de l'application
	 * @param joueurco Joueur actuellement connecté
	 * 
	 */
	private static void Connexion(JoueurHumain joueurco) {
		if(joueurco instanceof JoueurAdulte){
			boolean leave=false;
			do{
				System.out.println("Vous êtes connecté sous le nom de " + joueurco.getPseudo());
				System.out.println("Que voulez faire : ");
				System.out.println("1 - Afficher votre profil	  2 - Ajouter un ami	  3 - Supprimer un ami	  4 - Parcourir vos jeux\n"
						+ "5 - Offrir un jeu	  6 - Acheter un jeu 	 7 - Déclarer un enfant"
						+ "		 8 - Jouer		 9 - Deconnexion" + "\n"
						+ " Appuyez sur un autre chiffre pour quitter.");
				Scanner scanner = new Scanner(System.in);
				int choixmenu = scanner.nextInt();
				switch(choixmenu){
					case 1 : 
						joueurco.afficherprofil();
						break;
					case 2 :
						joueurco.ajouterami();
						break;
					case 3 :
						joueurco.supprimerami();
						break;
					case 4 :
						joueurco.parcourirjeu();
						break;
					case 5 : 
						joueurco.offrirjeu();
						break;
					case 6 :
						joueurco.acheterjeu();
						break;
					case 7 :
						joueurco.declarerenfant();
						break;
					case 8 :
						joueurco.jouer();
						break;
					case 9 :
						demarrage();
						break;
					default :
						leave=true;
						break;
				}
			}
			while(!leave);
			System.out.println("A bientôt !");
		}
		else{
			boolean leave=false;
			do{
				System.out.println("Vous êtes connecté sous le nom de " + joueurco.getPseudo());
				System.out.println("Que voulez faire : ");
				System.out.println("1 - Afficher votre profil	  2 - Ajouter un ami	  3 - Supprimer un ami	  4 - Parcourir vos jeux\n"
						+ "		 5 - Jouer 		 6 - Deconnexion"
						+ "\n"
						+ " Appuyez sur un autre chiffre pour quitter.");
				Scanner scanner = new Scanner(System.in);
				int choixmenu = scanner.nextInt();
				switch(choixmenu){
					case 1 : 
						joueurco.afficherprofil();
						break;
					case 2 :
						joueurco.ajouterami();
						break;
					case 3 :
						joueurco.supprimerami();
						break;
					case 4 :
						joueurco.parcourirjeu();
						break;
					case 5 : 
						joueurco.jouer();
						break;
					case 6 :
						demarrage();
						break;
					default :
						leave=true;
						break;
				}
			}
			while(!leave);
			System.out.println("A bientôt !");
		}
	}

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args){
		Jeux.importjeu();
		demarrage();
	}
}
