package chanpreet.searcher.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 21/1/17.
 */

public class Search {

    @SerializedName("key")
    private String key="";


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
