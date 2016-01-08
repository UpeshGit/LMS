package com.upesh.window.design;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.upesh.window.actionhandler.AddStockAction;
import com.upesh.window.actionhandler.ViewStockAction;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map.Entry;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

public class HomePage1 {

	JFrame frame;
	private final Action action = new AddStockAction();
	private final Action action_1 = new ViewStockAction();
	public HashMap<String, JComponent> componentMap = new HashMap<String, JComponent>();
	static HomePage1 window;
	private JTextField dateTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new HomePage1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage1() {
		initialize();
	}

	public static HomePage1 getWindow(){
		return window;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				focusJPanel("");
			}
		});
		frame.setBounds(100, 100, 1291, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnStock = new JMenu("Stock");
		mnStock.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mnStock.setBackground(new Color(255, 255, 255));
		menuBar.add(mnStock);
		
		JMenuItem mntmAddStock = new JMenuItem("Add stock");
		mntmAddStock.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mntmAddStock.setBackground(new Color(255, 255, 255));
		mntmAddStock.setAction(action);
		mnStock.add(mntmAddStock);
		
		JMenuItem mntmViewStock = new JMenuItem("View stock");
		mntmViewStock.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mntmViewStock.setAction(action_1);
		mnStock.add(mntmViewStock);
		
		JMenuItem mntmClearStock = new JMenuItem("Clear stock");
		mntmClearStock.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mnStock.add(mntmClearStock);
		
		JPanel addStockPanel = new JPanel();
		addStockPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel viewStockPanel = new JPanel();
		viewStockPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel titlePanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(136)
					.addComponent(viewStockPanel, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(addStockPanel, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(319, Short.MAX_VALUE)
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 718, GroupLayout.PREFERRED_SIZE)
					.addGap(236))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(viewStockPanel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(addStockPanel, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		
		JLabel titleLabel = new JLabel("Lottery Management System");
		titlePanel.add(titleLabel);
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		titleLabel.setForeground(new Color(0, 0, 255));
		componentMap.put("titleLabel", titleLabel);
		
		JLabel lblPanel = new JLabel("panel2");
		viewStockPanel.add(lblPanel);
		frame.getContentPane().setLayout(groupLayout);
		
		
		componentMap.put("addStockPanel", addStockPanel);
		
		dateTextField = new JTextField();
		dateTextField.setColumns(10);
		GroupLayout gl_addStockPanel = new GroupLayout(addStockPanel);
		gl_addStockPanel.setHorizontalGroup(
			gl_addStockPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_addStockPanel.createSequentialGroup()
					.addContainerGap(484, Short.MAX_VALUE)
					.addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		gl_addStockPanel.setVerticalGroup(
			gl_addStockPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addStockPanel.createSequentialGroup()
					.addGap(12)
					.addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(270, Short.MAX_VALUE))
		);
		addStockPanel.setLayout(gl_addStockPanel);
		componentMap.put("viewStockPanel", viewStockPanel);
		componentMap.put("menuBar", menuBar);
		componentMap.put("dateTextField", dateTextField);
	}
	
	
	
	
	
	
	public void focusJPanel(String cmpName){
		
		frame.getContentPane().setLayout(null);
		for(Entry<String, JComponent> componentEntry : componentMap.entrySet()){
			if(componentEntry.getValue() instanceof JPanel){
				if(componentEntry.getKey().equals(cmpName)){
					JPanel newLayer = (JPanel)componentMap.get(componentEntry.getKey());
					newLayer.setVisible(true);
					newLayer.setBounds(12, 91, 152, 49);
					newLayer.setSize(903, 322);
				}else{
					componentEntry.getValue().setVisible(false);
				}
			}
			
		}
	}
	
	public void setFrameLabelValue(String lblName , String value){
		((JLabel)componentMap.get(lblName)).setVisible(true);
		((JLabel)componentMap.get(lblName)).setText(value);
	}
}
