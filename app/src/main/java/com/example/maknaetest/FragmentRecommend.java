package com.example.maknaetest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FragmentRecommend extends Fragment {
    List<Card> lstCard ; //카드뷰를 여러개 추가하기 위해 리스트 변수 선언

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View recommended_view = inflater.inflate(R.layout.fragment_recommend, container, false);

        lstCard = new ArrayList<>();
        lstCard.add(new Card("혼술하기 딱 좋은","category card","m01",R.drawable.forth,R.drawable.heart_line));
        lstCard.add(new Card("기분전환이 필요해","category card","m02",R.drawable.first,R.drawable.heart_line));
        lstCard.add(new Card("LOVE HOUSE","category card","m03",R.drawable.second,R.drawable.heart_full));
        lstCard.add(new Card("위로받고 싶은 날","category card","m04",R.drawable.third,R.drawable.heart_line));
        lstCard.add(new Card("스터디집중모드","category card","m05",R.drawable.card_book,R.drawable.heart_line));
        lstCard.add(new Card("집순이를 위한","category card","m06",R.drawable.card_home,R.drawable.heart_line));

        RecyclerView myrv = (RecyclerView) recommended_view.findViewById(R.id.recycler_id); // fragment_recommend.xml의 recycler_id를 가진 RecyclerView 레이아웃 변수 선언
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(lstCard, getActivity()); //RecyclerView 레이아웃 부분에 카드뷰를 넣기 위한 어댑터 객체 선언
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2)); //fragment_recommend.xml의 recycler_id 부분이 카드뷰 두개가 채워지면 줄바꿈
        myrv.setAdapter(myAdapter); // RecyclerView에 어댑터 연결

        Button sort_btn = (Button) recommended_view.findViewById(R.id.sort_btn);


        sort_btn.setOnClickListener(new View.OnClickListener(){ // 정렬버튼 클릭시 채워진 하트를 포함하는 카드를 우선 정렬

            @Override
            public void onClick(View view) {

                Comparator<Card> sorted = new Comparator<Card>() {
                    @Override
                    public int compare(Card o1, Card o2) {
                        int ret;
                        if (o1.getHeart() > o2.getHeart())
                            ret= 1;
                        else if (o1.getHeart() == o2.getHeart())
                            ret= 0;
                        else
                            ret= -1;
                        return ret;
                    }
                };

                Collections.sort(lstCard,sorted);
                myAdapter.notifyDataSetChanged(); // 어댑터 갱신
                myrv.setAdapter(myAdapter);
//                Toast.makeText(getActivity(), "커튼2가 내려갑니다.", Toast.LENGTH_SHORT).show();



            }
        });



//        // 막내의 pick 이용하기 버튼
        Button pick_btn = (Button) recommended_view.findViewById(R.id.pick_btn);
        // 버튼 누르면 activity_ai_pick 액티비티로 이동.
        pick_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent pick_intent = new Intent(getActivity(), Pick_Activity.class);
                startActivity(pick_intent);
            }
        });


        return recommended_view; // 수정된 fragment_recommend.xml 반환


    }

}