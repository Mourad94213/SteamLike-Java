package tpnotefinal;

/**
 * Classe Bot
 * @author mamrouc
 *
 */
public class Bot extends Joueur{
	public Bot(){
		this.setNbmaxjeu(Integer.MAX_VALUE);
		this.setNbamis(Integer.MAX_VALUE);
		this.setPartiemax(Integer.MAX_VALUE);
		this.setBuytoother(false);
		this.setInvite(false);
	}
}
