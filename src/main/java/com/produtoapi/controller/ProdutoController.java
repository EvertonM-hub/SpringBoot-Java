package com.produtoapi.controller;

import com.produtoapi.model.Produto;
import com.produtoapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos") // http://localhost/produto
public class ProdutoController {
	 @Autowired // Injeção de dependência automatica
	 private ProdutoService produtoService;
	 
	 @GetMapping // metodo http (CRUD) retorna toda a lista de produtos
	 public List<Produto> listarTodos() {
		 	return produtoService.listarTodos();
	 }
	 
	 @PostMapping // metodo http (CRUD) para salvar produtos novos
	 public Produto salvar(@RequestBody Produto produto) {
		 	return produtoService.salvar(produto);
	 }
	 
	 @PutMapping("/{id}") // metodo http (CRUD) atualiza o produto ja existente
	 public Produto atualizar(@PathVariable Long id, @RequestBody
	Produto produto) {
		 	return produtoService.atualizar(id, produto);
	 }
	 
	 @DeleteMapping("/{id}") // metodo http (CRUD) deleta
	 public void deletar(@PathVariable Long id) {
		 produtoService.deletar(id);
	 }
	 
	 @GetMapping("/{id}") // metodo http (CRUD) procurar produto especifico pelo ID
	 public Optional<Produto> findById(@PathVariable Long id) {
		 	return produtoService.findById(id);
	 }
	 
	 @PostMapping("/salvarLista") // recebe uma lista de produtos e salva de uma vez
	 public List<Produto> salvarLista(@RequestBody List<Produto>
	produtos) {
	 return produtoService.salvarLista(produtos);
	 }

	 
	 
	 
	
	// ==============================================================================
	// =================== BUSCAS DETALHADAS POR NOME DE PRODUTO ====================
	// ==============================================================================
	// Endpoints de busca por nome de Produto
	 
	@GetMapping("/buscarPorNome")
	public List<Produto> buscarPorNome(@RequestParam String valor) {
		return produtoService.findByNome(valor);
	}
	
	@GetMapping("/buscarPorNomeContendo")
	public List<Produto> buscarPorNomeContendo(@RequestParam String valor) {
		return produtoService.findByNomeContaining(valor);
	}
	
	@GetMapping("/buscarPorNomeEStatus")
	public List<Produto> buscarPorNomeEStatus(@RequestParam String nome, @RequestParam String status) {
		return produtoService.findByNomeAndStatus(nome, status);
	}
	
	@GetMapping("/buscarPorNomeComecandoCom")
	public List<Produto> buscarPorNomeComecandoCom(@RequestParam String valor) {
		return produtoService.findByNomeStartingWith(valor);
	}
	
	@GetMapping("/buscarPorNomeTerminandoCom")
	public List<Produto> buscarPorNomeTerminandoCom(@RequestParam String valor) {
		return produtoService.findByNomeEndingWith(valor);
	}
	
	
	
	
	
	// ==============================================================================
	// =================== BUSCAS DETALHADAS POR PREÇO ==============================
	// ==============================================================================
	
	// Endpoints de busca por preço de Produto
	@GetMapping("/buscarPorPreco")
	public List<Produto> buscarPorPreco(@RequestParam Double valor) {
		return produtoService.findByPreco(valor);
	}
	
	@GetMapping("/buscarPorPrecoMaiorQue")
	public List<Produto> buscarPorPrecoMaiorQue(@RequestParam Double valor) {
		return produtoService.findByPrecoGreaterThan(valor);
	}
	
	@GetMapping("/buscarPorPrecoMenorQue")
	public List<Produto> buscarPorPrecoMenorQue(@RequestParam Double valor) {
		return produtoService.findByPrecoLessThan(valor);
	}
	
	@GetMapping("/buscarTotalPreco")
	public Double buscarTotalPreco() {
		return produtoService.findTotalPreco();
	}
	
	
	
	
	
	// ==============================================================================
	// ================ BUSCAS DETALHADAS POR QUANTIDADE DE PRODUTO =================
	// ==============================================================================
	
	// Endpoints de busca por quantidade de Produto
	@GetMapping("/buscarPorQuantidade")
	public List<Produto> buscarPorQuantidade(@RequestParam Integer valor) {
		return produtoService.findByQuantidade(valor);
	}
	
	@GetMapping("/buscarPorQuantidadeMenorQue")
	public List<Produto> buscarPorQuantidadeMenorQue(@RequestParam Integer valor) {
		return produtoService.findByQuantidadeLessThan(valor);
	}
	
	@GetMapping("/buscarPorQuantidadeMaiorQue")
	public List<Produto> buscarPorQuantidadeMaiorQue(@RequestParam Integer valor) {
		return produtoService.findByQuantidadeGreaterThan(valor);
	}
	
	
	
	
	
	//===========================================================================
	// =================== BUSCAS DETALHADAS POR STATUS DE PRODUTO ==============
	//===========================================================================
	
	// Endpoints de busca por Status do Produto
	@GetMapping("/buscarPorStatus")
	public List<Produto> buscarPorStatus(@RequestParam(required = false) String valor) { //Se nao definir o valor de required, ele vem como padrao True, fazendo que que o cliente obrigatoriamente psse um valor, e com ele false, o cliente pode enviar ou nao um valor   
		return produtoService.findByStatus(valor);
	}
	
	// Retorna exclusivamente produtos com status null
	@GetMapping("/buscarPorStatusNulos")
	public List<Produto> buscarPorStatusNulos() {
		return produtoService.findByStatusIsNull();
	}
	
	// Busca baseada em dois campos (preço e status)
	@GetMapping("/buscarPorPrecoEStatus")
	public List<Produto> buscarPorPrecoEStatus(@RequestParam Double preco, @RequestParam String status) {
		return produtoService.findByPrecoAndStatus(preco, status);
	}
	
	// Endpoint para trazer o total de produtos
	@GetMapping("/contarTotalDeProdutos")
	public Long contarTotalDeProdutos() {
		return produtoService.count();
	}
	
	// Se não passar nada, volta todos produtos com status padrão, neste caso será "Disponível".
	@GetMapping("/buscarPorStatusPadrao")
	public List<Produto> buscarPorStatusPadrao(@RequestParam(defaultValue = "Disponível") String valor) {
		return produtoService.findByStatus(valor);
	} 
	 
	 
}
