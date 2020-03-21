package com.azuki.shopcart.controller;

import com.azuki.shopcart.pojo.ShopCart;
import com.azuki.shopcart.service.ShopCartService;
import com.azuki.shopcart.vo.ShopCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Jason
 * Date: 2019/4/16 12:32
 * Description: No Description
 */
@Controller
public class ShopCartController {
    @Autowired
    ShopCartService shopcartService;

//    后台往前端传值中文乱码：在@RequestMapping后面加入参数produces="text/html;charset=utf-8"

    /**
     * 根据用户id查询用户购物车
     *
     * @param userId 用户ID
     * @return 用户购物车的集合
     */
    @ResponseBody
    @RequestMapping(value = "getShopCarByUserId", method = RequestMethod.POST)
    public List<ShopCart> getShopCarByUserId(@RequestParam int userId) {
        return this.shopcartService.getShopCartByUserId(userId);
    }

    /**
     * 修改购物车信息
     *
     * @param shopCartVo shopCartVo对象
     * @return 影响行数
     */
    @ResponseBody
    @RequestMapping(value = "updateShopCart", method = RequestMethod.POST)
    public int updateShopCart(@RequestBody ShopCartVo shopCartVo) {
        return this.shopcartService.updateShopCart(shopCartVo);
    }

    /**
     * 加入购物车
     *
     * @param shopCartVo shopCartVo对象
     * @return 影响行数
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "addToShopCart", method = RequestMethod.POST)
    public int addToShopCart(@RequestBody ShopCartVo shopCartVo) {
        ShopCart shopCart = this.shopcartService.checkShopCart(shopCartVo);
        if (shopCart != null) {
            //若不是第一次加购物车则数量改变
            shopCartVo.setGoodsNum(shopCartVo.getGoodsNum() + shopCart.getGoodsNum());
            return this.shopcartService.updateShopCart(shopCartVo);
        } else {
            return this.shopcartService.addToShopCart(shopCartVo);
        }
    }

    /**
     * 移出购物车
     *
     * @param cartDetailId 购物车ID
     * @return 影响行数
     */
    @ResponseBody
    @RequestMapping(value = "removeOutShopCart", method = RequestMethod.POST)
    public int removeOutShopCart(@RequestParam int cartDetailId) {
        return this.shopcartService.removeOutShopCart(cartDetailId);
    }

    /**
     * 生成订单
     *
     * @param shopCartVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkOut", method = RequestMethod.POST)
    public String checkOut1(@RequestBody List<ShopCartVo> shopCartVo) {
        for (ShopCartVo s : shopCartVo) {
            System.out.println(s);
        }
        return "生成订单";
    }
}
