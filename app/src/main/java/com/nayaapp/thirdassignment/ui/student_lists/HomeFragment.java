package com.nayaapp.thirdassignment.ui.student_lists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nayaapp.thirdassignment.R;
import com.nayaapp.thirdassignment.adapter.StudentAdapt;
import com.nayaapp.thirdassignment.model.DataSet;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    public RecyclerView recyclerView;
    View view;
    List<DataSet> studentLists = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.RcView);
        DataSet sd = new DataSet("riya", "thapa", "14", "female");

        studentLists = sd.getSlist();


        if (studentLists.isEmpty()) {
            studentLists.add(sd);

            studentLists.add(new DataSet("prabin", "namgyal", "16", "male"));


            sd.setSlist(studentLists);

        }


        StudentAdapt studentAdpt = new StudentAdapt(getActivity(), studentLists);
        recyclerView.setAdapter(studentAdpt);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}


