package chanpreet.searcher.Rest;



import chanpreet.searcher.Response.Resp;
import chanpreet.searcher.model.Search;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by chanpreet on 21/1/17.
 */

public interface ApiInterface {

    @POST("search/")
    Call<Resp> Searched(@Body Search search);
}
