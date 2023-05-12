package com.br.atividadespringbootbd01.atividadespringbootbd01.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.atividadespringbootbd01.atividadespringbootbd01.Model.Carro;
import com.br.atividadespringbootbd01.atividadespringbootbd01.Repository.CarroRepository;

@Controller
public class CarroController {

    @Autowired
    CarroRepository repository;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String salvar(Carro carro) {
        repository.save(carro);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("lista");
        ArrayList<Carro> carros = new ArrayList<>();
        carros = (ArrayList<Carro>) repository.findAll();
        mv.addObject("carros", carros);
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        repository.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/home/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("home");
        Carro carroAntigo = new Carro();
        carroAntigo = repository.findById(id).get();
        mv.addObject("carroAntigo", carroAntigo);
        return mv;
    }
}
