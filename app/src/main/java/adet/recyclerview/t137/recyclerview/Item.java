package adet.recyclerview.t137.recyclerview;

public class Item {

    private String thumbnailurl, title, price, discountPercentage, brand, stock, category;


    public Item(String thumbnailurl, String title, String price, String discountPercentage, String brand, String stock, String category){
        this.thumbnailurl = thumbnailurl;
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.stock = stock;
        this.category = category;
        this.discountPercentage = discountPercentage;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public String getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getStock() {
        return stock;
    }
}
