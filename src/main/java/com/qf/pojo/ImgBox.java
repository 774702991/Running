package com.qf.pojo;

public class ImgBox {

    private Integer id;
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "ImgBox{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
