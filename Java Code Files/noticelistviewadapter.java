package com.example.bibeka.iva;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bibeka on 3/19/2018.
 */

public class noticelistviewadapter extends BaseAdapter
{
    Context context;

    List<noticesub> TempSubjectList;

    public noticelistviewadapter(List<noticesub> listValue, Context context)
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
        noticeviewitem viewItem = null;

        if(convertView == null)
        {
            viewItem = new noticeviewitem();

            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInfiater.inflate(R.layout.noticeview, null);

            viewItem.DateTextView = (TextView)convertView.findViewById(R.id.datedrop);
            viewItem.SubjectTextView = (TextView)convertView.findViewById(R.id.subject);
            convertView.setTag(viewItem);
        }
        else
        {
            viewItem = (noticeviewitem) convertView.getTag();
        }



        viewItem.DateTextView.setText(TempSubjectList.get(position).Subject_DATE);
        viewItem.SubjectTextView.setText(TempSubjectList.get(position).Subject_SUBJECT);


        return convertView;
    }
}
