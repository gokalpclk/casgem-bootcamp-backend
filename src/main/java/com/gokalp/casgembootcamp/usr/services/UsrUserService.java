package com.gokalp.casgembootcamp.usr.services;

import com.gokalp.casgembootcamp.usr.converter.UsrUserMapper;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrUserCreateRequest;
import com.gokalp.casgembootcamp.usr.dto.responses.UsrUserCreateResponse;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import com.gokalp.casgembootcamp.usr.services.entityServices.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 5.01.2023
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class UsrUserService {

    private final UsrUserEntityService usrUserEntityService;
    private final PasswordEncoder passwordEncoder;

    public UsrUserCreateResponse save(UsrUserCreateRequest userCreateRequest) {
        UsrUser user = UsrUserMapper.INSTANCE.convertToUsrUser(userCreateRequest);
        user.setPassword(user.getPassword());
        user = usrUserEntityService.save(user);
        return UsrUserMapper.INSTANCE.convertToUsrUserCreateResponse(user);
    }
}
