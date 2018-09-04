package com.example.a91319.bikedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.edu.mytest.dao.DaoMaster;
import com.example.edu.mytest.dao.RideRecord;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestDaoFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.generateDaoButton)
    Button generateDaoButton;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    ArrayList<RideRecord> rideRecords = new ArrayList<>();
    RecyclerView.Adapter<ViewHolder> adapter;
    DaoMaster daomaster;


    public TestDaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test_dao, container, false);
        unbinder = ButterKnife.bind(this, view);
        initlayout();
        return view;
    }

    private void initlayout() {

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getContext(),getActivity().getPackageName()+"bike.db");
        daomaster = new DaoMaster(helper.getWritableDatabase());
        rideRecords = (ArrayList<RideRecord>) daomaster.newSession().getRideRecordDao().loadAll();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        adapter = new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_layout,parent,false));
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.bikeNumber.setText(String.valueOf(rideRecords.get(position).getBike_id()));
                holder.bikePatMoney.setText(String.valueOf(rideRecords.get(position).getMoney()));
                int time = (int) (rideRecords.get(position).getEnd_at().getTime()-rideRecords.get(position).getStart_at().getTime());
                int bikeTime = time/(1000*60);
                holder.bikeTime.setText(String.valueOf(bikeTime));
                holder.timeTV.setText(rideRecords.get(position).getStart_at().toString());
            }

            @Override
            public int getItemCount() {
                return 0;
            }
        };

        recyclerView.setAdapter(adapter);
        generateDaoButton.setOnClickListener(this);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.generateDaoButton:
                generateDb();
        }
    }

    private void generateDb() {
        ArrayList<RideRecord> datas = new ArrayList<>();
        int current = (int) daomaster.newSession().getRideRecordDao().count();
        for (int i=current;i<current+10;i++){
            RideRecord record = new RideRecord();
            record.setId((long) i);
            record.setBike_id(i);
            record.setStart_at(new Date(2018,6,20));
            record.setEnd_at(new Date(2018,6,21));
            record.setMoney(100);
            record.setIs_pay(true);
            datas.add(record);

        }

        daomaster.newSession().getRideRecordDao().insertOrReplaceInTx(datas);
        rideRecords.clear();
        rideRecords.addAll(daomaster.newSession().getRideRecordDao().loadAll());
        adapter.notifyDataSetChanged();

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
