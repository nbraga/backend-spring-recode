package com.br.emorio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.emorio.entity.ArtigoModel;
import com.br.emorio.entity.RespostaModelo;
import com.br.emorio.repositories.ArtigoRepository;

@RestController
@RequestMapping("/api")
public class ArtigoController {
	
	@Autowired
	private ArtigoRepository acoes;

	// Listar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/artigos", method = RequestMethod.GET)
	public @ResponseBody List<ArtigoModel> listar() {
		return acoes.findAll();
	}
	
		// Cadastrar
		@CrossOrigin(origins = "*")
		@RequestMapping(value = "/artigos", method = RequestMethod.POST)
		public @ResponseBody ArtigoModel cadastrar(@RequestBody ArtigoModel artigo){
		
			return acoes.save(artigo);
		}
		

		// Filtrar
		@CrossOrigin(origins = "*")
		@RequestMapping(value = "/artigos/{id}", method = RequestMethod.GET)
		public @ResponseBody ArtigoModel filtrar(@PathVariable int id) {
			return acoes.findById(id);
		}

		// Alterar
		@CrossOrigin(origins = "*")
		@RequestMapping(value = "/artigos", method = RequestMethod.PUT)
		public @ResponseBody ArtigoModel alterar(@RequestBody ArtigoModel artigo) {
			return acoes.save(artigo);
		}

		// Remover
		@CrossOrigin(origins = "*")
		@RequestMapping(value = "/artigos/{id}", method = RequestMethod.DELETE)
		public @ResponseBody RespostaModelo remover(@PathVariable Integer id) {

			RespostaModelo resposta = new RespostaModelo();

			try {

				ArtigoModel artigo = filtrar(id);
				this.acoes.delete(artigo);
				resposta.setMensagens("Artigo removido com sucesso");
			} catch (Exception e) {
				resposta.setMensagens("Falha ao deletar: " + e.getMessage());
			}

			return resposta;
		}

}
