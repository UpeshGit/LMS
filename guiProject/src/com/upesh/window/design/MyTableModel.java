package com.upesh.window.design;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	
	public MyTableModel(Object[][] data,String[] columns) {
		this.setDataVector(data, columns);
	}
	
	public Class getColumnClass(int col){
		if(col ==5)
			return Boolean.class;
		else
			return super.getColumnClass(col);
	}
}