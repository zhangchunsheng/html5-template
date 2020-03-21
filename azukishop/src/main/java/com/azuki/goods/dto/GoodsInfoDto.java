package com.azuki.goods.dto;

import com.azuki.goods.pojo.GoodsInfo;

public class GoodsInfoDto {
    GoodsInfo goodsInfo;
    int currentPage;
    int pageSize;

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "GoodsInfoVo{" +
                "goodsInfo=" + goodsInfo +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
