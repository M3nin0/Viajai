package controller;

import com.pengrad.telegrambot.model.Update;

import model.Model;
import view.View;

public class ControllerSearchLocalCidade implements ControllerSearchLocal{

	private View view;
	private Model model;
	
	public ControllerSearchLocalCidade (Model model, View view) {
		this.model = model; //connection Controller -> Model
		this.view = view; //connection Controller -> View
	}
	
	public void searchLocal(Update update) {
		view.sendTypingMessage(update); //send typing message for user
		model.searchGeoLocalidade(update);//call method for search local the city
		
	}

}
