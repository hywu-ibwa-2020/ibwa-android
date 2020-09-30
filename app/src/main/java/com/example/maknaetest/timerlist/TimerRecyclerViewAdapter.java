package com.example.maknaetest.timerlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maknaetest.R;
import com.example.maknaetest.timerdata.Timer;

import java.util.ArrayList;
import java.util.List;

// RecyclerView.Adapter를 상속받아 RecyclerView Adapter를 구현 (이때, 제네릭타입을 TimerViewHolder로 설정하였음.)
public class TimerRecyclerViewAdapter extends RecyclerView.Adapter<TimerViewHolder> {
    private List<Timer> timers;
    private OnToggleTimerListener listener;

    // 생성자에서 onToggleTimerListener객체를 전달받도록 설정.
    public TimerRecyclerViewAdapter(OnToggleTimerListener listener) {
        this.timers = new ArrayList<Timer>();
        this.listener = listener;
    }


    // onCreateViewHolder() 정의 (아이템 뷰를 위한 ViewHolder 객체를 생성해 리턴해줌.)
    // 타이머 아이템을 받아서 viewHolder 객체에 저장해주기 위함.
    @NonNull
    @Override
    public TimerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.timer_item, parent, false);
        return new TimerViewHolder(itemView);
    }

    // position에 해당하는 데이터를 viewHolder의 아이템뷰에 표시해줌.
    @Override
    public void onBindViewHolder(@NonNull TimerViewHolder holder, int position) {
        Timer timer = timers.get(position);
        holder.bind(timer, listener);
    }

    // 전체 데이터 갯수를 리턴해주는 getItemCount() 정의.
    @Override
    public int getItemCount() {
        return timers.size();
    }

    // Holder를 재활용하도록 돕는 onViewRecycled() 정의.
    @Override
    public void onViewRecycled(@NonNull TimerViewHolder holder) {
        super.onViewRecycled(holder);
        holder.timerStarted.setOnCheckedChangeListener(null);
    }

    // setTimers() 정의
    // 타이머가 생성되면 notifyDataSetChanged()를 통해 리사이클러뷰의 타이머 아이템들 목록을 업데이트해줌.
    public void setTimers(List<Timer> timers) {
        this.timers = timers;
        notifyDataSetChanged();
    }
}