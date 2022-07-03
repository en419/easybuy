package com.easybuy.Dao;

import com.easybuy.entity.TSmallCategory;
import com.easybuy.entity.TSmallCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSmallCategoryMapper {
    long countByExample(TSmallCategoryExample example);

    int deleteByExample(TSmallCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSmallCategory record);

    int insertSelective(TSmallCategory record);

    List<TSmallCategory> selectByExample(TSmallCategoryExample example);

    List<TSmallCategory> selectByPrimaryKey(Integer id);
    TSmallCategory selecatoneByid(Integer id);

    int updateByExampleSelective(@Param("record") TSmallCategory record, @Param("example") TSmallCategoryExample example);

    int updateByExample(@Param("record") TSmallCategory record, @Param("example") TSmallCategoryExample example);

    void updateByPrimaryKeySelective(TSmallCategory record);

    int updateByPrimaryKey(TSmallCategory record);
}