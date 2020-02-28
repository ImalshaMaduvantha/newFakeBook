package com.example.newfakebook;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newfakebook.database.MyDtabase;

import java.util.ArrayList;


public class BlackFragment extends Fragment {

    MyDtabase dbManager;
    ListView allView;
    String[] arr;

    public static BlackFragment newInstance(){
        BlackFragment blackFragment = new BlackFragment();
        return blackFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.black_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbManager = new MyDtabase(getContext());
        allView = view.findViewById(R.id.txtAll);
        viewAllStudent();
    }

    public void viewAllStudent() {

        Cursor cursor = dbManager.getAllStudents();
        ArrayList<String> dataset = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dataset);
        if ((cursor.getCount()) == 0) {
            AlertDialog.Builder message = new AlertDialog.Builder(getContext());
            message.setCancelable(true);
            message.setTitle("Error");
            message.setMessage("No Records Found");
            message.show();
        }

        StringBuffer buffer = new StringBuffer();

        while (cursor.moveToNext()) {
            buffer.append("Name  : " + cursor.getString(0) + "\n");
            buffer.append("Age   : " + cursor.getInt(1) + "\n");
            buffer.append("Mark  : " + cursor.getInt(2) + "\n\n");

        }
        arr = buffer.toString().split("\n\n");
        for (int i = 0; i < (arr.length); i++) {
            dataset.add(arr[i]);
        }
        allView.setAdapter(adapter);
    }

}
