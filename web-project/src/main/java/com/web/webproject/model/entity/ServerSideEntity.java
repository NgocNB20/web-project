package com.web.webproject.model.entity;

import lombok.Data;

@Data
public class ServerSideEntity {

    private Integer size = 50;

    private Integer page = 1;

    private String sortBy;

    private Boolean sortDesc;
}
