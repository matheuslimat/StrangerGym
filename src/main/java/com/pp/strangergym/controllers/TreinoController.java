package com.pp.strangergym.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pp.strangergym.models.Treino;
import com.pp.strangergym.repository.TreinoRepository;

@Controller
//@RestController n funciona pois ira retornar o json
public class TreinoController {
	
	@Autowired
	public TreinoRepository tr;
	
	@RequestMapping(value = "/cadastrarTreino", method=RequestMethod.GET)
	public String form() {
		return "treino/formTreino";
	}
	
	
	@RequestMapping(value="/cadastrarTreino", method=RequestMethod.POST)
	public String form(@Valid Treino treino, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarTreino";
		}
		
		tr.save(treino);
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
		return "redirect:/cadastrarTreino";
	}
	
	@RequestMapping(value="/visualizarTreinos")
	public ModelAndView listaTreinos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Treino> treinos = tr.findAll();
		mv.addObject("treinos", treinos);
		return mv;
	}
}
