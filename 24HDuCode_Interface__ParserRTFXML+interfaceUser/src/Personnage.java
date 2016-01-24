import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class Personnage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	String nom = "";
	int humeur = 0; // 0 : jeune | 1 : vieux
	String sexe = ""; // h : homme | f : femme
	int couleur = 0;
	int cheveux;
	ArrayList<String> caractere;
	ArrayList<String> signeDistinctif;
	
	
	Replique replique;
	
	private BufferedImage body;
	
	//String pathBody = "C:\\Users\\William.DESKTOP-F17CGCG\\Pictures\\";
	
	int body_x = 0;
	int body_y = 50;
	int position = 0;
	
	public Personnage(String nom)
	{
		this.nom = nom;
	}
	
	public Personnage(int position, String sexe, int humeur, int cheveux, int couleur) {
		
		this.sexe = sexe;
		this.humeur = humeur;
		this.position = position;
		this.couleur = couleur;
		this.cheveux = cheveux;
		
		//pathBody += sexe + couleur + cheveux + humeur + ".png";
		
		try {
			this.setLocation(0, 150);
			body = ImageIO.read(new FileInputStream("C:\\Users\\Alexis\\Pictures\\hommejoyeux.png"));
			System.out.println("ERROR ouverture stream image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLocation(0, 0);
		this.repaint();
		this.setPreferredSize(new Dimension (body.getWidth(),body.getHeight()));
		
	}	
	public void printPerso(){
		switch (position) {
			case 0:
				body_x = 200;
				body_y = 300;
				break;
				
			case 1 :
				// Affiche perso position 1
				break;
				
			case 2 : 
				// Affiche perso position 2
				break;
				
			case 3 : 
				// Affiche perso position 3
				break;
				
			case 4 :
				// Affiche perso position 4
				break;

		default:
			break;
		}
	}
	
	
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		 System.out.println("ccococ");
//		g.drawImage(body, body_x, body_y, body.getWidth()*5/6, body.getHeight()*5/6, null);	
//		System.out.println("prout");
//	}
	
	public void paint (Graphics g)
	{
		g.drawImage(body, body_x, body_y, body.getWidth()*5/6, body.getHeight()*5/6, null);
//		g.setColor(Color.black);
//		g.drawRect(100, 200, 100, 200);
		System.out.println("prout");
	}
	

	public void setBase(String base) {
		// TODO Auto-generated method stub
		String[] identite = base.split(",");
		this.nom=identite[0];
		//this.age=identite[1];
		//this.profession=identite[2];
		this.sexe=identite[3];
	}

	public void setCaract(String string) {
		// TODO Auto-generated method stub
		String[] temp = string.split(",");
		int i=0;
		while(i<temp.length){
			caractere.add(temp[i]);
		}
	}

	public void setDistinct(String string) {
		// TODO Auto-generated method stub
		String[] distinct = string.split(",");
		int i=0;
		while(i<distinct.length)
		{
			caractere.add(distinct[i]);
		}
	}
	
	public void setReplique(String rep) {
		replique.setReplique(rep);
	}
	
	
}
