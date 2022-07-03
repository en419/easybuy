package com.easybuy.Dao;

import com.easybuy.entity.TUsers;
import com.easybuy.entity.TUsersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TUsersMapper {
    int countByExample();

    int deleteByExample(TUsersExample example);

    int deleteByPrimaryKey(Integer id);

    void insert(TUsers record);

    int insertSelective(TUsers record);

    List<TUsers> selectByExample(TUsersExample example);

    List<TUsers> selectAllByIdTUsers(Map<String,Integer> map);

    TUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUsers record, @Param("example") TUsersExample example);

    int updateByExample(@Param("record") TUsers record, @Param("example") TUsersExample example);

    int updateByPrimaryKeySelective(TUsers record);

    void updateByPrimaryKey(TUsers record);
}