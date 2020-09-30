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
    private RecyclerView timersRecyclerView;
    private ImageView addTimer;
//    private ImageView deleteTimer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        timerRecyclerViewAdapter = new TimerRecyclerViewAdapter(this);
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

        timersRecyclerView = view.findViewById(R.id.fragment_timer_list_recylerView);
        timersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        timersRecyclerView.setAdapter(timerRecyclerViewAdapter);

//        addTimer = view.findViewById(R.id.timer_add_btn);
//        addTimer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Navigation.findNavController(v).navigate(R.id.action_timersListFragment_to_createtimerFragment);
//                Intent timer_add_intent = new Intent(getActivity(), TimerAddActivity.class);
//                startActivity(timer_add_intent);
//            }
//        });

        return view;
    }

    @Override
    public void onToggle(Timer timer) {
        if (timer.isStarted()) {
            timer.cancelTimer(getContext());
            TimersListViewModel.update(timer);
        } else {
            timer.schedule(getContext());
            TimersListViewModel.update(timer);
        }
    }
}
