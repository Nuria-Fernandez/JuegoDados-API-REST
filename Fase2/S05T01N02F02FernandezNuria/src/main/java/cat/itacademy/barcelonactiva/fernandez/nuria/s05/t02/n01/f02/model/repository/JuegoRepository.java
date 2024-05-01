package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.repository;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.domain.JuegoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends MongoRepository<JuegoEntity, String> {
}
