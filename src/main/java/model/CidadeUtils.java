package model;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.List;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cidades")
public class CidadeUtils implements InterfaceForAll {
	
	private List<Cidade>cidade;
	
	
	public List<Cidade> getCidade() {
		return cidade;
	}
	@XmlElement
	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}
	
	private final static String USER_AGENT = "Mozilla/5.0";
	
	private static BufferedReader parse;
	
	
	public static URL BuiltUrlCidade(String numero_cidade) {
		 UriComponents uriComponents = UriComponentsBuilder.newInstance()
           .scheme(PROTOCOL_API)
           .host(INPE_API_CIDADE)
           .path(PATH_API_CIDADE)
           .buildAndExpand(numero_cidade);
		 
		 URL url = null;
		 try {
	          url = new URL(uriComponents.toUriString());
	          System.out.println("deu bom");
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
		 
		 return url;
	
	}
	
	public static URL BuiltUrlSearch(String nome_cidade) {
		 UriComponents uriComponents = UriComponentsBuilder.newInstance()
          .scheme(PROTOCOL_API)
          .host(INPE_API_SEARCH)
          .path(PATH_API_SEARCH)
          .query(QUERY_API_SEARCH)
          .buildAndExpand(nome_cidade)
          .encode();
		 
		 URL url = null;
		 
		 try {
	          url = new URL(uriComponents.toUriString());
		 }catch (MalformedURLException e) {
	            e.printStackTrace();
	     }
		 
		 return url;
	
	}
	
	
	public static String getResponseFromHttpUrl(URL url) {
		
		String Text = null;
		
		parse = null;
		
		try {
			
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();

	        con.setRequestMethod("GET");

	        con.setRequestProperty("User-Agent", USER_AGENT);

	         parse = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        
	        String inputLine;
	        
	        StringBuffer response = new StringBuffer();
	        
	        
	       
	        while ((inputLine = parse.readLine()) != null) {
	            response.append(inputLine);
	        	}
	        Text = response.toString();
	        }
	        catch(IOException e){
	        	e.printStackTrace();
	        	Text = null;
	        }finally{
	        	if (parse == null) {
	        		
	        		try {
	        			parse.close();
	        		
	        		} catch (IOException e) {
	        			e.printStackTrace();
	        		}
	        	}
	        }
	        	
		return Text;
	}
	
	
	public static String getClassObjectId(String parseText) {
		CidadeUtils cidadeId = new CidadeUtils();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(CidadeUtils.class);
			Unmarshaller unmarshaller;
			unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(parseText);
			cidadeId = (CidadeUtils) unmarshaller.unmarshal(reader);
		} catch (JAXBException e2) {
			e2.printStackTrace();
		}
		return (cidadeId.getCidade().get(0).getId());
	}
	
	
	
	public static Cidade getClassObjectCity(String parseText) {
		Cidade cidade = new Cidade();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(CidadeUtils.class);
			Unmarshaller unmarshaller;
			unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(parseText);
			cidade = (Cidade) unmarshaller.unmarshal(reader);
		} catch (JAXBException e2) {
			e2.printStackTrace();
		}
		return cidade;
	}
	
	public static String makePrettyName(String userInput) {
		String userTratada = Normalizer.normalize(userInput, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

		userTratada = userTratada.replaceAll("\\s+", "%20");
		
		return (userTratada);
	}
	
	
	/*public Map<String, List<Double>> buscaLocalidade(String lat, String lon, String tipo) {
 
		try {
			String link = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + lat + "," + lon
					+ "&radius=900&keyword=" + tipo + "&key=KEYAPI";
			
			

			URL Url = new URL(link);

			Scanner scan = new Scanner(Url.openStream());
			String str = new String();
			while (scan.hasNext())
				str += scan.nextLine();
			scan.close();

			JSONObject obj = new JSONObject(str);
			JSONArray res = obj.getJSONArray("results");

			for (int i = 0; i < res.length(); i++) {
				JSONObject tes = res.getJSONObject(i);
				JSONObject latlon = tes.getJSONObject("geometry").getJSONObject("location");
				Double lat2 = latlon.getDouble("lat");
				Double lon2 = latlon.getDouble("lng");
				Double lat1 = Double.parseDouble(lat);
				Double lon1 = Double.parseDouble(lon);
				List<Double> locais = new ArrayList<Double>();
				Double avaliacao = -1.0;

				try {
					avaliacao = tes.getDouble("rating");
					locais.add(avaliacao);
				} catch (JSONException e) {
					locais.;add(0.0);
				}

				String nomeEstabelecimento = tes.getString("name");
				Cidade calcula = new Cidade();
				Double dist = calcula.distance(lat1, lon1, lat2, lon2);
				locais.add(dist);
				dados.put(nomeEstabelecimento, locais);

			}

		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}

		return (ordena(dados));
	}

	public Map<String, List<Double>> ordena(Map<String, List<Double>> dados) {

		List<Map.Entry<String, List<Double>>> list = new LinkedList<Map.Entry<String, List<Double>>>(dados.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, List<Double>>>() {
			public int compare(Map.Entry<String, List<Double>> o1, Map.Entry<String, List<Double>> o2) {
				return o1.getValue().get(1).compareTo(o2.getValue().get(1));
			}
		});

		Map<String, List<Double>> result = new LinkedHashMap<String, List<Double>>();
		for (Map.Entry<String, List<Double>> n : list)
			result.put(n.getKey(), n.getValue());

		return (result);

	}
	
	
	public String buscaCidadeLatLon(String lat, String lon) {

		String nomeCidade = null;
		try {
			String link = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lon
					+ "&key=KEYAPI";

			URL Url = new URL(link);

			Scanner scan = new Scanner(Url.openStream());
			String str = new String();
			while (scan.hasNext())
				str += scan.nextLine();
			scan.close();

			JSONObject obj = new JSONObject(str);

			JSONObject res = obj.getJSONArray("results").getJSONObject(0);
			JSONObject la = res.getJSONArray("address_components").getJSONObject(3);
			nomeCidade = la.getString("long_name");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return (nomeCidade);
	}

	public double distance(double lat1, double lng1, double lat2, double lng2) {


		double earthRadius = 6371; // miles (or 6371.0 kilometers)
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double a = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;

		return dist;
	}*/
	

}
