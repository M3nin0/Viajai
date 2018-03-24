package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="previsao")
public class Previsao {
	private String dia;
	private String tempo;
	private int maxima;
	private int minima;
	private float iuv;
	
	public String getDia() {
		return dia;
	}
	
	@XmlElement
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getTempo() {
		return tempo;
	}
	
	@XmlElement
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public int getMaxima() {
		return maxima;
	}
	
	@XmlElement
	public void setMaxima(int maxima) {
		this.maxima = maxima;
	}
	public int getMinima() {
		return minima;
	}
	
	@XmlElement
	public void setMinima(int minima) {
		this.minima = minima;
	}
	public float getIuv() {
		return iuv;
	}
	
	@XmlElement
	public void setIuv(float iuv) {
		this.iuv = iuv;
	}

}
