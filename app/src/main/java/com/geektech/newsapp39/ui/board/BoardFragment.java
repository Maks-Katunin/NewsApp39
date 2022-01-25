package com.geektech.newsapp39.ui.board;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.geektech.newsapp39.R;
import com.geektech.newsapp39.databinding.FragmentBoardBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayoutMediator;

public class BoardFragment extends Fragment {

    private FragmentBoardBinding binding;
    private BoardAdapter adapter;
    private int[] tabText = {R.drawable.ic_circle,
            R.drawable.ic_circle,
            R.drawable.ic_circle,
            R.drawable.ic_circle};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewPager();
        clickOnButton();
    }

    private void initViewPager() {
        adapter = new BoardAdapter();
        binding.boardVp.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout, binding.boardVp, (tab, position) ->
                tab.setIcon(tabText[position])).attach();
        binding.tabLayout.setTabIconTint(ColorStateList.valueOf(Color.rgb(248,0,0)));
    }

    private void clickOnButton() {
        binding.btnSkip.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(),
                    R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.navigation_home);
        });
        binding.btnSkip2.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(),
                    R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.navigation_home);
        });
    }
}