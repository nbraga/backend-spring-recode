package com.br.emorio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.emorio.entity.ArtigoModel;

@Repository
public interface ArtigoRepository extends JpaRepository<ArtigoModel, Integer> {
	
	// Listar
	List<ArtigoModel> findAll();
	
	// Pesquisar
	ArtigoModel findById(int id);

	// Remover
	void delete(ArtigoModel artigo);

	// Cadastrar / Alterar
	<ArtigoMod extends ArtigoModel> ArtigoMod save(ArtigoMod artigo);
}







