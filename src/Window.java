import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/************************************
 * Window management & Graphic engine
 * @author Maximilien Richer
 ************************************/

public class Window {
	protected static JappyBird jeu;
	protected static JFrame frame;
	private static DrawPanel screen;
	private static BufferedImage background = null;
	private static BufferedImage bird = null;
	private static BufferedImage tubeDown = null;
	private static BufferedImage tubeUp = null;

	//Window size (inner, usable surface)
	private static final int height = 256;
	private static final int width = 144;

	public Window(JappyBird j) {
		jeu = j;
		frame = new JFrame(JappyBird.gameName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Sprites loading
		try{ load();
		} catch (IOException e) { System.out.println(e); }

		//Windows init.
		screen = new DrawPanel();
		frame.add(screen);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(width+15, height+38);
		//the following is causing issue
		//frame.setResizable(false);

		//Hand to the game engine !
	}

	//Chargement les spites
	private void load() throws IOException{
		background = ImageIO.read(new File("rsc/fond2.png"));
		bird = ImageIO.read(new File("rsc/bird.png"));
		tubeDown = ImageIO.read(new File("rsc/tubeDown.png"));
		tubeUp = ImageIO.read(new File("rsc/tubeUp.png"));
	}

	//refresh JPanel
	public void refresh(){
		screen.repaint();
	}

	//Get&Set
	public static int getWidth(){ return width; }
	public static int getHeight(){ return height; }

	//Draw panel for window
	public class DrawPanel extends JPanel implements MouseListener {
		static final long serialVersionUID = 1L; //compatibility

		public DrawPanel() {
			//Double buffering
			super(true);
			addMouseListener(this);
		}

		/*****************************
		 *   Graphic Render Engine   *
		 *****************************/
		public void paint(Graphics g){
			super.paint(g);
			Graphics2D g2d = (Graphics2D)g;
			//Create composite for overlay
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
			//Wallpaper
			g2d.drawImage(Window.background, 0, 0, this);
			//Draw tubes into screen
			for(Tube t:JappyBird.tubes){
				g2d.drawImage(tubeUp, t.x, t.y, this);
				g2d.drawImage(tubeDown, t.x, t.getYBas(), this);
			}
			//Draw bird
			g2d.drawImage(bird, jeu.getBird().getXgauche(), jeu.getBird().getYhaut(), this);
		}

		//Fork of ImageObserver because it's needed for DrawImage
		public class ImageObs implements ImageObserver {
			public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
					int arg4, int arg5) {
				return false;
			}
		}

		/**
		 * The class own listener for the mouse, mostly unused
		 */
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			JappyBird.bird.bump();
			System.out.println("Jump!");
		}
	}

}
