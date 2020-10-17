package com.example.maknaetest.timerlist;

import android.view.View;

import java.util.List;

// 뷰의 visibility 속성을 처리해주는 ShowViewUtil 클래스
public class ShowViewUtil {
    public static void showViews(List<View> views){
        for (View view : views){
            view.setVisibility(View.VISIBLE);
        }
    }
    public static void hideViews(List<View> views){
        for (View view : views){
            view.setVisibility(View.GONE);
        }
    }
}
