package web.repository;

import org.springframework.data.repository.CrudRepository;

import web.model.Disciplina;
import web.model.Enderecos;

public interface EnderecosRepository extends CrudRepository<Enderecos, String>{
	Iterable<Enderecos>  findById(Disciplina disciplina);
}

