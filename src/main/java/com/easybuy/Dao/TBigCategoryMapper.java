package com.easybuy.Dao;

import com.easybuy.entity.TBigCategory;
import com.easybuy.entity.TBigCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBigCategoryMapper {
    long countByExample(TBigCategoryExample example);

    int deleteByExample(TBigCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(TBigCategory record);

    int insertSelective(TBigCategory record);

    List<TBigCategory> selectByExample(TBigCategoryExample example);
    List<TBigCategory> selectAll();

    TBigCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBigCategory record, @Param("example") TBigCategoryExample example);

    int updateByExample(@Param("record") TBigCategory record, @Param("example") TBigCategoryExample example);

    int updateByPrimaryKeySelective(TBigCategory record);

    int updateByPrimaryKey(TBigCategory record);

    void deletebigfl(Integer id);
}