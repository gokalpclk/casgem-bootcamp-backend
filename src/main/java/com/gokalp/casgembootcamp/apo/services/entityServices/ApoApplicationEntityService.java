package com.gokalp.casgembootcamp.apo.services.entityServices;

import com.gokalp.casgembootcamp.apo.dao.ApoApplicationDao;
import com.gokalp.casgembootcamp.apo.entity.ApoApplications;
import com.gokalp.casgembootcamp.gen.services.entityServices.BaseEntityService;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
@Service
public class ApoApplicationEntityService extends BaseEntityService<ApoApplications, ApoApplicationDao> {

	public ApoApplicationEntityService(ApoApplicationDao dao) {
		super(dao);
	}

}
