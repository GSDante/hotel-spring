package com.ufrn.imd.hotelspringlocacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrn.imd.hotelspringlocacao.model.Quarto;

public interface QuartoRepository extends JpaRepository<Quarto, Long>{

	boolean existsByNumero(String numero);
	List<Quarto> findByIsOcupado(boolean isOcupado);
	Optional<Quarto> findByNumero(String numero);
	Optional<Quarto> findByCliente(String cliente);
	boolean existsByCliente(String cliente);
}
