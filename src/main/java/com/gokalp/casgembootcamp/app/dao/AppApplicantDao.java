package com.gokalp.casgembootcamp.app.dao;

import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gokalp on 15.12.2022
 * @project casgem-bootcamp
 */
public interface AppApplicantDao extends JpaRepository<AppApplicant, Long> {
}
