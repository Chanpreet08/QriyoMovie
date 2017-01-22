package chanpreet.searcher.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.w3c.dom.Text;

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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.director.setText(list.get(position).getDirector());
        holder.imdbRating.setText(list.get(position).getImdbRating());
        holder.plot.setText(list.get(position).getPlot());
        holder.genre.setText(list.get(position).getGenre());
        Glide.with(context).load(list.get(position).getPoster()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.image){
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.image.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView director;
        private TextView plot;
        private ImageView image;
        private TextView imdbRating;
        private TextView genre;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id._movie_image);
            title = (TextView) itemView.findViewById(R.id.movie_title);
            genre = (TextView) itemView.findViewById(R.id.movie_genre);
            director = (TextView) itemView.findViewById(R.id.movie_director);
            plot = (TextView) itemView.findViewById(R.id.movie_plot);
            imdbRating = (TextView) itemView.findViewById(R.id.movie_imdb);
        }
    }
}
