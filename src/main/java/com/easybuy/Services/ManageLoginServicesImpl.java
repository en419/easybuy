package com.easybuy.Services;

import com.easybuy.Dao.TManageMapper;
import com.easybuy.entity.TManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageLoginServicesImpl implements ManageLoginServices{
    @Autowired
    private TManageMapper tm;
    @Override
    public TManage LoginManage(String userName,String passWord) {
        TManage tmpojo=tm.LoginManage(userName);
        System.out.println("services "+tmpojo);
        System.out.println(passWord);
        if(tmpojo.getPassword().equals(passWord)){
            return tmpojo;
        }
        else
            return null;

    }
}
