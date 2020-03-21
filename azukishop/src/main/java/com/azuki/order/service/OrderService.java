package com.azuki.order.service;

import com.azuki.order.pojo.Ordergoodsdetail;
import com.azuki.order.pojo.Orderinfo;

import java.util.List;

public interface OrderService {

    public List<Orderinfo> getListById(Integer id);

    /**
     * 获取所有的订单信息
     * @return
     */
    List<Orderinfo> getLIst();

    /**
     * 查询订单最大id
     * @return
     */
    Long selectOrderId();
    /**
     * 保存订单信息
     */
    void saveOrderInfo(Orderinfo orderinfo,String payCountString,Long orderId);

    /**
     * 根据订单编号查询订单信息
     */
    Orderinfo getOrderInfoById(Long orderId);
    /**
     * 根据订单ID获取订单商品信息
     * @param orderId
     * @return
     */
    List<Ordergoodsdetail> getOrderGoodsDetailByOrderId(String orderId);
    /**
     * 根据orderId查询UserId
     * @return
     */
    String getUserIdByOrderId(String orderId);

    /**
     * 根据UserId查询对应的所有订单Id
     * @return
     */
    List<Long> getOrderListByUserId(Long userId);

    /**
     * 保存用户订单表数据
     */
    void saveOrderUser(Long userId,Long orderId);

}
