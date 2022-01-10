/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jh.dao;

import co.com.jh.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jsherreram
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);
    
}
