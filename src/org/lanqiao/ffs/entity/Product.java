package org.lanqiao.ffs.entity;

import java.util.Objects;

public class Product {
    private int id;
    private String pname;//商品名称
    private String sort;//商品分类
    private String bornPlace;//商品产地
    private String supplier;//商品厂商
    private int count;//商品数量
    private String intime;//商品入库时间
    private Double price;//商品价格

    public Product() {

    }

    public Product(String pname, String sort, String bornPlace, String supplier, int count, String intime, Double price) {
        this.pname = pname;
        this.sort = sort;
        this.bornPlace = bornPlace;
        this.supplier = supplier;
        this.count = count;
        this.intime = intime;
        this.price = price;
    }

    public Product(int id, String pname, String sort, String bornPlace, String supplier, int count, String intime, Double price) {
        this.id = id;
        this.pname = pname;
        this.sort = sort;
        this.bornPlace = bornPlace;
        this.supplier = supplier;
        this.count = count;
        this.intime = intime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                count == product.count &&
                Objects.equals(pname, product.pname) &&
                Objects.equals(sort, product.sort) &&
                Objects.equals(bornPlace, product.bornPlace) &&
                Objects.equals(supplier, product.supplier) &&
                Objects.equals(intime, product.intime) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pname, sort, bornPlace, supplier, count, intime, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", sort='" + sort + '\'' +
                ", bornPlace='" + bornPlace + '\'' +
                ", supplier='" + supplier + '\'' +
                ", count=" + count +
                ", intime='" + intime + '\'' +
                ", price=" + price +
                '}';
    }
}
