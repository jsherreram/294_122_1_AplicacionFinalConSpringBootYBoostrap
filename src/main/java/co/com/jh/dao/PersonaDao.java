/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jh.dao;

import co.com.jh.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jsherreram
 */
public interface PersonaDao extends JpaRepository<Persona, Long> {
    
}
