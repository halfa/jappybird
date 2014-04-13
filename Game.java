import java.util.Vector;

/**
 * Classe de gestion du jeu
 * 
 * @author Maximilien
 * @author Julien
 */
public class Game {
	
	public static final String gameName = "Jappy Bird";
	public static Window fenetre;
	
	static Bird bird;
	public static Vector<Tube> tubes;
	
	public Game() {
		//Initialisation de l'IHM et chargement des sprites
		fenetre = new Window(this);

		bird = new Bird();
	}
	
	/**
	 * Boucle de jeu principale
	 */
	public int start(){
		//Initialisation
		int score = 0;
		//tant que l'oiseau n'est pas en collision
		while(collision()){
			//on avance les tubes
			try {Thread.sleep(50);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
		
		return score;
	}
	
	//retourne l'état actuel de collision
	public boolean collision(){
		for(Tube t:tubes)
			if(t.collision(getBird()))
				return true;
		return false;
	}

	public static void main(String[] args) {
		Game J = new Game();
		J.start();
	}
	
	//getSet
	public Bird getBird() {  return bird; }

}
