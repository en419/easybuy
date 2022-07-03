package com.easybuy.Dao;

import com.easybuy.entity.TOrders;
import com.easybuy.entity.TOrdersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrdersMapper {
    long countByExample(TOrdersExample example);

    int deleteByExample(TOrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TOrders record);

    int insertSelective(TOrders record);

    List<TOrders> selectByExample(TOrdersExample example);

    TOrders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TOrders record, @Param("example") TOrdersExample example);

    int updateByExample(@Param("record") TOrders record, @Param("example") TOrdersExample example);

    int updateByPrimaryKeySelective(TOrders record);

    int updateByPrimaryKey(TOrders record);
}