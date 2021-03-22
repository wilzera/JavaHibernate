package org.libertas;

import java.util.LinkedList;
import java.util.List;

import org.libertas.dao.BibliotecaDao;
import org.libertas.dao.CidadeDao;
import org.libertas.dao.ClienteDao;
import org.libertas.dao.EnderecoDao;
import org.libertas.dao.LivroDao;
import org.libertas.dao.ProdutoDao;
import org.libertas.model.teste.Autor;
import org.libertas.model.teste.Biblioteca;
import org.libertas.model.teste.Cidade;
import org.libertas.model.teste.Cliente;
import org.libertas.model.teste.Endereco;
import org.libertas.model.teste.Livro;
import org.libertas.model.teste.Produto;

public class MainTesteRelacionamento {
	
	public static void main(String[] args) {
		
		// Livros
		/*Livro livro1 = new Livro();
		livro1.setAno(1963);
		livro1.setTitulo("Planeta dos Macacos");
		LivroDao ldao = new LivroDao();
		ldao.inserir(livro1);
		
		Livro livro2 = new Livro();
		livro1.setAno(1980);
		livro1.setTitulo("A fundação");
		ldao.inserir(livro2);
		
		// Biblioteca
		Biblioteca biblioteca1 = new Biblioteca();
		biblioteca1.setNome("Biblioteca Libertas");
		biblioteca1.setEndereco("Av Wenceslau Braz, 1040");
		List<Livro> livros = new LinkedList<Livro>();
		biblioteca1.setLivros(livros);
		
		LivroDao ldao = new LivroDao();
		livros.add(ldao.consultar(1));
		livros.add(ldao.consultar(2));
		
		BibliotecaDao bdao = new BibliotecaDao();
		bdao.inserir(biblioteca1);*/
		
		// Clientes e Endereços
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Thulio Barbosa P. M.");
		cliente1.setCpf("128.555.544-65)");
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.inserir(cliente1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Joao Souza Seles");
		cliente2.setCpf("365.874.885-66)");
		clienteDao.inserir(cliente2);
		
		List<Endereco> enderecos = new LinkedList<Endereco>();
		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Rua vereador josé bras");
		endereco1.setBairro("Jardim Vitoria");
		endereco1.setNumero(15);
		endereco1.setCep("37950-000");
		
		Endereco endereco2 = new Endereco();
		endereco2.setLogradouro("Rua pinto ribeiro");
		endereco2.setBairro("Jardim Alvorada");
		endereco2.setNumero(1080);
		endereco1.setCep("58412-000");
		
		cliente1.setEnderecos(enderecos);
		
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecos.add(enderecoDao.consultar(1));
		enderecos.add(enderecoDao.consultar(2));
		
	}
	
}
