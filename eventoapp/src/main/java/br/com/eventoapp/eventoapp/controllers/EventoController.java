package br.com.eventoapp.eventoapp.controllers;

import br.com.eventoapp.eventoapp.models.Convidado;
import br.com.eventoapp.eventoapp.models.Evento;
import br.com.eventoapp.eventoapp.repository.ConvidadoRepository;
import br.com.eventoapp.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cr;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form() {
        return "evento/formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento) {
        er.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {
        ModelAndView mv = new ModelAndView("index");

        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);
        return mv;
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.POST)
    public String detalhesEventoPost(@PathVariable("codigo") long codigo, Convidado convidado) {
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento);
        cr.save(convidado);

        return "redirect:/{codigo}";
    }
}