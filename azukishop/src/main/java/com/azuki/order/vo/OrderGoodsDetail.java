package com.azuki.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderGoodsDetail {

    private String[] goodsNames;
    private String[] goodsNums;
    private String[] goodsPrices;
    private String[] goodsTotalPrices;

}
