package application;

//Unifacisa - Centro Universitário

//Sistemas de Informação
//Disciplina..: Programar em Linguagem Orientada a Objetos Básica
//Período.....: 3º Trimestre 2023
//Professor...: Ruan Pierre de Oliveira
//Alunos.......:
// 				Gustavo Tomio Magalhaes Kubo
// 				Sérgio Magno Castor Pinheiro
// 				Thiago Limeira de Alencar
// 				Tiago Marques Tito

import java.util.ArrayList;
import java.util.Scanner;

import entities.Produto;

public class Estoque {

	public static void main(String[] args) {
		int opcao;
		int itemOpcao;
		int itemVenda;
		int quantVenda;
		int quantidadeInicial;
		int itemRepor;
		int quantRepor;
		int codigoProduto;
		String itemNome;
		String nomeProduto;
		Scanner sc = new Scanner(System.in);
		ArrayList<Produto> produtos = new ArrayList<>();

		do {
			System.out.print("\n|--------------------------------------|\n");
			System.out.print("| Sistema de Estoque                   |\n");
			System.out.print("| -------------------------------------|\n");
			System.out.print("| Opção 1 - Listar Todos os Produtos   |\n");
			System.out.print("| Opção 2 - Consulta por Código        |\n");
			System.out.print("| Opção 3 - Consulta por Nome          |\n");
			System.out.print("| Opção 4 - Cadastrar Produtos         |\n");
			System.out.print("| Opção 5 - Repor Estoque Produtos     |\n");
			System.out.print("| Opção 6 - Remover um Produto         |\n");
			System.out.print("| Opção 7 - Vender Produto             |\n");
			System.out.print("| Opção 8 - Sair                       |\n");
			System.out.print("|--------------------------------------|\n\n");
			System.out.print("Digite uma opção: ");

			try {
				opcao = sc.nextInt();
				sc.nextLine();
				switch (opcao) {

				case 1: {
					if (produtos.isEmpty()) {
						System.out.println("Não existem produtos cadastrados");

					} else {

						System.out.print("Opção 1 - Lista de todos os produtos:\n");

						for (Produto item : produtos) {
							System.out.println(item);

						}
					}
					sc.nextLine();
					break;
				}
				case 2: {
					System.out.print("Opção 2 - Consulta por código       \n");
					System.out.print("Digite um código: ");
					itemOpcao = sc.nextInt();
					sc.nextLine();
					for (Produto item : produtos) {
						if (itemOpcao == item.getCodigo()) {
							System.out.println(item);
						}
					}
					sc.nextLine();
					break;
				}
				case 3: {
					System.out.print("Opção 3 - Consulta por nome         \n");
					System.out.print("Digite um nome: ");
					itemNome = sc.nextLine();
					for (Produto item : produtos) {
						if (itemNome.equals(item.getNome())) {
							System.out.println(item);
						}
					}
					sc.nextLine();
					break;
				}

				case 4: {
					System.out.print("Opção 4 - Cadastro de novo produto  \n");
					System.out.print("Digite o nome do produto: ");
					nomeProduto = sc.nextLine();
					System.out.print("Digite o Código do Produto: ");
					codigoProduto = sc.nextInt();
					sc.nextLine();
					boolean codigoDuplicado = false;

					for (int i = 0; i < produtos.size(); i++) {
						Produto item = produtos.get(i);
						if (codigoProduto == item.getCodigo()) {
							System.out.println("Código de produto duplicado.");
							System.out.print("Digite o Código do Produto: ");
							codigoProduto = sc.nextInt();
							sc.nextLine();
							codigoDuplicado = true;
							i = -1;
						}
					}
					System.out.print("Digite a quantidade do produto a ser estocado: ");
					quantidadeInicial = sc.nextInt();
					sc.nextLine();
					produtos.add(new Produto(codigoProduto, nomeProduto, quantidadeInicial));
					System.out.println("Produto Cadastrado com Sucesso!");
					sc.nextLine();
					break;
				}

				case 5: {
					System.out.print("Opção 5 - Repor estoque             \n");
					System.out.println("Produtos disponíveis para reposição:");
					for (int i = 0; i < produtos.size(); i++) {
						System.out.println(i + ": " + produtos.get(i).getNome());
					}

					System.out.print("Digite o número do produto a ser reposto: ");
					itemRepor = sc.nextInt();
					sc.nextLine();

					if (itemRepor >= 0 && itemRepor < produtos.size()) {
						System.out.print("Digite a quantidade a ser reposta: ");
						quantRepor = sc.nextInt();
						sc.nextLine();

						Produto produto = produtos.get(itemRepor);
						produto.repor(quantRepor);

						System.out.println(
								"Reposição realizada com sucesso. Nova quantidade: " + produto.getQuantidade());
					} else {
						System.out.println("Número de produto inválido.");
					}
					break;
				}

				case 6: {
					System.out.print("Opção 6 - Remover um Produto         \n");

					System.out.print("Produtos em Estoque :\n");

					for (Produto item : produtos) {
						System.out.println(item);

					}
					System.out.print("Digite o código do produto a ser removido: ");
					int codigoRemover = sc.nextInt();
					sc.nextLine();

					boolean produtoRemovido = false;
					for (Produto item : produtos) {
						if (codigoRemover == item.getCodigo()) {
							produtos.remove(item);
							System.out.println("Produto removido com sucesso!");
							produtoRemovido = true;
							sc.nextLine();
							break;
						}
					}

					if (!produtoRemovido) {
						System.out.println("Produto não encontrado. Nenhum produto foi removido.");
						sc.nextLine();
					}
					break;
				}

				case 7: {
					System.out.print("Opção 7 - Vender item               \n");
					System.out.print("Produtos em Estoque :\n");

					for (Produto item : produtos)
						System.out.println(item);

					System.out.print("Digite o código do produto a ser vendido: ");
					itemVenda = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite a quantidade do produto a ser vendido: ");
					quantVenda = sc.nextInt();
					sc.nextLine();
					for (Produto item : produtos) {
						if (itemVenda == item.getCodigo()) {
							System.out.println(item.venda(quantVenda));

						}
					}
					break;
				}

				case 8: {
					System.out.print("Opção 8 - Sair                      \n");
					System.out.print("Saiu do sistema de estoque.");
				}
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Por favor, digite uma opção válida.");
				sc.nextLine();
				opcao = -1;
			}
		} while (opcao != 8);
		sc.close();
	}
}
