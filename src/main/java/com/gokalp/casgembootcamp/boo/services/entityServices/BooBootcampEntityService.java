package com.gokalp.casgembootcamp.boo.services.entityServices;

import com.gokalp.casgembootcamp.boo.dao.BooBootcampDao;
import com.gokalp.casgembootcamp.boo.entity.BooBootcamp;
import com.gokalp.casgembootcamp.gen.services.entityServices.BaseEntityService;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 15.12.2022
 * @project casgem-bootcamp
 */
@Service
public class BooBootcampEntityService extends BaseEntityService<BooBootcamp, BooBootcampDao> {

	public BooBootcampEntityService(BooBootcampDao dao) {
		super(dao);
	}

}
