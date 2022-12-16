package com.gokalp.casgembootcamp.emp.dao;

import com.gokalp.casgembootcamp.emp.entity.EmpEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpEmployeeDao extends JpaRepository<EmpEmployee, Long> {
}
