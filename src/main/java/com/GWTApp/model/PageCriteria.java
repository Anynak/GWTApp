package com.GWTApp.model;

import lombok.Data;

@Data
public class PageCriteria {
    private int pageNumber = 1;
    private int pageSize = 10;
}
