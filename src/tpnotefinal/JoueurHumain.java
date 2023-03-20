package tpnotefinal;
import java.time.LocalDate;
import java.util.*;

/**
 * Classe JoueurHumain représentant tout les joueurs humain enfants, gold, standard
 * @author mamrouc
 *
 */
public abstract class JoueurHumain extends Joueur{
	private String pseudo, email;
	private LocalDate birth;
	ArrayList<Jeu> listejeu = new ArrayList<Jeu>();
	ArrayList<JoueurHumain> listeami = new ArrayList<JoueurHumain>();
	static ArrayList<JoueurHumain> listepseudo = new ArrayList<JoueurHumain>();
	ArrayList<String> machine = new ArrayList<String>();
	ArrayList<ArrayList<String>> historique = new ArrayList<ArrayList<String>>();
	
/**
 * getter du pseudo
 * @return pseudo le pseudo
 */
	public String getPseudo() {
		return pseudo;
	}
	
/**
 * setter du pseudo
 * @return pseudo le pseudo
 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}	
	
/**
 * getter du mail
 * @return email le mail
 */
	public String getemail() {
		return email;
	}

	/**
	 * setter du mail
	 * @return email le mail
	 */
	public void setemail(String email) {
		this.email = email;
	}
	
	/**
	 * getter de la date de naissance
	 * @return birth la date de naissance
	 */
	public LocalDate getbirth() {
		return birth;
	}

	/**
	 * setter de la date de naissance
	 * @return birth la date de naissance
	 */
	public void setbirth(LocalDate birth) {
		this.birth = birth;
	}
	
	/**
	 * affiche le profil et selon la classe de l'utilisateur affiche plus ou moins d'information
	 */
	public void afficherprofil() {
		if(this.getClass()==Gold.class || this.getClass()==Standard.class) {
			System.out.println("Pseudo : " + this.pseudo);
			System.out.println("Email : " + this.email);
			System.out.println("Date de naissance : " + this.birth);
			System.out.println("Vous possedez " + this.machine.size() + " machines : ");
			for(int i=0; i<this.machine.size(); i++) {
				if (i!=this.machine.size()-1) {
					System.out.println(machine.get(i) + ",");
				}
				else {
					System.out.println(machine.get(i) + ".");
				}
			}
		}
		else {
			System.out.println("Pseudo : " + this.pseudo);
		}
		System.out.println("Parties effectuées aujourd'hui : ");
		for(int i=0; i<this.historique.size(); i++) {
			System.out.println(i+1 + " | avec cette personne : " + this.historique.get(i).get(0) + " vous avez joué à " + this.historique.get(i).get(1));
		}
		
	}
	
	/**
	 * Ajoute en ami une personne ajoutable, c'est-à-dire non enfant, non présente dans la liste actuellement et existante
	 */
	public void ajouterami() {
		System.out.println("Quel(le) ami(e) souhaitez vous ajouter ? : ");
		boolean added=false;
		Scanner qlami = new Scanner(System.in);
		String ami = qlami.next();
		for(int i=0;i<JoueurHumain.listepseudo.size();i++) {
			if(ami.equals(JoueurHumain.listepseudo.get(i).getPseudo())) {
				JoueurHumain amiactuel = JoueurHumain.listepseudo.get(i);
				if (this.getClass()!=Enfant.class) {
					if(this.getClass()==Standard.class) {
						if(this.listeami.size()>=100) {
							System.out.println("Liste d'ami complète");
							added=true;
						}
					}
					else if(amiactuel.getClass()!=Enfant.class) {
						this.listeami.add(amiactuel);
						System.out.println("Vous venez d'ajouter " + amiactuel.pseudo + " en ami.");
						added=true;
					}
					else {
						System.out.println("Vous ne pouvez pas ajouter cet utilisateur en ami.");
						added=true;
					}
				}
				else {
					if(this.listeami.size()>=10) {
						System.out.println("Liste d'ami complète");
						added=true;
					}
					else if(amiactuel.getClass()==Enfant.class) {
						this.listeami.add(amiactuel);
						System.out.println("Vous venez d'ajouter " + amiactuel.pseudo + " en ami");
						added=true;
					}
					else {
						System.out.println("Vous ne pouvez pas ajouter cet utilisateur en ami.");
						added=true;
					}
				}
			}
		}
		if(!added) {
			System.out.println("Cet utilisateur n'existe pas.");
		}
	}

	/**
	 * supprime de la liste d'ami un joueur présent
	 */
	public void supprimerami() {
		System.out.println("Quel(le) ami(e) souhaitez vous supprimer ? : ");
		boolean deleted=false;
		Scanner qlami = new Scanner(System.in);
		String ami = qlami.next();
		for(int i=0;i<this.listeami.size();i++) {
			if(ami.equals(this.listeami.get(i).getPseudo())) {
				JoueurHumain amiactuel = this.listeami.get(i);
				this.listeami.remove(amiactuel);
				System.out.println("Vous venez de supprimer " + amiactuel.pseudo + " de vos amis");
				deleted=true;
			}
		}
		if(!deleted) {
			System.out.println("Cet utilisateur n'existe pas ou ne fait pas partie de vos ami");
		}
	}

