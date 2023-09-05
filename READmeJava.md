
O sistema desenvolvido tem por função atendar o manejo do estoque de um pequeno comércio. Pressupõe-se que há outros sistemas conectados a ele que controlam as permissões dos usuários de acessar o sistema de estoque e fazer alterações na quantidade de produtos a entrar e sair. Este sistema pretende ser a interface do usuário com o estoque apenas.

### Levantamento de requisitos
- O sistema enumra todos os produtos.
- Os produtos tem quantidades, codigo e nome.
- A venda diminui a quantidade estocada.
- Opcional:
- É emitido um aviso quando o produto tem menos de 5 unidades.
- É registrado o dia da última reposição.

### Classes:
- Estoque (Main): 
	- inicia o programa.
	- lista todos os produtos.
	- consulta por nome.
	- consulta por código.
	- vender item.
	- reposição de estoque.
	- cadastro de novo produto.

- Produto
	- atributos:
		- codigo
		- nome
		- quantidade
	- métodos:
		- getCodigo
		- getNome
		- venda
		- repor
		- toString
