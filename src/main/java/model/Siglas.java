package model;

import java.util.HashMap;
import java.util.Map;

public class Siglas {
	
	public static String siglaAero(String nome){
		String nomeRetorno = null;
		
		Map<String,String> siglaRetorna =  new HashMap<String,String>();
		//map of acronyms aero
		siglaRetorna.put("SBTK", "Tarauacá");;
		siglaRetorna.put("SBRB", "Presidente Médici");
		siglaRetorna.put("SBCZ",	"Internacional");
		siglaRetorna.put("SBMO",	"Zumbi dos Palmares");
		siglaRetorna.put("SBEG",	"Eduardo Gomes");	
		siglaRetorna.put("SBMN",	"Ponta Pelada");	
		siglaRetorna.put("SBMY",	"Manicoré	");
		siglaRetorna.put("SBTT",	"Tabatinga");	
		siglaRetorna.put("SBUA"	,"São Gabriel da Cachoeira");	
		siglaRetorna.put("SBTF"	,"Tefé");	
		siglaRetorna.put("SBAM","Amapá");	
		siglaRetorna.put("SBMQ",	"Internacional");	
		siglaRetorna.put("SBOI"	,"Oiapoque	");
		siglaRetorna.put("SBLP"	,"Bom Jesus da Lapa");	
		siglaRetorna.put("SBCV"	,"Caravelas	");
		siglaRetorna.put("SBIL"	,"Jorge Amado	");
		siglaRetorna.put("SBLE"	,"Chapada Diamantina");	
		siglaRetorna.put("SBUF"	,"Paulo Afonso	");
		siglaRetorna.put("SBPS"	,"Porto Seguro	");
		siglaRetorna.put("SBSV"	,"Dep. Luís Eduardo Magalhães");	
		siglaRetorna.put("SBQV"	,"Vitória da Conquista	");
		siglaRetorna.put("SBFZ"	,"Pinto Martins	");
		siglaRetorna.put("SBJU"	,"Cariri	");
		siglaRetorna.put("SBBR"	,"Juscelino Kubitschek");	
		siglaRetorna.put("SBVT"	,"Eurico Aguiar Salles");	
		siglaRetorna.put("SBAN"	,"Anápolis	");
		siglaRetorna.put("SBGO"	,"Santa Genoveva");	
		siglaRetorna.put("SBCI"	,"Carolina	");
		siglaRetorna.put("SBIZ"	,"Imperatriz	");
		siglaRetorna.put("SBSL"	,"Mar. Cunha Machado");	
		siglaRetorna.put("SBAX","Araxá");
		siglaRetorna.put("SBPR"	,"Carlos Prates");	
		siglaRetorna.put("SBBQ"	,"Barbacena	");
		siglaRetorna.put("SBBH"	,"Pampulha	");
		siglaRetorna.put("SBCF"	,"Tancredo Neves");	
		siglaRetorna.put("SBPC"	,"Poços de Caldas");	
		siglaRetorna.put("SBUR"	,"Uberaba");
		siglaRetorna.put("SBUL"	,"Uberlândia");	
		siglaRetorna.put("SBIP"	,"Ipatinga	");
		siglaRetorna.put("SBJF"	,"Francisco de Assis");	
		siglaRetorna.put("SBMK"	,"Montes Claros	");
		siglaRetorna.put("SBVG"	,"Varginha	");
		siglaRetorna.put("SBGV"	,"Gov. Valadares");	
		siglaRetorna.put("SBCG"	,"Internacional	");
		siglaRetorna.put("SBCR"	,"Corumbá	MS");
		siglaRetorna.put("SBPP"	,"Internacional");	
		siglaRetorna.put("SBAT"	,"Alta Floresta");	
		siglaRetorna.put("SBBW"	,"Barra do Garças");	
		siglaRetorna.put("SBCY"	,"Marechal Rondon");	
		siglaRetorna.put("SBHT"	,"Altamira	");
		siglaRetorna.put("SBBE"	,"Val-de-Cans	");
		siglaRetorna.put("SBIH"	,"Itaituba");
		siglaRetorna.put("SBEK"	,"Jacareacanga");	
		siglaRetorna.put("SBMA"	,"Marabá	");
		siglaRetorna.put("SBCC"	,"Cachimbó");	
		siglaRetorna.put("SBTB"	,"Trombetas");	
		siglaRetorna.put("SBCJ"	,"Carajás	");
		siglaRetorna.put("SBSN"	,"Santarém");	
		siglaRetorna.put("SBTU"	,"Tucuruí	");
		siglaRetorna.put("SBAA"	,"Conceição do Araguaia");	
		siglaRetorna.put("SBKG"	,"Pres. João Suassuna	");
		siglaRetorna.put("SBJP"	,"Presidente Castro Pinto	");
		siglaRetorna.put("SBFN"	,"Fernando de Noronha	");
		siglaRetorna.put("SBRF"	,"Guararapes	");
		siglaRetorna.put("SBPL"	,"Sen. Nilo Coelho");	
		siglaRetorna.put("SBPB"	,"Dr. João Silva Filho");	
		siglaRetorna.put("SBTE"	,"Sen. Petrônio Portella");	
		siglaRetorna.put("SBLO"	,"Londrina	");
		siglaRetorna.put("SBFI"	,"Cataratas	");
		siglaRetorna.put("SBBI"	,"Bacacheri	");
		siglaRetorna.put("SBCT"	,"Afonso Pena	");
		siglaRetorna.put("SBMG"	,"Silvio Name Junior");	
		siglaRetorna.put("SBCB"	,"Cabo Frio	");
		siglaRetorna.put("SBAF","Afonsos");
		siglaRetorna.put("SBGL","Galeão	");
		siglaRetorna.put("SBJR"	,"Jacarepaguá");	
		siglaRetorna.put("SBRJ"	,"Santos Dumont");	
		siglaRetorna.put("SBSC"	,"Santa Cruz");
		siglaRetorna.put("SBME"	,"Macaé");
		siglaRetorna.put("SBES","São Pedro da Aldeia");	
		siglaRetorna.put("SBCP"	,"Bartolomeu Lysandro");	
		siglaRetorna.put("SBMS","Dix-Sept Rosado	");
		siglaRetorna.put("SBNT"	,"Augusto Severo");
		siglaRetorna.put("SBGM"	,"Guajará Mirim");
		siglaRetorna.put("SBVH"	,"Brigadeiro Camarão");	
		siglaRetorna.put("SBPV","Governador Jorge Teixeira de Oliveira");
		siglaRetorna.put("SBBV"	,"Boa Vista");
		siglaRetorna.put("SBBG"	,"Bagé");
		siglaRetorna.put("SBSM","Santa Maria");	
		siglaRetorna.put("SBPA"	,"Salgado Filho");	
		siglaRetorna.put("SBPK","Pelotas");
		siglaRetorna.put("SBCO"	,"Canoas");
		siglaRetorna.put("SBUG","Rubem Berta");	
		siglaRetorna.put("SBCH"	,"Chapecó");
		siglaRetorna.put("SBCM" ,"Forquilinha");	
		siglaRetorna.put("SBFL","Hercílio Luz");	
		siglaRetorna.put("SBJV","Lauro Carneiro de Loyola");	
		siglaRetorna.put("SBNF" ,"Ministro Victor Konder");
		siglaRetorna.put("SBAR"	,"Santa Maria");
		siglaRetorna.put("SBBU","Bauru");
		siglaRetorna.put("SBKP"	,"Viracopos");
		siglaRetorna.put("SBDN"	,"Presidente Prudente");
		siglaRetorna.put("SBRP"	,"Leite Lopes");
		siglaRetorna.put("SBSR"	,"São José do Rio Preto");
		siglaRetorna.put("SBYS"	,"Fontenelle");
		siglaRetorna.put("SBST"	,"Base Aérea");
		siglaRetorna.put("SBGP","Gavião Peixoto");
		siglaRetorna.put("SBGW","Guaratinguetá");
		siglaRetorna.put("SBGR","Guarulhos");;
		siglaRetorna.put("SBSJ"	,"São José dos Campos");
		siglaRetorna.put("SBMT","Campo de Marte");
		siglaRetorna.put("SBSP"	,"Congonhas");
		siglaRetorna.put("SBTA"	,"Taubaté");
		siglaRetorna.put("SBPJ"	,"Palmas");
		siglaRetorna.put("SBPN"	,"Porto Nacional");;
		
		
		//for in value 	
		for (Map.Entry<String, String>entry: siglaRetorna.entrySet()) {
			if (nome.equals(entry.getValue())) {
				nomeRetorno = entry.getKey();
			}
		}
		

		
		return nomeRetorno;	
		
		
	}
	
