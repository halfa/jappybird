/**
 * We use the mouse
 * @author Maximilien
 */

import java.awt.event.MouseAdapter;

public class Control extends MouseAdapter {

	public Control() {
	}

	//On mouse press
	public void mousePressed(){
		JappyBird.bird.bump();
		System.out.println("controlEvent");
	}

}
