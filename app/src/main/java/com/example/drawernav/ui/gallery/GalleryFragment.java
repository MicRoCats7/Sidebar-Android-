package com.example.drawernav.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawernav.GridSpacingItemDecoration;
import com.example.drawernav.Kenma;
import com.example.drawernav.KenmaAdapter;
import com.example.drawernav.KenmaData;
import com.example.drawernav.R;
import com.example.drawernav.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    private RecyclerView rvKenma;
    private ArrayList<Kenma> list = new ArrayList<>();

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rvKenma = view.findViewById(R.id.Recylerview);
        rvKenma.setHasFixedSize(true);


        rvKenma = view.findViewById(R.id.Recylerview);
        rvKenma.setHasFixedSize(true);

        list.addAll(KenmaData.getListData());
        showRecyclerGrid();

        int spanCount = 2; // 3 columns
        int spacing = 20; // 50px
        boolean includeEdge = true;
        rvKenma.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
    }

    private void showRecyclerGrid() {
        rvKenma.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        KenmaAdapter kenmaAdapter = new KenmaAdapter(list);
        rvKenma.setAdapter(kenmaAdapter);
    }
}