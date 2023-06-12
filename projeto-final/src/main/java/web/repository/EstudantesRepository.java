package web.repository;
import org.springframework.data.repository.CrudRepository;
import web.model.Estudante;
public interface EstudantesRepository extends CrudRepository<Estudante, String>{
	
	Estudante findById(long id);
    Estudante findByNome(String nome);

}
