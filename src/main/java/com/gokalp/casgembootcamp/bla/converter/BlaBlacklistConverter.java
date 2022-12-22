package com.gokalp.casgembootcamp.bla.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Gokalp on 21.12.2022
 * @project casgem-bootcamp
 */
@Mapper(componentModel = "spring", uses = {})
public interface BlaBlacklistConverter {
    BlaBlacklistConverter INSTANCE = Mappers.getMapper(BlaBlacklistConverter.class);
}
