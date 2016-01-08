package com.upesh.service.stock;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.upesh.dao.AddStockDAO;
import com.upesh.dao.AuthenticationDAO;
import com.upesh.vo.LoginVO;
import com.upesh.vo.StockVO;

public class AddStockService {
	
	public static String CONFIG_PATH = "../../../../resources/configuration.properties";

	private AddStockDAO addStockDAO = new AddStockDAO();
	
	public boolean addStock(List<StockVO> stocks) throws IOException{
		
		return addStockDAO.saveStockDetails(stocks);
	}

	public List<StockVO> getStockList(){
		return addStockDAO.getStockList();
	}
}
