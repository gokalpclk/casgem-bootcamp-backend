package com.gokalp.casgembootcamp.usr.converter;

import com.gokalp.casgembootcamp.usr.dto.requests.UsrUserCreateRequest;
import com.gokalp.casgembootcamp.usr.dto.responses.UsrUserCreateResponse;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Gokalp on 5.01.2023
 * @project casgem-bootcamp
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {
    UsrUserMapper INSTANCE  = Mappers.getMapper(UsrUserMapper.class);
    UsrUser convertToUsrUser(UsrUserCreateRequest userCreateRequest);
    UsrUserCreateResponse convertToUsrUserCreateResponse(UsrUser user);
}
