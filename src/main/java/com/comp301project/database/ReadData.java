package com.comp301project.database;

import com.comp301project.Entity.Table;
import com.comp301project.TableService.TableService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadData {

	private static ReadData readData;


	public static ReadData getReadDataObject() {

		if(readData==null) {
			readData=new ReadData();
		}
		return readData;
	}



	@SuppressWarnings("unchecked")
	public void ReadDataFromFile() {
		JSONParser parser=new JSONParser();
		File dataBaseFile=new File("ReservationDataset.json");
		//System.out.println(dataBaseFile);

		try {
			FileReader fileReader=new FileReader(dataBaseFile);
			Object parsedFile = parser.parse(fileReader);
			ArrayList<JSONObject> tables = (ArrayList<JSONObject>) parsedFile;
			//System.out.println(tables);
			int hourValue=0;
			for(int i=0;i<tables.size();i++) {
				ArrayList<Integer> reservedHours = new ArrayList<Integer>();
				JSONObject currentTable= tables.get(i);
				String ID = (String) currentTable.get("tableID");
				int price=((Long) currentTable.get("pricePerHour")).intValue();
				JSONArray reservedHoursArray=(JSONArray) currentTable.get("reservedHours");
				for(int j=0;j<reservedHoursArray.size();j++) {
					hourValue=((Long) reservedHoursArray.get(j)).intValue();
					reservedHours.add(hourValue);
				}
				Table table = new Table(ID,price,reservedHours);
				TableService.getTableServiceInstance().addNewTable(table);
			}
		}
		catch(Exception exception) {
			System.out.println("An error is occurred at reading data!");
			System.out.println("System is returning to default values!");
			WriteDefaultData.getInstance().returnToDefaults();
		}
	}



}