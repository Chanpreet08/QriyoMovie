package chanpreet.searcher.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 21/1/17.
 */

public class Search {

    @SerializedName("title")
    private String searchTitle="";


    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

}
