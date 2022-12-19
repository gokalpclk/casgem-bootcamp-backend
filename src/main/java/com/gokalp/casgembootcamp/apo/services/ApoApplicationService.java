package com.gokalp.casgembootcamp.apo.services;

import com.gokalp.casgembootcamp.apo.services.entityServices.ApoApplicationEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Gokalp on 19.12.2022
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class ApoApplicationService {
    private final ApoApplicationEntityService applicationEntityService;
}
