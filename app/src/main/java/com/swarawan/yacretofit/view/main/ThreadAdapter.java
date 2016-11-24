package com.swarawan.yacretofit.view.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.swarawan.yacretofit.R;
import com.swarawan.yacretofit.model.response.ThreadResponseModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by rioswarawan on 11/24/16.
 */

public class ThreadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ThreadResponseModel.ThreadData> data;
    private LayoutInflater inflater;

    public ThreadAdapter(Context context, List<ThreadResponseModel.ThreadData> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ThreadResponseModel.ThreadData model = data.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.populate(model);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView featuredImage;
        private TextView title;
        private TextView author;
        private TextView date;

        public ViewHolder(View itemView) {
            super(itemView);

            featuredImage = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            date = (TextView) itemView.findViewById(R.id.content);
        }

        public void populate(ThreadResponseModel.ThreadData thread) {
            title.setText(thread.getTitle());
            author.setText("By: " + thread.getAuthorName());
            date.setText(thread.getDate());
            Glide.with(context).load(thread.getImage()).placeholder(android.R.color.darker_gray).into(featuredImage);
        }

    }
}
