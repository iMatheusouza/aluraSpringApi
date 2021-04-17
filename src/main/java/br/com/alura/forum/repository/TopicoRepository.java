package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alura.forum.modelo.Topico;

//Ele pede dois parametros que sao a entidade(a tabela do bd) e o tipo da chave prim'aria, que nosso caso é long
public interface TopicoRepository extends JpaRepository<Topico, Long> {
	List<Topico> findByCursoNome(String cursoNome);
}
