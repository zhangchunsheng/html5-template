package com.azuki.shopcart.service.impl;

import com.azuki.shopcart.mapper.ShopCartMapper;
import com.azuki.shopcart.pojo.ShopCart;
import com.azuki.shopcart.service.ShopCartService;
import com.azuki.shopcart.vo.ShopCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/4/16 11:59
 * Description: No Description
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    ShopCartMapper shopCartMapper;

    /**
     * 根据用户id查询用户购物车
     *
     * @param userId 用户ID
     * @return 用户购物车的集合
     */
    public List<ShopCart> getShopCartByUserId(int userId) {
        return shopCartMapper.getShopCarByUserId(userId);
    }

    /**
     * 检查是否为第一次添加购物车
     *
     * @param shopCartVo 购物车VO对象
     * @return 查询的购物车对象
     */
    public ShopCart checkShopCart(ShopCartVo shopCartVo) {
        return shopCartMapper.checkShopCart(shopCartVo);
    }

    /**
     * 添加到购物车
     *
     * @param shopCartVo 购物车VO对象
     * @return 影响行数
     */
    public int addToShopCart(ShopCartVo shopCartVo) {
        return shopCartMapper.addToShopCart(shopCartVo);
    }

    /**
     * 更新购物车信息
     *
     * @param shopCartVo 购物车VO对象
     * @return 影响行数
     */
    public int updateShopCart(ShopCartVo shopCartVo) {
        return shopCartMapper.updateShopCart(shopCartVo);
    }

    /**
     * 移出购物车
     *
     * @param cartDetailId 购物车ID
     * @return 影响行数
     */
    public int removeOutShopCart(int cartDetailId) {
        return shopCartMapper.removeOutShopCart(cartDetailId);
    }
}
