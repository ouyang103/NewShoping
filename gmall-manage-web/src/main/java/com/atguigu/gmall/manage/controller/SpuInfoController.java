package com.atguigu.gmall.manage.controller;

import ControllerUtils.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.utils.MyUploadUtil;
import com.atguigu.gmall.service.SpuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author yufei
 * @create 2018-08-03 16:22
 */
@Controller
public class SpuInfoController extends BaseController {

    @Reference
    SpuInfoService spuInfoService;

    @RequestMapping("getSaleAttrListBySpuId")
    @ResponseBody
    public List<SpuSaleAttr> getSaleAttrListBySpuId(String spuId) {
        List<SpuSaleAttr> list = spuInfoService.getSaleAttrListBySpuId(spuId);
        return list;
    }

    @ResponseBody
    @RequestMapping("getSpuImageListBySpuId")
    public List<SpuImage> getSpuImageListBySpuId(String spuId) {
        List<SpuImage> spuImageListBySpuId = spuInfoService.getSpuImageListBySpuId(spuId);
        return spuImageListBySpuId;
    }

    /**
     *文件上传
     * @return
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value = "file") MultipartFile file) {

        String url = MyUploadUtil.uploadImage(file);

        return url;
    }

    @RequestMapping("/getSpuListData")
    @ResponseBody
    public List<SpuInfo> getSpuListData(String ctg3Id) {
        return spuInfoService.getSpuListData(ctg3Id);
    }

    @RequestMapping("/getSaleValeName")
    @ResponseBody
    public List<BaseSaleAttr> getSaleValeName() {
        return spuInfoService.getSaleValeName();
    }

    @ResponseBody
    @RequestMapping("/saveSpu")
    public Object saveSpu(SpuInfo spuInfo) {
        start();
        try {
           spuInfoService.saveSpu(spuInfo);
            success(true);
        }catch (Exception e) {
            success(false);
            e.printStackTrace();
        }

        return end();
    }
}
