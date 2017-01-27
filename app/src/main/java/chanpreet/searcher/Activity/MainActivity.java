package chanpreet.searcher.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import chanpreet.searcher.Adapter.MovieAdapter;
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
    private TextView initialText;
    Search search = new Search();
    ProgressDialog pd;
    private CoordinatorLayout cLayout;
    private ArrayList<SearchResponse> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private String genre[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cLayout = (CoordinatorLayout) findViewById(R.id.c_layout);
        initialText = (TextView) findViewById(R.id.initial_text);
        pd = Tools.getProgressDialog(MainActivity.this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select a genre")
                        .setItems(R.array.genre_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                genre = getResources().getStringArray(R.array.genre_array);
                                search.setKey(genre[which]);
                                pd.show();
                                ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                                Call<Resp> call = apiService.Searched(search);
                                call.enqueue(new Callback<Resp>() {
                                    @Override
                                    public void onResponse(Call<Resp> call, Response<Resp> response) {
                                        if (response.isSuccessful()) {
                                            initialText.setVisibility(View.GONE);
                                            pd.dismiss();
                                            list = response.body().getList();
                                            Snackbar snackbar = Snackbar
                                                    .make(cLayout, "Fetching Data", Snackbar.LENGTH_SHORT);
                                            snackbar.show();
                                            setRecyclerView();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Resp> call, Throwable t) {
                                        pd.dismiss();
                                        Snackbar snackbar = Snackbar
                                                .make(cLayout, "Can't connect!! Check your Internet Connection", Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                    }
                                });
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
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
                        if (response.isSuccessful()) {
                            initialText.setVisibility(View.GONE);
                            pd.dismiss();
                            list = response.body().getList();
                            Snackbar snackbar = Snackbar
                                    .make(cLayout, "Fetching Data", Snackbar.LENGTH_SHORT);
                            snackbar.show();
                            setRecyclerView();
                        }
                    }

                    @Override
                    public void onFailure(Call<Resp> call, Throwable t) {
                        pd.dismiss();
                        Snackbar snackbar = Snackbar
                                .make(cLayout, "Can't connect!! Check your Internet Connection", Snackbar.LENGTH_LONG);
                        snackbar.show();
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

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler);
        adapter = new MovieAdapter(MainActivity.this, list);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menuItem = menu.findItem(R.id.search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(listener);
        return true;
    }
}
