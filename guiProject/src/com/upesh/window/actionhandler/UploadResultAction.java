package com.upesh.window.actionhandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFileChooser;

import org.hsqldb.lib.FileUtil;

import com.toedter.calendar.JDateChooser;
import com.upesh.window.design.HomeWindow;

public class UploadResultAction {
	
	HashMap<String, JComponent> componentMap;
	
	public UploadResultAction(){
		componentMap = HomeWindow.getWindow().componentMap;
		initialize(componentMap);
	}
	
	private void initialize(HashMap<String,JComponent> componentMap2){
		
		HomeWindow.getWindow().focusJPanel("uploadPanel",1000,500);
		
		
	}

	public void upload() {
		HashMap<String, HashMap<String, JComponent>> componentPerPanel = HomeWindow.getWindow().componentsPerPanelMap;
		HashMap<String, JComponent> uploadPanelComponents = componentPerPanel.get("uploadFilePanel");
			
		JFileChooser jFileChooser = (JFileChooser)uploadPanelComponents.get("fileChooser");
		JDateChooser jDateChooser = (JDateChooser)uploadPanelComponents.get("fileChooser");
		File selectedFile =  jFileChooser.getSelectedFile();	
		String newName = selectedFile.getName()+
		File file = new File("D:\\uploads\\");
		
		try(FileChannel source =  new FileInputStream(selectedFile).getChannel(); FileChannel dest =
				new FileOutputStream(file).getChannel();){
			dest.transferFrom(source, 0, source.size());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void cancel() {
		componentMap.get("uploadPanel").setVisible(false);
		
		
	}

}
