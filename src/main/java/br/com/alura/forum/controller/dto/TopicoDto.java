package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	//Recebo o topico pela chamada, e devolvo apenas os atributos necessarios
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public static List<TopicoDto> converter(List<Topico> topicos) {
		//Itera sobre a lista de topicos que chegou, chama o constructor do TopicosDto
		//para cada elemento topico que chegou, e depois guarda cada um em uma lista, é como se fosse um filtro
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	}
	
	
}
