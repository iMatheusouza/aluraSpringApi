package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;


@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		//Caso o filtro esteja vazio, procure em todos
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List <Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		
	}
	
	@PostMapping
	//ResponseEntity é encarregado de devolver uma resposta pro cliente, e passamos no seu parametro o tipo da resposta que será devolvida
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		//preciso gerar uma entidade topico pra conseguir guardar ela no banco, entao eu crio um metodo converter dentro do meu topicoForm que vai converter
		//o form em topico
		
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		//Para devolvermos uma response precisamos devolver uma uri pro cliente, entao o uriBuilder do spring facilita a gente nao precisar ficarp passando a URL Na mao
		//Entao passamos o path pra ela, que seria o nosso topico, e o ID que seria o topico que acabou de ser criado, chamamos o buildAndExpand para substituir
		//as variaveis presentes no path, e buscamos o iD do topico com o getter da classe, e no final de tudo convertemos para uri
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		//O responseEntity tem vários m'etodos internos onde cada um seria um codigo http, sendo o create o código 201, ai dizemos que vamos devolver um responsebody
		//Que seria o tópicoDto do nosso tópico recem criado.

		return ResponseEntity.created(uri).body(new TopicoDto(topico));
		
	}
}
