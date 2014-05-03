/**
 * Un tube est constitué d'une partie supérieur et inférieur
 * @param position est définie par le point en bas à gauche du tube supérieur
 * @param espacement entre les deux tubes
 * @author Maximilien
 */
public class Tube extends InGameObj{
	
	public int espacement; //la hauteur entre t_haut et t_bas
	public Tube() {
		super(100,26);
		//TODO: déplacer les initialisations et gérer le rand
	}
	
	/**
	 * Constucteur de tube.
	 * @param la position de l'__ouverture__ du tube
	 *        cad le point milieux-haut-gauche
	 */
	public Tube(int posX, int posY, int e) {
		//on passe les dimentions
		super(100,26);
		//les positions sont celles du tube haut
		x = posX;
		y = posY;
		espacement = e;
	}

	//pour le tube du bas, seul la position y change
	public int getYBas(){ return y+hauteur+espacement;}

	//Décale le tube
	public void avance(){
		x -= JappyBird.speed;
	}
	//regarde si le tube est sorti de l'écran à gauche
	public boolean offScreenLeft(){
		return x+largeur<0;
	}

}
