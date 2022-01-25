package com.geektech.newsapp39.ui.board;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.newsapp39.R;
import com.geektech.newsapp39.databinding.ItemBoardVpBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private ItemBoardVpBinding binding;
    private final int[] listImg = {
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background};

    private final String[] titleList = {"Title1", "Title2", "Title3","Title4"};
    private final String[] subTitleList = {"SubTitle1", "SubTitle2", "SubTitle3","SubTitle4"};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemBoardVpBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(listImg[position], titleList[position], subTitleList[position]);
        setOnClick(titleList[position]);
    }

    private void setOnClick(String pos) {

    }

    @Override
    public int getItemCount() {
        return titleList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemBoardVpBinding binding) {
            super(binding.getRoot());
        }

        public void onBind(int img, String title, String subTitle) {
            binding.boardIv.setImageResource(img);
            binding.title.setText(title);
            binding.subtitle.setText(subTitle);
        }
    }
}
