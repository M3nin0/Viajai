package controller;
import com.pengrad.telegrambot.model.Update;

import model.Model;
import view.View;

public class ControllerSearchCidade implements ControllerSearch {

	
	private View view;
	private Model model;


	public ControllerSearchCidade(Model model, View view){
		this.model = model; //connection Controller -> Model
		this.view = view; //connection Controller -> View
	}
	
	

	public void search(Update update) {
		view.sendTypingMessage(update); //send typing message for user
		model.searchCidadeXML(update); //call method for search the city
		
	}

}
