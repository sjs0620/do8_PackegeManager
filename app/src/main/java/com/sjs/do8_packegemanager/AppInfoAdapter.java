package com.sjs.do8_packegemanager;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class AppInfoAdapter extends BaseAdapter {
    private List<ApplicationInfo> mInfo;

    public AppInfoAdapter(List<ApplicationInfo> data) {
        this.mInfo = data;
    }

    @Override
    public int getCount() {
        return mInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return mInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
            holder.imageView = convertView.findViewById(R.id.icon_image);
            holder.textView = convertView.findViewById(R.id.app_name_text);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        ApplicationInfo info = mInfo.get(position);

        Drawable icon = info.loadIcon(parent.getContext().getPackageManager());
        holder.imageView.setImageDrawable(icon);

        String name = String.valueOf(info.loadLabel(parent.getContext().getPackageManager()));
        holder.textView.setText(name);

        return convertView;
    }

    private static class  ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
