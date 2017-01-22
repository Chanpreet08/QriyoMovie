package chanpreet.searcher.Activity;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import chanpreet.searcher.R;
import chanpreet.searcher.Response.Resp;
import chanpreet.searcher.Response.SearchResponse;
import chanpreet.searcher.Rest.ApiClient;
import chanpreet.searcher.Rest.ApiInterface;
import chanpreet.searcher.Tools.Tools;
import chanpreet.searcher.model.Search;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private MenuItem menuItem;
    private SearchView.OnQueryTextListener listener;
    Search search = new Search();
    ProgressDialog pd;
    private ArrayList<SearchResponse> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pd = Tools.getProgressDialog(MainActivity.this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

         listener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search.setKey(query);
                pd.show();
                ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                Call<Resp> call = apiService.Searched(search);
                call.enqueue(new Callback<Resp>() {
                    @Override
                    public void onResponse(Call<Resp> call, Response<Resp> response) {
                        if(response.isSuccessful())
                        {
                            pd.dismiss();
                            list = response.body().getList();
                            Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Resp> call, Throwable t) {
                        pd.dismiss();
                        Log.e("error",t.getCause().toString());
                        Toast.makeText(MainActivity.this,"UNSuccessful",Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menuItem = menu.findItem(R.id.search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(listener);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
