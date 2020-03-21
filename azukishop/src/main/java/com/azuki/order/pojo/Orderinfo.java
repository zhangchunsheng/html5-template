package com.azuki.order.pojo;



import java.util.Date;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

@ToString
@Getter
@Setter
public class Orderinfo {

  private Long orderId;
  private String orderInfoId;
  private java.sql.Date created_date;
  private String consignee;
  private String phone;
  private String receiverAdd;
  private Integer status;
  private String sendType;
  private String payType;
  private Long payCount;
  private Date checkDate;
  private String checkPerson;



}
