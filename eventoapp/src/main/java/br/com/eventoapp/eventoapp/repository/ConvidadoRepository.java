package br.com.eventoapp.eventoapp.repository;

import br.com.eventoapp.eventoapp.models.Convidado;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
}
