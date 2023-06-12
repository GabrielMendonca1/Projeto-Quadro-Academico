package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.model.Disciplina;
import web.repository.DisciplinaRepository;
@Controller
public class DisciplinaController {
@Autowired
	private DisciplinaRepository ur;
//… Métodos de inserção de dados

	@RequestMapping(value="/cadastrarDisciplina", method=RequestMethod.GET)
	public String form(){
		return "disciplina/formDisciplina";
	}
	
	@RequestMapping(value="/cadastrarDisciplina", method=RequestMethod.POST)
	public String form(Disciplina disciplina){
		
		ur.save(disciplina);
		return "redirect:/cadastrarDisciplina";
	}
		
		@RequestMapping("/listarDisciplina")
		public ModelAndView listarDisciplina(){
			
			ModelAndView mv = new ModelAndView("disciplina/listarDisciplinas");
			
			Iterable<Disciplina> disciplina = ur.findAll();
		
			mv.addObject("disciplinas", disciplina);
			return mv;
		
	}
		
		@RequestMapping(value="/atualizarDisciplina", method=RequestMethod.GET)
		public String atualizarDisciplinas(){
			return "disciplina/atualizarDisciplina";
		}
		
		@RequestMapping(value="/atualizarDisciplina", method=RequestMethod.POST)
		public String atualizarDisciplina(String nome, String professor){
			
			Disciplina disciplina = ur.findByNome(nome);	
			
			disciplina.setProfessor(professor);
			
			ur.save(disciplina);
			return "redirect:/listarDisciplina";
		}	
}
