package chanpreet.searcher.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import chanpreet.searcher.Response.SearchResponse;
import chanpreet.searcher.R;

/**
 * Created by chanpreet on 22/1/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SearchResponse> list = new ArrayList<>();
    public MovieAdapter(Context context, ArrayList<SearchResponse> list)
    {
        this.context = context;
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout_movies,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.director.setText(list.get(position).getDirector());
        holder.imdbRating.setText(list.get(position).getImdbRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView director;
        private TextView imdbRating;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.movie_title);
            director = (TextView) itemView.findViewById(R.id.movie_director);
            imdbRating = (TextView) itemView.findViewById(R.id.movie_imdb);
        }
    }
}
