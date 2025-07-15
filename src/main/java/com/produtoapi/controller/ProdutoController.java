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
}
