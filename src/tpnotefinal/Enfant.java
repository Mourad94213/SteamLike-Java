package tpnotefinal;

import java.time.LocalDate;
import java.util.*;
/**
 * Classe enfant
 * @author mamrouc
 *
 */
public class Enfant extends JoueurHumain {
	ArrayList<JoueurHumain> parents = new ArrayList<JoueurHumain>();
/**
 * Constructeur de la classe Enfant
 * @param choixnom pseudo de l'enfant
 * @param choixemail email de l'enfant
 * @param datenaissance date de naissance de l'enfant
 */
	public Enfant(String choixnom, String choixemail, LocalDate datenaissance) {
		this.setPseudo(choixnom);
		this.setemail(choixemail);
		this.setbirth(datenaissance);
		this.setNbmaxjeu(30);
		this.setNbamis(10);
		this.setPartiemax(10);
		this.setBuytoother(false);
		this.setInvite(false);
	}

	@Override
	public void declarerenfant() {
		
	}

	@Override
	public void offrirjeu() {
		
	}

}
