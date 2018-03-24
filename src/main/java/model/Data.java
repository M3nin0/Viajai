package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {
	public String data() { 
	LocalDate localDate = LocalDate.now();
	return (DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate).toString());
     
	}

}
