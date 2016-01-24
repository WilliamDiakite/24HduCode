import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		Scene sc = new Scene(2);
		Personnage perso = new Personnage(0, "f", 1, 1, 3);
		Replique rep = new Replique("is coming soon. And if you live in San Francisco, the host city of big games");
		
		/**
		 * Les deux lignes suivantes ne servent à rien
		 * Les mystère de Swing...
		 * Elles étaient sensées permettre de choisir la position du personnage
		 */
		perso.setLayout(null);
		perso.setBounds(0, 500, 460, 200);
		//perso.setOpaque(false);
		
		
		JFrame jf = new JFrame();
		jf.setTitle("Theatre");
		jf.setSize(915, 720);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sc.add(perso);

		jf.getContentPane().add(sc);
		sc.add(perso);
		sc.add(rep);
		sc.setVisible(true);
		
	}

}
