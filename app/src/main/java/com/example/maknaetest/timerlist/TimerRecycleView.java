package com.example.maknaetest.timerlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// RecyclerView의 item들이 비어있을 때, emptyView를 표시하기위해서 RecyclerView를 상속하는 TimerRecyclerView 만듦.
public class TimerRecycleView extends RecyclerView {

    private List<View> nonEmptyViews = Collections.emptyList();
    private List<View> emptyViews = Collections.emptyList();


    private AdapterDataObserver timerObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
            toggleViews();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            toggleViews();
        }
    };

    private void toggleViews() {
        if(getAdapter()!=null && !emptyViews.isEmpty() && !nonEmptyViews.isEmpty()){
            if(getAdapter().getItemCount()==0){
                // 모든 empty views 보이기
                ShowViewUtil.showViews(emptyViews);
                // RecyclerView 숨기기
                TimerRecycleView.this.setVisibility(View.GONE);
                // nonEmptyViews 숨기기
                ShowViewUtil.hideViews(nonEmptyViews);

            }else{
                // 모든 empty views 숨기기
                ShowViewUtil.hideViews(emptyViews);
                // RecyclerView 보이기
                TimerRecycleView.this.setVisibility(View.VISIBLE);
                // nonEmptyViews 보이기
                ShowViewUtil.showViews(nonEmptyViews);
            }
        }
    }

    public TimerRecycleView(@NonNull Context context) {
        super(context);
    }

    public TimerRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TimerRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdapter(@Nullable Adapter adapter) {
        super.setAdapter(adapter);
        if(adapter!=null){
            adapter.registerAdapterDataObserver(timerObserver);
        }
        timerObserver.onChanged();
    }

    public void hideIfEmpty(View... views){
        nonEmptyViews = Arrays.asList(views);
    }
    public void showIfEmpty(View... views){
        emptyViews = Arrays.asList(views);
    }
}
