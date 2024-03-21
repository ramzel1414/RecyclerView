package adet.recyclerview.t137.recyclerview;

public class PhoneModel {

    String phoneName;
    String phonePrice;
    String phoneDiscount;
    String description;
    String rating;
    int image;

    public PhoneModel(String phoneName,
                      String phonePrice,
                      String phoneDiscount,
                      int image,
                      String description,
                      String rating) {
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
        this.phoneDiscount = phoneDiscount;
        this.image = image;
        this.description = description;
        this.rating = rating;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getPhonePrice() {
        return phonePrice;
    }

    public String getPhoneDiscount() {
        return phoneDiscount;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }
}
