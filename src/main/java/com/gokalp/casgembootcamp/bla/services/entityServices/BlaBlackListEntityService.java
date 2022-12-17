package com.gokalp.casgembootcamp.bla.services.entityServices;

import com.gokalp.casgembootcamp.bla.dao.BlaBlacklistDao;
import com.gokalp.casgembootcamp.bla.entity.BlaBlacklist;
import com.gokalp.casgembootcamp.gen.services.entityServices.BaseEntityService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gokalp on 15.12.2022
 * @project casgem-bootcamp
 */
public class BlaBlackListEntityService extends BaseEntityService<BlaBlacklist, BlaBlacklistDao> {

	public BlaBlackListEntityService(BlaBlacklistDao dao) {
		super(dao);
	}

}
