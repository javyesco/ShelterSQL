package edu.pupr.RefugioSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JDateChooser datePicker;
	private JTextField txtSearch;
	private JLabel lblDateOfReport;
	private JLabel lblOutputOfReports;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		setTitle("Report Tab");
		setBounds(100, 100, 577, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 172, 489, 387);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/refugio","root","2797");
					String query = "SELECT * FROM PETS WHERE DATE_ENTRY=?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, txtSearch.getText());
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		txtSearch.setBounds(140, 55, 248, 60);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		lblDateOfReport = new JLabel("Report Date");
		lblDateOfReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfReport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfReport.setBounds(139, 16, 248, 29);
		contentPane.add(lblDateOfReport);
		
		lblOutputOfReports = new JLabel("Output of Reports");
		lblOutputOfReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputOfReports.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOutputOfReports.setBounds(26, 131, 489, 29);
		contentPane.add(lblOutputOfReports);
	}
}
