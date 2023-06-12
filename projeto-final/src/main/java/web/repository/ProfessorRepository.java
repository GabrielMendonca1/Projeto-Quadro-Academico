package web.repository;
import org.springframework.data.repository.CrudRepository;
import web.model.Professor;
public interface ProfessorRepository extends CrudRepository<Professor, String>{
	
	Professor findById(long id);
	Professor findByNome(String nome);
}
