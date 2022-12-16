package com.gokalp.casgembootcamp.apo.dao;

import com.gokalp.casgembootcamp.apo.entity.ApoApplications;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
public interface ApoApplicationDao extends JpaRepository<ApoApplications, Long> {
}
