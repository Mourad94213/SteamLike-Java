package tpnotefinal;

/**
 * Classe Joueur représentant un joueur humain ou non
 * @author mamrouc
 *
 */
public abstract class Joueur {
	private int nbmaxjeu;
	private int nbamis;
	private int partiemax;
	private boolean buytoother;
	private boolean invite;
	
	/**
	 * getter de nbmaxjeu
	 * @return nombre maximum de jeu actuellement
	 */
	public int getNbmaxjeu() {
		return nbmaxjeu;
	}
	
	/**
	 * setter de nbmaxjeu
	 * @param nbmaxjeu nombre maximum de jeu actuellement
	 */
	public void setNbmaxjeu(int nbmaxjeu) {
		this.nbmaxjeu = nbmaxjeu;
	}
	
	/**
	 * getter de nbamis
	 * @return nbamis nombre d'amis maximum actuellement
	 */
	public int getNbamis() {
		return nbamis;
	}
	
	/**
	 * setter de nbamis
	 * @return nbamis nombre d'amis maximum actuellement
	 */
	public void setNbamis(int nbamis) {
		this.nbamis = nbamis;
	}
	
	/**
	 * getter de partiemax
	 * @return partiemax nombre de partie maximum actuellement
	 */
	public int getPartiemax() {
		return partiemax;
	}
	
	/**
	 * setter de partiemax
	 * @return partiemax nombre de partie maximum actuellement
	 */
	public void setPartiemax(int partiemax) {
		this.partiemax = partiemax;
	}
	
	/**
	 * getter de buytoother
	 * @return buytoother possibilité d'acheter ou non aux autres joueurs
	 */
	public boolean isBuytoother() {
		return buytoother;
	}
	
	/**
	 * setter de buytoother
	 * @return buytoother possibilité d'acheter ou non aux autres joueurs
	 */
	public void setBuytoother(boolean buytoother) {
		this.buytoother = buytoother;
	}	
	
	/**
	 * getter de invite
	 * @return invite possibilité d'inviter ou non les autres joueurs
	 */
	public boolean isInvite() {
		return invite;
	}
	
	/**
	 * setter de invite
	 * @return invite possibilité d'inviter ou non les autres joueurs
	 */
	public void setInvite(boolean invite) {
		this.invite = invite;
	}
}
