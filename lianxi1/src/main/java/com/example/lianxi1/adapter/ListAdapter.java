package com.example.lianxi1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.lianxi1.Person;
import com.example.lianxi1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */

public class ListAdapter extends BaseAdapter implements Filterable {
    private List<Person> list;

    private Context context;

    private PersonFilter filter;
    private List<Person> mList;

    public ListAdapter(List<Person> list, Context context) {
        this.list = list;
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        }
        Person p = list.get(position);
        TextView firstname = (TextView) convertView.findViewById(R.id.firstname);
        TextView lastname = (TextView) convertView.findViewById(R.id.lastname);
        TextView age = (TextView) convertView.findViewById(R.id.age);

        firstname.setText(p.firstname);
        lastname.setText(p.lastname);
        age.setText(p.age + "");



        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new PersonFilter(list);
        }
        return filter;
    }

    private class PersonFilter extends Filter {

        private List<Person> original;

        public PersonFilter(List<Person> list) {
            this.original = list;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = original;
                results.count = original.size();
            } else {
                mList = new ArrayList<Person>();
                for (Person p : original) {
                    if (p.firstname.toUpperCase().startsWith(constraint.toString().toUpperCase())
                            || p.lastname.toUpperCase().startsWith(constraint.toString().toUpperCase())
                            || new String(p.age + "").toUpperCase().startsWith(constraint.toString().toUpperCase())) {
                        mList.add(p);
                    }
                }
                results.values = mList;
                results.count = mList.size();

            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            list = (List<Person>) results.values;
            notifyDataSetChanged();
        }

    }


}