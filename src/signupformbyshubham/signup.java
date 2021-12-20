package signupformbyshubham;
import java.sql.DriverManager;

import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class signup extends JFrame {
int k=0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	static final String DB_URL = "jdbc:mysql://localhost:3306/signupform";
	   static final String USER = "root";
	   static final String PASS = "Shubh@252525";

	   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		PreparedStatement pst=null;
		Connection con=null;
		con=(Connection)DB.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SignUpform");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(129, 11, 126, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFirstName.setBounds(10, 110, 126, 27);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLastName.setBounds(10, 148, 126, 27);
		contentPane.add(lblLastName);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblUserId.setBounds(10, 186, 126, 27);
		contentPane.add(lblUserId);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(10, 224, 126, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email ID");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 262, 126, 27);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(281, 110, 108, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(281, 148, 108, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(281, 186, 108, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(281, 262, 108, 20);
		contentPane.add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(281, 224, 108, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first=textField.getText();
				String last=textField_1.getText();
				String userid=textField_2.getText();
				String password=passwordField.getText();
				String email=textField_3.getText();
				
				FileReader in = null;
			     FileWriter out = null;
			     try {
			    	 in = new FileReader("input.txt");
			    	 do {
			             k=in.read();
			               
			            } while ((in.read()) != -1);
			    }catch (Exception e2) {
			    	// TODO: handle exception
			    }	finally {
			        if (in != null) {
			               try {
							in.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            }}
				
				int id=++k;
				String query="insert into signup(firstname,lastname,userid,password,emailid)"+" values(?,?,?,?,?)";
				try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         Statement stmt = conn.createStatement();
				      ) {		      
				         // Execute a query
				         System.out.println("Inserting records into the table...");          
				         String sql = "INSERT INTO registration VALUES (100, 'Zara', 'Ali', 18)";
				         
				         sql = "INSERT INTO signup VALUES ('"+first+"', '"+last+"', '"+userid+"', '"+password+"','"+email+"','"+id+"')";
				         stmt.executeUpdate(sql);
				         System.out.println("Inserted records into the table...");   	  
				      } catch (SQLException e1) {
				         e1.printStackTrace();
				      }  
				JOptionPane.showMessageDialog(null, "Data added");
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				passwordField.setText(null);
				textField_3.setText(null);
				
				try {
					out = new FileWriter("input.txt");
					out.write(k);
			    }catch (Exception e2) {
			    	// TODO: handle exception
			    }	finally {
			        if (in != null) {
			               try {
							out.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            }}
				
				
			}
		});
		btnNewButton.setBounds(129, 350, 102, 23);
		contentPane.add(btnNewButton);
	}
}
