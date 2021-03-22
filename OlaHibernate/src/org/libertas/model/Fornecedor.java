package org.libertas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idfornecedor;
	private String nome;
	private String cnpj;
	private String telefone;
	private String endereco;
	private String bairro;
	private String cidade;

	public long getIdfornecedor() {
		return idfornecedor;
	}

	public void setIdfornecedor(long idfornecedor) {
		this.idfornecedor = idfornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Fornecedor [idfornecedor=" + idfornecedor + ", nome=" + nome + ", cnpj=" + cnpj + ", telefone="
				+ telefone + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + "]";
	}
	
}
