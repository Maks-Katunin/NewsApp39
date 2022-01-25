package com.geektech.newsapp39.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.geektech.newsapp39.R;
import com.geektech.newsapp39.data.local.DataNews;
import com.geektech.newsapp39.databinding.FragmentHomeBinding;
import com.geektech.newsapp39.models.News;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements NewsAdapter.OnItemClick {

    private FragmentHomeBinding binding;
    private NewsAdapter adapter;
    private DataNews news;
    private ArrayList<News> arrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        initFragmentResultListener();
        initRv();
    }

    private void initRv() {
        adapter = new NewsAdapter();
        news = new DataNews();
        adapter.setNewsList(arrayList);
        adapter.setListener(this);
        binding.newsRv.setAdapter(adapter);
    }

    private void initListeners() {
        binding.fab.setOnClickListener(v -> openFragment());
    }

    private void initFragmentResultListener() {
        getParentFragmentManager().setFragmentResultListener("rk_news",
                getViewLifecycleOwner(), (requestKey, result) -> {
                    News news = (News) result.getSerializable("news");
                    arrayList.add(news);
                    adapter.setNewsList(arrayList);
                    binding.newsRv.setAdapter(adapter);
                });
    }


    private void openFragment() {
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.newsFragment);
    }


    @Override
    public void onClick(News news) {
        Toast.makeText(getContext(), news.getTitle(), Toast.LENGTH_SHORT).show();
        EditDataFragment(news);
    }


    @Override
    public void onLongClick(int position) {
        Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                    arrayList.remove(position);
                    adapter.setNewsList(arrayList);
                    binding.newsRv.setAdapter(adapter);
    }

    private void EditDataFragment(News news) {

       /* Bundle bundle = new Bundle();
        String setNews = news.getTitle();
        bundle.putSerializable("news", setNews);
        getParentFragmentManager().setFragmentResult("rk_news", bundle);
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.editDataFragment);*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}