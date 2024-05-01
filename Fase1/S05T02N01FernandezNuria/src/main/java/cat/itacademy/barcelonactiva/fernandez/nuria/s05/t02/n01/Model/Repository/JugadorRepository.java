package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Repository;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Domain.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<JugadorEntity, Integer> {
    @Query("SELECT COUNT(j) > 0 FROM JugadorEntity j WHERE j.nombreJugador = :nombreJugador")
    boolean existeNombreJugador(@Param("nombreJugador")String nombreJugador);

}
