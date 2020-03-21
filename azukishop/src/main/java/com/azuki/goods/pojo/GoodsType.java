package com.azuki.goods.pojo;

public class GoodsType {
    int categoryId;
    String typeName;
    int parentId;
    int status;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "categoryId=" + categoryId +
                ", typeName='" + typeName + '\'' +
                ", parentId=" + parentId +
                ", status=" + status +
                '}';
    }
}
