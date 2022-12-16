package com.gokalp.casgembootcamp.ins.services.entityServices;

import com.gokalp.casgembootcamp.gen.services.entityServices.BaseEntityService;
import com.gokalp.casgembootcamp.ins.dao.InsInstructorDao;
import com.gokalp.casgembootcamp.ins.entity.InsInstructor;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
@Service
public class InsInstructorEntityService extends BaseEntityService<InsInstructor, InsInstructorDao> {
    public InsInstructorEntityService(InsInstructorDao dao) {
        super(dao);
    }
}
