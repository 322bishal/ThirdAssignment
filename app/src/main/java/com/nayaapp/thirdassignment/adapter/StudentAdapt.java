package com.nayaapp.thirdassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nayaapp.thirdassignment.R;
import com.nayaapp.thirdassignment.model.DataSet;

import java.util.List;

public class StudentAdapt extends RecyclerView.Adapter<StudentAdapt.Studentview> {
    Context context;
    List<DataSet> dataSetList;

    public StudentAdapt(Context context, List<DataSet> dataSetList) {
        this.context = context;
        this.dataSetList = dataSetList;
    }

    @NonNull
    @Override
    public StudentAdapt.Studentview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new Studentview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapt.Studentview holder, final int position) {
        DataSet dataSet= dataSetList.get(position);
        if(dataSet.getStugender().equalsIgnoreCase("male")){
            holder.imgcard.setImageResource(R.drawable.ic_male_user);
        }

        else if (dataSet.getStugender().equalsIgnoreCase("female")){
            holder.imgcard.setImageResource(R.drawable.ic_woman_avatar);
        }

        else {

            holder.imgcard.setImageResource(R.drawable.noimage);
        }
        holder.txname.setText(dataSet.getStuname());
        holder.txaddress.setText(dataSet.getStuaddress());
        holder.txage.setText(dataSet.getStuage());
        holder.txgender.setText(dataSet.getStugender());

        holder.btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSetList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSetList.size();
    }

    public class Studentview extends RecyclerView.ViewHolder {
        ImageView imgcard;
        TextView txname,txaddress,txage,txgender;
        Button btndel;
        public Studentview(@NonNull View itemView) {
            super(itemView);
            imgcard= itemView.findViewById(R.id.cv);
            txname= itemView.findViewById(R.id.tvname);
            txaddress= itemView.findViewById(R.id.tvaddresss);
            txage= itemView.findViewById(R.id.tvage);
            btndel= itemView.findViewById(R.id.btndelete);
            txgender=itemView.findViewById(R.id.tvgender);
        }
    }
}
