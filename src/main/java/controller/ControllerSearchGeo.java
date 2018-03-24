package controller;

import java.io.IOException;

import com.pengrad.telegrambot.model.Update;

public interface ControllerSearchGeo {
	
	public void searchGeo(Update update) throws IOException;

}
