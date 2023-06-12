package web.model;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Estudante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
    private String nome;
    private String email;
    private int anoEgresso;
    
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getAnoEgresso() {
			return anoEgresso;
		}
		public void setanoEgresso(int anoEgresso) {
			this.anoEgresso = anoEgresso;
		}
		
	}
