import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.Image;
import java.awt.List;
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
import javax.swing.JTextArea;
import java.util.*;
import javax.swing.UIManager;
import java.awt.SystemColor;


public class TessForm {

	private JFrame frmconTextextractorV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TessForm window = new TessForm();
					window.frmconTextextractorV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TessForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmconTextextractorV = new JFrame();
		frmconTextextractorV.setTitle("7Con TextExtractor v(1.0.0.1)");
		frmconTextextractorV.setBounds(100, 100, 536, 461);
		frmconTextextractorV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmconTextextractorV.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 481, 49);
		//List<Images> image= new List<Images>();
	
		frmconTextextractorV.getContentPane().add(panel);
		panel.setLayout(null);
 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(219, 5, 0, 0);
		lblNewLabel.setIcon(new ImageIcon("/Users/rishirais/Downloads/dd-logo-50X50.png"));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(224, 5, 0, 0);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/rishirais/Downloads/7con-logo-50X50.png"));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\admin\\workspace\\software\\7ConSaxParser\\dd-logo-50X50.png"));
		lblNewLabel_2.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_2.setBounds(10, 5, 52, 44);
		panel.add(lblNewLabel_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon("C:\\Users\\admin\\workspace\\software\\7ConSaxParser\\7con-logo-50X50.png"));
		label_3.setBackground(SystemColor.menu);
		label_3.setBounds(419, 5, 52, 44);
		panel.add(label_3);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setIcon(new ImageIcon("C:\\Users\\admin\\workspace\\software\\7ConSaxParser\\TextExtractor.jpg"));
		label_5.setBackground(SystemColor.menu);
		label_5.setBounds(173, 5, 113, 44);
		panel.add(label_5);

		Label label = new Label("XML Input File");
		label.setBounds(22, 77, 92, 17);
		frmconTextextractorV.getContentPane().add(label);

		Label label_1 = new Label("Image Input File");
		label_1.setBounds(22, 111, 92, 17);
		frmconTextextractorV.getContentPane().add(label_1);

		Label label_2 = new Label("XML Output Path");
		label_2.setBounds(22, 147, 92, 17);
		frmconTextextractorV.getContentPane().add(label_2);

		final TextField textField = new TextField();
		textField.setBounds(120, 72, 255, 22);
		frmconTextextractorV.getContentPane().add(textField);

		final TextField textField_1 = new TextField();
		textField_1.setBounds(120, 106, 255, 22);
		frmconTextextractorV.getContentPane().add(textField_1);

		final TextField textField_2 = new TextField();
		textField_2.setBounds(120, 142, 255, 22);
		frmconTextextractorV.getContentPane().add(textField_2);

		Button button = new Button("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//Code to browse for file
				JFileChooser fileChooser = new JFileChooser();

				// For Directory
				//fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				// For File
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				fileChooser.setAcceptAllFileFilterUsed(true);

				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {textField.setText(fileChooser.getSelectedFile().toString());}
			}
		}

				);
		button.setBounds(398, 72, 77, 22);
		frmconTextextractorV.getContentPane().add(button);

		Button button_1 = new Button("Browse");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fileChooser = new JFileChooser();

				// For Directory
				//fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				// For File
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				fileChooser.setAcceptAllFileFilterUsed(true);

				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {textField_1.setText(fileChooser.getSelectedFile().toString());}
			}
		});
		button_1.setBounds(398, 106, 77, 22);
		frmconTextextractorV.getContentPane().add(button_1);

		Button button_2 = new Button("Browse");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				JFileChooser fileChooser = new JFileChooser();

				// For Directory
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				// For File
				// fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				fileChooser.setAcceptAllFileFilterUsed(true);

				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {textField_2.setText(fileChooser.getSelectedFile().toString());}
			}
		});
		button_2.setBounds(398, 142, 77, 22);
		frmconTextextractorV.getContentPane().add(button_2);

		Button button_3 = new Button("Submit");
		button_3.setBounds(192, 170, 102, 28);
		frmconTextextractorV.getContentPane().add(button_3);
		
    	final JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 209, 500, 203);
		
		frmconTextextractorV.getContentPane().add(textArea);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBackground(SystemColor.menu);
		label_4.setBounds(367, 227, 82, 14);
		frmconTextextractorV.getContentPane().add(label_4);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
					
				if(textField.getText().length()>0 && textField_1.getText().length()>0 && textField_2.getText().length()>0)
				{
					textArea.append("Running the Extractor");
				StaxXMLStreamReader load= new StaxXMLStreamReader();
				Boolean run=false;
				run=load.runEngine(textField.getText(), textField_1.getText(), textField_2.getText(),textArea);
				if(run)
				{
					System.out.println("System Message : Parsing and Extracion of the Document Completed");
					textArea.append("/n");
					textArea.append("System Message : Parsing and Extracion of the Document Completed");
				}
				}
				else
				{
					textArea.append("Please check inputs");
				}
		      }
		});
	
	}
}
