package com.upesh.window.actionhandler;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.upesh.service.stock.AddStockService;
import com.upesh.vo.StockVO;
import com.upesh.window.design.MyTableModel;
import com.upesh.window.design.HomeWindow;

public class ViewStockAction extends AbstractAction {
	
	JTable table;
	AddStockService service = new AddStockService();
	public ViewStockAction() {
		putValue(NAME, "View stock");
	}
	public void actionPerformed(ActionEvent e) {
		HomeWindow.getWindow().focusJPanel("viewStockPanel",1300,600);
		HomeWindow.getWindow().setFrameLabelValue("titleLabel", "View Stock");
		HashMap<String, JComponent> componentMap = HomeWindow.getWindow().componentMap;
		initialize(componentMap);
	}
	
	void initialize(HashMap<String, JComponent> componentMap){
		HashMap<String, JComponent> viewStockPanelComponents = HomeWindow.getWindow().componentsPerPanelMap.get("viewStockPanel");
		table = (JTable) viewStockPanelComponents.get("table"); 
		JScrollPane scrollPane =  (JScrollPane) componentMap.get("scrollPane");
		scrollPane.setSize(1000, 500);
		scrollPane.setMinimumSize(new Dimension(1,1));
		
		List<StockVO> stocks =  service.getStockList();
		
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
		
		table.setModel(new com.upesh.window.design.MyTableModel(mainArr,columns));
	}
}