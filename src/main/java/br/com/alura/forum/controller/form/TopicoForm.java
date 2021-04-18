package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.modelo.Curso;

public class TopicoForm {
	private String titulo;
	private String mensagem;
	private String nomeCurso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	//Essa funcao converte o form que chegou do cliente em tópico, e recebe o cursoRepository como parametro, para conseguir buscar a entidade curso só pelo nome
	public Topico converter(CursoRepository cursoRepository) {
		//Busco o curso pelo nome pra conseguir devolver a entidade curso para o banco
		Curso curso = cursoRepository.findByNome(nomeCurso);
		//Entao crio o meu topico com as informacoes ja presentes no meu topicoForm
		return new Topico(titulo, mensagem, curso);
	}
}
