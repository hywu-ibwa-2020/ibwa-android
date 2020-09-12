package com.example.maknaetest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecommend extends Fragment {
    List<Card> lstCard ;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View recommended_view = inflater.inflate(R.layout.fragment_recommend, container, false);

        lstCard = new ArrayList<>();
        lstCard.add(new Card("혼술하기 딱 좋은","category card","description card",R.drawable.forth));
        lstCard.add(new Card("기분전환이 필요해","category card","description card",R.drawable.first));
        lstCard.add(new Card("LOVE HOUSE","category card","description card",R.drawable.second));
        lstCard.add(new Card("위로받고 싶은 날","category card","description card",R.drawable.third));

        RecyclerView myrv = (RecyclerView) recommended_view.findViewById(R.id.recycler_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(lstCard, getActivity());
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrv.setAdapter(myAdapter);

        return recommended_view;
    }
}