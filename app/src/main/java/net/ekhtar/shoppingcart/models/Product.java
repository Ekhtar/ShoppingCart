package net.ekhtar.shoppingcart.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ahmed.a.elfattah on 17/10/2017.
 */

public class Product implements Parcelable {
    private String id;
    private String name = null, nameِِArabic = null, brand = null , modelNumber = null , mainColor = null ; // Step 1 Data
    private String category = null, mainMaterial = null, productionCountry = null, youtubeID = null;
    private double dimensions = 0.0, weight = 0.0;// Step 2 Data
    private String generalDescription = null, generalDescriptionArabic = null; // Step 3 Data
    private String notes = null, productWarranty = null, box = null, boxArabic = null;
    private double price = 0.0; int quantity = 1; // Step 3 Data
    private String imge1 = null, imge2 = null, imge3 = null, imge4 = null, imge5 = null, imge6 = null; // Step 3 Data

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameِِArabic() {
        return nameِِArabic;
    }

    public void setNameِِArabic(String nameِِArabic) {
        this.nameِِArabic = nameِِArabic;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }

    public String getYoutubeID() {
        return youtubeID;
    }

    public void setYoutubeID(String youtubeID) {
        this.youtubeID = youtubeID;
    }

    public double getDimensions() {
        return dimensions;
    }

    public void setDimensions(double dimensions) {
        this.dimensions = dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public String getGeneralDescriptionArabic() {
        return generalDescriptionArabic;
    }

    public void setGeneralDescriptionArabic(String generalDescriptionArabic) {
        this.generalDescriptionArabic = generalDescriptionArabic;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProductWarranty() {
        return productWarranty;
    }

    public void setProductWarranty(String productWarranty) {
        this.productWarranty = productWarranty;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getBoxArabic() {
        return boxArabic;
    }

    public void setBoxArabic(String boxArabic) {
        this.boxArabic = boxArabic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImge1() {
        return imge1;
    }

    public void setImge1(String imge1) {
        this.imge1 = imge1;
    }

    public String getImge2() {
        return imge2;
    }

    public void setImge2(String imge2) {
        this.imge2 = imge2;
    }

    public String getImge3() {
        return imge3;
    }

    public void setImge3(String imge3) {
        this.imge3 = imge3;
    }

    public String getImge4() {
        return imge4;
    }

    public void setImge4(String imge4) {
        this.imge4 = imge4;
    }

    public String getImge5() {
        return imge5;
    }

    public void setImge5(String imge5) {
        this.imge5 = imge5;
    }

    public String getImge6() {
        return imge6;
    }

    public void setImge6(String imge6) {
        this.imge6 = imge6;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.nameِِArabic);
        dest.writeString(this.brand);
        dest.writeString(this.modelNumber);
        dest.writeString(this.mainColor);
        dest.writeString(this.category);
        dest.writeString(this.mainMaterial);
        dest.writeString(this.productionCountry);
        dest.writeString(this.youtubeID);
        dest.writeDouble(this.dimensions);
        dest.writeDouble(this.weight);
        dest.writeString(this.generalDescription);
        dest.writeString(this.generalDescriptionArabic);
        dest.writeString(this.notes);
        dest.writeString(this.productWarranty);
        dest.writeString(this.box);
        dest.writeString(this.boxArabic);
        dest.writeDouble(this.price);
        dest.writeInt(this.quantity);
        dest.writeString(this.imge1);
        dest.writeString(this.imge2);
        dest.writeString(this.imge3);
        dest.writeString(this.imge4);
        dest.writeString(this.imge5);
        dest.writeString(this.imge6);
    }

    protected Product(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.nameِِArabic = in.readString();
        this.brand = in.readString();
        this.modelNumber = in.readString();
        this.mainColor = in.readString();
        this.category = in.readString();
        this.mainMaterial = in.readString();
        this.productionCountry = in.readString();
        this.youtubeID = in.readString();
        this.dimensions = in.readDouble();
        this.weight = in.readDouble();
        this.generalDescription = in.readString();
        this.generalDescriptionArabic = in.readString();
        this.notes = in.readString();
        this.productWarranty = in.readString();
        this.box = in.readString();
        this.boxArabic = in.readString();
        this.price = in.readDouble();
        this.quantity = in.readInt();
        this.imge1 = in.readString();
        this.imge2 = in.readString();
        this.imge3 = in.readString();
        this.imge4 = in.readString();
        this.imge5 = in.readString();
        this.imge6 = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
