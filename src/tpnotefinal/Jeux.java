package tpnotefinal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Classe réunissant tout les jeux
 * @author mamrouc
 *
 */
public class Jeux {
	public static ArrayList<Jeu> listejeu = new ArrayList<Jeu>();
	public static ArrayList<String> listemachine = new ArrayList<String>();
	public static ArrayList<String> listegenre = new ArrayList<String>();

	/**
	 * Importation des jeux depuis le fichier csv puis stockage dans des arrays.
	 */
	public static void importjeu(){
		String line = "";  
		String splitBy = ",";  
		try {  
			BufferedReader br = new BufferedReader(new FileReader("vgsales.csv"));  
			while ((line = br.readLine()) != null) { 
				String[] gameLine = line.split(splitBy);  
				if(!gameLine[0].equals("Rank")) {
					if(!gameLine[1].contains("\"")) {
						if(!gameLine[3].equals("N/A")) {
							Jeu j = new Jeu(gameLine[0],gameLine[1],gameLine[2],gameLine[3],gameLine[4], gameLine[5]);
							listejeu.add(j);
							if(!listemachine.contains(gameLine[2])) {
								listemachine.add(gameLine[2]);
							}
							if(!listegenre.contains(gameLine[4])) {
								listegenre.add(gameLine[4]);
							}
							
						}
					}
				}
			}
			br.close();
		}catch (IOException e)   {  
			e.printStackTrace();  
		}  
	}
}
