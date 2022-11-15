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

import com.br.emorio.entity.ComentarioModel;
import com.br.emorio.entity.RespostaModelo;
import com.br.emorio.repositories.ComentarioRepository;

@RestController
@RequestMapping("/api")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository acoes;
	
	// Listar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/comentarios", method = RequestMethod.GET)
	public @ResponseBody List<ComentarioModel> listar() {
		return acoes.findAll();
	}
	
	// Cadastrar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/comentarios", method = RequestMethod.POST)
	public @ResponseBody ComentarioModel cadastrar(@RequestBody ComentarioModel comentario) {
	return acoes.save(comentario);
	}
	

	
	// Filtrar
			@CrossOrigin(origins = "*")
			@RequestMapping(value = "/comentarios/{id}", method = RequestMethod.GET)
			public @ResponseBody ComentarioModel filtrar(@PathVariable int id) {
				return acoes.findById(id);
			}

			// Alterar
			@CrossOrigin(origins = "*")
			@RequestMapping(value = "/comentarios", method = RequestMethod.PUT)
			public @ResponseBody ComentarioModel alterar(@RequestBody ComentarioModel comentario) {
				return acoes.save(comentario);
			}

			// Remover
			@CrossOrigin(origins = "*")
			@RequestMapping(value = "/comentarios/{id}", method = RequestMethod.DELETE)
			public @ResponseBody RespostaModelo remover(@PathVariable Integer id) {

				RespostaModelo resposta = new RespostaModelo();

				try {

					ComentarioModel comentario = filtrar(id);
					this.acoes.delete(comentario);
					resposta.setMensagens("Comentario removido com sucesso");
				} catch (Exception e) {
					resposta.setMensagens("Falha ao deletar: " + e.getMessage());
				}

				return resposta;
			}


}
