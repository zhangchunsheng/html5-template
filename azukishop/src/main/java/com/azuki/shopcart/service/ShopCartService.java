package com.azuki.shopcart.service;

import com.azuki.shopcart.pojo.ShopCart;
import com.azuki.shopcart.vo.ShopCartVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/4/16 11:59
 * Description: No Description
 */
public interface ShopCartService {
    /**
     * 根据用户id查询用户购物车
     *
     * @param userId 用户ID
     * @return 用户购物车的集合
     */
    List<ShopCart> getShopCartByUserId(int userId);

    /**
     * 查询是否为第一次添加购物车
     *
     * @param shopCartVo 购物车VO对象
     * @return 查询到的条数
     */
    ShopCart checkShopCart(ShopCartVo shopCartVo);

    /**
     * 添加到购物车
     *
     * @param shopCartVo 购物车VO对象
     * @return 影响行数
     */
    int addToShopCart(ShopCartVo shopCartVo);

    /**
     * 更新购物车信息
     *
     * @param shopCartVo 购物车VO对象
     * @return 影响行数
     */
    int updateShopCart(ShopCartVo shopCartVo);

    /**
     * 移出购物车
     *
     * @param cartDetailId 购物车ID
     * @return 影响行数
     */
    int removeOutShopCart(int cartDetailId);
}
