package com.gokalp.casgembootcamp.ins.dao;

import com.gokalp.casgembootcamp.ins.entity.InsInstructor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
public interface InsInstructorDao extends JpaRepository<InsInstructor, Long> {
}
