package com.br.atividadespringbootbd01.atividadespringbootbd01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.atividadespringbootbd01.atividadespringbootbd01.Model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
