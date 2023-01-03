package com.gokalp.casgembootcamp.usr.dao;

import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gokalp on 3.01.2023
 * @project casgem-bootcamp
 */
@Repository
public interface UsrUserDao extends JpaRepository<UsrUser, Long> {
    UsrUser findByEmail(String email);
}
