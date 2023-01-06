package com.gokalp.casgembootcamp.sec.controller;


import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import com.gokalp.casgembootcamp.sec.dto.SecLoginRequestDto;
import com.gokalp.casgembootcamp.sec.service.AuthenticationService;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrUserCreateRequest;
import com.gokalp.casgembootcamp.usr.dto.responses.UsrUserCreateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gokalp on 9/3/22
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto){

        String token = authenticationService.login(secLoginRequestDto);

        return ResponseEntity.ok(RestResponse.of(token));
    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsrUserCreateRequest userCreateRequest){

        UsrUserCreateResponse userCreateResponse = authenticationService.register(userCreateRequest);

        return ResponseEntity.ok(RestResponse.of(userCreateResponse));
    }
}
