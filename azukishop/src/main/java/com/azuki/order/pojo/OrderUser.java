package com.azuki.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderUser {

  private Long ouId;
  private Long orderId;
  private Long userId;
  private String status;

}
