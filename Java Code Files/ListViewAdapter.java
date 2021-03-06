package com.example.bibeka.iva;

/**
 * Created by Juned on 6/17/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter
{
    Context context;

    List<Subject> TempSubjectList;

    public ListViewAdapter(List<Subject> listValue, Context context)
    {
        this.context = context;
        this.TempSubjectList = listValue;
    }

    @Override
    public int getCount()
    {
        return this.TempSubjectList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.TempSubjectList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewItem viewItem = null;

        if(convertView == null)
        {
            viewItem = new ViewItem();

            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInfiater.inflate(R.layout.listvalue, null);

            viewItem.IdTextView = (TextView)convertView.findViewById(R.id.textviewSubjectName);

            viewItem.NameTextView = (TextView)convertView.findViewById(R.id.textviewID);
            viewItem.PinTextView = (TextView)convertView.findViewById(R.id.textView3);
            viewItem.VoteTextView = (TextView)convertView.findViewById(R.id.textView2);
            viewItem.PartyTextView = (TextView)convertView.findViewById(R.id.textView);

            convertView.setTag(viewItem);
        }
        else
        {
            viewItem = (ViewItem) convertView.getTag();
        }



        viewItem.IdTextView.setText(TempSubjectList.get(position).Subject_ID);
        viewItem.NameTextView.setText(TempSubjectList.get(position).Subject_Name);
        viewItem.PinTextView.setText(TempSubjectList.get(position).Subject_Pin);
        viewItem.VoteTextView.setText(TempSubjectList.get(position).Subject_Vote);
        viewItem.PartyTextView.setText(TempSubjectList.get(position).Subject_Party);


        return convertView;
    }
}

