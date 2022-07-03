package com.easybuy.Services;

import com.easybuy.Dao.TBigCategoryMapper;
import com.easybuy.Dao.TProductMapper;
import com.easybuy.Dao.TSmallCategoryMapper;
import com.easybuy.Dao.TUsersMapper;
import com.easybuy.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Target;
import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

@Service
public class ManageCRUDServicesImpl implements ManageCRUDServices{
    @Autowired
    private TUsersMapper usersMapper;
    @Autowired
    private TBigCategoryMapper bigCategoryMapper;
    @Autowired
    private TSmallCategoryMapper smallCategoryMapper;
    @Autowired
    private TProductMapper productMapper;

    @Transactional
    @Override
    public void updatesmallcategory(TSmallCategory smallCategory) {
        smallCategoryMapper.updateByPrimaryKeySelective(smallCategory);
    }

    @Override
    public TSmallCategory selectsmallcategoryByid(Integer id) {
       TSmallCategory smallCategory= smallCategoryMapper.selecatoneByid(id);
        return smallCategory;
    }

    @Transactional
    @Override
    public void deletexfl(Integer id) {
        smallCategoryMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    @Override
    public TBigCategory selectbigcategoryByid(Integer id) {
        TBigCategory bigCategory=bigCategoryMapper.selectByPrimaryKey(id);
        return bigCategory;
    }

    @Transactional
    @Override
    public List<TProduct> selectAllproduct() {
        List<TProduct> products =productMapper.selectAllProducts();
        return products;
    }

    @Transactional
    @Override
    public void deletebigfl(Integer id) {
        bigCategoryMapper.deletebigfl(id);
    }

    @Transactional
    @Override
    public void addBigCategory(TBigCategory bigCategory) {
        bigCategoryMapper.insert(bigCategory);
    }

    @Transactional
    @Override
    public void productClassadd(TSmallCategory smallCategory) {
        smallCategoryMapper.insert(smallCategory);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TBigCategory> selectAllbigcategory() {
        List<TBigCategory> tBigCategories=bigCategoryMapper.selectAll();
        return tBigCategories;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TUsers> scanuser(Map<String,Integer> map) {
        List<TUsers> usersList=usersMapper.selectAllByIdTUsers(map);
        return usersList;
    }

    @Override
    public void manageadduser(TUsers user) {
        usersMapper.insert(user);
    }
    @Transactional(readOnly = true)
    @Override
    public TUsers usermodify(Integer id) {
        TUsers user=usersMapper.selectByPrimaryKey(id);
        return user;
    }

    @Transactional
    @Override
    public void updateuser(TUsers user) {
        usersMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    @Override
    public void userdelete(Integer id) {
        usersMapper.deleteByPrimaryKey(id);
    }
   @Transactional(readOnly = true)
    @Override
    public int countByExample() {
        int num=usersMapper.countByExample();
        return num;
    }
}
