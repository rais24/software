import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class ParserForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParserForm window = new ParserForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ParserForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 430, 70);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/rishirais/Downloads/dd-logo-50X50.png"));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/rishirais/Downloads/7con-logo-50X50.png"));
		panel.add(lblNewLabel_1);
		
		Label label = new Label("XML Input Path");
		label.setBounds(22, 112, 66, 17);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Image Input Path");
		label_1.setBounds(22, 144, 66, 17);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("XML Output Path");
		label_2.setBounds(22, 181, 66, 17);
		frame.getContentPane().add(label_2);
		
		final TextField textField = new TextField();
		textField.setBounds(165, 107, 147, 22);
		frame.getContentPane().add(textField);
		
		final TextField textField_1 = new TextField();
		textField_1.setBounds(165, 144, 147, 22);
		frame.getContentPane().add(textField_1);
		
		final TextField textField_2 = new TextField();
		textField_2.setBounds(165, 181, 147, 22);
		frame.getContentPane().add(textField_2);
		
		Button button = new Button("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			
				System.out.println("Going here");
			//Code to browse for file
				
	            JFileChooser fileChooser = new JFileChooser();
	            
	            // For Directory
	            //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	     
	            // For File
	            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	     
	            fileChooser.setAcceptAllFileFilterUsed(false);
	     
	            int rVal = fileChooser.showOpenDialog(null);
	            if (rVal == JFileChooser.APPROVE_OPTION) {textField.setText(fileChooser.getSelectedFile().toString());}
			}
		}
			
		);
		button.setBounds(318, 101, 102, 28);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Browse");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				 JFileChooser fileChooser = new JFileChooser();
		            
		            // For Directory
		            //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		     
		            // For File
		            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		     
		            fileChooser.setAcceptAllFileFilterUsed(false);
		     
		            int rVal = fileChooser.showOpenDialog(null);
		            if (rVal == JFileChooser.APPROVE_OPTION) {textField_1.setText(fileChooser.getSelectedFile().toString());}
			}
		});
		button_1.setBounds(318, 141, 102, 28);
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("Browse");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 JFileChooser fileChooser = new JFileChooser();
		            
		            // For Directory
		            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		     
		            // For File
		           // fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		     
		            fileChooser.setAcceptAllFileFilterUsed(false);
		     
		            int rVal = fileChooser.showOpenDialog(null);
		            if (rVal == JFileChooser.APPROVE_OPTION) {textField_2.setText(fileChooser.getSelectedFile().toString());}
			}
		});
		button_2.setBounds(318, 175, 102, 28);
		frame.getContentPane().add(button_2);
		
		Button button_3 = new Button("Submit");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			
			StaxXMLStreamReader load= new StaxXMLStreamReader();
			//load.runEngine(textField.getText(), textField_1.getText(), textField_2.getText());
				//Here we add the Code to call the Parsing
			}
		});
		button_3.setBounds(168, 228, 102, 28);
		frame.getContentPane().add(button_3);
	}
}
