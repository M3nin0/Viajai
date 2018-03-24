package controller;

import java.io.IOException;

import com.pengrad.telegrambot.model.Update;

import model.Model;
import view.View;

public class ControllerSearchGeoCidade implements ControllerSearchGeo {
	
	
	private View view;
	private Model model;


	public ControllerSearchGeoCidade(Model model, View view){
		this.model = model; //connection Controller -> Model
		this.view = view; //connection Controller -> View
	}
	
	

	
	public void searchGeo(Update update) throws IOException {
		view.sendTypingMessage(update); //send typing message for user
		model.searchCidadeGeo(update); //call method for search the city
		
	}
	
	

}
