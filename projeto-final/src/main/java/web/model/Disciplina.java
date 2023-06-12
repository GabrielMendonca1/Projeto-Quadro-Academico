package web.model;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Disciplina implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;	
	private String nome;
	private String professor;
	
	@OneToMany
	private List<Enderecos> enderecos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	// …
	public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getProfessor() {
			return professor;
		}
		public void setProfessor(String professor) {
			this.professor = professor;
		}
	}