	public static String siglaCidade(String nome){
		String nomeRetorno = null;
		
		Map<String,String> siglaRetornaCidade =  new HashMap<String,String>();
	
		//map of acronyms city
		siglaRetornaCidade.put("ec", "Encoberto com Chuvas Isoladas");  	
		siglaRetornaCidade.put("ci", "Chuvas Isoladas");
		siglaRetornaCidade.put("c" ,"Chuvas Periódicas");
		siglaRetornaCidade.put("in","Instável");
		siglaRetornaCidade.put("pp","Possiblidade de Pancadas de Chuva");
		siglaRetornaCidade.put("cm" ,"Chuva pela Manhã");
		siglaRetornaCidade.put("cn" ,"Chuva a Noite");
		siglaRetornaCidade.put("pt" ,"Pancadas de Chuva a Tarde");
		siglaRetornaCidade.put("pm" ,"Pancadas de Chuva pela Manhã");
		siglaRetornaCidade.put("np" ,"Nublado e Pancadas de Chuva");
		siglaRetornaCidade.put("pc" ,"Pancadas de Chuva");
		siglaRetornaCidade.put("pn" ,"Parcialmente Nublado");
		siglaRetornaCidade.put("cv" ,"Chuvisco");
		siglaRetornaCidade.put("ch" ,"Chuvoso");
		siglaRetornaCidade.put("t" ,"Tempestade");
		siglaRetornaCidade.put("ps" ,"Predomínio de Sol");
		siglaRetornaCidade.put("e" 	,"Encoberto");
		siglaRetornaCidade.put("n" 	,"Nublado");
		siglaRetornaCidade.put("nv" ,"Nevoeiro");
		siglaRetornaCidade.put("g" 	,"Geada");
		siglaRetornaCidade.put("ne" ,"Neve");
		siglaRetornaCidade.put("nd" ,"Não Definido");
		siglaRetornaCidade.put("pnt" ,"Pancadas de Chuva a Noite");
		siglaRetornaCidade.put("psc" ,"Possibilidade de Chuva");
		siglaRetornaCidade.put("pcm ","Possibilidade de Chuva pela Manhã");
		siglaRetornaCidade.put("pct" ,"Possibilidade de Chuva a Tarde");
		siglaRetornaCidade.put("pcn" ,"Possibilidade de Chuva a Noite");
		siglaRetornaCidade.put("npt" ,"Nublado com Pancadas a Tarde");
		siglaRetornaCidade.put("npn ","Nublado com Pancadas a Noite");
		siglaRetornaCidade.put("ncn" ,"Nublado com Possibilidade de Chuva a Noite");
		siglaRetornaCidade.put("nct" ,"Nublado com Possibilidade de Chuva a Tarde");
		siglaRetornaCidade.put("ncm" ,"Nublublado com Possibilidade de Chuva pela Manhã");
		siglaRetornaCidade.put("npm" ,"Nublado com Pancadas pela Manhã");
		siglaRetornaCidade.put("npp" ,"Nublado com Possibilidade de Chuva");
		siglaRetornaCidade.put("vn" ,"Variação de Nebulosidade");
		siglaRetornaCidade.put("ct" ,"Chuva a Tarde");
		siglaRetornaCidade.put("ppn" ,"Possibilidade de Pancada de Chuva a Noite");
		siglaRetornaCidade.put("ppt" ,"Possibilidade de Pancadade de Chuva a Tarde");
		siglaRetornaCidade.put("ppm","Possibilidade de Pancada de Chuva pela Manhã");
		siglaRetornaCidade.put("nppc" ,"Nublado com possibilidade de pancadas de chuva");
		siglaRetornaCidade.put("nppcm","Nublado com possibilidade de pancadas de chuva de manhã");
		siglaRetornaCidade.put("nppct","Nublado com possibilidade de pancadas de chuva a tarde");
		siglaRetornaCidade.put("nppcn" ,"Nublado com possibilidade de pancadas de chuva a noite");
		
		for (Map.Entry<String, String>entry: siglaRetornaCidade.entrySet()) {
			if (nome.equals(entry.getKey())) {
				nomeRetorno = entry.getValue();
			}
		}
		
		return nomeRetorno;
	
	}
	
	
	
	

}
