package com.azuki.goods.service;

import com.azuki.goods.dto.GoodsInfoDto;
import com.azuki.goods.pojo.GoodsInfo;
import com.azuki.goods.vo.GoodsInfoVo;

import java.util.List;

public interface GoodsInfoService {

    public List<GoodsInfoDto> getGoodsInfoPageBy();

    public GoodsInfo getGoodsInfoById(int goodsId);

    public List<GoodsInfoDto> getGoodsInfoBy(GoodsInfo goodsInfo);

    public List<GoodsInfoDto> getGoodsInfoByTypeName(GoodsInfoVo goodsInfoVo);

}
