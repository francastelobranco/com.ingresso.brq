package com.brqingresso.usuario.dataprovider.repository;

import com.brqingresso.usuario.dataprovider.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    boolean existsByCpf(String cpf);
}
