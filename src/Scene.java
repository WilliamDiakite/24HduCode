import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Scene extends JPanel {
	
	
	private static final long serialVersionUID = 1L;

	final private int x = 0;
	final private int y = 0;
	
	Musique son;
	
	int number;
	HashMap<Personnage, Replique> intervenants;
	
	String background_path = "C:\\Users\\William.DESKTOP-F17CGCG\\Pictures\\background";
	BufferedImage img;
	int background_nb = 0;
	
	public Scene(int background){
		background_nb = background;
		background_path += background_nb + ".png";
		Musique mu = new Musique();
		try{
			img = ImageIO.read(new FileInputStream(background_path));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR Scene no file found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR io scene");
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e){
		repaint();
	}
	
	public void paintComponent(Graphics g){
		
		g.drawImage(img, x, y, img.getWidth(), img.getHeight(), null);
		
//		for(int i = 0; i <  this.getComponentCount(); i++){
//			getComponent(i).repaint();
//		}
		
		
		
	}
	
	
}
