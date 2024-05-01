package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.repository;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.domain.JugadorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends MongoRepository<JugadorEntity, String> {
    boolean existsByNombreJugador(String nombreJugador);
}
