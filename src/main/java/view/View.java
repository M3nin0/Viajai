package view;

import java.io.IOException;
import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import controller.ControllerSearch;
import controller.ControllerSearchAero;
import controller.ControllerSearchCidade;
import controller.ControllerSearchGeo;
import controller.ControllerSearchGeoCidade;
import controller.ControllerSearchLocal;
import controller.ControllerSearchLocalCidade;
import model.Model;

public class View implements Observer {

	TelegramBot bot = TelegramBotAdapter.build("TOKEN_TELEGRAM");

	// Object that receives messages
	GetUpdatesResponse updatesResponse;
	// Object that send responses
	SendResponse sendResponse;
	// Object that manage chat actions like "typing action"
	BaseResponse baseResponse;

	int queuesIndex = 0;

	ControllerSearchGeo controllerSearchGeo;

	ControllerSearchLocal controllerSearchLocal;

	ControllerSearch controllerSearch; // Strategy Pattern -- connection View -> Controller
	boolean location = false;

	boolean teste = false;

	boolean local = false;

	boolean searchBehaviour = false;

	private Model model;

	public View(Model model) {
		this.model = model;
	}

	public void setControllerSearch(ControllerSearch controllerSearch) { // Strategy Pattern
		this.controllerSearch = controllerSearch;
	}

	public void setControllerSearchGeo(ControllerSearchGeo controllerSearchGeo) {
		this.controllerSearchGeo = controllerSearchGeo;
	}

	public void setControllerSearchLocal(ControllerSearchLocal controllerSearchLocal) {
		this.controllerSearchLocal = controllerSearchLocal;
	}

	public void receiveUsersMessages() throws InterruptedException, IOException {

		// infinity loop
		while (true) {

			// taking the Queue of Messages
			updatesResponse = bot.execute(new GetUpdates().limit(100).offset(queuesIndex));

			// Queue of messages
			List<Update> updates = updatesResponse.updates();

			// taking each message in the Queue
			for (Update update : updates) {

				// updating queue's index
				queuesIndex = update.updateId() + 1;

				// messages for users
				try {

					if (location ) {
					
						sendResponse = bot
								.execute(new SendMessage(update.message().chat().id(), "Ótimo, vou procurar"));

						setControllerSearchGeo(new ControllerSearchGeoCidade(model, this));

						this.callControllerSearchGeo(update);
						location = false;

					} else {

						if (update.message().text().equals("ola") || update.message().text().equals("Olá")
								|| update.message().text().equals("/start")) {
							sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
									"Ola, digite: " + "\n" + "1 - Para saber o clima das cidades do Brasil" + "\n"
											+ "2 - Para o saber o clima dos aeroportos do Brasil" + "\n"
											+ "3 - Compartilhe sua localização e descubra pontos turisticos" + "\n"
											+ "4 - Procura por diversos pontos turisticos de sua cidade"));

						}

						if (this.searchBehaviour == true) {

							this.callControllerSearch(update);

						}
						if (local) {
							this.callControllerSearchLocal(update);
						}

						else if (update.message().text().equals("3")) {
							sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
									"Ótimo, compartilhe sua localizacao"));

							this.location = true;

						} else if (update.message().text().equals("1")) {

							sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
									"Nome cidade, dia atual - Para ver o dial atual" + "\n"
											+ "Nome cidade, todos os dias - Para ver todos os dias"));
							setControllerSearch(new ControllerSearchCidade(model, this));
							this.searchBehaviour = true;

						}

						else if (update.message().text().equals("2") || update.message().text().equals("(2)")) {
							setControllerSearch(new ControllerSearchAero(model, this));

							sendResponse = bot.execute(
									new SendMessage(update.message().chat().id(), "Qual é o nome do aeroporto?"));
							this.searchBehaviour = true;

						} else if (update.message().text().equals("4") || update.message().text().equals("(4)")) {
							setControllerSearchLocal(new ControllerSearchLocalCidade(model, this));

							sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
									"Escolha o tipo de estabelecimento: " + "\n" + "- Restaurante" + "\n" + "- Hospital"
											+ "\n" + "- Bar" + "\n" + "- Igreja" + "\n" + "- Academia" + "\n"
											+ "- Universidade"));
							this.local = true;

						} else if (update.message().text().equalsIgnoreCase("Todos")) {
							setControllerSearchLocal(new ControllerSearchLocalCidade(model, this));
							sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
									"Deseja ver todas as localidades ou climas?"));
							this.local = true;
						}

					}

				} catch (NullPointerException e) {
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
							"Não te entendi amigo, entre com os dados corretos"));

				}
			}
		}

	}

	public void callControllerSearch(Update update) {
		this.controllerSearch.search(update);

	}

	public void callControllerSearchGeo(Update update) throws IOException {
		this.controllerSearchGeo.searchGeo(update);

	}

	public void callControllerSearchLocal(Update update) {
		this.controllerSearchLocal.searchLocal(update);
	}

	public void update(long chatId, String nomeCidade) {

		sendResponse = bot.execute(new SendMessage(chatId, nomeCidade));

		this.searchBehaviour = false;
		this.location = false;
		this.local = false;

	}

	public void sendTypingMessage(Update update) {
		baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
	}

}
