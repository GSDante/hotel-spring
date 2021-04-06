package com.ufrn.imd.hotelspringclienteAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrn.imd.hotelspringclienteAuth.model.Usuario;
import java.util.Optional;


public interface ClienteAuthRepository extends JpaRepository<Usuario,Long>{
	Optional<Usuario> findByLogin(String login);
    boolean existsByLogin(String login);

	
}
