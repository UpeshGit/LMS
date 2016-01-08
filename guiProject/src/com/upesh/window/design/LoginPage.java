package com.upesh.window.design;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import com.upesh.service.authentication.AuthenticationService;

public class LoginPage {

	private JFrame frmMyApplication;
	private JPasswordField passwordField;
	private JButton btnCancel;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					LoginPage window = new LoginPage();
					window.frmMyApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyApplication = new JFrame();
		frmMyApplication.setType(Type.POPUP);
		frmMyApplication.setTitle("MY APPLICATION");
		frmMyApplication.setResizable(false);
		frmMyApplication.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmMyApplication.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
		frmMyApplication.getContentPane().setForeground(new Color(255, 0, 0));
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLogin.setForeground(new Color(0, 0, 51));
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setAction(action);
		btnNewButton.setToolTipText("login to application");
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setAction(action_1);
		btnCancel.setToolTipText("cancel loggin in");
		GroupLayout groupLayout = new GroupLayout(frmMyApplication.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(70))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
							.addGap(49)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLogin)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(61))
		);
		frmMyApplication.getContentPane().setLayout(groupLayout);
		frmMyApplication.setBounds(500, 500, 450, 200);
		frmMyApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * OK button pressed
	 * authenticate the user
	 * @author umuthukk
	 *
	 */
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("OK button pressed");
			AuthenticationService authenticationService = new AuthenticationService();
			try {
				boolean validLogin = authenticationService.authenticate(new String(passwordField.getPassword()));
				if(validLogin){
					frmMyApplication.setVisible(false);
				
				}else{
					
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * CANCEL button presssed
	 * @author umuthukk
	 *
	 */
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
