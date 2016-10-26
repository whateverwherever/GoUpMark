package com.lin.tp.goupmark.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lin.tp.goupmark.R;
import com.lin.tp.goupmark.ui.adapter.OnlyTextAdapter;

import java.util.ArrayList;
import java.util.List;


public class WineTypeListFragment extends ListFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final List<String> stringList=new ArrayList<>();
        stringList.add("啤酒");
        stringList.add("红酒");
        stringList.add("白酒");
        stringList.add("洋酒");
        stringList.add("黄酒");
        stringList.add("门店");
        stringList.add("活动");
        FragmentForTab_2 fragmentForTab_2=new FragmentForTab_2();

        final FragmentManager manager = getActivity().getSupportFragmentManager();
        Bundle bundle=new Bundle();
        bundle.putString("key",stringList.get(0));
        fragmentForTab_2.setArguments(bundle);
//        fragmentForTab_2.setArguments(bundle);
//        fragment.setArguments(bundle);
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.showInfo_content,fragmentForTab_2);
        transaction.commit();
        OnlyTextAdapter onlyTextAdapter=new OnlyTextAdapter(stringList,getActivity());
        setListAdapter(onlyTextAdapter);
        onlyTextAdapter.setOnItemClickListener(new OnlyTextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FragmentTransaction transaction = manager.beginTransaction();
                FragmentForTab_2 fragmentForTab_21=new FragmentForTab_2();
                Bundle bundle1=new Bundle();
                bundle1.putString("key",stringList.get(position));
                fragmentForTab_21.setArguments(bundle1);
                transaction.replace(R.id.showInfo_content,fragmentForTab_21);
                transaction.commit();
                Toast.makeText(getActivity(),stringList.get(position),Toast.LENGTH_SHORT).show();
            }
        });


        return inflater.inflate(R.layout.fragment_for_wine_type, container,false);
    }
}
