package com.athenea.ms_excepciones.repository;

import com.athenea.ms_excepciones.entity.AbExcepcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExcepcionRepository extends JpaRepository<AbExcepcion, Long> {

    Optional<AbExcepcion> findByCodigo(String codigo);
}
