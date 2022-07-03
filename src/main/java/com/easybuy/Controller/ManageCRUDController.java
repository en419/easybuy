package com.easybuy.Controller;

import com.easybuy.Services.ManageCRUDServices;
import com.easybuy.entity.TBigCategory;
import com.easybuy.entity.TSmallCategory;
import com.easybuy.entity.TUsers;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.util.UUID;

@Controller
public class ManageCRUDController {
    @Value("http://localhost:82/images/")
    private String hosturl;
    @Autowired
    private ManageCRUDServices manageServices;
    @RequestMapping("/manageadduser")
    public String adduser(TUsers user, MultipartFile image){
        String name = UUID.randomUUID().toString();//随机的一唯一uuid
        String oldName =image.getOriginalFilename();//上传的文件的文件名
        int pos = oldName.lastIndexOf(".");//得到文件名后缀的位置
        String fileName = name + oldName.substring(pos);//最终我们存储的文件名
        user.setImageurl(hosturl+fileName);
        try {
            image.transferTo(new File("d:/upload/images/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        manageServices.manageadduser(user);
        return "redirect:/user";
    }
    @RequestMapping("/updateuser")
    public String updateuser(TUsers user,MultipartFile image){
        if(image.getSize()!=0){
        String name = UUID.randomUUID().toString();//随机的一唯一uuid
        String oldName =image.getOriginalFilename();//上传的文件的文件名
        int pos = oldName.lastIndexOf(".");//得到文件名后缀的位置
        String fileName = name + oldName.substring(pos);//最终我们存储的文件名
        user.setImageurl(hosturl+fileName);
        try {
            image.transferTo(new File("d:/upload/images/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }}
        manageServices.updateuser(user);
        return "redirect:/user";
    }
    @RequestMapping("/userdelete")
    public String userdelete(Integer id,Integer PageNo,Integer PageSize){
        if (PageNo == null || PageNo.intValue() < 0) {
            PageNo=1;//页号默认值 为1
        }
        if(PageSize==null){ PageSize=5;//默认值5 每页5行
        }
        manageServices.userdelete(id);
        return "redirect:/user?PageNo="+PageNo+"&PageSize="+PageSize;
    }
    @RequestMapping("/productClassaddsmallcategory")
    public String productClassadd(TSmallCategory smallCategory){
        manageServices.productClassadd(smallCategory);
        return "redirect:productClass";
    }
    @RequestMapping("/modifysmall")
    public String modifysmall(Integer id, Model model){
        TBigCategory bigCategory=manageServices.selectbigcategoryByid(id);
        model.addAttribute("BigCategory",bigCategory);
        System.out.println(bigCategory);
        return "manage/productClass-modify-Small";
    }
    @RequestMapping("/deletexfl")
    public String deletexfl(Integer sid,Integer bid){
        manageServices.deletexfl(sid);
        return "redirect:modifysmall?id="+bid;
    }
    @RequestMapping("/toupdatesmallcategory")
    public String updatesmallcategory(Integer id,Integer pid,String name,String parentname,Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        model.addAttribute("parentname",parentname);
        model.addAttribute("parentId",pid);
        return "manage/productClass-modify";
    }
    @RequestMapping("/updatesmallcategory")
    public String updatesmallcategory(TSmallCategory smallCategory){
        manageServices.updatesmallcategory(smallCategory);
        System.out.println("id:"+smallCategory.getParentId());
        return "redirect:modifysmall?id="+smallCategory.getParentId();

    }
    @RequestMapping("/toproductClassaddBig")
    public String toproductClassaddBig(TBigCategory bigCategory){
        manageServices.addBigCategory(bigCategory);
        return "redirect:productClass";
    }
    @RequestMapping("/productClassaddBig")
    public String productClassaddBig(){
        return "manage/productClassaddBig";
    }
    @RequestMapping("/deletebigfl")
    public String deletebigfl(Integer id){
        manageServices.deletebigfl(id);
        return "redirect:productClass";
    }
}
