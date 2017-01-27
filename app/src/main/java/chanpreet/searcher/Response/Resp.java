package chanpreet.searcher.Response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by chanpreet on 21/1/17.
 */

public class Resp {
    @SerializedName("data")
    private ArrayList<SearchResponse> list = new ArrayList<>();

    public ArrayList<SearchResponse> getList() {
        return list;
    }

    public void setList(ArrayList<SearchResponse> list) {
        this.list = list;
    }
}
