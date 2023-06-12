package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import web.model.Professor;
import web.repository.ProfessorRepository;
@Controller
public class ProfessorController {
@Autowired
	private ProfessorRepository ur;

//… Métodos de inserção de dados

	@RequestMapping(value="/cadastrarProfessores", method=RequestMethod.GET)
	public String form(){
		return "professor/formProfessores";
	}
	
	@RequestMapping(value="/cadastrarProfessores", method=RequestMethod.POST)
	public String form(Professor professor){
		
		ur.save(professor);
		return "redirect:/cadastrarProfessores";
	}
	
	@RequestMapping("/listarProfessores")
	public ModelAndView listarProfessores(){
	    ModelAndView mv = new ModelAndView("professor/listarProfessores");
	    Iterable<Professor> professores = ur.findAll();
	    mv.addObject("professores", professores);
	    return mv;
	}

	@RequestMapping(value="/atualizarProfessores", method=RequestMethod.GET)
	public String atualizarProfessores(){
		return "professor/atualizarProfessores";
	}
	
	@RequestMapping(value="/atualizarProfessores", method=RequestMethod.POST)
	public String atualizarProfessores(String nome, String email){
		
		Professor professor = ur.findByNome(nome);	
		
		professor.setEmail(email);
		
		ur.save(professor);
		return "redirect:/listarProfessores";
	}	
}
