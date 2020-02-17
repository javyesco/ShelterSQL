package edu.pupr.RefugioSQL;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class theRefugeDB extends JFrame {

	private JPanel mainPanel;
	private JLabel lblPhoto;
	//	JFrame f = new JFrame("sub Frame");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					theRefugeDB frame = new theRefugeDB();
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
	public theRefugeDB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Poly Refuge");
		setBounds(100, 100, 600, 500);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Add New Pet");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPet pet = new AddPet();
				pet.setVisible(true);
			}
		});
		mnFile.add(mntmOpen);

		JMenuItem mntmModify = new JMenuItem("Modify Pet");
		mntmModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePet upt = new UpdatePet();
				upt.setVisible(true);
			}
		});
		mnFile.add(mntmModify);

		JMenuItem mntmDisplay = new JMenuItem("Display Pet Info");
		mntmDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DisplayPetInfo dis = new DisplayPetInfo();
				dis.setVisible(true);
			}
		});
		
		JMenuItem mntmDeletePet = new JMenuItem("Delete Pet");
		mntmDeletePet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePet del = new DeletePet();
				del.setVisible(true);
			}
		});
		mnFile.add(mntmDeletePet);
		mnFile.add(mntmDisplay);

		JMenuItem mntmReport = new JMenuItem("Report");
		mntmReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Report re = new Report();
				re.setVisible(true);
			}
		});
		mnFile.add(mntmReport);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmNewMenuItem = new JMenuItem("Help Contents");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "FOR ANY DOUBT REGARDING THE CODE\nPLEASE CONTACT US AT XXX-XXX-XXXX");
			}
		});
		mnHelp.add(mntmNewMenuItem);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "THIS CODE WAS MADE BY: \nJAVIER ESCOBAR");
			}
		});
		mnHelp.add(mntmAbout);
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.ORANGE);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblUrbanTailsInc = new JLabel("Urban Tails Co.");
		lblUrbanTailsInc.setHorizontalAlignment(SwingConstants.CENTER);
		lblUrbanTailsInc.setFont(new Font("Javanese Text", Font.PLAIN, 26));
		lblUrbanTailsInc.setBounds(179, 311, 215, 61);
		mainPanel.add(lblUrbanTailsInc);
		
				lblPhoto = new JLabel("");
				lblPhoto.setBounds(67, -16, 418, 374);
				mainPanel.add(lblPhoto);

		ImageBackgroung();
	}

	public void ImageBackgroung() {
		ImageIcon icon = new ImageIcon("C:/Users/javye/eclipse-workspace/RefugioSQL/hiclipart.com-id_idpxg.png");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		lblPhoto.setIcon(scaledIcon);
	}
}
