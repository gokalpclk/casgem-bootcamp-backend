package com.gokalp.casgembootcamp.emp.services.entityServices;

import com.gokalp.casgembootcamp.emp.dao.EmpEmployeeDao;
import com.gokalp.casgembootcamp.emp.entity.EmpEmployee;
import com.gokalp.casgembootcamp.gen.enums.GenErrorMessage;
import com.gokalp.casgembootcamp.gen.exceptions.ItemNotFoundException;
import com.gokalp.casgembootcamp.gen.services.entityServices.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */

public class EmpEmployeeEntityService extends BaseEntityService<EmpEmployee, EmpEmployeeDao> {

    public EmpEmployeeEntityService(EmpEmployeeDao dao) {
        super(dao);
    }
}
