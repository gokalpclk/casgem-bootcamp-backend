package com.gokalp.casgembootcamp.apo.converter;

import com.gokalp.casgembootcamp.apo.dto.requests.ApoApplicationCreateRequest;
import com.gokalp.casgembootcamp.apo.dto.requests.ApoApplicationUpdateRequest;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationCreateResponse;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationGetAllResponse;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationGetResponse;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationUpdateResponse;
import com.gokalp.casgembootcamp.apo.entity.ApoApplication;
import com.gokalp.casgembootcamp.apo.services.entityServices.ApoApplicationEntityService;
import com.gokalp.casgembootcamp.boo.services.entityServices.BooBootcampEntityService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Gokalp on 19.12.2022
 * @project casgem-bootcamp
 */
@Mapper(componentModel = "spring", uses = {ApoApplicationEntityService.class, BooBootcampEntityService.class})
public interface ApoApplicationConverter {
    ApoApplicationConverter INSTANCE = Mappers.getMapper(ApoApplicationConverter.class);

    ApoApplication convertToApoApplication(ApoApplicationCreateRequest applicationCreateRequest);
    ApoApplication convertToApoApplication(ApoApplicationUpdateRequest applicationUpdateRequest);
    ApoApplicationUpdateResponse convertToAppApplicantUpdateResponse(ApoApplication applications);
    ApoApplicationCreateResponse convertToApoApplicationCreateResponse(ApoApplication applications);
    List<ApoApplicationGetAllResponse> convertToListOfApoApplicationGetAllResponse(List<ApoApplication> applicationList);
    ApoApplicationGetResponse convertToApoApplicationGetResponse(ApoApplication apoApplication);

}
