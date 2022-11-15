package com.br.emorio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.emorio.entity.ComentarioModel;

public interface ComentarioRepository extends JpaRepository<ComentarioModel, Integer> {

	// Pesquisar
	List<ComentarioModel> findAll();

	// Pesquisar
	ComentarioModel findById(int id);

	// Remover
	void delete(ComentarioModel comentario);

	// Cadastrar / Alterar
	<ComentarioMod extends ComentarioModel> ComentarioMod save(ComentarioMod comentario);
}




