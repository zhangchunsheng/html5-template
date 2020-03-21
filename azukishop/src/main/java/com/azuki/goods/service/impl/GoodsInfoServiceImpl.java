package com.azuki.goods.service.impl;

import com.azuki.goods.dto.GoodsInfoDto;
import com.azuki.goods.mapper.GoodsInfoMapper;
import com.azuki.goods.pojo.GoodsInfo;
import com.azuki.goods.service.GoodsInfoService;
import com.azuki.goods.vo.GoodsInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    GoodsInfoMapper goodsInfoMapper;

    /**
     * 分页展示商品
     * @return GoodsInfoDto集合
     */
    public List<GoodsInfoDto> getGoodsInfoPageBy() {
        return this.goodsInfoMapper.getGoodsInfoPageBy();
    }



    /**
     * 根据id查询商品信息
     * @param goodsId
     * @return GoodsInfo
     */
    public GoodsInfo getGoodsInfoById(int goodsId) {
        return this.goodsInfoMapper.getGoodsInfoById(goodsId);
    }




    /**
     * 根据"goodsName"和"brandName"进行模糊搜索
     * @param goodsInfo
     * @return List<GoodsInfo>
     */
    public List<GoodsInfoDto> getGoodsInfoBy(GoodsInfo goodsInfo) {
        return this.goodsInfoMapper.getGoodsInfoBy(goodsInfo);
    }

    /**
     * 根据类别名进行搜索
     * @param goodsInfoVo
     * @return List<GoodsInfoDto>
     */
    public List<GoodsInfoDto> getGoodsInfoByTypeName(GoodsInfoVo goodsInfoVo) {
        return this.goodsInfoMapper.getGoodsInfoByTypeName(goodsInfoVo);
    }


}
