package com.example.maknaetest.timerlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maknaetest.R;
import com.example.maknaetest.createtimer.TimerAddActivity;
import com.example.maknaetest.timerdata.Timer;

import java.util.List;

public class FragmentTimerList extends Fragment implements OnToggleTimerListener {
    private TimerRecyclerViewAdapter timerRecyclerViewAdapter;
    private TimersListViewModel TimersListViewModel;
    private TimerRecycleView timersRecyclerView;
    private ImageView addTimer;
//    private ImageView deleteTimer;

    // 타이머가 없을 때, 표시할 empty 화면
    View timerEmptyView;
    // 타이머가 있을 때만 보이는 constraintLayout_fix
    ConstraintLayout constraintLayout_fix;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        timerRecyclerViewAdapter = new TimerRecyclerViewAdapter(this);
        // ViewModelProviders.of 못 쓰니까 대체하는 코드 다시 찾아서 넣기.
        TimersListViewModel = ViewModelProviders.of(this).get(TimersListViewModel.class);
        TimersListViewModel.getTimersLiveData().observe(this, new Observer<List<Timer>>() {
            @Override
            public void onChanged(List<Timer> timers) {
                if (timers != null) {
                    timerRecyclerViewAdapter.setTimers(timers);
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer_list, container, false);

        // empty화면
        timerEmptyView = view.findViewById(R.id.fragment_timer_empty);
//        timerState = view.findViewById(R.id.timer_state);
        constraintLayout_fix = view.findViewById(R.id.constraintLayout_fix);

        timersRecyclerView = (TimerRecycleView) view.findViewById(R.id.fragment_timer_list_recyclerView);

        // 타이머가 있을때, constarintLayout_fix를 없애주기위해 hideIfEmpty 메소드 사용.
        timersRecyclerView.hideIfEmpty(constraintLayout_fix);
        // 타이머가 없을때, empty화면을 보여주기위해 showIfEmpty 메소드 사용.
        timersRecyclerView.showIfEmpty(timerEmptyView);

        // linearLayoutManager을 통해 수직 방향으로 타이머 뷰 보이기
        timersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        timersRecyclerView.setAdapter(timerRecyclerViewAdapter);

        // empty화면의 타이머 추가 버튼 활성화
        Button timer_add_btn = (Button) view.findViewById(R.id.timer_add_btn);
        // 타이머 추가 버튼 누르면 타이머 추가 액티비티로 이동.
        timer_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timer_add_intent = new Intent(getActivity(), TimerAddActivity.class);
                startActivity(timer_add_intent);
            }
        });

        addTimer = view.findViewById(R.id.timer_add_image_btn);
        addTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Navigation.findNavController(v).navigate(R.id.action_timersListFragment_to_createtimerFragment);
                Intent timer_add_intent = new Intent(getActivity(), TimerAddActivity.class);
                startActivity(timer_add_intent);
            }
        });

        return view;
    }

    @Override
    public void onToggle(Timer timer) {
        // 타이머가
        if (timer.isStarted()) {
            timer.cancelTimer(getContext());
        } else {
            timer.schedule(getContext());
        }
        TimersListViewModel.update(timer);
    }
}
