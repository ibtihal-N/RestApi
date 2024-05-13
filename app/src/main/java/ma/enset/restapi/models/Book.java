package ma.enset.restapi.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    @SerializedName("volumeInfo")

    private volumeInfo volumeInfo;

    public Book() {
    }

    public Book(ma.enset.restapi.models.volumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public ma.enset.restapi.models.volumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(ma.enset.restapi.models.volumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
