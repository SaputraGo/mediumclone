package com.android.mediumclone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kamalshree on 5/14/2018.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Article> articleList;

    //getting the context and product list with constructor
    public ArticleAdapter(Context mCtx, List<Article> articleList) {
        this.mCtx = mCtx;
        this.articleList = articleList;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.main_text_layout, null);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        //getting the product of the specified position
        Article article = articleList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(article.getTitle());
        holder.textViewMainTitle.setText(article.getMaintitle());
        holder.textViewAuthor.setText(article.getAuthor());
        holder.textViewDate.setText(article.getDate());
        holder.textViewTime.setText(article.getTime());


        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(article.getImage()));
    }


    @Override
    public int getItemCount() {
        return articleList.size();
    }


    class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewMainTitle, textViewAuthor, textViewDate,textViewTime;
        ImageView imageView;

        public ArticleViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.recyclerView_title);
            textViewMainTitle = (TextView)itemView.findViewById(R.id.recyclerView_maintitle);
            textViewAuthor = (TextView)itemView.findViewById(R.id.recyclerView_author);
            textViewDate = (TextView)itemView.findViewById(R.id.recyclerView_date);
            textViewTime = (TextView)itemView.findViewById(R.id.recyclerView_time);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
