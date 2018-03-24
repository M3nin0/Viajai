package model;



public interface InterfaceForAll {

	final static String PROTOCOL_API= "http";
	
	final static  String INPE_API_CIDADE = 
			"servicos.cptec.inpe.br";
	
	final static String PATH_API_CIDADE = 
			"/XML/cidade/7dias/{code_city}/previsao.xml";
	
	final static  String INPE_API_SEARCH = 
			"servicos.cptec.inpe.br";
	
	final static String PATH_API_SEARCH = "/XML/listaCidades";
	final static String QUERY_API_SEARCH = "city={cidade}";
	
	final static String PATH_API_AERO_SEARCH =
			"/XML/estacao/{code_aero}/condicoesAtuais.xml";
	
	//http://servicos.cptec.inpe.br/XML/estacao/SBGR/condicoesAtuais.xml
	

}
