package ormas.aditya.com.ormascibiru;

import com.google.gson.annotations.SerializedName;

public class Ormas {
    @SerializedName("id") private int id;
    @SerializedName("name") private String name;
    @SerializedName("address") private String address;
    @SerializedName("type") private String type;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }
}

