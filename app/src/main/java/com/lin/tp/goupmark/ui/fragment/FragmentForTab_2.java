package com.lin.tp.goupmark.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lin.tp.goupmark.R;

/**
 * Created by TP on 2016/7/14.
 */

public class FragmentForTab_2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content_2,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=getArguments();
        if (bundle!=null)
        {
            TextView textView= (TextView) getActivity().findViewById(R.id.ttttttttt);
            String string=bundle.getString("key");
            textView.setText(string);

        }
    }
}
