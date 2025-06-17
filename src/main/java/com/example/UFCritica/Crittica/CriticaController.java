package com.example.UFCritica.Crittica;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/criticas")
public class CriticaController {
    
    private final CriticaRepository criticaRepository;

    public CriticaController(CriticaRepository criticaRepository) {
        this.criticaRepository = criticaRepository;
    }

    @GetMapping("/mural")
    public String mural(Model model) {
        model.addAttribute("criticas", criticaRepository.findAll());
        return "mural";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("critica", new critica());
        return "add-critica";
    }

    @PostMapping("/add")
    public String addCritica(@ModelAttribute critica critica) {
        criticaRepository.save(critica);
        return "redirect:/criticas/mural?successMessage=Crítica+adicionada+com+sucesso!";
    }
}