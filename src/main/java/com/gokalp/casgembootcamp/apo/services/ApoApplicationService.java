package com.gokalp.casgembootcamp.apo.services;

import com.gokalp.casgembootcamp.apo.converter.ApoApplicationConverter;
import com.gokalp.casgembootcamp.apo.dto.requests.ApoApplicationCreateRequest;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationCreateResponse;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationGetAllResponse;
import com.gokalp.casgembootcamp.apo.entity.ApoApplication;
import com.gokalp.casgembootcamp.apo.services.entityServices.ApoApplicationEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gokalp on 19.12.2022
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class ApoApplicationService {
    private final ApoApplicationEntityService applicationEntityService;

    public List<ApoApplicationGetAllResponse> getAll(){
        List<ApoApplication> applicationList = applicationEntityService.findAll();
        List<ApoApplicationGetAllResponse> applicationGetAllResponseList = ApoApplicationConverter.INSTANCE.convertToListOfApoApplicationGetAllResponse(applicationList);
        return applicationGetAllResponseList;
    }

    public ApoApplicationCreateResponse create(ApoApplicationCreateRequest applicationCreateRequest){
        //todo: add jwt
        ApoApplication application = ApoApplicationConverter.INSTANCE.convertToApoApplication(applicationCreateRequest);
        application = applicationEntityService.save(application);
        ApoApplicationCreateResponse applicationCreateResponse = ApoApplicationConverter.INSTANCE.convertToApoApplicationCreateResponse(application);
        return applicationCreateResponse;

    }
}
