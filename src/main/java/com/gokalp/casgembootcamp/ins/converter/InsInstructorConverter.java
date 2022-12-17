package com.gokalp.casgembootcamp.ins.converter;

import com.gokalp.casgembootcamp.ins.dto.requests.InsInstructorCreateRequest;
import com.gokalp.casgembootcamp.ins.dto.requests.InsInstructorUpdateRequest;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorCreateResponse;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorGetAllResponse;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorGetResponse;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorUpdateResponse;
import com.gokalp.casgembootcamp.ins.entity.InsInstructor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Gokalp on 16.12.2022
 * @project casgem-bootcamp
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InsInstructorConverter {

	InsInstructorConverter INSTANCE = Mappers.getMapper(InsInstructorConverter.class);

	InsInstructor convertToInsInstructor(InsInstructorCreateRequest insInstructorCreateRequest);

	InsInstructorCreateResponse convertToInsInstructorCreateResponse(InsInstructor insInstructor);

	List<InsInstructorGetAllResponse> convertToListOfInsInstructorGetAllResponse(List<InsInstructor> instructorList);

	InsInstructorGetResponse convertToInsInstructorGetResponse(InsInstructor insInstructor);

	InsInstructor convertToInsInstructor(InsInstructorUpdateRequest insInstructorUpdateRequest);

	InsInstructorUpdateResponse convertToInsInstructorUpdateResponse(InsInstructor insInstructor);

}
