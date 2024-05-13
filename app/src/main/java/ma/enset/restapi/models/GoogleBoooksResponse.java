package ma.enset.restapi.models;

import android.telecom.Call;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleBoooksResponse {
    @SerializedName("totalItems")

    private int totalItems;
    @SerializedName("kind")
    public String kind;
    @SerializedName("items")

    private List<Book> items;

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }
}
