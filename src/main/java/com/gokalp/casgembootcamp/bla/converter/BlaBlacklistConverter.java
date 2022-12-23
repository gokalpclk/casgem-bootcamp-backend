package com.gokalp.casgembootcamp.bla.converter;

import com.gokalp.casgembootcamp.bla.dto.requests.BlaBlacklistCreateRequest;
import com.gokalp.casgembootcamp.bla.dto.requests.BlaBlacklistUpdateRequest;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistCreateResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistGetAllResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistGetResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistUpdateResponse;
import com.gokalp.casgembootcamp.bla.entity.BlaBlacklist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Gokalp on 21.12.2022
 * @project casgem-bootcamp
 */
@Mapper(componentModel = "spring", uses = {})
public interface BlaBlacklistConverter {
    BlaBlacklistConverter INSTANCE = Mappers.getMapper(BlaBlacklistConverter.class);

    List<BlaBlacklistGetAllResponse> convertToListOfBlaBlacklistGetAllResponse(List<BlaBlacklist> blacklistsList);

    BlaBlacklistGetResponse convertToBlaBlacklistGetResponse(BlaBlacklist blacklist);

    BlaBlacklist convertToBlaBlacklist(BlaBlacklistUpdateRequest blacklistUpdateRequest);

    BlaBlacklist convertToBlaBlacklist(BlaBlacklistCreateRequest blacklistCreateRequest);

    BlaBlacklistCreateResponse convertToBlaBlacklistCreateResponse(BlaBlacklist blacklist);

    BlaBlacklistUpdateResponse convertToBlaBlacklistUpdateResponse(BlaBlacklist blacklist);

}
