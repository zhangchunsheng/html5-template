package com.azuki.goods.controller;

import com.azuki.goods.dto.GoodsInfoDto;
import com.azuki.goods.pojo.GoodsInfo;
import com.azuki.goods.service.GoodsInfoService;
import com.azuki.goods.vo.GoodsInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GoodsInfoController {

    @Autowired
    GoodsInfoService goodsInfoService;


    /**
     * 分页展示信息
     * @param goodsInfoVo
     * @return goodsPageInfo分页信息
     */
    @RequestMapping(value = "/getGoodsInfoPageBy",method = RequestMethod.POST)
    @ResponseBody
    public Object getGoodsInfoPageBy(@RequestBody(required = false) GoodsInfoVo goodsInfoVo) {
        PageHelper.startPage(goodsInfoVo.getCurrentPage(),15);
        List<GoodsInfoDto> goodsInfos = this.goodsInfoService.getGoodsInfoPageBy();
        PageInfo<GoodsInfoDto> goodsPageInfo = new PageInfo<GoodsInfoDto>(goodsInfos);
        return goodsPageInfo;

    }


    /**
     * 商品详情
     * @param goodsInfo
     * @return goodsInfo商品对象
     */
    @RequestMapping(value = "/getGoodsInfoById")
    @ResponseBody
    public Object getGoodsInfoById(@RequestBody(required = false)GoodsInfo goodsInfo) {

        return this.goodsInfoService.getGoodsInfoById( goodsInfo.getGoodsId());
    }

    /**
     * 搜索
     * @param goodsInfovo
     * @return goodsPageInfo
     */

    @RequestMapping(value = "/getGoodsInfoBy",method = RequestMethod.POST)
    @ResponseBody
    public Object getGoodsInfoBy(@RequestBody(required = false) GoodsInfoVo goodsInfovo) {
        PageHelper.startPage(goodsInfovo.getCurrentPage(),15);
        List<GoodsInfoDto> goodsInfos = this.goodsInfoService.getGoodsInfoBy(goodsInfovo.getGoodsInfo());
        PageInfo<GoodsInfoDto> goodsPageInfo = new PageInfo<GoodsInfoDto>(goodsInfos);
        return goodsPageInfo;
    }

    /**
     * 根据类别名查询商品信息
     * @param goodsInfoVo
     * @return goodsPageInfo
     */
    @ResponseBody
    @RequestMapping(value = "/getGoodsInfoByTypeName")
    public Object getGoodsInfoByTypeName(@RequestBody(required = false) GoodsInfoVo goodsInfoVo) {
        PageHelper.startPage(goodsInfoVo.getCurrentPage(),15);
        List<GoodsInfoDto> goodsInfos = this.goodsInfoService.getGoodsInfoByTypeName(goodsInfoVo);
        PageInfo<GoodsInfoDto> goodsPageInfo = new PageInfo<GoodsInfoDto>(goodsInfos);
        return goodsPageInfo;
    }
}
