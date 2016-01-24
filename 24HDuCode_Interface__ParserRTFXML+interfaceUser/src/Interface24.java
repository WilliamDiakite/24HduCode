import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Interface24 extends JFrame {

	public JPanel contentPane;
	public JTextField numberActeField;
	public JRadioButton rdbtnScene;
	public JRadioButton rdbtnActe;
	public JLabel labelTypePartie;
	public ButtonGroup groupe;
	private JLabel lblPersonnages;
	private JTextField textField;
	JTextPane txtpnExempleNicolas;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface24 frame = new Interface24();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Interface24() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		rdbtnActe = new JRadioButton("Acte");
		rdbtnActe.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnActe.setBounds(50, 20, 127, 25);
		contentPane.add(rdbtnActe);

		rdbtnScene = new JRadioButton("Scene");
		rdbtnScene.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnScene.setBounds(50, 54, 127, 25);
		contentPane.add(rdbtnScene);
		
		groupe = new ButtonGroup();
		groupe.add(rdbtnScene);
		groupe.add(rdbtnActe);

		labelTypePartie = new JLabel("");
		labelTypePartie.setBounds(320, 34, 142, 22);
		contentPane.add(labelTypePartie);

		numberActeField = new JTextField();
		numberActeField.setBounds(491, 34, 116, 22);
		contentPane.add(numberActeField);
		numberActeField.setColumns(10);
		
		lblPersonnages = new JLabel("Personnages (Synthaxe : Nom, Age, Profession, Sexe; Caract\u00E8re1, Caract\u00E8re2; signeDistinctif1.) ");
		lblPersonnages.setBounds(12, 117, 595, 16);
		contentPane.add(lblPersonnages);
		
		txtpnExempleNicolas = new JTextPane();
		txtpnExempleNicolas.setBounds(22, 146, 585, 272);
		contentPane.add(txtpnExempleNicolas);
		
		JLabel lblLieu = new JLabel("Lieu");
		lblLieu.setBounds(12, 431, 56, 16);
		contentPane.add(lblLieu);
		
		textField = new JTextField();
		textField.setBounds(12, 460, 165, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnValidation = new JButton("Validation");
		btnValidation.addActionListener(new getCarac());
		btnValidation.setBounds(510, 459, 97, 25);
		contentPane.add(btnValidation);

		rdbtnActe.addActionListener(new Affiche());
		rdbtnScene.addActionListener(new Affiche());
	}

	public class Affiche implements ActionListener {

		public Affiche() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(rdbtnActe.isSelected())
				labelTypePartie.setText("Numero de l'Acte :");
			else
				labelTypePartie.setText("Numero de la Scène :");
			
		}
	}
	
	public class getCarac implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] persos=((JTextComponent) txtpnExempleNicolas).getText().split(";");
			int j=0;
			while(j<persos.length)
			{
				String[] base= persos[j].split(";");
				Personnage perso = new Personnage();
				perso.setBase(base[1]);
				perso.setCaract(base[2]);
				perso.setDistinct(base[3]);
			}
			
		}
		
	}
}
