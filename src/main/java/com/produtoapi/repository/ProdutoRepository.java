package com.produtoapi.repository;

import com.produtoapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
	
	// Busca por nome do produto
	List<Produto> findByNome(String nome); // findBy é um padrao do SpringBoot e espera receber um parametro. ele envia um nome e espera receber uma lista de nomes
	List<Produto> findByNomeContaining(String nome); // Nome é o campo do produto, containing o nome que vai ser passado, retornando a lista que foi buscada
	List<Produto> findByNomeAndStatus(String nome, String status);// findBy e And sao do Spring, nome e status sao os campos, ele espera receber dois parametros, que vao retornar a lista esperada
	List<Produto> findByNomeStartingWith(String prefix);// busca pelo comeco do nome(StartingWith), Ex: fone, vem todos os fones disponiveis.
	List<Produto> findByNomeEndingWith(String suffix);// procura pelo nome terminado em(EndingWith) + nome esperado
	
	
	
	// Busca por preço do produto
	List<Produto> findByPreco(Double preco);// busca pelo preco correto de cada produto
	List<Produto> findByPrecoGreaterThan(Double preco); // busca por preço maior que
	List<Produto> findByPrecoLessThan(Double preco); // busca por preco menor que
	
	// Usando anottation @Query para obter total de preços
	@Query("SELECT SUM(p.preco) FROM Produto p")
	Double findTotalPreco();
	
	
	
	// Buscas por quantidade de produto
	List<Produto> findByQuantidade(Integer quantidade); // busca pela quantidade correta
	List<Produto> findByQuantidadeLessThan(Integer quantidade); // Busca por quantidade menor que
	List<Produto> findByQuantidadeGreaterThan(Integer quantidade); // Busca por quantidade maior que
	
	
	
	// Buscas por preço e status
	List<Produto> findByStatus(String status); // Busca pelo status especificado 
	List<Produto> findByStatusIsNull(); // Busca pelo status null
	List<Produto> findByPrecoAndStatus(Double preco, String status); // Busca pelo preço e pelo status
}