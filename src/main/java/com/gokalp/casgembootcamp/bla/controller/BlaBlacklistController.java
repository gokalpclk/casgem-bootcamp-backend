package com.gokalp.casgembootcamp.bla.controller;

import com.gokalp.casgembootcamp.bla.dto.requests.BlaBlacklistCreateRequest;
import com.gokalp.casgembootcamp.bla.dto.requests.BlaBlacklistUpdateRequest;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistCreateResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistGetAllResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistGetResponse;
import com.gokalp.casgembootcamp.bla.dto.responses.BlaBlacklistUpdateResponse;
import com.gokalp.casgembootcamp.bla.services.BlaBlacklistService;
import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gokalp on 23.12.2022
 * @project casgem-bootcamp
 */
@RestController
@RequestMapping("/api/v1/blacklist")
@AllArgsConstructor
public class BlaBlacklistController {

    private BlaBlacklistService blacklistService;

    @GetMapping
    public ResponseEntity getAll(){
        List<BlaBlacklistGetAllResponse> blacklistGetAllResponseList = blacklistService.getAll();
        return ResponseEntity.ok(RestResponse.of(blacklistGetAllResponseList));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BlaBlacklistCreateRequest blacklistCreateRequest){
        BlaBlacklistCreateResponse blacklistCreateResponse = blacklistService.create(blacklistCreateRequest);
        return ResponseEntity.ok(RestResponse.of(blacklistCreateResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        BlaBlacklistGetResponse blacklistGetResponse = blacklistService.getById(id);
        return ResponseEntity.ok(RestResponse.of(blacklistGetResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody BlaBlacklistUpdateRequest blacklistUpdateRequest, @PathVariable Long id){
        BlaBlacklistUpdateResponse blacklistUpdateResponse = blacklistService.update(blacklistUpdateRequest, id);
        return ResponseEntity.ok(RestResponse.of(blacklistUpdateResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        blacklistService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
