package com.geektech.newsapp39.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.geektech.newsapp39.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ActivityResultLauncher<String> mGetContent;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initActivityResultLauncher();
        selectPhotoFromGallery();
    }

    private void initActivityResultLauncher() {
        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri -> binding.image.setImageURI(uri));
    }

    private void selectPhotoFromGallery() {
        binding.image.setOnClickListener(v -> mGetContent.launch("image/*"));
    }
}


