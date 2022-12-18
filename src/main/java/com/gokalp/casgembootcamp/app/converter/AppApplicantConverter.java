package com.gokalp.casgembootcamp.app.converter;

import com.gokalp.casgembootcamp.app.dto.requests.AppApplicantCreateRequest;
import com.gokalp.casgembootcamp.app.dto.requests.AppApplicantUpdateRequest;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantCreateResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantGetAllResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantGetResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantUpdateResponse;
import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Gokalp on 15.12.2022
 * @project casgem-bootcamp
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AppApplicantConverter {

	AppApplicantConverter INSTANCE = Mappers.getMapper(AppApplicantConverter.class);
	List<AppApplicantGetAllResponse> convertToListOfAppApplicantGetAllResponse(List<AppApplicant> applicantList);
	AppApplicant convertToAppApplicant(AppApplicantCreateRequest applicantCreateRequest);
	AppApplicantCreateResponse convertToAppApplicantCreateResponse(AppApplicant applicant);
	AppApplicantGetResponse convertToAppApplicantGetResponse(AppApplicant applicant);
	 AppApplicant convertToAppApplicant(AppApplicantUpdateRequest applicantUpdateRequest);
	 AppApplicantUpdateResponse convertToAppApplicantUpdateResponse(AppApplicant applicant);


}
