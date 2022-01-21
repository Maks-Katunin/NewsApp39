package com.geektech.newsapp39.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.geektech.newsapp39.R;
import com.geektech.newsapp39.data.local.DataNews;
import com.geektech.newsapp39.databinding.FragmentHomeBinding;
import com.geektech.newsapp39.models.News;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NewsAdapter adapter;
    private DataNews news;

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
        ArrayList<News> arrayList = news.getNewsList();
        adapter.setNewsList(arrayList);
        binding.newsRv.setAdapter(adapter);
    }

    private void initFragmentResultListener() {
        getParentFragmentManager().setFragmentResultListener("rk_news",
                getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        News news = (News) result.getSerializable("news");
                        adapter.setNews(news);


                        //                       Log.e("TAG", "YES" + news.getTitle());
//                        Toast.makeText(requireContext(), news.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initListeners() {
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void openFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.newsFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}