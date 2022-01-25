package com.geektech.newsapp39.ui.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.newsapp39.databinding.ItemNewsBinding;
import com.geektech.newsapp39.models.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> newsList;
    private ItemNewsBinding binding;
    private OnItemClick listener;

    @SuppressLint("NotifyDataSetChanged")
    public void setNewsList(ArrayList<News> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    public void setListener(OnItemClick listener) {
        this.listener = listener;
    }

    public void setNews(News news) {
        this.newsList = new ArrayList<>();
        newsList.add(news);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemNewsBinding.inflate(LayoutInflater
                        .from(parent.getContext()), parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull ItemNewsBinding binding) {
            super(binding.getRoot());
        }

        public void onBind(News news) {
            binding.titleTv.setText(news.getTitle());
            binding.dateTv.setText(String.valueOf(news.getCreateAd()));
            initListeners(news);
        }

        private void initListeners(News news) {
            binding.getRoot().setOnClickListener(v -> listener.onClick(news));

            binding.getRoot().setOnLongClickListener(v -> {
                listener.onLongClick(getAdapterPosition());
                return true;
            });
        }
    }

    interface OnItemClick {
        void onClick(News news);
        void onLongClick(int position);

    }
}
