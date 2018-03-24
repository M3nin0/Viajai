package model;

import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class AeroportoUtils implements InterfaceForAll {
	
	public static URL BuiltUrlAero(String numero_aeroporto) {
		 UriComponents uriComponents = UriComponentsBuilder.newInstance()
          .scheme(PROTOCOL_API)
          .host(INPE_API_CIDADE)
          .path(PATH_API_AERO_SEARCH)
          .buildAndExpand(numero_aeroporto);
		 
		 URL url = null;
		 try {
	          url = new URL(uriComponents.toUriString());
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
		 
		 return url;
	
	}
	
	public static Aeroporto getClassObjectAero(String parseText) {
		Aeroporto aero = new Aeroporto();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Aeroporto.class);
			Unmarshaller unmarshaller;
			unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(parseText);
			aero = (Aeroporto) unmarshaller.unmarshal(reader);
		} catch (JAXBException e2) {
			e2.printStackTrace();
		}
		return aero;
	}
	
	
	
	

}
