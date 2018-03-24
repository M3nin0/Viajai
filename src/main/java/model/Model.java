package model;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import com.pengrad.telegrambot.model.Update;
import view.Observer;
import java.io.IOException;
import java.net.URL;

public class Model implements Subject {

	public String lat = null;
	public String lon = null;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	private List<Observer> observers = new LinkedList<Observer>();

	Map<String, List<Double>> dadosLocal = new HashMap<String, List<Double>>();
	Map<String, List<String>> dados = new HashMap<String, List<String>>();

	List<String> subdados = new ArrayList<String>();
	List<String> locais = new ArrayList<String>();
	List<String> listaLocais = new ArrayList<String>();

	Cidade cidade = new Cidade();

	Update update;

	String id = null;

	int index = 0;
	private static Model uniqueInstance;

	Model() {
	}

	public static Model getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Model();
		}
		return uniqueInstance;
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers(long chatId, String studentsData) {
		for (Observer observer : observers) {
			observer.update(chatId, studentsData);
		}
	}

	public void searchCidadeXML(Update update) {
		
		String userInput = update.message().text();

		String userTratada = CidadeUtils.makePrettyName(userInput);	
		
		
		URL cidadeUrlId = CidadeUtils.BuiltUrlSearch(userTratada);
		
		String cidadeIdFile = CidadeUtils.getResponseFromHttpUrl(cidadeUrlId);
		if (cidadeIdFile != null) {
		
			String id = CidadeUtils.getClassObjectId(cidadeIdFile);
			
			URL cidadeAll = CidadeUtils.BuiltUrlCidade(id);
			
			String cidadeFileAll = CidadeUtils.getResponseFromHttpUrl(cidadeAll);
			
			Cidade cidade = CidadeUtils.getClassObjectCity(cidadeFileAll);
			
			for (int i = 0; i < cidade.getPrevisao().size();i++) {
				this.notifyObservers(update.message().chat().id(),"Data: "
				+ cidade.getPrevisao().get(i).getDia() + "\n" + "Temperatura Mínima: " 
				+ cidade.getPrevisao().get(i).getMinima() + "\n" + "Temperatura Máxima: "
				+ cidade.getPrevisao().get(i).getMaxima());
				
			}
		}
		else {
			this.notifyObservers(update.message().chat().id(),"Cidade não encontrada");			
		}
		
	}

	public void searchAeroXML(Update update) {

		String aeroNome = null;
		String aeroSigla = null;

		aeroNome = update.message().text();

		aeroSigla = Sigla.siglaAero(aeroNome);
		
		URL aeroUrl = AeroportoUtils.BuiltUrlAero(aeroSigla);
		
		String aeroParse = CidadeUtils.getResponseFromHttpUrl(aeroUrl);
		
		if (aeroParse != null) {
			Aeroporto aeroporto = AeroportoUtils.getClassObjectAero(aeroParse);
			this.notifyObservers(update.message().chat().id(),"Aeroporto: " + aeroNome
					+ "Atualização: " + aeroporto.getAtualizacao()
					+ "Temperatura: " + aeroporto.getTemperatura()
					+ "Tempo: " + Siglas.siglaCidade(aeroporto.getTemp_desc()));
		}else {
			this.notifyObservers(update.message().chat().id(),"Aeroporto não existe");
			
		}
		
		
		
	}

	public void searchCidadeGeo(Update update) throws IOException {
		
		this.notifyObservers(update.message().chat().id(),"Tenho que implmentar ainda XD");
		/*String nomeCidade = null;
		String teste = null;
		String userTratada = null;
		String userInput = null;

		List<String> separa = null;


		setLat(update.message().location().latitude().toString());
		setLon(update.message().location().longitude().toString());

		nomeCidade = cidade.buscaCidadeLatLon(getLat(), getLon());
		userTratada = nomeCidade;
		userInput = nomeCidade;
		try {
			userTratada = Normalizer.normalize(userTratada, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

			userTratada = userTratada.replaceAll("\\s+", "%20");

			teste = cidade.buscaId(userTratada, userInput);

			dados = cidade.buscaCidade(teste);

			this.notifyObservers(update.message().chat().id(), "Cidade: " + userInput);

			for (Map.Entry<String, List<String>> entrada : dados.entrySet()) {
				separa = entrada.getValue();
				this.notifyObservers(update.message().chat().id(),
						"Data: " + entrada.getKey() + "\n" + "Temperatura Máxima: " + separa.get(0) + "\n"
								+ "Temperatura Mínima: " + separa.get(1) + "\n" + "Índice de raio ultravioletas : "
								+ separa.get(2) + "\n" + "Clima: " + separa.get(3));

			}
			separa = null;
			dados = null;

		} catch (Exception e) {
			e.printStackTrace();
			this.notifyObservers(update.message().chat().id(), "Cidade não encontrada");

		}*/

	}

	public void searchGeoLocalidade(Update update) {
		
		this.notifyObservers(update.message().chat().id(),"Sei lá pra que serve esse método");

		/*Cidade cidade = new Cidade();

		List<Double> separa = null;

		String tratamento = null;
		String tipo = update.message().text();
		String tratadaFinal = null;
		String tratadaInicio = null;

		Local local = new Local();

		tratadaFinal = local.tratarFinal(tipo);
		System.out.println("Entrou aqui");
		if (!getLat().equals(null) && !getLat().equals(null)) {
			if (tratadaFinal.equalsIgnoreCase(" mais proximo")) {

				try {
				tratadaInicio = local.tratarInicio(tipo);

				tratamento = local.trataLocal(tratadaInicio);
				}
				catch(ArrayIndexOutOfBoundsException e) {
					this.notifyObservers(update.message().chat().id(),"Ebdsddsa");
					
				}

				dadosLocal = cidade.buscaLocalidade(getLat(), getLon(), tratamento);

				if (!tratamento.equals("N/A")) {
					for (Map.Entry<String, List<Double>> entrada : dadosLocal.entrySet()) {
						separa = entrada.getValue();
						this.notifyObservers(update.message().chat().id(),
								"Estabelecimento: " + entrada.getKey() + "\n" + "Avaliação: " + separa.get(0) + "/5.0"
										+ "\n" + "Distância: " + separa.get(1) + " Km");

						break;

					}
					separa = null;
					dados = null;
					subdados = null;

				} else {
					this.notifyObservers(update.message().chat().id(), "Localidade não encontrada");
				}

			} else {
				tratadaInicio = local.tratarInicio(tipo);

				tratamento = local.trataLocal(tratadaInicio);

				dadosLocal = cidade.buscaLocalidade(getLat(), getLon(), tratamento);

				if (!tratamento.equals("N/A")) {
					for (Map.Entry<String, List<Double>> entrada : dadosLocal.entrySet()) {
						separa = entrada.getValue();
						this.notifyObservers(update.message().chat().id(),
								"Estabelecimento: " + entrada.getKey() + "\n" + "Avaliação: " + separa.get(0) + "/5.0"
										+ "\n" + "Distância: " + separa.get(1) + " Km");

					}
					separa = null;
					dados = null;
					subdados = null;

				} else {
					this.notifyObservers(update.message().chat().id(), "Localidade não encontrada");
				}

			}
		} else {
			this.notifyObservers(update.message().chat().id(), "Por favor, comparilhe sua localização antes.");

		}*/

	}

}
