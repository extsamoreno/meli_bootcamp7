package com.muelitas.demo.services.enums;

public enum StatusEnum {
    FINALIZED(1L),
    CANCELLED(2L),
    PENDING(3L),
    REPROGRAMMED(4L);

    private Long value;

    StatusEnum(Long value) {
        this.value = value;
    }

    public Long getValue(){
        return this.value;
    }

}
