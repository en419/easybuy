package com.easybuy.Services;

import com.easybuy.entity.*;

import java.util.List;
import java.util.Map;

public interface ManageCRUDServices {
    List<TUsers> scanuser(Map<String,Integer> map);
    void manageadduser(TUsers user);
    TUsers usermodify(Integer id);

    void updateuser(TUsers user);

    void userdelete(Integer id);

    int countByExample();

    List<TBigCategory> selectAllbigcategory();

    void productClassadd(TSmallCategory smallCategory);

    TBigCategory selectbigcategoryByid(Integer id);

    void deletexfl(Integer id);

    TSmallCategory selectsmallcategoryByid(Integer id);

    void updatesmallcategory(TSmallCategory smallCategory);

    void addBigCategory(TBigCategory bigCategory);

    void deletebigfl(Integer id);

    List<TProduct> selectAllproduct();
}
