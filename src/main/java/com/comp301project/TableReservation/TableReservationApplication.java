package com.comp301project.TableReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.comp301project.FirstThings.FirstThings;

@SpringBootApplication
public class TableReservationApplication {

	public static void main(String[] args) {
		//WriteDefaultData.getInstance().returnToDefaults();
		FirstThings.handleFirstThings();
		SpringApplication.run(TableReservationApplication.class, args);
	}

}