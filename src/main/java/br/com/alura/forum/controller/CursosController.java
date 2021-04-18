package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.modelo.Curso;


@RestController
public class CursosController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@RequestMapping("/cursos")
	public void cursos(String cursoNome) {
//		List<Curso> cursos = cursoRepository.findAll();
		//chamando esse método onde findBy é padrao do JPA repository, tudo que vier depois dele seria uma propriedade
		//da entidade que estamos dentro, logo a entidade Curso tem um campo Nome dentro dela que será procurado.
		
		//Se houver um relacionamento, como exemplo a entidade Curso tem um relacionamento com a entidade Genero
		//Podemos buscar no curso dentro do Genero dessa forma findByGeneroNome, onde nome é uma propriedade INTERNA
		//Da entidade Genero
//		List<Curso> cursos = cursoRepository.findByNome(cursoNome);
				
	}
}
