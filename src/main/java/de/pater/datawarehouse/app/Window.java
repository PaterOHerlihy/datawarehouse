package de.pater.datawarehouse.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window {

	private JFrame frmDatensiloManager;
	private File input;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmDatensiloManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatensiloManager = new JFrame();
		frmDatensiloManager.setTitle("Datensilo Manager");
		frmDatensiloManager.setBounds(100, 100, 450, 486);
		frmDatensiloManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatensiloManager.getContentPane().setLayout(new BorderLayout(0, 0));
		JButton btnNewButton = new JButton("Datei eingeben");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogType(JFileChooser.OPEN_DIALOG);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "Json", "json");
					    chooser.setFileFilter(filter);
					    int returnVal = chooser.showOpenDialog(frmDatensiloManager.getParent());
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					       System.out.println("You chose to open this file: " +
					       chooser.getSelectedFile().getName());
					       input = chooser.getSelectedFile();
					       
					       BufferedImage myPicture;
					       
						try {
							
							myPicture = ImageIO.read(new File("jason-statham.png"));
							JLabel picLabel = new JLabel(new ImageIcon(myPicture));
							frmDatensiloManager.hide();
							frmDatensiloManager.getContentPane().add(picLabel, BorderLayout.CENTER);
							frmDatensiloManager.show();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					       
					       
					       
					    }
			}
		});
		frmDatensiloManager.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnSend = new JButton("Daten verarbeiten");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(input!=null) {
					Extractor ex = new Extractor();
			        try {
						ex.extractToDB(input);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		frmDatensiloManager.getContentPane().add(btnSend, BorderLayout.SOUTH);
	}

}
