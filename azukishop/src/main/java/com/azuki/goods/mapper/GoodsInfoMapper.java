package com.azuki.goods.mapper;

import com.azuki.goods.dto.GoodsInfoDto;
import com.azuki.goods.pojo.GoodsInfo;
import com.azuki.goods.vo.GoodsInfoVo;

import java.util.List;


public interface GoodsInfoMapper {

    //查询所有goods
    public List<GoodsInfoDto> getGoodsInfoPageBy();

    //根据id查询商品
    public GoodsInfo getGoodsInfoById(int goodsId);

    //搜索
    public List<GoodsInfoDto> getGoodsInfoBy(GoodsInfo goodsInfo);

    //根据类名查询goodsInfo
    public List<GoodsInfoDto> getGoodsInfoByTypeName(GoodsInfoVo goodsInfoVo);


}
