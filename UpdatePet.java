package edu.pupr.RefugioSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

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
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class UpdatePet extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFileChoose;
	private JTextField txtType;
	private JTextField txtColor;
	private JTextField txtGender;
	private JTextField txtSterilized;
	private JTextField txtPedigree;
	private JTextField txtVaccine1;
	private JTextField txtVaccine2;
	private JTextField txtVaccine3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePet frame = new UpdatePet();
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
	public UpdatePet() {
		setTitle("Update Pet");
		setBounds(100, 100, 890, 841);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPetName = new JLabel("Pet's Name");
		lblPetName.setBounds(38, 44, 145, 45);
		contentPane.add(lblPetName);

		JLabel lblPetPhoto = new JLabel("Pet's Photo");
		lblPetPhoto.setBounds(38, 105, 145, 45);
		contentPane.add(lblPetPhoto);

		JLabel lblPetType = new JLabel("Pet's Type");
		lblPetType.setBounds(38, 166, 145, 45);
		contentPane.add(lblPetType);

		JLabel lblPetColor = new JLabel("Color");
		lblPetColor.setBounds(38, 227, 145, 45);
		contentPane.add(lblPetColor);

		JLabel lblPetGender = new JLabel("Gender");
		lblPetGender.setBounds(38, 288, 145, 45);
		contentPane.add(lblPetGender);

		JLabel lblSterilized = new JLabel("isSterilized");
		lblSterilized.setBounds(38, 349, 145, 45);
		contentPane.add(lblSterilized);

		JLabel lblPedigree = new JLabel("Pedigree");
		lblPedigree.setBounds(38, 410, 145, 45);
		contentPane.add(lblPedigree);

		JLabel lblDateEntry = new JLabel("Date Entry");
		lblDateEntry.setBounds(38, 471, 145, 45);
		contentPane.add(lblDateEntry);

		JLabel lblVaccine1 = new JLabel("Vaccine #1");
		lblVaccine1.setBounds(38, 532, 145, 45);
		contentPane.add(lblVaccine1);

		JLabel lblVaccine2 = new JLabel("Vaccine #2");
		lblVaccine2.setBounds(38, 593, 145, 45);
		contentPane.add(lblVaccine2);

		JLabel lblVaccine3 = new JLabel("Vaccine #3");
		lblVaccine3.setBounds(38, 654, 145, 45);
		contentPane.add(lblVaccine3);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(200, 44, 206, 45);
		contentPane.add(txtName);

		txtFileChoose = new JTextField();
		txtFileChoose.setEditable(false);
		txtFileChoose.setColumns(10);
		txtFileChoose.setBounds(198, 105, 206, 45);
		contentPane.add(txtFileChoose);

		txtType = new JTextField();
		txtType.setColumns(10);
		txtType.setBounds(198, 166, 206, 45);
		contentPane.add(txtType);

		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(200, 227, 206, 45);
		contentPane.add(txtColor);

		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(198, 288, 206, 45);
		contentPane.add(txtGender);

		txtSterilized = new JTextField();
		txtSterilized.setColumns(10);
		txtSterilized.setBounds(200, 349, 206, 45);
		contentPane.add(txtSterilized);

		txtPedigree = new JTextField();
		txtPedigree.setColumns(10);
		txtPedigree.setBounds(200, 410, 206, 45);
		contentPane.add(txtPedigree);

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

		JDateChooser datePicker = new JDateChooser();
		datePicker.setBounds(200, 471, 206, 40);
		contentPane.add(datePicker);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String petname = txtName.getText();
				String petphoto = txtFileChoose.getText();
				String pettype = txtType.getText();
				String color = txtColor.getText();
				int gender = Integer.parseInt(txtGender.getText());
				int isSterilized = Integer.parseInt(txtSterilized.getText());
				//DATE
				String pedigree = txtPedigree.getText();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date_entry = df.format(datePicker.getDate());
				//END
				String vaccine1 = txtVaccine1.getText();
				String vaccine2 = txtVaccine2.getText();
				String vaccine3 = txtVaccine3.getText();

				Connection conn = null;
				PreparedStatement pstmt = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/refugio","root","2797");
					pstmt = conn.prepareStatement("UPDATE PETS SET PETPHOTO=?, PETTYPE=?, COLOR=?,GENDER=?,ISSTERILIZED=?,PEDIGREE=?,DATE_ENTRY=?,"
							+ "VACCINE1=?,VACCINE2=?,VACCINE3=? WHERE PETNAME=?");

					pstmt.setString(11, petname);
					pstmt.setString(1, petphoto);
					pstmt.setString(2, pettype);
					pstmt.setString(3, color);
					pstmt.setInt(4, gender);
					pstmt.setInt(5, isSterilized);
					pstmt.setString(6, pedigree);
					pstmt.setString(7, date_entry);
					pstmt.setString(8, vaccine1);
					pstmt.setString(9, vaccine2);
					pstmt.setString(10, vaccine3);
					int i = pstmt.executeUpdate();

					if(i>0) {
						JOptionPane.showMessageDialog(null, "Data was Updated");
					}else {
						JOptionPane.showMessageDialog(null, "Data was not Updated");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});
		btnUpdate.setBounds(475, 651, 356, 51);
		contentPane.add(btnUpdate);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(475, 166, 356, 404);
		contentPane.add(panel);
		panel.setLayout(null);

		lblImageOutput = new JLabel("");
		lblImageOutput.setBounds(15, 16, 326, 372);
		panel.add(lblImageOutput);

		JLabel lblUpdateInformationTo = new JLabel("Update Information To SQL DATABASE");
		lblUpdateInformationTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateInformationTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUpdateInformationTo.setBounds(475, 605, 356, 29);
		contentPane.add(lblUpdateInformationTo);

		JButton button = new JButton("Choose Path Folder");
		button.addActionListener(new ActionListener() {
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
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(475, 96, 356, 54);
		contentPane.add(button);

		JLabel label = new JLabel("Select the Pet's Photograph");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(475, 56, 356, 29);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Clear Text");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText("   ");
				txtFileChoose.setText("   ");
				txtType.setText("   ");
				txtColor.setText("   ");
				txtGender.setText("   ");
				txtSterilized.setText("   ");
				txtPedigree.setText("   ");
				txtVaccine1.setText("   ");
				txtVaccine2.setText("   ");
				txtVaccine3.setText("   ");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(475, 718, 356, 51);
		contentPane.add(btnNewButton);
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
