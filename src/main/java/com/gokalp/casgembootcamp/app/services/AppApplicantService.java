package com.gokalp.casgembootcamp.app.services;

import com.gokalp.casgembootcamp.app.services.entityServices.AppApplicantEntityService;
import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 15.12.2022
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class AppApplicantService {

	private final AppApplicantEntityService appApplicantEntityService;

}
