package tpnotefinal;

import java.time.LocalDate;

/**
 * Classe Standard
 * @author mamrouc
 *
 */
public class Standard extends JoueurAdulte{

	/**
	 * Constructeur de la classe Standard
	 * @param pseudo pseudo du joueur
	 * @param email email du joueur
	 * @param birth date de naissance du joueur
	 */
	public Standard(String pseudo, String email, LocalDate birth){
		this.setPseudo(pseudo);
		this.setemail(email);
		this.setbirth(birth);
		this.setNbmaxjeu(50);
		this.setNbamis(100);
		this.setPartiemax(5);
		this.setBuytoother(true);
		this.setInvite(true);
	}
	



	

}
