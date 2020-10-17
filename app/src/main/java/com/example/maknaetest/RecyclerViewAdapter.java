package com.example.maknaetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Comparator;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<Card> mData; // 카드뷰리스트 안 각 카드들의 요소데이터(제목, 꽉찬 하트, ) 카드 확장화면에 전송하기 위해

    public RecyclerViewAdapter(List<Card> mData, Activity activity) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.card_view_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_card_title.setText(mData.get(position).getTitle()); //MyViewHolder 클래스(아래코드에 있음)에 카드뷰 리스트에서 가져온 값 (기분전환이 필요해) 넣기
        holder.img_card_thumbnail.setImageResource(mData.get(position).getThumbnail());//MyViewHolder 클래스(아래코드에 있음)에 카드뷰 리스트에서 가져온 값 (배경사진) 넣기
        holder.heart.setImageResource(mData.get(position).getHeart());//MyViewHolder 클래스(아래코드에 있음)에 카드뷰 리스트에서 가져온 값 (빈하트) 넣기
        holder.heart.setTag(0);
        holder.heart.setOnClickListener(new MyListener(holder.heart, position));// 하트 이미지를 클릭하면 발생하는 상황을 MyListener()에서 처리

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                // passing data to the card activity
                Intent intent = new Intent(v.getContext(), Card_Activity.class);
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Music_state",mData.get(position).getMusic_state());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                context.startActivity(intent);
            }
        });

        // set click

    }

    class MyListener implements View.OnClickListener {

        ImageView heart;
        int position;

        public MyListener(@NonNull ImageView heart, int position) {
            this.heart = heart;
            this.position = position;
        }

        // 빈하트 클릭하면 꽉찬하트로, 꽉찬하트 클릭하면 빈하트로 전환
        @Override
        public void onClick(View v) {
            if (Integer.parseInt(heart.getTag().toString()) == 0) {
                heart.setImageResource(R.drawable.heart_full);
                mData.get(position).setHeart(R.drawable.heart_full);
                heart.setTag(1);
            } else {
                heart.setImageResource(R.drawable.heart_line);
                mData.get(position).setHeart(R.drawable.heart_line);
                heart.setTag(0);
            }


        } // end onClick

    } // end MyListener()


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_card_title ;
        ImageView img_card_thumbnail;
        CardView cardView;
        ImageView heart;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_card_title = (TextView)itemView.findViewById(R.id.card_title_id); //card_view_item.xml의 card_title_id .ex)기분전환이 필요헤 ..
            img_card_thumbnail = (ImageView) itemView.findViewById(R.id.card_img_id); //card_view_item.xml의 card_img_id (배경이미지)
            cardView = (CardView) itemView.findViewById(R.id.cardview_id); //card_view_item.xml의 cardview_id (카드뷰 틀)
            heart = (ImageView) itemView.findViewById(R.id.card_heart);//card_view_item.xml의 card_heart(하트부분)


        }
    }

}
