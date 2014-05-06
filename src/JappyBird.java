import java.util.Vector;

/********************************
 * Classe de gestion du jeu
 * @author Maximilien
 * @author Julien
 ********************************/
public class JappyBird {
	
	public static final String gameName = "Jappy Bird";
	public static Window fenetre;
	//ingame objects
	public static final Bird bird = new Bird();
	public static Vector<Tube> tubes = new Vector<Tube>();
	//numbers
	public static int score = 0;
	//distance entre le tube du haut et celui du bas
	public static int betweenTubes = 15;
	public static int speed = 5;

	public JappyBird() {
		//initialisation des tuyaux
		//for(int i=0; i<500; i++)
		//	tubes.add(new Tube());
		tubes.add(new Tube());
		System.out.println("tubes passed");
		fenetre = new Window(this); //IHM
	}
	
	/***************************
	 * Boucle de jeu principale
	 */
	public int start(){
		//tant que l'oiseau n'est pas en collision
		while(!collision()){
			//on avance les tubes
			for(Tube t:tubes)
				t.avance();
			//on rafraichi l'écran

			//waiting
			try {Thread.sleep(50);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
		
		return score;
	}
	
	//retourne l'état actuel de collision aux niveau des éléments du jeu
	public boolean collision(){
		for(Tube t:tubes)
			if(t.collisionAvec(getBird()))
				return true;
		return false;
	}
	

	public static void main(String[] args) {
		JappyBird J = new JappyBird();
		J.start();
	}
	
	//getSet
	public Bird getBird() {  return bird; }

}
