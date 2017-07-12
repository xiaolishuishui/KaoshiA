package com.example.administrator.kaoshia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/6.
 */

public class Myadapter extends BaseAdapter {
    Context context;
    ArrayList<Students> list;

    public Myadapter(Context context, ArrayList<Students> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewholder;
                if ( convertView==null){
                           convertView=View.inflate(context,R.layout.item,null) ;
                    viewholder=new ViewHolder();
                    viewholder.tv1= (TextView) convertView.findViewById(R.id.tv1);
                    viewholder.tv2= (TextView) convertView.findViewById(R.id.tv2);
                    viewholder.tv3= (TextView) convertView.findViewById(R.id.tv3);
                    convertView.setTag(viewholder);
                }else {
                     viewholder= (ViewHolder) convertView.getTag();
                        }
               viewholder.tv1.setText(list.get(position).getName());
               viewholder.tv2.setText(list.get(position).getDianhua());
               viewholder.tv3.setText(list.get(position).getDizhi());
               return convertView;
           }
           class ViewHolder{
               TextView tv1;
               TextView tv2;
               TextView tv3;
           }
}
