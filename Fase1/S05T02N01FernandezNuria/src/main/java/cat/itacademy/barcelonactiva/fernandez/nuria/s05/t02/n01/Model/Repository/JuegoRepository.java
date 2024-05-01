package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Repository;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Domain.JuegoEntity;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Domain.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, Integer> {

}
