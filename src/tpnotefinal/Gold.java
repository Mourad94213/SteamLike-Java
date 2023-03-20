package tpnotefinal;
import java.time.LocalDate;
/**
 * Classe Gold
 * @author mamrouc
 *
 */
public class Gold extends JoueurAdulte{
/**
 * Constructeur de la classe Gold
 * @param pseudo pseudo du joueur
 * @param email email du joueur
 * @param birth date de naissance du joueur
 */
	public Gold(String pseudo, String email, LocalDate birth){
		this.setPseudo(pseudo);
		this.setemail(email);
		this.setbirth(birth);
		this.setNbmaxjeu(Integer.MAX_VALUE);
		this.setNbamis(Integer.MAX_VALUE);
		this.setPartiemax(10);
		this.setBuytoother(true);
		this.setInvite(true);
	}
	


	
	

}
