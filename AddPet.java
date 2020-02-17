package edu.pupr.RefugioSQL;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AddPet extends JFrame {

	private JPanel contentPane;
	private JTextField txtPetName;
	private JTextField txtFileChoose;
	private JTextField txtPetType;
	private JTextField txtColor;
	private JTextField txtGender;
	private JTextField txtSterilized;
	private JTextField txtPedigree;
	private JTextField txtVaccine1;
	private JTextField txtVaccine2;
	private JTextField txtVaccine3;
	private JDateChooser datePicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPet frame = new AddPet();
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
	public AddPet() {
		setTitle("Add Pet");
		setBounds(100, 100, 890, 841);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtPetName = new JTextField();
		txtPetName.setBounds(200, 44, 206, 45);
		contentPane.add(txtPetName);
		txtPetName.setColumns(10);

		txtFileChoose = new JTextField();
		txtFileChoose.setEditable(false);
		txtFileChoose.setColumns(10);
		txtFileChoose.setBounds(200, 105, 206, 45);
		contentPane.add(txtFileChoose);

		txtPetType = new JTextField();
		txtPetType.setColumns(10);
		txtPetType.setBounds(200, 166, 206, 45);
		contentPane.add(txtPetType);

		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(200, 227, 206, 45);
		contentPane.add(txtColor);

		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(200, 288, 206, 45);
		contentPane.add(txtGender);

		txtSterilized = new JTextField();
		txtSterilized.setColumns(10);
		txtSterilized.setBounds(200, 349, 206, 45);
		contentPane.add(txtSterilized);

		txtPedigree = new JTextField();
		txtPedigree.setColumns(10);
		txtPedigree.setBounds(200, 410, 206, 45);
		contentPane.add(txtPedigree);
		/**
		txtDateEntry = new JTextField();
		txtDateEntry.setColumns(10);
		txtDateEntry.setBounds(15, 16, 206, 45);
		contentPane.add(txtDateEntry);
		 */
		txtVaccine1 = new JTextField();
		txtVaccine1.setColumns(10);
		txtVaccine1.setBounds(200, 532, 206, 45);
		contentPane.add(txtVaccine1);

		txtVaccine2 = new JTextField();
		txtVaccine2.setColumns(10);
		txtVaccine2.setBounds(200, 593, 206, 45);
		contentPane.add(txtVaccine2);

		txtVaccine3 = new JTextField();
		txtVaccine3.setColumns(10);
		txtVaccine3.setBounds(200, 654, 206, 45);
		contentPane.add(txtVaccine3);

		JLabel lblNewLabel = new JLabel("Pet's Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(29, 43, 145, 45);
		contentPane.add(lblNewLabel);

		JLabel lblPetsPhoto = new JLabel("Pet's Photo");
		lblPetsPhoto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPetsPhoto.setBounds(29, 105, 145, 45);
		contentPane.add(lblPetsPhoto);

		JLabel lblPetsType = new JLabel("Pet's Type");
		lblPetsType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPetsType.setBounds(29, 166, 145, 45);
		contentPane.add(lblPetsType);

		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblColor.setBounds(29, 227, 145, 45);
		contentPane.add(lblColor);

		JLabel lblIs = new JLabel("Gender");
		lblIs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIs.setBounds(29, 288, 145, 45);
		contentPane.add(lblIs);

		JLabel lblPedigree = new JLabel("Is Sterilized");
		lblPedigree.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPedigree.setBounds(29, 349, 145, 45);
		contentPane.add(lblPedigree);

		JLabel lblDateEntry = new JLabel("Pedigree");
		lblDateEntry.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateEntry.setBounds(29, 410, 145, 45);
		contentPane.add(lblDateEntry);

		JLabel lblDateEntry_1 = new JLabel("Date Entry");
		lblDateEntry_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateEntry_1.setBounds(29, 471, 145, 45);
		contentPane.add(lblDateEntry_1);

		JLabel lblVaccine = new JLabel("Vaccine #1");
		lblVaccine.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVaccine.setBounds(29, 532, 145, 45);
		contentPane.add(lblVaccine);

		JLabel lblVaccine_1 = new JLabel("Vaccine #2");
		lblVaccine_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVaccine_1.setBounds(29, 593, 145, 45);
		contentPane.add(lblVaccine_1);

		JLabel lblVaccine_2 = new JLabel("Vaccine #3");
		lblVaccine_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVaccine_2.setBounds(29, 654, 145, 45);
		contentPane.add(lblVaccine_2);

		JButton btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = txtPetName.getText();
				String photo = txtFileChoose.getText();
				String type = txtPetType.getText();
				String color = txtColor.getText();
				int gender = Integer.parseInt(txtGender.getText());
				int isSterilized = Integer.parseInt(txtSterilized.getText());
				String pedigree = txtPedigree.getText();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date = df.format(datePicker.getDate());
				String vaccine1 = txtVaccine1.getText();
				String vaccine2 = txtVaccine2.getText();
				String vaccine3 = txtVaccine3.getText();

				Connection conn = null;
				PreparedStatement pstmt = null;

				try {

					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/refugio","root","2797");
					pstmt = conn.prepareStatement("INSERT INTO PETS VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1, name);
					pstmt.setString(2, photo);
					pstmt.setString(3, type);
					pstmt.setString(4, color);
					pstmt.setInt(5, gender);
					pstmt.setInt(6, isSterilized);
					pstmt.setString(7, pedigree);
					pstmt.setString(8, date);
					pstmt.setString(9, vaccine1);
					pstmt.setString(10, vaccine2);
					pstmt.setString(11, vaccine3);
					int i = pstmt.executeUpdate();

					if(i>0) {
						JOptionPane.showMessageDialog(null, "Data was Added");
					}else {
						JOptionPane.showMessageDialog(null, "Data was not Added");
					}

				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnInsert.setBounds(475, 649, 356, 54);
		contentPane.add(btnInsert);

		datePicker = new JDateChooser();
		datePicker.setBounds(200, 476, 206, 40);
		contentPane.add(datePicker);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(475, 166, 356, 404);
		contentPane.add(panel);
		panel.setLayout(null);

		lblImageOutput = new JLabel("");
		lblImageOutput.setBounds(15, 16, 326, 372);
		panel.add(lblImageOutput);

		JButton btnChoosePathFolder = new JButton("Choose Path Folder");
		btnChoosePathFolder.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnChoosePathFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File("C:\\Users\\javye\\Pictures\\PHOTOSPET"));

				FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpg", "jpeg", "gif");
				file.addChoosableFileFilter(filter);

				int a = file.showSaveDialog(null);
				if(a==JFileChooser.APPROVE_OPTION) {
					File f = file.getSelectedFile();
					String p = f.getAbsolutePath();
					txtFileChoose.setText(file.getSelectedFile().getAbsolutePath());
					lblImageOutput.setIcon(seticon(p, null));
				}
			}
		});
		btnChoosePathFolder.setBounds(475, 100, 356, 54);
		contentPane.add(btnChoosePathFolder);

		JLabel lblNewLabel_1 = new JLabel("Insert Information To SQL DATABASE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(475, 610, 356, 29);
		contentPane.add(lblNewLabel_1);

		JLabel lblSelectThePets = new JLabel("Select the Pet's Photograph");
		lblSelectThePets.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectThePets.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectThePets.setBounds(475, 56, 356, 29);
		contentPane.add(lblSelectThePets);
		
		JButton btnClearText = new JButton("Clear Text");
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPetName.setText("   ");
				txtFileChoose.setText("   ");
				txtPetType.setText("   ");
				txtColor.setText("   ");
				txtGender.setText("   ");
				txtSterilized.setText("   ");
				txtPedigree.setText("   ");
				txtVaccine1.setText("   ");
				txtVaccine2.setText("   ");
				txtVaccine3.setText("   ");
			}
		});
		btnClearText.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClearText.setBounds(475, 719, 356, 50);
		contentPane.add(btnClearText);
	}

	byte[] image;
	String imagepath="";
	ImageIcon myImage;
	private JLabel lblImageOutput;


	public ImageIcon seticon(String m, byte[] image) {

		if(m!=null) {
			myImage = new ImageIcon(m);
		}else {
			myImage = new ImageIcon(image);
		}

		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(lblImageOutput.getWidth(), lblImageOutput.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		return i;
	}
}
