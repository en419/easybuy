package com.easybuy.Controller;

import com.easybuy.Services.ManageCRUDServices;
import com.easybuy.entity.TBigCategory;
import com.easybuy.entity.TProduct;
import com.easybuy.entity.TSmallCategory;
import com.easybuy.entity.TUsers;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManageController {
    @Autowired
    private ManageCRUDServices manageServices;
    @RequestMapping("/topageindex")
    public String topageindex(){
        return "index";
    }
    @RequestMapping("/user")
    public String user(Model model,Integer PageNo,Integer PageSize){
        if (PageNo == null || PageNo.intValue() < 0) {
            PageNo=1;//页号默认值 为1
        }
        if(PageSize==null){ PageSize=5;//默认值5 每页5行
        }
        Map<String,Integer> map=new HashMap<>();
        map.put("offset",(PageNo-1)*PageSize);
        map.put("PageSize",PageSize);
        List<TUsers> usersList=manageServices.scanuser(map);
        int totalRows = manageServices.countByExample(); //计算总页数
        System.out.println("总行数："+totalRows);
        int totalPages = totalRows / PageSize;//总页数 = 总行数/每页行数
        if(totalRows%PageSize>0){
            totalPages ++;//如果有余数 总页数加1
        }
        model.addAttribute("PageNo", PageNo);
        model.addAttribute("PageSize", PageSize);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("userlist",usersList);
        return "manage/user";
    }
    @RequestMapping("/product")
    public String product(Model model){
        List<TProduct> products=manageServices.selectAllproduct();
        model.addAttribute("products",products);
        return "manage/product";
    }
    @RequestMapping("/order")
    public String order(){
        return "manage/order";
    }
    @RequestMapping("/manageguestbook")
    public String guestbook(){
        return "manage/guestbook";
    }
    @RequestMapping("/news")
    public String news(){
        return "manage/news";
    }
    @RequestMapping("/tomanage")
    public String tomanage(){
        return "manage/index";
    }

    @RequestMapping("/useradd")
    public String useradd(){
        return "manage/user-add";
    }
    @RequestMapping("/productClassadd")
    //新增小分类
    public String productClassadd(Integer id,Model model){
        List<TBigCategory> tBigCategories= manageServices.selectAllbigcategory();
        model.addAttribute("Bigcategory",tBigCategories);
        model.addAttribute("Id",id);
        return "manage/productClass-add";
    }
    //分类管理
    @RequestMapping("/productClass")
    public String productClass(Model model){
        List<TBigCategory> tBigCategories= manageServices.selectAllbigcategory();
        model.addAttribute("Bigcategory",tBigCategories);
        List<TSmallCategory> tSmallCategories=new ArrayList<>();
        for(int i=0;i<tBigCategories.size();i++){
            int len=tBigCategories.get(i).getSmallCategorys().size();
            for(int j=0;j<len;j++){
                tSmallCategories.add(tBigCategories.get(i).getSmallCategorys().get(j));
            }
        }
        model.addAttribute("Smallcategory",tSmallCategories);
        System.out.println(tSmallCategories);
        return "manage/productClass";
    }
    @RequestMapping("/productadd")
    public String productadd(){
        return "manage/product-add";
    }
    @RequestMapping("/newsadd")
    public String newsadd(){
        return "manage/news-add";
    }
    @RequestMapping("/tomanagelogin")
    public String managelogin(){
        return "manage/login";
    }
    @RequestMapping("/usermodify")
    public String usermodify(Integer id, Model model){
       TUsers user= manageServices.usermodify(id);
       model.addAttribute("user",user);
        return "manage/user-modify";
    }
}
