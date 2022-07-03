package com.easybuy.entity;

import lombok.Data;

import java.util.List;

@Data
public class TBigCategory {
    private Integer id;

    private String name;

    private List<TSmallCategory> smallCategorys;
}