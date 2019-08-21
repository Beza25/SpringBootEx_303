package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    TODO_Repository todoRepository;

    @RequestMapping("/")
    public String listTODO(Model model){
        model.addAttribute("todos", todoRepository.findAll());
        return "list";
    }

    @RequestMapping("/add")
    public String todoForm(Model model){
        model.addAttribute("todo", new TODO());
        return "todoForm";
    }

    @RequestMapping("/process")
    public String processForm(@Valid TODO todo, BindingResult result){
        if (result.hasErrors()){
            return "todoForm";
        }
        todoRepository.save(todo);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showTODO(@PathVariable("id") long id, Model model){
        model.addAttribute("todo", todoRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateTODO(@PathVariable("id") long id, Model model){
        model.addAttribute("todo", todoRepository.findById(id).get());
        return "todoForm";
    }

    @RequestMapping("/delete/{id}")
    public String delTODO(@PathVariable("id") long id){
        todoRepository.deleteById(id);
        return "redirect:/";
    }

}
