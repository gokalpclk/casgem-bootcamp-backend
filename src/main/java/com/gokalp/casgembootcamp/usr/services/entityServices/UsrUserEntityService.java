package com.gokalp.casgembootcamp.usr.services.entityServices;

import com.gokalp.casgembootcamp.gen.services.entityServices.BaseEntityService;
import com.gokalp.casgembootcamp.usr.dao.UsrUserDao;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 3.01.2023
 * @project casgem-bootcamp
 */
@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {


    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }

    public UsrUser findByEmail(String email){
        return getDao().findByEmail(email);
    }
}
