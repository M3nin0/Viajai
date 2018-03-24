package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cidade")
public class Cidade {
	private String nome;
	private String uf;
	private String atualizacao;
	private String id;
	private List<Previsao>previsao;
	
	
	public String getId() {
		return id;
	}
	
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	@XmlElement
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	
	@XmlElement
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getAtualizacao() {
		return atualizacao;
	}
	
	@XmlElement
	public void setAtualizacao(String atualizacao) {
		this.atualizacao = atualizacao;
	}
	public List<Previsao> getPrevisao() {
		return previsao;
	}
	
	@XmlElement
	public void setPrevisao(List<Previsao> previsao) {
		this.previsao = previsao;
	}
	
	
	
	
	

}