package com.azuki.order.mapper;

import com.azuki.order.pojo.Ordergoodsdetail;
import com.azuki.order.pojo.Orderinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderMapper {

    /**
     * 根据Id查询指定订单信息
     * @param orderId
     * @return
     */
     List<Orderinfo> getListById(Integer orderId);
    /**
     * 获取所有订单信息
     */
    List<Orderinfo> getList();

    /**
     * 指定Id增加订单信息
     */
    void insertOrderInfoById();

    /**
     * 指定Id删除订单信息
     */
    void deleteOrderInfoById(Integer orderId);

    /**
     * 指定id修改订单信息
     */
     void updateOrderInfoById(Integer orderId);

    /**
     * 查询最大OrderId
     * @return
     */
    Long selectOrderId();
    /**
     * 保存订单信息
     */
    void saveOrderInfo(Orderinfo orderinfo);
    /**
     * 根据订单编号查询订单信息
     */
    Orderinfo getOrderInfoById(Long orderId);

    /**
     * 根据订单ID获取订单商品信息
     * @param orderId
     * @return
     */
    List<Ordergoodsdetail> getOrderGoodsDetailByOrderId(Long orderId);

    /**
     * 根据orderId查询UserId
     * @return
     */
    String getUserIdByOrderId(Long orderId);
    /**
     * 根据UserId查询对应的所有订单Id
     * @return
     */
    List<Long> getOrderListByUserId(Long userId);
    /**
     * 保存用户订单表数据
     */
    void saveOrderUser(@Param("orderId") Long orderId,@Param("userId")Long userId);

}