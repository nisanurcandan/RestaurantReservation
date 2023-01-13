package com.comp301project.database;

import com.comp301project.Entity.Table;
import com.comp301project.TableService.TableService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.List;

public class WriteData {

	private static FileWriter file;
	private static WriteData writer;

	public static WriteData getWriter() {
		if(writer==null) {
			writer=new WriteData();
		}
		return writer;
	}


	public void save() {
		List<Table> allTables= TableService.getTableServiceInstance().getAllTables();
		JSONArray allTablesArray=new JSONArray();
		for(int i=0;i<allTables.size();i++) {
			JSONObject table = new JSONObject();
			table.put("tableID", allTables.get(i).getTableID());
			table.put("pricePerHour", allTables.get(i).getPricePerHour());
			List<Integer> reservedHours=allTables.get(i).getReservedHours();
			JSONArray reservedHoursArray = new JSONArray();
			for(int j=0;j<reservedHours.size();j++) {
				reservedHoursArray.add(reservedHours.get(j));
			}
			table.put("reservedHours", reservedHoursArray);
			allTablesArray.add(table);
		}
		handleSavingToFile(allTablesArray);
	}

	private void handleSavingToFile(JSONArray allTables) {
		try {
			file = new FileWriter("ReservationDataset.json");
			file.write(allTables.toJSONString());
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		finally {
			try {
				file.flush();
				file.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}