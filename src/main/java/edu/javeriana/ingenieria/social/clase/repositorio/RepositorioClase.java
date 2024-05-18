package edu.javeriana.ingenieria.social.clase.repositorio;

import edu.javeriana.ingenieria.social.clase.dominio.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioClase extends JpaRepository<Clase, Integer> {
    List<Clase> findAllByAsignatura(Integer asignatura);

    Clase findOneByCodigo(Integer codigo);

    boolean existsByCodigo(Integer codigo);
}
