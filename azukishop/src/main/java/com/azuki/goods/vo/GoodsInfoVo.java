package com.azuki.goods.vo;

import com.azuki.goods.pojo.GoodsInfo;

public class GoodsInfoVo {
    GoodsInfo goodsInfo;
     int currentPage;
     int pageSize;
     String typeName;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "GoodsInfoVo{" +
                "goodsInfo=" + goodsInfo +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
