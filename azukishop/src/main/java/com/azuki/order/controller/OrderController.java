package com.azuki.order.controller;


import com.azuki.order.vo.OrderGoodsDetail;
import com.azuki.order.pojo.Ordergoodsdetail;
import com.azuki.order.pojo.Orderinfo;
import com.azuki.order.service.OrderService;
import com.azuki.user.pojo.Userinfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;


    /**
     * 依据Id获取订单信息
     *
     * @return
     */
    @GetMapping("getOrderInfoById")
    public String getOrderInfoById(String orderId) {
        String json = null;
        Orderinfo orderinfo = orderService.getOrderInfoById(Long.parseLong(orderId));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(orderinfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 保存订单数据
     *
     * @param orderinfo
     * @param payCountString
     */
    @PostMapping("saveOrderInfo")
    public String saveOrderInfo(Orderinfo orderinfo, String payCountString, HttpSession session) {
        Userinfo userInfo = (Userinfo) session.getAttribute("UserInfo");
        if (userInfo == null) {
            userInfo = new Userinfo();
            userInfo.setUserId((long) 1);
        }
        Long orderId = selectOrderId() + 1;
        orderinfo.setOrderId(orderId);
        orderService.saveOrderInfo(orderinfo, payCountString, orderId);
        orderService.saveOrderUser(orderId, userInfo.getUserId());
        return orderId + "";

    }

    /**
     * 查询最大orderId
     */
    public Long selectOrderId() {
        Long orderId = orderService.selectOrderId();
        return orderId;
    }

    /**
     * 根据订单Id获取订单商品信息
     *
     * @param orderId
     * @return
     */
    @GetMapping("getOrderGoodsDetailByOrderId")
    public String getOrderGoodsDetailByOrderId(String orderId) {
        List<Ordergoodsdetail> orderGoodsDetailInfo = orderService.getOrderGoodsDetailByOrderId(orderId);
        if (orderGoodsDetailInfo != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = null;
            try {
                json = objectMapper.writeValueAsString(orderGoodsDetailInfo);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return json;
        }
        return null;
    }

    /**
     * 保存订单商品信息
     */
    @PostMapping("saveOrderGoodsInfo")
    public String saveOrderGoodsInfo(String orderGoodsInfo) {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderGoodsDetail orderGoodsDetailDto = null;
        try {
            orderGoodsDetailDto = objectMapper.readValue(orderGoodsInfo, OrderGoodsDetail.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "1";
    }


    /**
     * 通过userId查询该用户所有的订单信息
     *
     * @param
     * @return
     */
    @GetMapping("getOrderInfoByUserId")
    public String getOrderInfoByUserId(HttpSession session) {
        Userinfo userInfo = (Userinfo) session.getAttribute("UserInfo");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = dateFormat.format(new java.util.Date());
        int newTime = Integer.parseInt(format);
        if (userInfo == null) {
            userInfo = new Userinfo();
            userInfo.setUserId((long) 1);
        }
        List<Long> orderListByUserId = orderService.getOrderListByUserId(userInfo.getUserId());
        ArrayList<Orderinfo> orderinfos = new ArrayList<Orderinfo>();
        for (int i = orderListByUserId.size() - 1; i > -1; i--) {
            Orderinfo orderInfoById = orderService.getOrderInfoById(orderListByUserId.get(i));
            Date created_date = orderInfoById.getCreated_date();
            String format1 = dateFormat.format(created_date);
            if (newTime - Integer.parseInt(format1) < 30) {
                orderinfos.add(orderInfoById);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(orderinfos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 从session获取数据进行渲染
     */
    @GetMapping("getOrderGoodsBySession")
    public String getOrderGoodsBySession(HttpSession session) {
        Object orderGoods = session.getAttribute("orderGoods");
        Userinfo userInfo = (Userinfo) session.getAttribute("UserInfo");
        return "";
    }
}
