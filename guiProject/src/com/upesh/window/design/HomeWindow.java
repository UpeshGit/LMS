package com.upesh.window.design;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.upesh.window.actionhandler.AddStockAction;
import com.upesh.window.actionhandler.UploadResultAction;
import com.upesh.window.actionhandler.ViewStockAction;

import java.awt.TextField;

import javax.swing.border.BevelBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JRadioButton;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;

public class HomeWindow {

	private JFrame frame;
	private final Action action = new AddStockAction();
	private final Action action_1 = new ViewStockAction();
	public HashMap<String, JComponent> componentMap = new HashMap<String, JComponent>();
	public HashMap<String, HashMap<String, JComponent>> componentsPerPanelMap = new HashMap<>();
	static HomeWindow window;
	private JTextField addStockStartingSerail;
	private JTextField addStockTotal;
	public UploadResultAction uploadResultAction;
	/**
	 * @wbp.nonvisual location=1181,364
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action_2 = new IndividualRadioClicked();
	private final Action action_3 = new BulkRadioWithSerial();
	private final Action action_4 = new BulkRadioWithCount();
	private final Action action_5 = new SwingAction();
	private JTable editStockTable;
	private final Action action_6 = new CommitAction();
	private final Action action_7 = new uploadFileMenuAction();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					window = new HomeWindow();
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
	public HomeWindow() {
		initialize();
	}

	public static HomeWindow getWindow(){
		return window;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				focusJPanel("",0,0);
			}
		});
		frame.setBounds(100, 100, 1397, 920);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JPanel addStockPanel = new JPanel();
		addStockPanel.setBackground(SystemColor.info);
		addStockPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel viewStockPanel = new JPanel();
		viewStockPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel titlePanel = new JPanel();
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(SystemColor.inactiveCaptionBorder);
		
		JPanel uploadPanel = new JPanel();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION))
					uploadResultAction.upload();
				if(e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION))
					uploadResultAction.cancel();
			}
		});
		
		JLabel chooseFileLabel = new JLabel("Choose the file to upload....");
		chooseFileLabel.setForeground(Color.BLUE);
		chooseFileLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel lblChooseResultDate = new JLabel("Choose Result Date");
		GroupLayout gl_uploadPanel = new GroupLayout(uploadPanel);
		gl_uploadPanel.setHorizontalGroup(
			gl_uploadPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_uploadPanel.createSequentialGroup()
					.addGroup(gl_uploadPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_uploadPanel.createSequentialGroup()
							.addGap(68)
							.addComponent(fileChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_uploadPanel.createSequentialGroup()
							.addGap(238)
							.addComponent(chooseFileLabel)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_uploadPanel.createSequentialGroup()
					.addContainerGap(441, Short.MAX_VALUE)
					.addComponent(lblChooseResultDate)
					.addGap(36)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(111))
		);
		gl_uploadPanel.setVerticalGroup(
			gl_uploadPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_uploadPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(chooseFileLabel)
					.addGap(36)
					.addGroup(gl_uploadPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseResultDate))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(fileChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		uploadPanel.setLayout(gl_uploadPanel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(addStockPanel, GroupLayout.PREFERRED_SIZE, 1445, Short.MAX_VALUE)
					.addGap(860)
					.addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(viewStockPanel, GroupLayout.DEFAULT_SIZE, 2299, Short.MAX_VALUE)
					.addGap(237))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
					.addGap(712))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(457)
					.addComponent(uploadPanel, GroupLayout.PREFERRED_SIZE, 848, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1202, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(447)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(154))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(134)
							.addComponent(addStockPanel, 0, 0, Short.MAX_VALUE)
							.addGap(38)))
					.addGap(64)
					.addComponent(viewStockPanel, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addGap(147))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(uploadPanel, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(582, Short.MAX_VALUE))
		);
		
		JRadioButton individualRadio = new JRadioButton("Individual                       ");
		individualRadio.setAction(action_2);
		individualRadio.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if(arg0.getNewValue().equals(true)){
				}
			}
		});
		individualRadio.setFont(new Font("SansSerif", Font.PLAIN, 14));
		individualRadio.setSelected(true);
		optionsPanel.add(individualRadio);
		
		buttonGroup.add(individualRadio);
		
		JRadioButton bulkAddCountRadio = new JRadioButton("bulk addition (Count)      ");
		bulkAddCountRadio.setAction(action_4);
		bulkAddCountRadio.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if(arg0.getNewValue().equals(true)){
					}
			}
		});
		bulkAddCountRadio.setFont(new Font("SansSerif", Font.PLAIN, 14));
		optionsPanel.add(bulkAddCountRadio);
		
		JLabel lbLStartingSerial = new JLabel("Serial Number");
		
		JLabel lblQuantity = new JLabel("Quantity");
		
		JLabel lblAmount = new JLabel("Amount");
		
		JLabel lblTotal = new JLabel("Total");
		
		addStockStartingSerail = new JTextField();
		addStockStartingSerail.setColumns(10);
		
		JSpinner addStockQnty = new JSpinner();
		
		JSpinner addStockAmount = new JSpinner();
		
		addStockTotal = new JTextField();
		addStockTotal.setColumns(10);
		
		JButton addStockButton = new JButton("Add");
		addStockButton.setAction(action_5);
		
		JDateChooser addStockDateChooser = new JDateChooser();
		
		JComboBox ltryNameComboBox = new JComboBox();
		
		JLabel lblLottertType = new JLabel("Lottert Type");
		GroupLayout gl_addStockPanel = new GroupLayout(addStockPanel);
		gl_addStockPanel.setHorizontalGroup(
			gl_addStockPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_addStockPanel.createSequentialGroup()
					.addGroup(gl_addStockPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addStockPanel.createSequentialGroup()
							.addGroup(gl_addStockPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_addStockPanel.createSequentialGroup()
									.addGap(23)
									.addComponent(ltryNameComboBox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_addStockPanel.createSequentialGroup()
									.addGap(86)
									.addComponent(lblLottertType)))
							.addGap(72)
							.addGroup(gl_addStockPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_addStockPanel.createSequentialGroup()
									.addComponent(addStockStartingSerail, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
									.addGap(30))
								.addGroup(gl_addStockPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 36, GroupLayout.PREFERRED_SIZE)
									.addComponent(lbLStartingSerial, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addGap(68)))
							.addGroup(gl_addStockPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(addStockQnty, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_addStockPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(addStockAmount, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_addStockPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(addStockTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_addStockPanel.createSequentialGroup()
							.addGap(754)
							.addComponent(addStockDateChooser, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(165, Short.MAX_VALUE))
				.addGroup(gl_addStockPanel.createSequentialGroup()
					.addContainerGap(985, Short.MAX_VALUE)
					.addComponent(addStockButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		gl_addStockPanel.setVerticalGroup(
			gl_addStockPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addStockPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(addStockDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_addStockPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addStockPanel.createSequentialGroup()
							.addGap(53)
							.addComponent(ltryNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addComponent(addStockButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(17))
						.addGroup(gl_addStockPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_addStockPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_addStockPanel.createSequentialGroup()
									.addGroup(gl_addStockPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbLStartingSerial, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQuantity)
										.addComponent(lblAmount)
										.addComponent(lblTotal)
										.addComponent(lblLottertType))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(addStockStartingSerail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_addStockPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(addStockAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(addStockQnty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(addStockTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		addStockPanel.setLayout(gl_addStockPanel);
		
		JLabel titleLabel = new JLabel("Lottery Management System");
		titleLabel.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 25));
		titleLabel.setForeground(Color.BLUE);
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_titlePanel.createSequentialGroup()
					.addGap(285)
					.addComponent(titleLabel)
					.addContainerGap(402, Short.MAX_VALUE))
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addComponent(titleLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		titlePanel.setLayout(gl_titlePanel);
		frame.getContentPane().setLayout(groupLayout);
		componentMap.put("titleLabel", titleLabel);
		componentMap.put("addStockPanel", addStockPanel);
		componentMap.put("viewStockPanel", viewStockPanel);
		componentMap.put("addStockDateChooser", addStockDateChooser);
		componentMap.put("uploadPanel", uploadPanel);
		
		editStockTable = new JTable();
		editStockTable.setBorder(null);
		editStockTable.setFont(new Font("SansSerif", Font.PLAIN, 16));
		editStockTable.setCellSelectionEnabled(true);
		editStockTable.setColumnSelectionAllowed(true);
		editStockTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		JScrollPane scrollPane = new JScrollPane(editStockTable);
		//viewStockPanel.add(editStockTable);
		componentMap.put("menuBar", menuBar);
		
		HashMap<String, JComponent> addStockPanelComponents = new HashMap();
		HashMap<String, JComponent> viewStockPanelComponents = new HashMap();
		HashMap<String, JComponent> uploadFilePanelComponents = new HashMap();
		addStockPanelComponents.put("dateChooser", addStockDateChooser);
		addStockPanelComponents.put("startingSerialLabel", lbLStartingSerial);
		addStockPanelComponents.put("AmountLabel", lblAmount);
		addStockPanelComponents.put("quantityLabel", lblQuantity);
		addStockPanelComponents.put("totalLabel", lblTotal);
		
		addStockPanelComponents.put("amount", addStockAmount);
		addStockPanelComponents.put("quantity", addStockQnty);
		addStockPanelComponents.put("startingSerial", addStockStartingSerail);
		addStockPanelComponents.put("amount", addStockAmount);
		addStockPanelComponents.put("ltryNameComboBox", ltryNameComboBox);
		
		componentsPerPanelMap.put("addStockPanel", addStockPanelComponents);
		
		viewStockPanelComponents.put("table",editStockTable);
		
		uploadFilePanelComponents.put("fileChooser", fileChooser);
		uploadFilePanelComponents.put("dateChooser", dateChooser);
		componentsPerPanelMap.put("uploadFilePanel", uploadFilePanelComponents);
		JButton btnCommit = new JButton("Commit");
		btnCommit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnCommit.setAction(action_6);
		GroupLayout gl_viewStockPanel = new GroupLayout(viewStockPanel);
		gl_viewStockPanel.setHorizontalGroup(
			gl_viewStockPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_viewStockPanel.createSequentialGroup()
					.addContainerGap(988, Short.MAX_VALUE)
					.addComponent(btnCommit)
					.addGap(61))
				.addGroup(Alignment.LEADING, gl_viewStockPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
					.addGap(156))
		);
		gl_viewStockPanel.setVerticalGroup(
			gl_viewStockPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_viewStockPanel.createSequentialGroup()
					.addContainerGap(229, Short.MAX_VALUE)
					.addComponent(btnCommit)
					.addGap(19))
				.addGroup(gl_viewStockPanel.createSequentialGroup()
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		viewStockPanel.setLayout(gl_viewStockPanel);
		componentsPerPanelMap.put("viewStockPanel", viewStockPanelComponents);
		componentMap.put("scrollPane", scrollPane);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnFile.add(mntmExit);
		
		JMenu mnSales = new JMenu("Sales");
		mnSales.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnSales);
		
		JMenuItem mntmRetailSale = new JMenuItem("Retail Sale");
		mntmRetailSale.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSales.add(mntmRetailSale);
		
		JMenuItem mntmWholeSale = new JMenuItem("Whole sale");
		mntmWholeSale.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSales.add(mntmWholeSale);
		
		JMenu mnStock = new JMenu("Stock");
		mnStock.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnStock);
		
		JMenuItem mntmAddStock = new JMenuItem("Add Stock");
		mntmAddStock.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnStock.add(mntmAddStock);
		mntmAddStock.setAction(action);
		
		JMenuItem mntmViewStock = new JMenuItem("View Stock");
		mntmViewStock.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnStock.add(mntmViewStock);
		mntmViewStock.setAction(action_1);
		
		JMenuItem mntmViewStockfilters = new JMenuItem("View Stock (Filters)");
		mntmViewStockfilters.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnStock.add(mntmViewStockfilters);
		
		JMenu mnResult = new JMenu("Result");
		mnResult.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnResult);
		
		JMenuItem mntmUploadResult = new JMenuItem("Upload Result");
		mntmUploadResult.setAction(action_7);
		mntmUploadResult.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnResult.add(mntmUploadResult);
		
		JMenuItem mntmMatchResult = new JMenuItem("Match Result");
		mntmMatchResult.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnResult.add(mntmMatchResult);
		
		JMenuItem mntmViewResult = new JMenuItem("View Result");
		mntmViewResult.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnResult.add(mntmViewResult);
		
		JMenu mnReports = new JMenu("Reports");
		mnReports.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnReports);
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnHelp);
		
		JMenu mnLookAndFeel = new JMenu("Look And Feel");
		mnLookAndFeel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnHelp.add(mnLookAndFeel);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		mnLookAndFeel.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("New radio item");
		mnLookAndFeel.add(rdbtnmntmNewRadioItem_1);
		
		JMenuItem mntmMotif = new JMenuItem("Motif");
		mnLookAndFeel.add(mntmMotif);
		componentMap.put("optionsPanel", optionsPanel);
		buttonGroup.add(bulkAddCountRadio);
	}

	

	
	
	
	public void focusJPanel(String cmpName, int width, int height){
		
		frame.getContentPane().setLayout(null);
		for(Entry<String, JComponent> componentEntry : componentMap.entrySet()){
			if(componentEntry.getValue() instanceof JPanel){
				if(componentEntry.getKey().equals(cmpName)){
					JPanel newLayer = (JPanel)componentMap.get(componentEntry.getKey());
					newLayer.setVisible(true);
					newLayer.setBounds(12, 91, 152, 49);
					newLayer.setSize(width, height);
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
	private class IndividualRadioClicked extends AbstractAction {
		public IndividualRadioClicked() {
			putValue(NAME, "Individual     ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			((AddStockAction)action).modOfAddition = "IND";
			((AddStockAction)action).changeLayout();
			
		}
	}
	private class BulkRadioWithSerial extends AbstractAction {
		public BulkRadioWithSerial() {
			putValue(NAME, "Bulk addition(Serial no)");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			((AddStockAction)action).modOfAddition = "BLKSRL";
			((AddStockAction)action).changeLayout();
		}
	}
	private class BulkRadioWithCount extends AbstractAction {
		public BulkRadioWithCount() {
			putValue(NAME, "Bulk addition(Count)");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			((AddStockAction)action).modOfAddition = "BLKCNT";
			((AddStockAction)action).changeLayout();
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			((AddStockAction)action).addStock();
		}
	}
	private class CommitAction extends AbstractAction {
		public CommitAction() {
			putValue(NAME, "Commit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			((AddStockAction)action).commit();
		}
	}
	private class uploadFileMenuAction extends AbstractAction {
		public uploadFileMenuAction() {
			putValue(NAME, "Upload Result");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			uploadResultAction = new UploadResultAction();
		}
	}
}
