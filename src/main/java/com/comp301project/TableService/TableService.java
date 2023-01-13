package com.comp301project.TableService;

import com.comp301project.Entity.Table;

import java.util.ArrayList;
import java.util.List;

public class TableService {

	private List<Table> allTables;
	private List<Table> availableTables;
	private static TableService tableServiceSingleton;

	private TableService() {
		allTables=new ArrayList<Table>();
		availableTables=new ArrayList<Table>();
	}

	public static TableService getTableServiceInstance() {
		if(tableServiceSingleton==null) {
			tableServiceSingleton=new TableService();
		}
		return tableServiceSingleton;
	}

	public void addNewTable(Table newTable) {
		allTables.add(newTable);
	}

	public List<Table> getAllTables(){
		return allTables;
	}

	/*public List<Table> getAvailableTables(){
		this.availableTables.clear();
		int currentTime=TimeHandler.getTimeHandlerObject().getCurrentHour();
		System.out.println("current h:"+currentTime);
		for(int i=0;i<allTables.size();i++) {
			if(this.allTables.get(i).isAvailableAtThisTime(currentTime)) {
				this.availableTables.add(allTables.get(i));
			}
		}
		return this.availableTables;
	}*/

	public Table getTableById(String Id) {
		Table table = null;
		for(int i=0;i<this.allTables.size();i++){
			if(allTables.get(i).getTableID().equals(Id)) {
				table=allTables.get(i);
			}
		}
		return table;
	}

}