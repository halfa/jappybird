/**
 * Abstract class for in-game objects
 * Collide Engine *todo*
 * @author Maximilien
 */
public abstract class InGameObj {

	//(x,y) in the left top corner
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

	public boolean collideWith(InGameObj igo){
		//if(this.x)
		return false;
	}

	//vérifie si un nombre appartient à l'interval [a;b]
	public boolean isIn(int n, int a, int b){
		if(n>a && n<b)
			return true;
		else return false;
	}
	public boolean isOffScreenLeft(){ return x+largeur<0; }
}
