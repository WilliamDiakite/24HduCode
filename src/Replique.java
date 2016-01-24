import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Replique extends JPanel {
	

	private static final long serialVersionUID = 1L;
	
	int number;
	String discours = "";
	
	/**
	 * Positions des lignes dans la TextBox
	 */
	final private int TEXT_X = 35;
	final private int TEXT_Y1 = 145;
	final private int TEXT_Y2 = 190;
	
	
	public Replique(String rep){
		discours = rep;
		this.setPreferredSize(new Dimension (900,650));
	}
	

	public void setReplique(String rep) {
		discours = rep;
	}
	
	/**
	 * Méthodes qui fonctionne lorsque le texte qu'elle affiche (discours d'un personnage) s'étend sur deux lignes maximum
	 * Encore une fois, Swing c'est la galère...
	 */
	public void paint (Graphics g){
		//super.paintComponent(g);
		
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		
		ArrayList <String> lines = new ArrayList<String>();
		int i = 0;
		int y = 0;
		int length = 0;
		int max_line = 60;
		System.out.println("j'aime les bananes" + discours.length());
		String phrase = "";
		
		//Tant qu'on est pas arrivé au bout du discours,
//		while(length < discours. length()-1){
//			String line = "";
//			// on range dans une string une ligne complète du discours et on l'ajoute à la liste lines
//			while(line.length() < max_line-1 || line.length() <= discours.length()-1){
//				line += discours.split(" ")[x];
//				x++;
//				System.out.println("je passe");
//			} 
//			length += line.length();
//			lines.add(line);
//			line = "";
//		}
		
		String[] temp = discours.split(" ");
		
		while (length < this.discours.length()){
			int lengthLine = 0;
			
			while (lengthLine < max_line && i < temp.length){
				lengthLine += temp[i].length() + 1;
				i += 1;
			}
			
			phrase = "";
			
			for (int x = y; x<i; x++){
				phrase += temp[x] + " ";
			}
			y = i;
			
			System.out.println(phrase);
			lines.add(phrase);
			length += lengthLine;
		}
		
		//g.drawString(phrase, TEXT_X, TEXT_Y1);
		
//		//Tant qu'on a pas affiché toute les lignes du discours, on les affiche par deux 
		for(int z = 0; z < lines.size()-1; z++){
			g.drawString(lines.get(z), TEXT_X, TEXT_Y1);
			g.drawString(lines.get(z+1), TEXT_X, TEXT_Y2);
			i += 2;
			
			
			
//			try {
//				wait(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		//g.drawString("Jaime les couleurs", 35, 145);
		
		
		
	}
	
	
}
