package com.example.a91319.bikedemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a91319.bikedemo.Message;
import com.example.a91319.bikedemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class Paxirafragment extends Fragment {


    @BindView(R.id.RecyclerView_paxira)
    RecyclerView RecyclerViewPaxira;
    Unbinder unbinder;

    ArrayList<Message> messageArrayList = new ArrayList<>();


    public Paxirafragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paxirafragment, container, false);
        unbinder = ButterKnife.bind(this, view);


        for (int i=50;i>0;i--){
            Message message = new Message("timeTv"+i,"bikeNumber"+i,"bikeTime"+i,"bikePayMoney"+i);
            messageArrayList.add(message);
        }

        //布局管理器
        RecyclerViewPaxira.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
        //添加分隔线
        RecyclerViewPaxira.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        RecyclerViewPaxira.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            //返回一个自定义的viewholder对象
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_layout,parent,false));
            }

            //返回Viewholder中的控件
            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.timeTV.setText( messageArrayList.get( position ).getMy_time() );
                holder.bikeNumber.setText( messageArrayList.get( position ).getBike_number() );
                holder.bikeTime.setText( messageArrayList.get( position ).getCycling_time() );
                holder.bikePatMoney.setText( messageArrayList.get( position ).getCycling_money() );
            }


            @Override
            public int getItemCount() {
                return messageArrayList.size();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.time_TV)
        TextView timeTV;
        @BindView(R.id.bike_number)
        TextView bikeNumber;
        @BindView(R.id.bike_time)
        TextView bikeTime;
        @BindView(R.id.bike_PatMoney)
        TextView bikePatMoney;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
