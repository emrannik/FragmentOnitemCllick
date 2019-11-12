package com.emran.example.fragmentonitemcllick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {
    private RecyclerView myrecyclerview;
    private List<InfoModel> infoModels;

    public InfoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.info_fragment, container, false);
        myrecyclerview=(RecyclerView)v.findViewById(R.id.info_reclerview);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(getContext(),infoModels);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        infoModels=new ArrayList<>();
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.hediedwith));
        infoModels.add(new InfoModel("Filips","0184555525",R.drawable.mariasemples));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.privacy));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.thevigitarian));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.themartian));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.thewildrobot));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.themartian));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.thevigitarian));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.privacy));
        infoModels.add(new InfoModel("Filips","0184555525",R.drawable.hediedwith));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.thevigitarian));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.hediedwith));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.mariasemples));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.themartian));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.thewildrobot));
        infoModels.add(new InfoModel("Martin","01845555",R.drawable.hediedwith));


    }
}
