package application;

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
		int codigoInicial = 0;
		String itemNome;
		String nomeProduto;
		Scanner sc = new Scanner(System.in);
		ArrayList<Produto> produtos = new ArrayList<>();

		do {
			menu();
			System.out.print("Digite uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1: {
				System.out.print("Opção 1 - Vender item               \n");
				System.out.print("Digite o código do produto a ser vendido: ");
				itemVenda = sc.nextInt();
				sc.nextLine();
				System.out.print("Digite a quantidade do produto a ser vendido: ");
				quantVenda = sc.nextInt();
				sc.nextLine();
				for (Produto item : produtos) {
					if (itemVenda == item.getCodigo()) {
						System.out.println(item.venda(quantVenda));
						break;
					}
				}
				break;
			}
			case 2: {
				System.out.print("Opção 2 - Lista de todos os produtos:\n");
				for (Produto item : produtos) {
					System.out.println(item);
				}
				break;
			}
			case 3: {
				System.out.print("Opção 3 - Consulta por código       \n");
				System.out.print("Digite um código: ");
				itemOpcao = sc.nextInt();
				sc.nextLine();
				for (Produto item : produtos) {
					if (itemOpcao == item.getCodigo()) {
						System.out.println(item);
						break;
					}
				}
				break;
			}
			case 4: {
				System.out.print("Opção 4 - Consulta por nome         \n");
				System.out.print("Digite um nome: ");
				itemNome = sc.nextLine();
				for (Produto item : produtos) {
					if (itemNome.equals(item.getNome())) {
						System.out.println(item);
						break;
					}
				}
				break;
			}
			case 5: {
				System.out.print("Opção 5 - Repor estoque             \n");
				System.out.print("Digite o código do produto a ser resposto: ");
				itemRepor = sc.nextInt();
				sc.nextLine();
				System.out.print("Digite a quantidade do produto a ser reposto: ");
				quantRepor = sc.nextInt();
				sc.nextLine();
				System.out.println(produtos.get(itemRepor).repor(quantRepor));
				break;
			}

			case 6: {
				System.out.print("Opção 6 - Cadastro de novo produto  \n");
				System.out.print("Digite o nome do produto: ");
				nomeProduto = sc.nextLine();
				System.out.print("Digite a quantidade do produto a ser estocado: ");
				quantidadeInicial = sc.nextInt();
				sc.nextLine();
				produtos.add(new Produto(codigoInicial, nomeProduto, quantidadeInicial));
				codigoInicial++;
				break;
			}
			case 7: {
				System.out.print("Opção 7 - Sair                      \n");
				System.out.print("Saiu do sistema de estoque.");
			}
			}
		} while (opcao != 7);
		sc.close();
	}

	public static void menu() {
		System.out.print("\n|-------------------------------------|\n");
		System.out.print("| Sistema de estoque                  |\n");
		System.out.print("| Opção 1 - Vender item               |\n");
		System.out.print("| Opção 2 - Listar todos os produtos  |\n");
		System.out.print("| Opção 3 - Consulta por código       |\n");
		System.out.print("| Opção 4 - Consulta por nome         |\n");
		System.out.print("| Opção 5 - Repor estoque             |\n");
		System.out.print("| Opção 6 - Cadastro de novo produto  |\n");
		System.out.print("| Opção 7 - Sair                      |\n");
		System.out.print("|-------------------------------------|\n\n");
	}
}
