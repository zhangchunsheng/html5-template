package com.azuki.goods.pojo;

public class GoodsInfo {
    int goodsId;
    String goodsNo; //商品编号(G+goodsId+创建时间)
    int price;  //商品价格         奖励积分：Reward Points 可以换成销量
    int basePrice;//  市场价（原价）
    int costPrice;//	 成本价
    int stockNumber;//  商品库存
    int sellNumber;//  销量
    String goodsDesc;//    商品描述
    String status;// 商品状态 TOP：上架DOWN：下架DEL：删除
    int firstCategoryId;//	一级类别ID
    int secondCategoryId;//	  二级类别ID
    String shopAddress;//	   发货地
    String originAddress;//	原产地
    String remark;//	备注
    String carriageTime;//  上架时间（YYYYMMDDhhmmss）
    String modifyAt;// 修改时间
    String modifyBy;// 由谁修改
    String createAt;// 创建时间
    String createBy;// 由谁创建
    String firstCategoryName;//	    一级类别名称
    String secondCategoryName;//  二级类别名称
    String brandName;//品牌名称
    String goodsPic;//
    int categoryId;//  父类id
    int brandId;//  品牌ID
    String goodsTitle;// 商品标题（展示列表使用）
    String goodsName;// 商品名称

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(int sellNumber) {
        this.sellNumber = sellNumber;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFirstCategoryId() {
        return firstCategoryId;
    }

    public void setFirstCategoryId(int firstCategoryId) {
        this.firstCategoryId = firstCategoryId;
    }

    public int getSecondCategoryId() {
        return secondCategoryId;
    }

    public void setSecondCategoryId(int secondCategoryId) {
        this.secondCategoryId = secondCategoryId;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCarriageTime() {
        return carriageTime;
    }

    public void setCarriageTime(String carriageTime) {
        this.carriageTime = carriageTime;
    }

    public String getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(String modifyAt) {
        this.modifyAt = modifyAt;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getFirstCategoryName() {
        return firstCategoryName;
    }

    public void setFirstCategoryName(String firstCategoryName) {
        this.firstCategoryName = firstCategoryName;
    }

    public String getSecondCategoryName() {
        return secondCategoryName;
    }

    public void setSecondCategoryName(String secondCategoryName) {
        this.secondCategoryName = secondCategoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "goodsId=" + goodsId +
                ", goodsNo='" + goodsNo + '\'' +
                ", price=" + price +
                ", basePrice=" + basePrice +
                ", costPrice=" + costPrice +
                ", stockNumber=" + stockNumber +
                ", sellNumber=" + sellNumber +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", status='" + status + '\'' +
                ", firstCategoryId=" + firstCategoryId +
                ", secondCategoryId=" + secondCategoryId +
                ", shopAddress='" + shopAddress + '\'' +
                ", originAddress='" + originAddress + '\'' +
                ", remark='" + remark + '\'' +
                ", carriageTime='" + carriageTime + '\'' +
                ", modifyAt='" + modifyAt + '\'' +
                ", modifyBy='" + modifyBy + '\'' +
                ", createAt='" + createAt + '\'' +
                ", createBy='" + createBy + '\'' +
                ", firstCategoryName='" + firstCategoryName + '\'' +
                ", secondCategoryName='" + secondCategoryName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", goodsPic='" + goodsPic + '\'' +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}
