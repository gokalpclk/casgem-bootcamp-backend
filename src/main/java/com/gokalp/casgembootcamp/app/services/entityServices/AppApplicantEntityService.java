package com.gokalp.casgembootcamp.app.services.entityServices;

import com.gokalp.casgembootcamp.app.dao.AppApplicantDao;
import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import com.gokalp.casgembootcamp.gen.services.entityServices.BaseEntityService;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 15.12.2022
 * @project casgem-bootcamp
 */
@Service
public class AppApplicantEntityService extends BaseEntityService<AppApplicant, AppApplicantDao> {

	public AppApplicantEntityService(AppApplicantDao dao) {
		super(dao);
	}

}
