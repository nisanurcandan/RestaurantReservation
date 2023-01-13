package com.comp301project.database;

import com.comp301project.Entity.Table;
import com.comp301project.TableService.TableService;

import java.util.ArrayList;
import java.util.Arrays;

public class WriteDefaultData {

	private static WriteDefaultData writeDefaultData;

	public static WriteDefaultData getInstance() {
		if(writeDefaultData==null) {
			writeDefaultData=new WriteDefaultData();
		}
		return writeDefaultData;
	}

	public void returnToDefaults() {
		try {
			TableService service=TableService.getTableServiceInstance();
			service.getAllTables().clear();
			Integer rh1[] = {4, 5, 8, 11, 12, 13, 17, 19, 20};
			Integer rh2[] = {0, 1, 3, 4, 7, 10, 12, 13, 14, 16, 17};
			Integer rh3[] = {4, 6, 7, 12, 13, 14, 18, 19, 23};
			Integer rh4[] = {1, 3, 5, 6, 9, 12, 13, 16, 19};
			Integer rh5[] = {3, 10, 12, 14, 16, 18, 20};
			Integer rh6[] = {0, 4, 12, 13, 21, 22, 23};
			Integer rh7[] = {3, 7, 12, 13, 15, 16, 17, 21};
			Integer rh8[] = {0, 6, 10, 11, 12, 14, 17, 19};
			Table wm1=new Table("1",5,new ArrayList<>(Arrays.asList(rh1)));
			Table wm2=new Table("2",7,new ArrayList<>(Arrays.asList(rh2)));
			Table wm3=new Table("3",9,new ArrayList<>(Arrays.asList(rh3)));
			Table wm4=new Table("4",3,new ArrayList<>(Arrays.asList(rh4)));
			Table wm5=new Table("5",10,new ArrayList<>(Arrays.asList(rh5)));
			Table wm6=new Table("6",8,new ArrayList<>(Arrays.asList(rh6)));
			Table wm7=new Table("7",2,new ArrayList<>(Arrays.asList(rh7)));
			Table wm8=new Table("8",5,new ArrayList<>(Arrays.asList(rh8)));
			service.addNewTable(wm1);
			service.addNewTable(wm2);
			service.addNewTable(wm3);
			service.addNewTable(wm4);
			service.addNewTable(wm5);
			service.addNewTable(wm6);
			service.addNewTable(wm7);
			service.addNewTable(wm8);

			WriteData.getWriter().save();
		}
		catch(Exception e){
			System.out.println("An error occurred at writing defaults!");
		}
	}

}