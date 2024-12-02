package com.idus.idus.repository;

import com.idus.idus.entity.SomaResultado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SomaResultadoRepository  {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public SomaResultado save(SomaResultado somaResultado) {
        entityManager.persist(somaResultado); // Salva a entidade no banco de dados
        return somaResultado; // Retorna a entidade salva
    }



}
