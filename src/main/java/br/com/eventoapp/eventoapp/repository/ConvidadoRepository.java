package br.com.eventoapp.eventoapp.repository;

import br.com.eventoapp.eventoapp.models.Convidado;
import br.com.eventoapp.eventoapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
    Iterable<Convidado> findByEvento(Evento evento);
    Convidado findByRg(String rg);
}
