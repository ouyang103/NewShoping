package com.atguigu.gmall.manage.controller;

import ControllerUtils.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.AttrInfo;
import com.atguigu.gmall.bean.BaseAttrValue;
import com.atguigu.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-01 18:31
 */
@Controller
public class AttrInfoController extends BaseController {

    @Reference
    AttrService attrService;

    @RequestMapping("getAttrListByCtg3Id")
    @ResponseBody
    public List<AttrInfo> getAttrListByCtg3Id(String catalog3Id) {
        return attrService.getAttrListByCtg3Id(catalog3Id);
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<BaseAttrValue> getAttrValueList(String attrId) {

            List<BaseAttrValue> list = attrService.getAttrValueList(attrId);

        return list;
    }

    /**
     * 删除平台属性
     * @param arrId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteArrByID")
    public Object deleteArrByID(String arrId) {
        start();

        try {
            attrService.deleteArrByID(arrId);
            success(true);
        }catch (Exception e) {
            success(false);
            e.printStackTrace();
        }
        return end();
    }

    /**
     * 查询三级查询对应的所有平台属性
     * @param ctg3Id
     * @return
     */
    @RequestMapping("getArrtListData")
    @ResponseBody
    public List<AttrInfo> getArrtListData(String ctg3Id) {

        List<AttrInfo> list = attrService.getArrtListData(ctg3Id);

        return list;
    }

    /**
     * 保存三级查询所对应的平台属性
     * @param attrInfo
     * @return
     */
    @RequestMapping("saveArr")
    @ResponseBody
    public String saveArr(AttrInfo attrInfo) {

            attrService.saveArr(attrInfo);

            return "success";
    }
}
