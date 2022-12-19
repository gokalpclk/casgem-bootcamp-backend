package com.gokalp.casgembootcamp.apo.converter;

import com.gokalp.casgembootcamp.apo.dto.requests.ApoApplicationCreateRequest;
import com.gokalp.casgembootcamp.apo.dto.requests.ApoApplicationUpdateRequest;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationCreateResponse;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationGetAllResponse;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationGetResponse;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationUpdateResponse;
import com.gokalp.casgembootcamp.apo.entity.ApoApplications;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantUpdateResponse;
import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Gokalp on 19.12.2022
 * @project casgem-bootcamp
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ApoApplicationConverter {
    ApoApplicationConverter INSTANCE = Mappers.getMapper(ApoApplicationConverter.class);

    ApoApplications convertToApoApplication(ApoApplicationCreateRequest applicationCreateRequest);
    ApoApplications convertToApoApplication(ApoApplicationUpdateRequest applicationUpdateRequest);
    ApoApplicationUpdateResponse convertToAppApplicantUpdateResponse(ApoApplications applications);
    ApoApplicationCreateResponse convertToApoApplicationCreateResponse(ApoApplications applications);
    List<ApoApplicationGetAllResponse> convertToListOfApoApplicationGetAllResponse(List<ApoApplications> applicationList);
    ApoApplicationGetResponse convertToApoApplicationGetResponse(ApoApplications apoApplications);

}
