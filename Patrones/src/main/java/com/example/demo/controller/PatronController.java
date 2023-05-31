package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.Patron;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PatronController {

    private Map<String, Patron> patrones;

    public PatronController() {
        patrones = new HashMap<>();
        patrones.put("PAT-001", new Patron("PAT-001", "Patrones creacionales", "Estos patrones proporcionan mecanismos de creación de objetos que incrementan la flexibilidad y la reutilización del código existente.", 1, "", "Creacción"));
        patrones.put("PAT-002", new Patron("PAT-002", "Factory Method", "Es un patrón de diseño creacional que proporciona una interfaz para crear objetos en una superclase, mientras permite a las subclases alterar el tipo de objetos que se crearán.", 2, "PAT-001", "Utiliza el Método Fábrica cuando no conozcas de antemano las dependencias y los tipos exactos de los objetos con los que deba funcionar tu código."));
        patrones.put("PAT-003", new Patron("PAT-003", "Abstract Factory", "Es un patrón de diseño creacional que nos permite producir familias de objetos relacionados sin especificar sus clases concretas.", 3, "PAT-002", "Cuando tu código deba funcionar con varias familias de productos relacionados, pero no desees que dependa de las clases concretas de esos productos"));
        patrones.put("PAT-004", new Patron("PAT-004", "Builder", "Es un patrón de diseño creacional que nos permite construir objetos complejos paso a paso. El patrón nos permite producir distintos tipos y representaciones de un objeto empleando el mismo código de construcción.", 4, "PAT-002", "Utiliza el patrón Builder para evitar un constructor telescópico."));
        patrones.put("PAT-005", new Patron("PAT-005", "Prototype", "Es un patrón de diseño creacional que nos permite copiar objetos existentes sin que el código dependa de sus clases.", 5, "PAT-002", "Utiliza el patrón Prototype cuando tu código no deba depender de las clases concretas de objetos que necesites copiar."));
        patrones.put("PAT-006", new Patron("PAT-006", "Singleton", "Es un patrón de diseño creacional que nos permite asegurarnos de que una clase tenga una única instancia, a la vez que proporciona un punto de acceso global a dicha instancia.", 6, "PAT-002", "Cuando una clase de tu programa tan solo deba tener una instancia disponible para todos los clientes"));
        patrones.put("PAT-007", new Patron("PAT-007", "Patrones estructurales", "Estos patrones proporcionan mecanismos de creación de objetos que incrementan la flexibilidad y la reutilización del código existente.", 7, "PAT-001", "Estructura"));
        patrones.put("PAT-008", new Patron("PAT-008", "Factory Method", "Es un patrón de diseño creacional que proporciona una interfaz para crear objetos en una superclase, mientras permite a las subclases alterar el tipo de objetos que se crearán.", 8, "PAT-007", "Utiliza el Método Fábrica cuando no conozcas de antemano las dependencias y los tipos exactos de los objetos con los que deba funcionar tu código."));
        }

            @GetMapping("/patron/{codigo}")
            public String obtenerPatron(@PathVariable String codigo, Model model) {
                if (patrones.containsKey(codigo)) {
                    Patron patron = patrones.get(codigo);
                    model.addAttribute("patron", patron);
                }
                return "patron";
            }
        }
