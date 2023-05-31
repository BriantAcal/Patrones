package com.example.demo.controller;

import com.example.demo.Patron;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

    private final PatronRepositorio patronRepositorio;

    public ProyectoController(PatronRepositorio patronRepositorio) {
        this.patronRepositorio = patronRepositorio;
    }

    @GetMapping("/")
    public String listaProyectos(Model model) {
        Map<String, Patron> patrones = patronRepositorio.obtenerTodos();
        model.addAttribute("proyectos", patrones);
        return "proyecto/lista";
    }


    @PostMapping("/crear")
    public String crearProyecto(@ModelAttribute("patron") Patron patron) {
    	patronRepositorio.agregarPatron(patron);
        return "redirect:/proyecto/";
    }

    @GetMapping("/{codigo}")
    public String verProyecto(@PathVariable("codigo") String codigo, Model model) {
        Patron patron = patronRepositorio.obtenerPorCodigo(codigo);
        model.addAttribute("patron", patron);
        return "proyecto/ver";
    }

    @GetMapping("/{codigo}/editar")
    public String mostrarFormularioEditar(@PathVariable("codigo") String codigo, Model model) {
        Patron patron = patronRepositorio.obtenerPorCodigo(codigo);
        model.addAttribute("patron", patron);
        return "proyecto/editar";
    }

    @PostMapping("/{codigo}/editar")
    public String editarProyecto(@PathVariable("codigo") String codigo, @ModelAttribute("patron") Patron patron) {
        Patron patronExistente = patronRepositorio.obtenerPorCodigo(codigo);
        patronExistente.setCodigo(patron.getCodigo());
        patronExistente.setNombre(patron.getNombre());
        patronExistente.setDescripcion(patron.getDescripcion());
        patronExistente.setId(patron.getId());
        patronExistente.setPadre(patron.getPadre());
        patronExistente.setUso(patron.getUso());
        return "redirect:/proyecto/" + codigo;
    }

    @PostMapping("/{codigo}/eliminar")
    public String eliminarProyecto(@PathVariable("codigo") String codigo) {
    	patronRepositorio.eliminarPatron(codigo);
        return "redirect:/proyecto/";
    }
}
