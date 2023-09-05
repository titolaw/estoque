package entities;

public class Produto {

	private int codigo;
	private String nome;
	private int quantidade;

	public Produto(int codigo, String nome, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String venda(int vendido) {
		if (quantidade == 0) {
			return "Não há o produto em estoque.";
		} else if (quantidade < vendido) {
			return "Não há quantidade suficiente do produto em estoque.";
		} else {
			this.quantidade -= vendido;
			return "Venda efetuada";
		}
	}

	public String repor(int reposto) {
		quantidade += reposto;
		return "item reposto.";
	}

	@Override
	public String toString() {
		return "Produto: " + nome + " (cód.: " + codigo + " | estoque: " + quantidade + ")";
	}

	public String getQuantidade() {
		
		return null;
	}

}
