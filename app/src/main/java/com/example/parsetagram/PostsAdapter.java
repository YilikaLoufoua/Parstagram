package com.example.parsetagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>{

    Context context;
    List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Post> postList) {
        posts.addAll(postList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImage;
        TextView tvUsername;
        ImageView ivOptions;
        ImageView ivPost;
        ImageView ivHeart;
        ImageView ivComment;
        ImageView ivDirect;
        ImageView ivSave;
        TextView tvDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            TextView tvUsername = itemView.findViewById(R.id.tvUsername);
            ImageView ivOptions = itemView.findViewById(R.id.ivOptions);
            ImageView ivPost = itemView.findViewById(R.id.ivPost);
            ImageView ivHeart = itemView.findViewById(R.id.ivHeart);
            ImageView ivComment = itemView.findViewById(R.id.ivComment);
            ImageView ivDirect = itemView.findViewById(R.id.ivDirect);
            ImageView ivSave = itemView.findViewById(R.id.ivSave);
            TextView tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        public void bind(Post post) {
            tvUsername.setText(post.getUser().toString());
            Glide.with(context).load(post.getImage().getUrl()).into(ivPost);
        }
    }
}