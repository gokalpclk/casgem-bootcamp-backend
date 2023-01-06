package com.gokalp.casgembootcamp.sec.enums;

/**
 * @author Gokalp on 9/4/22
 */
public enum EnumJwtConstant {
    BEARER("Bearer ");

    private String constant;

    EnumJwtConstant(String constant) {

        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }


    @Override
    public String toString() {
        return constant;
    }
}
