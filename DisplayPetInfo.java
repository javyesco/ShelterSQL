package edu.pupr.RefugioSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DisplayPetInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayPetInfo frame = new DisplayPetInfo();
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
	public DisplayPetInfo() {
		setTitle("Display Pet Info");
		setBounds(100, 100, 450, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(42, 52, 340, 63);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JButton btnDisplayInfo = new JButton("Display Info");
		btnDisplayInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String petname = txtName.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/refugio","root","2797");
					PreparedStatement ps = con.prepareStatement("SELECT * FROM PETS WHERE PETNAME=?");

					ps.setString(1, petname);

					ResultSet rs = ps.executeQuery();

					while(rs.next()) {
						//JOption Option
						/**JOptionPane.showMessageDialog(null, rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getInt(5)+
								"|"+rs.getInt(6)+"|"+rs.getString(7)+"|"+rs.getString(8)+"|"+rs.getString(9)+"|"+rs.getString(10)+"|"+rs.getString(11));*/
						System.out.println("Pet's Name\t\t" + "Pet's Photo\t\t\t" + "Type\t" + "Color\t" + "Gender\t" + "tisSterilized\t" + "Pedigree\t\t" + 
								"Date-Entry\t" + "Vaccine1\t" + "Vaccine2\t" + "Vaccine3\t\n\n" + rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+
								"\t"+rs.getInt(6)+"\t\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t\t"+rs.getString(10)+"\t\t"+rs.getString(11));
					}
					rs.close();
					ps.close();
					con.close();

				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnDisplayInfo.setBounds(42, 131, 340, 48);
		contentPane.add(btnDisplayInfo);
		
		JLabel lblDisplayPetInfo = new JLabel("Display Pet Info");
		lblDisplayPetInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayPetInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDisplayPetInfo.setBounds(42, 16, 340, 29);
		contentPane.add(lblDisplayPetInfo);
	}
}
