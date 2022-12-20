package com.gokalp.casgembootcamp.apo.dao;

import com.gokalp.casgembootcamp.apo.entity.ApoApplication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
public interface ApoApplicationDao extends JpaRepository<ApoApplication, Long> {

}
