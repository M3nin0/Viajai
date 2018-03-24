package controller;
import com.pengrad.telegrambot.model.Update;

import model.Model;
import view.View;
public class ControllerSearchAero implements ControllerSearch {
	
	

	private View view;
	private Model model;

	
	

	public ControllerSearchAero(Model model,View view) {
		
		this.view = view;
		this.model = model;
	}




	
	public void search(Update update) {
		view.sendTypingMessage(update);//send typing message for user 
		model.searchAeroXML(update);// call method search 
		
	}

}

