package tpnotefinal;

/**
 * Classe Jeu représentant 1 seul jeu
 * @author mamrouc
 *
 */
public class Jeu {
	public String Rank;
	public String Name;
	public String Platform;
	public String Year;
	public String Genre;
	public String Publisher;
	/**
	 * 
	 * @param r Rang du jeu
	 * @param n Nom du jeu
	 * @param p Platerforme du jeu
	 * @param y Année de sortie du jeu
	 * @param G Genre du jeu
	 * @param Pu Editeur du jeu
	 */
	public Jeu(String r, String n, String p, String y, String G, String Pu){
		this.Rank=r;
		this.Name=n;
		this.Platform=p;
		this.Year=y;
		this.Genre=G;
		this.Publisher=Pu;
	}
}
