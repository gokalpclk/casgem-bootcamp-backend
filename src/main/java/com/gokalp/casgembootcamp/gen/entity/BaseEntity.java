package com.gokalp.casgembootcamp.gen.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel, Cloneable, Serializable {

    private static final Long seralVersionUID = 1L;

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
