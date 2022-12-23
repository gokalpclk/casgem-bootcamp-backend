package com.gokalp.casgembootcamp.bla.services;

import com.gokalp.casgembootcamp.bla.converter.BlaBlacklistConverter;
import com.gokalp.casgembootcamp.bla.dto.requests.BlaBlacklistCreateRequest;
import com.gokalp.casgembootcamp.bla.dto.requests.BlaBlacklistUpdateRequest;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistCreateResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistGetAllResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistGetResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistUpdateResponse;
import com.gokalp.casgembootcamp.bla.entity.BlaBlacklist;
import com.gokalp.casgembootcamp.bla.services.entityServices.BlaBlackListEntityService;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gokalp on 23.12.2022
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class BlaBlacklistService {
    private final BlaBlackListEntityService blackListEntityService;

    public List<BlaBlacklistGetAllResponse> getAll() {
        List<BlaBlacklist> blacklistList = blackListEntityService.findAll();
        List<BlaBlacklistGetAllResponse> blacklistGetAllResponseList = BlaBlacklistConverter.INSTANCE.convertToListOfBlaBlacklistGetAllResponse(blacklistList);
        return blacklistGetAllResponseList;
    }

    public BlaBlacklistCreateResponse create(BlaBlacklistCreateRequest blacklistCreateRequest) {
        BlaBlacklist blacklist = BlaBlacklistConverter.INSTANCE.convertToBlaBlacklist(blacklistCreateRequest);
        blacklist = blackListEntityService.save(blacklist);
        BlaBlacklistCreateResponse blacklistCreateResponse = BlaBlacklistConverter.INSTANCE.convertToBlaBlacklistCreateResponse(blacklist);
        return blacklistCreateResponse;
    }

    public BlaBlacklistGetResponse getById(Long id) {
        BlaBlacklist blacklist = blackListEntityService.getByIdWithControl(id);
        BlaBlacklistGetResponse blacklistGetResponse = BlaBlacklistConverter.INSTANCE.convertToBlaBlacklistGetResponse(blacklist);
        return blacklistGetResponse;
    }

    public BlaBlacklistUpdateResponse update(BlaBlacklistUpdateRequest blacklistUpdateRequest, Long id) {
        BlaBlacklist blacklist = BlaBlacklistConverter.INSTANCE.convertToBlaBlacklist(blacklistUpdateRequest);
        blacklist.setId(id);
        blacklist = blackListEntityService.save(blacklist);
        BlaBlacklistUpdateResponse blacklistUpdateResponse = BlaBlacklistConverter.INSTANCE.convertToBlaBlacklistUpdateResponse(blacklist);
        return blacklistUpdateResponse;
    }

    public void delete(Long id){
        BlaBlacklist blacklist = blackListEntityService.getByIdWithControl(id);
        blackListEntityService.delete(blacklist);
    }
}
