/**
 * Un tube est constitu� d'une partie sup�rieur et inf�rieur
 * @param position est d�finie par le point en bas � gauche du tube sup�rieur
 * @param espacement entre les deux tubes
 * @author Maximilien
 */
public class Tube extends InGameObj{
	
	public int espacement; //la hauteur entre t_haut et t_bas
	public Tube() {
		//TODO: d�placer les initialisations et g�rer le rand
	}
	
	/**
	 * Constucteur de tube.
	 * @param la position de l'ouverture du tube
	 *        cad le point milieux-haut-gauche et l'�paisseur vers le bas
	 */
	public Tube(int posX, int posY, int e) {
		//on passe les dimentions
		super(100,26)
		x = posX;
		y = posY;
		espacement = e;
	}
	
	//D�cale le tube
	public void avance(){
		x -= vitesse;
	}
	//regarde si le tube est sorti de l'�cran � gauche
	public boolean offScreenLeft(){
		return x+l_tube<0;
	}

}
