package entity;

public class Cart {
    private String name;        //购物车中一项对应的商品名称
    private Double price;       //单价
    private Double totalPrice;  //总价
    private Integer count;


    public Cart(String name, int i, int i1, int count){

    }

    public Cart(String name, Double price, Double totalPrice, Integer count) {
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
