package edu.pupr.RefugioSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DeletePet extends JFrame {

	private JPanel contentPane;
	private JTextField txtPetName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePet frame = new DeletePet();
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
	public DeletePet() {
		setTitle("Delete Pet");
		setBounds(100, 100, 527, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPetName = new JTextField();
		txtPetName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPetName.setBounds(61, 66, 387, 75);
		contentPane.add(txtPetName);
		txtPetName.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtPetName.getText();
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/refugio","root","2797");
					pstmt = conn.prepareStatement("DELETE FROM PETS WHERE PETNAME=?");
					pstmt.setString(1, name);
					int i = pstmt.executeUpdate();

					if(i>0) {
						JOptionPane.showMessageDialog(null, "Data was Deleted");
					}else {
						JOptionPane.showMessageDialog(null, "Data was not Deleted");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnDelete.setBounds(61, 190, 387, 58);
		contentPane.add(btnDelete);
		
		JLabel lblDeleteInformationOf = new JLabel("Delete Information of Pet");
		lblDeleteInformationOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteInformationOf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteInformationOf.setBounds(61, 157, 387, 29);
		contentPane.add(lblDeleteInformationOf);
		
		JLabel lblProvideTheName = new JLabel("Provide the Name of the Pet");
		lblProvideTheName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvideTheName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProvideTheName.setBounds(61, 26, 387, 29);
		contentPane.add(lblProvideTheName);
	}

}
