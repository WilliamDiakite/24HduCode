import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.management.ListenerNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class interfaceUtilisateur extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	JComboBox comboBoxNom;
	JComboBox comboBoxVetement;
	JComboBox comboBoxCheveux;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	ButtonGroup groupeBouton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton;
	public static Scene sc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		sc = new Scene(1);
		Test test = new Test();
		test.getText(sc.textPiece, sc.listePerso);
	
		for (String t : sc.textPiece)
		{
			System.out.println(t);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceUtilisateur frame = new interfaceUtilisateur(sc.listePerso);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfaceUtilisateur(ArrayList<Personnage> listePerso) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Le petit théâtre des Datagrammes Baguette");
		
		

		
		panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		Scene sc = new Scene(1);
		comboBoxNom = new JComboBox();
		for (Personnage p : listePerso)
		{
			comboBoxNom.addItem(p.nom);
			
		}
		comboBoxNom.setBounds(156, 0, 195, 29);
		panel.add(comboBoxNom);
		
		JLabel lblNewLabel = new JLabel("Personnage");
		lblNewLabel.setBounds(12, 0, 86, 29);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Sexe");
		lblNewLabel_1.setBounds(12, 42, 86, 29);
		panel.add(lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("Homme");
		rdbtnNewRadioButton.setBounds(166, 44, 96, 25);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Femme");
		rdbtnNewRadioButton_1.setBounds(287, 44, 96, 25);
		panel.add(rdbtnNewRadioButton_1);
		
		groupeBouton = new ButtonGroup();
		groupeBouton.add(rdbtnNewRadioButton_1);
		groupeBouton.add(rdbtnNewRadioButton);
		
		lblNewLabel_2 = new JLabel("Couleur de v\u00E9tements");
		lblNewLabel_2.setBounds(12, 84, 130, 37);
		panel.add(lblNewLabel_2);
		
		comboBoxVetement = new JComboBox();
		comboBoxVetement.setBounds(156, 91, 195, 30);
		panel.add(comboBoxVetement);
		comboBoxVetement.addItem("Rouge");
		comboBoxVetement.addItem("Vert");
		comboBoxVetement.addItem("Bleu");
		
		JLabel lblNewLabel_3 = new JLabel("Couleur de cheveux");
		lblNewLabel_3.setBounds(12, 149, 130, 29);
		panel.add(lblNewLabel_3);
		
		comboBoxCheveux = new JComboBox();
		comboBoxCheveux.setBounds(156, 152, 195, 26);
		panel.add(comboBoxCheveux);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(22, 218, 97, 25);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new Evenement());
		
		comboBoxCheveux.addItem("Blond");
		comboBoxCheveux.addItem("Brun");
		comboBoxCheveux.addItem("Gris");
		
		
	}
	
	public class Evenement implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			 String nom = comboBoxNom.getSelectedItem().toString();
			 int i =0; 
			 int enr =0; 
			 for (Personnage p : sc.listePerso)
			 {
				 if (p.nom.equals(nom))
				 {
					 enr = i; 
				 }
				 i++;
			 }
			
			 String cheveux = comboBoxCheveux.getSelectedItem().toString();
			 switch (cheveux) {
			case "blond":
				sc.listePerso.get(enr).cheveux= 1;
				
				break;
			case "brun":
				sc.listePerso.get(enr).cheveux = 2;
				break;

			default:
				sc.listePerso.get(enr).cheveux = 3 ;
				break;
			}
			 String vetement = comboBoxVetement.getSelectedItem().toString();
			 switch (vetement) {
				case "rouge":
					sc.listePerso.get(enr).couleur= 1;
					
					break;
				case "vert":
					sc.listePerso.get(enr).couleur = 2;
					break;

				default:
					sc.listePerso.get(enr).couleur = 3 ;
					break;
				}
			 String sexe =""; 
			 if (rdbtnNewRadioButton.isSelected())
			 {
				 sexe = "Homme";
			 }
			 else 
			 {
				 if (rdbtnNewRadioButton_1.isSelected())
				 {
					 sexe ="Femme";
				 }						 
			 }
			 sc.listePerso.get(enr).sexe= sexe;
			 
			 
		}
	}
}
