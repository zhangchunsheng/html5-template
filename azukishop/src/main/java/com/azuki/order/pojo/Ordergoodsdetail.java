package com.azuki.order.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ordergoodsdetail {

  private Long ogId;
  private Long orderId;
  private Long goodsId;
  private String goodsName;
  private Long goodsPrice;
  private Long goodsNum;
  private Long goodsTotalPrice;


}
