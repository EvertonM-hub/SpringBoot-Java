package com.produtoapi.service;

import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; // Optional em java é classe de container genérico qua pode conter um valor não nulo ou estar vazia, usada para evitar null e prevenir possíveis NullPointerException

	@Service
	public class ProdutoService {
		 @Autowired
		 private ProdutoRepository produtoRepository;	
		 
		 public List<Produto> listarTodos() {
			return produtoRepository.findAll();
		 }
		 
		 public Produto salvar(Produto produto) {
			 return produtoRepository.save(produto);
		 }
		 
		 public void deletar(Long id) {
			 produtoRepository.deleteById(id);
		 }
		 
		 public Produto atualizar(Long id, Produto produto) {
			 if (produtoRepository.existsById(id)) {
				 produto.setId(id);
				 return produtoRepository.save(produto);
		 } else {
			 throw new RuntimeException("Produto não encontrado");
		 }
		 }
		
		 public Optional<Produto> findById(Long id) { // consulta por ID
			 return produtoRepository.findById(id);
		 }
		 
		 public List<Produto> salvarLista(List<Produto> produtos) { //salva a lista de produtos
			 return produtoRepository.saveAll(produtos);
			 }

		

		}
