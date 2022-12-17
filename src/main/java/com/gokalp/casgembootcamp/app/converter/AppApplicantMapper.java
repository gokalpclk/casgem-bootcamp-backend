package com.gokalp.casgembootcamp.app.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Gokalp on 15.12.2022
 * @project casgem-bootcamp
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AppApplicantMapper {

	AppApplicantMapper INSTANCE = Mappers.getMapper(AppApplicantMapper.class);

}
