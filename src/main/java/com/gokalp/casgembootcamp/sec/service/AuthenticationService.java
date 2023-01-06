package com.gokalp.casgembootcamp.sec.service;


import com.gokalp.casgembootcamp.sec.dto.SecLoginRequestDto;
import com.gokalp.casgembootcamp.sec.enums.EnumJwtConstant;
import com.gokalp.casgembootcamp.sec.security.JwtTokenGenerator;
import com.gokalp.casgembootcamp.sec.security.JwtUserDetails;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrUserCreateRequest;
import com.gokalp.casgembootcamp.usr.dto.responses.UsrUserCreateResponse;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import com.gokalp.casgembootcamp.usr.services.UsrUserService;
import com.gokalp.casgembootcamp.usr.services.entityServices.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 9/3/22
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsrUserService userService;

    private final UsrUserEntityService userEntityService;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public UsrUserCreateResponse register(UsrUserCreateRequest cusCustomerSaveRequestDto) {

        UsrUserCreateResponse userCreateResponse = userService.save(cusCustomerSaveRequestDto);

        return userCreateResponse;
    }

    public String login(SecLoginRequestDto secLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(secLoginRequestDto.getEmail(), secLoginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String bearer = EnumJwtConstant.BEARER.getConstant();

        return bearer + token;
    }

    public UsrUser getCurrentUser() {

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        UsrUser user = null;
        if (jwtUserDetails != null){
            user = userEntityService.getByIdWithControl(jwtUserDetails.getId());
        }

        return user;
    }

    public Long getCurrentCustomerId(){

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        Long jwtUserDetailsId = null;
        if (jwtUserDetails != null){
            jwtUserDetailsId = jwtUserDetails.getId();
        }

        return jwtUserDetailsId;
    }

    private JwtUserDetails getCurrentJwtUserDetails() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails){
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }
        return jwtUserDetails;
    }
}
