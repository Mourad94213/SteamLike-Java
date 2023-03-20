package tpnotefinal;
import java.time.LocalDate;
import java.util.*;

/**
 * Classe JoueurAdulte représentant les joueurs adultes gold ou standard
 * @author mamrouc
 *
 */
public abstract class JoueurAdulte extends JoueurHumain{
	private ArrayList<JoueurHumain> enfants = new ArrayList<JoueurHumain>();
	
	/**
	 * Déclare un enfant et s'ajoute mutuellement aux liste d'ami avec la possibilité d'ajouter un tuteur supplémentaire
	 */
	public void declarerenfant(){
		boolean emailok=true;
		boolean pseudook=true;
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Quel est le pseudo de votre enfant ?");
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
		System.out.println("Quel est l'email de votre enfant ?");
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
		System.out.println("Quel est la date de naissance de votre enfant ? format (AAAA-MM-DD)");
		String choixdate = scanner2.next();
		LocalDate datenaissance = LocalDate.parse(choixdate);
			Enfant j1 = new Enfant(choixnom, choixemail, datenaissance);
			JoueurHumain.listepseudo.add(j1);
			this.enfants.add(j1);
			j1.parents.add(this);
			this.listeami.add(j1);
			j1.listeami.add(this);
			System.out.println("Quelle console(s) possedez-vous ?");
			int choix;
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
				j1.machine.add(Jeux.listemachine.get(choix));
			}
			System.out.println("Le compte de votre enfant " + choixnom + " a été crée avec succès.");
			System.out.println("Voulez vous ajouter un autre tuteur ? (1.Oui ou 2.Non)");
			Scanner scanner3 = new Scanner(System.in);
			choix=scanner3.nextInt();
			if(choix==1){
				System.out.println("Quel est le pseudo du 2ème tuteur ?");
				String nomt2= scanner3.next();
				for(int i=0; i<JoueurHumain.listepseudo.size();i++){
					if(nomt2.equals(JoueurHumain.listepseudo.get(i).getPseudo())){
						j1.parents.add(JoueurHumain.listepseudo.get(i));
						j1.listeami.add(JoueurHumain.listepseudo.get(i));
						JoueurHumain.listepseudo.get(i).listeami.add(j1);
						System.out.println(JoueurHumain.listepseudo.get(i).getPseudo() + " a été ajouté comme tuteur.");
					}
				}
			}
		}
		
	/**
	 * Méthode permettant d'offrir un jeu à un joueur présent dans notre liste d'ami
	 */
	public void offrirjeu(){
		System.out.println("Quel genre de jeu souhaitez vous offrir ?");
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
		System.out.println("A qui voulez vous offrir ce jeu ?");
		String amioffert = qljeu.next();
		for(int i=0;i<this.listeami.size();i++) {
			if(amioffert.equals(this.listeami.get(i).getPseudo())) {
				JoueurHumain amiactuel = JoueurHumain.listepseudo.get(i);
				amiactuel.listejeu.add(Jeux.listejeu.get(jeusouhaité));
			}
		}
		System.out.println("Vous venez d'offrir " + Jeux.listejeu.get(jeusouhaité).Name + " à votre ami.");
	}
	
}
