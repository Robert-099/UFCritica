package com.example.UFCritica.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao UFCrítica!");
        return "index";
    }
    
    @GetMapping("/saudacao")
    public String saudacao(
        @RequestParam(name="nome", required=false, defaultValue="Visitante") String nome,
        Model model) {
        
        if(nome == null || nome.trim().isEmpty()) {
            return "redirect:/";
        }
        
        model.addAttribute("nome", nome);
        return "saudacao";
    }
}