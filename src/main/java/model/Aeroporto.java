package model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="metar")
public class Aeroporto {
	
	private String codigo;
	private String atualizacao;
	private int temperatura;
	private String temp_desc;
	private int umidade;
	private int vento_dir;
	private int vento_int;
	private int visibilidade;

	public String getCodigo() {
		return codigo;
	}
	@XmlElement
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAtualizacao() {
		return atualizacao;
	}
	
	@XmlElement
	public void setAtualizacao(String atualizacao) {
		this.atualizacao = atualizacao;
	}

	public int getTemperatura() {
		return temperatura;
	}
	
	@XmlElement
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public String getTemp_desc() {
		return temp_desc;
	}

	@XmlElement
	public void setTemp_desc(String temp_desc) {
		this.temp_desc = temp_desc;
	}

	public int getUmidade() {
		return umidade;
	}

	@XmlElement
	public void setUmidade(int umidade) {
		this.umidade = umidade;
	}

	public int getVento_dir() {
		return vento_dir;
	}

	@XmlElement
	public void setVento_dir(int vento_dir) {
		this.vento_dir = vento_dir;
	}

	public int getVento_int() {
		return vento_int;
	}

	@XmlElement
	public void setVento_int(int vento_int) {
		this.vento_int = vento_int;
	}

	public int getVisibilidade() {
		return visibilidade;
	}

	@XmlElement
	public void setVisibilidade(int visibilidade) {
		this.visibilidade = visibilidade;
	}
	
	

}
