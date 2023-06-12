package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import web.model.Estudante;
import web.repository.EstudantesRepository;
@Controller
public class EstudantesController {
@Autowired
	private EstudantesRepository ur;

//… Métodos de inserção de dados

	@RequestMapping(value="/cadastrarEstudantes", method=RequestMethod.GET)
	public String form(){
		return "estudante/formEstudantes";
	}
	
	@RequestMapping(value="/cadastrarEstudantes", method=RequestMethod.POST)
	public String form(Estudante estudante){
		
		ur.save(estudante);
		return "redirect:/cadastrarEstudantes";
	}
	
	@RequestMapping("/listarEstudantes")
	public ModelAndView listarEstudantes(){
		
		ModelAndView mv = new ModelAndView("estudante/listarEstudantes");
		
		Iterable<Estudante> estudantes = ur.findAll();
	
		mv.addObject("estudantes", estudantes);
		return mv;
	}

	@RequestMapping(value="/atualizarEstudantes", method=RequestMethod.GET)
	public String atualizarEstudantes(){
		return "estudante/atualizarEstudantes";
	}
	
	@RequestMapping(value="/atualizarEstudante", method=RequestMethod.POST)
	public String atualizarEstudante(String nome, String email){
		
		Estudante estudante = ur.findByNome(nome);	
		
		estudante.setEmail(email);
		
		ur.save(estudante);
		return "redirect:/listarEstudantes";
	}	
	
	
}
