package com.upesh.window.actionhandler;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;
import com.upesh.service.stock.AddStockService;
import com.upesh.utilities.PropertyReader;
import com.upesh.vo.StockVO;
import com.upesh.window.design.HomeWindow;
import com.upesh.window.design.MyTableModel;

public  class AddStockAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	public static String modOfAddition = "IND";
	public List<StockVO> stocks = new ArrayList<StockVO>();
	HashMap<String, JComponent> componentMap;
	
	
	public AddStockAction() {
		putValue(NAME, "Add stock");
		putValue(SHORT_DESCRIPTION, "Some short description");
	}
	
	public void actionPerformed(ActionEvent e) {
		componentMap = HomeWindow.getWindow().componentMap;
		initialize(componentMap);
	}
	
	void initialize(HashMap<String, JComponent> componentMap){
		
		HomeWindow.getWindow().focusJPanel("addStockPanel",1000,300);
		HomeWindow.getWindow().setFrameLabelValue("titleLabel", "Add Stock");
		HashMap<String, JComponent> addStockComponents = HomeWindow.getWindow().componentsPerPanelMap.get("addStockPanel");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		componentMap.get("optionsPanel").setVisible(true);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		((JDateChooser)componentMap.get("addStockDateChooser")).setCalendar(cal);
		JComboBox<String> combo = ((JComboBox<String>)addStockComponents.get("ltryNameComboBox"));
		
		String lotteryTypesStr = PropertyReader.getPropertyValue("lotteryTypes");
		String[] lotteryTypes = lotteryTypesStr.split(",");
		for(String type : lotteryTypes){
			combo.addItem(type);
		}
		modOfAddition = "IND";
		changeLayout();
	}
	
	public static void changeLayout(){
		
		if(HomeWindow.getWindow()!=null){
			HashMap<String, JComponent> addStockComponents = HomeWindow.getWindow().componentsPerPanelMap.get("addStockPanel");
			/***
			 * addStockPanel
			 * addStockDateChooser , amount,  quantity, endingSerial , startingSerial , total , 
			 * startingSerialLabel, AmountLabel, endingSerialLabel , quantityLabel , totalLabel
			 * button
			 *  
			 */
			
			switch (modOfAddition) {
			case "IND":
				String arr[] = {"dateChooser",  "ltryNameComboBox", "startingSerialLabel", "startingSerial","AmountLabel", "amount", "totalLabel", "total" , "button"}; 
				List<String> requiredFields = Arrays.asList(arr);
				for(Entry<String, JComponent> entry : addStockComponents.entrySet()){
					if(requiredFields.contains(entry.getKey())){
						entry.getValue().setVisible(true);
					}
						
					else
						entry.getValue().setVisible(false);
				}
				break;

			case "BLKCNT":
				for(Entry<String, JComponent> entry : addStockComponents.entrySet()){
					entry.getValue().setVisible(true);
				}
				break;
			default:
				break;
			}
		}
		
	}
	
	public void addStock(){
		StockVO stockVO = null;
		HashMap<String, JComponent> addStockComponents = HomeWindow.getWindow().componentsPerPanelMap.get("addStockPanel");
		HashMap<String, JComponent> viewStockComponents = HomeWindow.getWindow().componentsPerPanelMap.get("viewStockPanel");
		String serialNo = ((JTextField)addStockComponents.get("startingSerial")).getText();
		Integer amount =  (Integer) ((JSpinner)addStockComponents.get("amount")).getValue();
		Integer quantity = (Integer) ((JSpinner)addStockComponents.get("quantity")).getValue();
		Date date = (Date) ((JDateChooser)addStockComponents.get("dateChooser")).getDate();
		String lotteryType = (String) ((JComboBox<String>)addStockComponents.get("ltryNameComboBox")).getSelectedItem();
		int numberPortion = Integer.parseInt(PropertyReader.getPropertyValue("serialNumberPortion"));
		componentMap.get("viewStockPanel").setVisible(true);
		componentMap.get("viewStockPanel").setBounds(12,500, 1000, 300);
		
		
		if(modOfAddition.equals("IND")){
			stockVO = new StockVO();
			stockVO.setSerialNo(serialNo);
			stockVO.setAmount(amount);
			stockVO.setTicketDate(date);
			stockVO.setStockDate(new Date());
			stockVO.setLotteryType(lotteryType);
			this.stocks.add(stockVO);
			
			
		}else if(modOfAddition.equalsIgnoreCase("BLKCNT")){
			for(int ind=0;ind<quantity;ind++){
				stockVO = new StockVO();
				stockVO.setSerialNo(serialNo);
				stockVO.setAmount(amount);
				stockVO.setTicketDate(date);
				stockVO.setStockDate(new Date());
				stockVO.setLotteryType(lotteryType);
				this.stocks.add(stockVO);
				
				String numberPart = serialNo.substring(serialNo.length()-numberPortion, serialNo.length());
				String stringPart = serialNo.substring(0,serialNo.length()-numberPortion);
				int nextSerial = Integer.parseInt(numberPart) +1;
				serialNo = stringPart + nextSerial;
			}
		}
		
		
		
		// POPULATE TABLE
	    Object mainArr[][] = new Object[stocks.size()][6];
	    int i =0;
	    SimpleDateFormat fomat = new SimpleDateFormat("DD - MMM - YYYY");
	    
		for(StockVO stockVO2 : stocks){
			Object[] subArr = new Object[6];
			subArr[0] = stockVO2.getLotteryType();
			subArr[1] = stockVO2.getSerialNo();
			subArr[2] = stockVO2.getAmount();
			subArr[3] = fomat.format(stockVO2.getTicketDate());
			subArr[4] = fomat.format(stockVO2.getStockDate());
			subArr[5] = stockVO2.getShouldRemove();
			mainArr[i] = subArr;
			i++;
		}
		
		String[] columns = {"LOTTERY TYPE   ", "TICKET NUMBER          " ,  " AMOUNT    ","TICKET DATE       ","STOCK ADDED ON    ", "REMOVE   "}; 
		JTable jtable = (JTable)viewStockComponents.get("table");
		jtable.setModel(new MyTableModel(mainArr,   columns));
		
		
		// RESET FIELDS
		((JTextField)addStockComponents.get("startingSerial")).setText("");
	//	((JTextField)addStockComponents.get("endingSerial")).setText("");
		((JSpinner)addStockComponents.get("amount")).setValue(0);
		((JSpinner)addStockComponents.get("quantity")).setValue(0);
		
	}
	
	
	
	
	








	public void commit()  {
		HashMap<String, JComponent> viewStockComponents = HomeWindow.getWindow().componentsPerPanelMap.get("viewStockPanel");
		JTable jtable = (JTable)viewStockComponents.get("table");
		
		DefaultTableModel model = (DefaultTableModel) jtable.getModel();
		List<StockVO> stocks = new ArrayList<StockVO>();
		Vector dataVector = model.getDataVector();
		Iterator iter = dataVector.iterator();
		StockVO stockVO;
		
		Calendar cal = Calendar.getInstance();
		
		
		while(iter.hasNext()){
			Vector vector = (Vector) iter.next();
			
				Iterator iter1 = vector.iterator();
				stockVO = new StockVO();
				stockVO.setLotteryType((String)iter1.next());
				stockVO.setSerialNo((String)iter1.next());
				stockVO.setAmount((Double)iter1.next());
				long date = Date.parse((String)iter1.next());
				cal.setTimeInMillis(date);
				stockVO.setTicketDate(cal.getTime());
				date = Date.parse((String)iter1.next());
				cal.setTimeInMillis(date);
				stockVO.setStockDate(cal.getTime());
				stockVO.setShouldRemove((Boolean)iter1.next());
				stocks.add(stockVO);
			
		}
		jtable.setModel(new MyTableModel(new Object[0][0],  new String[0]));
		
		AddStockService stockService = new AddStockService();
		try {
			stockService.addStock(stocks);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		componentMap.get("viewStockPanel").setVisible(false);
	}
	

}


