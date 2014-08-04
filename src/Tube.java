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
		y = Window.getHeight()+((int)Math.random()*100-270);
		space = JappyBird.betweenTubes;
	}

	/**
	 * @param is the __left-top-corner__ of the opening */
	public Tube(int posX, int posY, int e) {
		super(100,26); //giving dim.
		//top tube pos.
		x = posX;
		y = posY;
		space = e;
	}

	//for the bottom tube drawing
	public int getYBas(){ return y+hauteur+space;}

	public void foward(){ x -= JappyBird.speed; }
	public boolean isOffScreenLeft(){ return x+largeur<0; }

}
