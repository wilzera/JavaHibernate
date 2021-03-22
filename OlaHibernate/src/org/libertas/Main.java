package org.libertas;

import java.util.List;
import java.util.Scanner;

import org.libertas.dao.PessoaDaoHibernate;
import org.libertas.model.Pessoa;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(System.in);
			
			int menu = 0;
			
			while (menu != 6) {
				System.out.println("\n========== | Cadastro de pessoa | ==========");
				System.out.println("Selecione a sua opção:");
				System.out.println("1- Inserir");
				System.out.println("2- Alterar");
				System.out.println("3- Excluir");
				System.out.println("4- Consultar");
				System.out.println("5- Listar");
				System.out.println("6- Sair");
				System.out.println("============================================\n");
				
				System.out.print("Digite a opção desejada: ");
				menu = Integer.parseInt(in.nextLine());
				
				switch (menu) {
				case 1: {
					inserir(in);
					break;
				}
				case 2: {
					alterar(in);
					break;
				}
				case 3: {
					excluir(in);
					break;
				}
				case 4: {
					consultar(in);
					break;
				}
				case 5: {
					listar(in);
					break;
				}
				case 6: {
					System.out.println("Fim...");
					break;
				}
				default:
					System.out.println("Opção invalida!");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void listar(Scanner in) {
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		List<Pessoa> lista = pdao.listar();
		for (Pessoa p : lista ) {
			System.out.println(p);
		}
	}

	private static void consultar(Scanner in) {
		System.out.print("Digite o codigo que desejado: ");
		int id = Integer.parseInt(in.nextLine());
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		Pessoa p = pdao.consultar(id);
		System.out.println(p);
	}

	private static void excluir(Scanner in) {
		System.out.print("Digite o codigo que deseja excluir: ");
		int id = Integer.parseInt(in.nextLine());
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		Pessoa p = new Pessoa();
		p.setIdpessoa(id);
		pdao.excluir(p);
		System.out.println(p);
		
	}

	private static void alterar(Scanner in) {
		Pessoa p = new Pessoa();
		
		System.out.println("Idpessoa");
		p.setIdpessoa(Integer.parseInt(in.nextLine()));
		
		System.out.println("Nome: ");
		p.setNome(in.nextLine());
		
		System.out.println("Telefone: ");
		p.setTelefone(in.nextLine());
		
		System.out.println("Email: ");
		p.setEmail(in.nextLine());
		
		System.out.println("Endereco: ");
		p.setEndereco(in.nextLine());
		
		System.out.println("Bairro: ");
		p.setBairro(in.nextLine());
		
		System.out.println("CEP: ");
		p.setCep(in.nextLine());
		
		System.out.println("Cidade: ");
		p.setCidade(in.nextLine());
		
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		pdao.alterar(p);
		
	}

	private static void inserir(Scanner in) {
		Pessoa p = new Pessoa();

		System.out.println("Nome: ");
		p.setNome(in.nextLine());
		
		System.out.println("Telefone: ");
		p.setTelefone(in.nextLine());
		
		System.out.println("Email: ");
		p.setEmail(in.nextLine());
		
		System.out.println("Endereco: ");
		p.setEndereco(in.nextLine());
		
		System.out.println("Bairro: ");
		p.setBairro(in.nextLine());
		
		System.out.println("CEP: ");
		p.setCep(in.nextLine());
		
		System.out.println("Cidade: ");
		p.setCidade(in.nextLine());
		
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		pdao.inserir(p);
		
	}

}
