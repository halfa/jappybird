/**
 * Abstract class for in-game objects
 * @author Maximilien
 *
 */
public abstract class InGameObj {
	
	//(x,y) en haut à gauche de l'objet
	public int x;
	public int y;
	public int hauteur;
	public int largeur;

	public InGameObj(int h, int l) {
		hauteur = h;
		largeur = l;
	}
	
	public int getXgauche(){ return x; }
	public int getYhaut(){ return y; }
	public int getXdroit(){ return x+largeur; }
	public int getYbas(){ return y+hauteur; }
	
	//Fonction qui test si il y a collision entre deux objets
	public boolean collisionAvec(InGameObj igo){
		//TODO: collision system
		return false;
	}

}
