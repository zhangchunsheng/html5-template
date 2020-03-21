package com.azuki.order.service.impl;


import com.azuki.order.mapper.OrderMapper;
import com.azuki.order.pojo.Ordergoodsdetail;
import com.azuki.order.pojo.Orderinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderSeriveImpl implements com.azuki.order.service.OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Orderinfo> getListById(Integer id) {

        return orderMapper.getListById(id);
    }

    public List<Orderinfo> getLIst() {
        return orderMapper.getList();
    }

    public Long selectOrderId() {
            return orderMapper.selectOrderId();
    }

    public void saveOrderInfo(Orderinfo orderinfo,String payCountString,Long orderId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = dateFormat.format(new Date());
        UUID uuid = UUID.randomUUID();
        String[] splits = uuid.toString().split("\\-");
        String uuidString = "";
        for(String split:splits){
            uuidString=uuidString + split;
        }
        orderinfo.setOrderInfoId("O" + orderId + format + uuidString);
        if ("货到付款".equals(orderinfo.getPayType())) {
            orderinfo.setStatus(0);
        } else {
            orderinfo.setStatus(1);
        }
        CharSequence charSequence = payCountString.subSequence(1, payCountString.length());
        double payCountDouble = Double.parseDouble(charSequence.toString());
        Long payCount = (long) (payCountDouble * 100);
        orderinfo.setPayCount(payCount);
        orderMapper.saveOrderInfo(orderinfo);
    }

    public Orderinfo getOrderInfoById(Long orderId) {

            return orderMapper.getOrderInfoById(orderId);

    }

    public List<Ordergoodsdetail> getOrderGoodsDetailByOrderId(String orderId) {
        long orderIdLong = Long.parseLong(orderId);
        return orderMapper.getOrderGoodsDetailByOrderId(orderIdLong);
    }

    public String getUserIdByOrderId(String orderId) {
        long orderIdLong = Long.parseLong(orderId);
        return orderMapper.getUserIdByOrderId(orderIdLong);
    }

    public List<Long> getOrderListByUserId(Long userId) {
        return orderMapper.getOrderListByUserId(userId);
    }

    public void saveOrderUser(Long orderId,Long userId) {
        orderMapper.saveOrderUser(orderId,userId);
    }
}
