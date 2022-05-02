package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Customer> arrayList;

    public CustomerAdapter(Context context, int layout, ArrayList<Customer> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null) {
            view= LayoutInflater.from(context).inflate(layout,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.txtLopHP= view.findViewById(R.id.txtLopHP);
            viewHolder.txtName= view.findViewById(R.id.txtName);
            viewHolder.txtEmail= view.findViewById(R.id.txtEmail);
           viewHolder.imgPicture= view.findViewById(R.id.imgPicture);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.txtLopHP.setText(arrayList.get(i).getLopHP());
        viewHolder.txtName.setText(arrayList.get(i).getName());
        viewHolder.txtEmail.setText( String.valueOf(arrayList.get(i).getEmail()));
       viewHolder.imgPicture.setImageResource(arrayList.get(i).getImgCustomer());

        //
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context,DonutDetail.class);
//                intent.putExtra("title",donutArr.get(i).getTitle());
//                intent.putExtra("description",donutArr.get(i).getDescription());
//                intent.putExtra("price",donutArr.get(i).getPrice());
//                intent.putExtra("image",donutArr.get(i).getImgDount());
//                context.startActivity(intent);
//
//
//            }
//        });

        return view;
    }
    private class ViewHolder {
        TextView txtLopHP;
        TextView txtName;
        TextView txtEmail;
        ImageView imgPicture;
    }
}