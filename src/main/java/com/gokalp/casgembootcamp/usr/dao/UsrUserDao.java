package com.gokalp.casgembootcamp.usr.dao;

import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gokalp on 26.12.2022
 * @project casgem-bootcamp
 */
public interface UsrUserDao extends JpaRepository<UsrUser, Long> {
    UsrUser findByNationalIdentity(String nationalIdentity);
}
