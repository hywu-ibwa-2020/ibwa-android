package com.example.maknaetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        lstCard.add(new Card("혼술하기 딱 좋은","category card","description card",R.drawable.forth,R.drawable.heart_1));
        lstCard.add(new Card("기분전환이 필요해","category card","description card",R.drawable.first,R.drawable.heart_1));
        lstCard.add(new Card("LOVE HOUSE","category card","description card",R.drawable.second,R.drawable.heart_2));
        lstCard.add(new Card("위로받고 싶은 날","category card","description card",R.drawable.third,R.drawable.heart_1));
        lstCard.add(new Card("스터디집중모드","category card","description card",R.drawable.card_book,R.drawable.heart_1));
        lstCard.add(new Card("집순이를 위한","category card","description card",R.drawable.card_home,R.drawable.heart_1));

        RecyclerView myrv = (RecyclerView) recommended_view.findViewById(R.id.recycler_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(lstCard, getActivity());
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrv.setAdapter(myAdapter);

//        // 막내의 pick 이용하기 버튼
//        Button pick_btn = (Button) recommended_view.findViewById(R.id.pick_btn);
//        // 버튼 누르면 activity_card 액티비티(뮤직화면)로 이동.
//        pick_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent pick_intent = new Intent(getActivity(), Card_Activity.class);
//                startActivity(pick_intent);
//            }
//        });

        return recommended_view;
    }
}