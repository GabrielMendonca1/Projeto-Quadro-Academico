package web.repository;
import org.springframework.data.repository.CrudRepository;
import web.model.Disciplina;
public interface DisciplinaRepository extends CrudRepository<Disciplina, String>{
	
	Disciplina findById(long id);
	
	Disciplina findByNome(String nome);
}
