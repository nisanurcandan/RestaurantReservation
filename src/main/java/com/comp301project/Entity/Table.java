package com.comp301project.Entity;

import com.comp301project.database.WriteData;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Table {

	private String tableID;
	private int pricePerHour;
	private List<Integer> reservedHours;

	public Table(String tableID, int pricePerHour, List<Integer> reservedHours) {
		this.tableID=tableID;
		this.pricePerHour=pricePerHour;
		this.reservedHours=reservedHours;
		this.sortReservedHours();
	}

	public String getTableID() {
		return tableID;
	}

	public void setTableID(String tableID) {
		this.tableID = tableID;
	}

	public int getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(int pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public List<Integer> getReservedHours() {
		this.sortReservedHours();
		return reservedHours;
	}

	public void setReservedHours(List<Integer> reservedHours) {
		this.reservedHours = reservedHours;
	}

	public void makeReservation(int hour) throws IOException {
		if(isAvailableAtThisTime(hour)) {
			this.reservedHours.add(hour);
			this.sortReservedHours();
			WriteData.getWriter().save();
		}
	}

	private void sortReservedHours() {
		Collections.sort(this.reservedHours);
	}

	public boolean isAvailableAtThisTime(int time) {
		for(int i=0;i<this.reservedHours.size();i++) {
			if(this.reservedHours.get(i)==time) {
				return false;
			}
		}
		return true;
	}

}