	/**
	 * parcourt la liste des jeux du joueur et affiches plusieurs informations tel que le rang, le nom, la plateforme, l'année et le genre
	 */
	public void parcourirjeu() {
		System.out.println("Vous possedez " + this.listejeu.size() + " jeux : ");
		System.out.println("n°  	Rang  	  Nom  	  Plateforme 	  Année 	 Genre");
		for(int i=0; i<this.listejeu.size(); i++) {
			System.out.println(i + "\t" + this.listejeu.get(i).Rank + "\t" + this.listejeu.get(i).Name+ "\t" + this.listejeu.get(i).Platform + "\t" + this.listejeu.get(i).Year
					+ "\t" + this.listejeu.get(i).Genre);
		}
	}

/**
 * Achete un jeu et l'ajoute à la collection en vérifiant que la limite de jeu n'est pas atteinte et que sa classe lui le permet
 */
	public void acheterjeu() {
		if(this.getNbmaxjeu()!=0){
			System.out.println("Quel genre de jeu souhaitez vous acheter ?");
			for(int i=0;i<Jeux.listegenre.size();i++) {
				System.out.println(i + " - " + Jeux.listegenre.get(i));
			}
			Scanner qljeu = new Scanner(System.in);
			int genresouhaité = qljeu.nextInt();
			System.out.println("Sur quel plateforme voulez vous ce genre de jeu ?");	
			for(int i=0;i<Jeux.listemachine.size();i++) {
				System.out.println(i + " - " + Jeux.listemachine.get(i));
			}
			int consolesouhaité = qljeu.nextInt();
			for(int i=0;i<Jeux.listejeu.size();i++) {
				if(Jeux.listejeu.get(i).Genre.equals(Jeux.listegenre.get(genresouhaité)) && Jeux.listejeu.get(i).Platform.equals(Jeux.listemachine.get(consolesouhaité)))
					
					System.out.println(i + " - " + Jeux.listejeu.get(i).Name);
			}
			int jeusouhaité = qljeu.nextInt();
			this.listejeu.add(Jeux.listejeu.get(jeusouhaité));
			this.setNbmaxjeu(getNbmaxjeu()-1);
			System.out.println("Vous venez d'ajouter " + Jeux.listejeu.get(jeusouhaité).Name + " à votre collection.");
			}
		else{
			System.out.println("Vous ne pouvez plus acheter de jeu.");
		}
	}

	public abstract void declarerenfant();
	public abstract void offrirjeu();

	/**
	 * Lance une partie si possible, avec un bot, seul ou un ami
	 */
	public void jouer() {
		if(this.getPartiemax()!=0){
			System.out.println("A quel jeu voulez-vous jouer ?");
			for(int i=0; i<this.listejeu.size(); i++){
				System.out.println(i + " " + this.listejeu.get(i).Name);
			}
			Scanner qljeu = new Scanner(System.in);
			int jeu = qljeu.nextInt();
			ArrayList<String> histo = new ArrayList<String>();
			System.out.println("Voulez vous jouer avec un bot(1), tout seul(2) ou bien avec un ami(3)");
			int choixavec = qljeu.nextInt();
			switch(choixavec){
			case 1 : 
				System.out.println("Vous lancez une partie avec un bot sur " + this.listejeu.get(jeu).Name);
				this.setPartiemax(getPartiemax()-1);
				System.out.println("Il vous reste " + this.getPartiemax() + " partie(s) aujourd'hui");
				histo.add("bot");
				histo.add(this.listejeu.get(jeu).Name);
				this.historique.add(histo);
				break;
			case 2 :
				System.out.println("Vous lancez une partie tout seul sur " + this.listejeu.get(jeu).Name);
				this.setPartiemax(getPartiemax()-1);
				System.out.println("Il vous reste " + this.getPartiemax() + " partie(s) aujourd'hui");
				histo.add("seul");
				histo.add(this.listejeu.get(jeu).Name);
				this.historique.add(histo);
				break;	
			case 3 :
				boolean ajoue=false;
				System.out.println("Avec quel(le) ami(e) voulez vous jouer ?");
				String ami = qljeu.next();
				for(int i=0; i<this.listeami.size(); i++){
					if(ami.equals(this.listeami.get(i).pseudo)){
						for(int y=0; y<this.listeami.get(i).listejeu.size(); y++){
							if(this.listeami.get(i).listejeu.get(y).Name.equals(this.listejeu.get(jeu))){
								System.out.println("Vous lancez une partie avec " + ami + " sur " + this.listejeu.get(jeu).Name);
								this.setPartiemax(getPartiemax()-1);
								System.out.println("Il vous reste " + this.getPartiemax() + " partie(s) aujourd'hui");
								histo.add(ami);
								histo.add(this.listejeu.get(jeu).Name);
								this.historique.add(histo);
								ajoue=true;
							}
						}
					}
				}
				if(!ajoue)
					System.out.println("Vous n'avez pas d'ami avec ce pseudo ou votre ami ne possède pas ce jeu.");
				break;
			}
		}
		else{
			System.out.println("Vous ne pouvez plus jouer aujourd'hui");
		}
	}




}
