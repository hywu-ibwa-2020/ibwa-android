package com.example.maknaetest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecommend extends Fragment {
    List<Card> lstCard ; //카드뷰를 여러개 추가하기 위해 리스트 변수 선언

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View recommended_view = inflater.inflate(R.layout.fragment_recommend, container, false);

        lstCard = new ArrayList<>();
        lstCard.add(new Card("혼술하기 딱 좋은","category card","description card",R.drawable.forth,R.drawable.heart_line));
        lstCard.add(new Card("기분전환이 필요해","category card","description card",R.drawable.first,R.drawable.heart_line));
        lstCard.add(new Card("LOVE HOUSE","category card","description card",R.drawable.second,R.drawable.heart_line));
        lstCard.add(new Card("위로받고 싶은 날","category card","description card",R.drawable.third,R.drawable.heart_line));
        lstCard.add(new Card("스터디집중모드","category card","description card",R.drawable.card_book,R.drawable.heart_line));
        lstCard.add(new Card("집순이를 위한","category card","description card",R.drawable.card_home,R.drawable.heart_line));

        RecyclerView myrv = (RecyclerView) recommended_view.findViewById(R.id.recycler_id); // fragment_recommend.xml의 recycler_id를 가진 RecyclerView 레이아웃 변수 선언
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(lstCard, getActivity()); //RecyclerView 레이아웃 부분에 카드뷰를 넣기 위한 어댑터 객체 선언
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2)); //fragment_recommend.xml의 recycler_id 부분이 카드뷰 두개가 채워지면 줄바꿈
        myrv.setAdapter(myAdapter); // RecyclerView에 어댑터 연결

//        // 막내의 pick 이용하기 버튼 (구현준비중!)
//        Button pick_btn = (Button) recommended_view.findViewById(R.id.pick_btn);
//        // 버튼 누르면 activity_card 액티비티(뮤직화면)로 이동.
//        pick_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent pick_intent = new Intent(getActivity(), Card_Activity.class);
//                startActivity(pick_intent);
//            }
//        });

        return recommended_view; // 수정된 fragment_recommend.xml 반환
    }
}