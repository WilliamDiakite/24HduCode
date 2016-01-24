import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Replique extends JPanel{
	

	private static final long serialVersionUID = 1L;
	
	int number;
	String discours = "";
	
	final private int TEXT_X = 0;
	final private int TEXT_Y1 = 0;
	final private int TEXT_Y2 = 0;
	final private int MAX_CHAR_LINE = 1;
	
	public Replique(String rep){
		discours = rep;
		this.setPreferredSize(new Dimension (900,650));
	}

	public void setReplique(String rep) {
		discours = rep;
	}
	
	public void paint (Graphics g){
		//super.paintComponent(g);
		
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		
		ArrayList <String> lines = new ArrayList<String>();
		int i = 0;
		int length = 0;
		int maxLength = 100;
		
		//Tant qu'on est pas arrivé au bout du discours,
		while(length < discours. length()){
			String line = "";
			// on range dans une string une ligne complète du discours et on l'ajoute à la liste lines
			for(int x = 0; x < discours.split(" ").length; x++){
				if(line.length() < maxLength){
					line += discours.split(" ")[x];
				}
				lines.add(line);
				line = "";
			}
			 
		}
		
		
		
		i = 0;
		//Tant qu'on a pas affiché toute les lignes du discours, on les affiche par deux 
		while(i < lines.size()){
			g.drawString(lines.get(i), TEXT_X, TEXT_Y1);
			g.drawString(lines.get(i+1), TEXT_X, TEXT_Y2);
			i += 2;
		}
		
		g.drawString("J'aime le JPanel et Swing", 100, 145);
		
	}
	
	
}
