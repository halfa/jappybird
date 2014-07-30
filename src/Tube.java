/**
 * Un tube est constitué d'une partie supérieur et inférieur
 * @param position est définie par le point en bas à gauche du tube supérieur
 * @param space entre les deux tubes
 * @author Maximilien
 */
import java.lang.Math;

public class Tube extends InGameObj{

	public final int space; //between the tubes

	public Tube() {
		super(100,26); //dim d'un seul des deux tubes
		x = Window.getWidth()+1;
		y = Window.getHeight()+((int)Math.random()*100-250);
		space = JappyBird.betweenTubes;
	}

	/**
	 * Constucteur de tube.
	 * @param la position de l'__ouverture__ du tube
	 *        cad le point milieux-haut-gauche
	 */
	public Tube(int posX, int posY, int e) {
		super(100,26); //giving dim.
		//top tube pos.
		x = posX;
		y = posY;
		space = e;
	}

	//for the bottom tube
	public int getYBas(){ return y+hauteur+space;}

	//Décale le tube
	public void foward(){
		x -= JappyBird.speed;

	}
	//test si le tube est sorti de l'écran à gauche
	public boolean offScreenLeft(){
		return x+largeur<0;
	}

}