package com.lin.tp.goupmark.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lin.tp.goupmark.R;

import java.util.List;


public class OnlyTextAdapter extends BaseAdapter{
    private List<String> mData;
    private LayoutInflater layoutInflater;
    private Context context;
    private int clickId;
    public OnlyTextAdapter(List<String> mData, Context context) {
        this.mData = mData;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView==null)
        {
            holder=new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.only_text_list_item,null);
            holder.textViewDesc=(TextView)convertView.findViewById(R.id.wineType);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }

        holder.textViewDesc.setText(mData.get(position));
        if (onItemClickListener!=null) {
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickId=position;
                    Toast.makeText(context,"asdasd",Toast.LENGTH_SHORT).show();
                    onItemClickListener.onItemClick(position);
                }
            });
        }
        return convertView;
    }
    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.onItemClickListener=listener;
    }
    private static class ViewHolder{
        TextView textViewDesc;
    }
}
