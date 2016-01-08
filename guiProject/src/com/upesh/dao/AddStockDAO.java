package com.upesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.upesh.dao.utilities.ResultSetExtractor;
import com.upesh.dao.utilities.SaveData;
import com.upesh.vo.StockVO;

public class AddStockDAO {
	
	SaveData saveData = new SaveData();
	public boolean saveStockDetails(List<StockVO> stocks){
		for(StockVO stockVO:stocks){
			if(!stockVO.getShouldRemove()){
				SimpleDateFormat format = new SimpleDateFormat("DD/MMM/YYYY");
				String query = "INSERT INTO LOTTERY VALUES('"+stockVO.getLotteryType()+"','"+stockVO.getSerialNo()+"','"+format.format(stockVO.getTicketDate()) +
						"','" +format.format(stockVO.getStockDate())+"',"+stockVO.getAmount()+",'"+stockVO.getCustomerName() +"','"+stockVO.getMobileNumber() +"','"+
						(stockVO.getShouldRemove()?"N":"Y")+ "')";
				saveData.getResultOfQuery(query);
			}
			
		}
		return false;
	}
	
	public List<StockVO> getStockList(){
	
		String query = "SELECT * FROM LOTTERY";
		ResultSet rs = ResultSetExtractor.getResultOfQuery(query );
		List<StockVO> stocks = new ArrayList<StockVO>();
		StockVO stockVO;
		try{
			while(rs.next()){
				stockVO = new StockVO();
				stockVO.setLotteryType(rs.getString(1));
				stockVO.setSerialNo(rs.getString(2));
				stockVO.setTicketDate(rs.getDate(3));
				stockVO.setStockDate(rs.getDate(4));
				stockVO.setAmount(rs.getDouble(5));
				stockVO.setCustomerName(rs.getString(6));
				stockVO.setMobileNumber(rs.getString(7));
				stockVO.setShouldRemove(rs.getString(8).equals("Y")?false:true);
				stocks.add(stockVO);
			}
		}catch(SQLException e){
			return null;
		}
		
		return stocks;
		
	}

}