/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.repository;

import com.fuimonosapp.domain.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author Javier
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findOneByUsername(String username);

    public Usuario findOneByEmail(String email);

    public Usuario findOneByCelular(String celular);

    public Usuario findByUsernameAndPass(String username, String password);

    public Usuario findByUsername(String username);
    
    @Override
    public Page<Usuario> findAll(Pageable pageable);

    @Query( value = "select * from usuario "+
            "where nombre ilike '%' || :searchWord || '%' "+
            "or apellido ilike '%' || :searchWord || '%' "+
            "or username ilike '%' || :searchWord || '%' "+
            "or correo_electronico ilike '%' || :searchWord || '%' ",
            nativeQuery = true,
            countQuery = "select count(*) from usuario "+
            "where nombre ilike '%' || :searchWord || '%' "+
            "or apellido ilike '%' || :searchWord || '%' "+
            "or username ilike '%' || :searchWord || '%' "+
            "or correo_electronico ilike '%' || :searchWord || '%' ?#{#pageable}")
    public Page<Usuario> findAllBySearchWord(@Param("searchWord")String searchWord, Pageable page);

}
