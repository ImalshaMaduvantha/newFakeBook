package com.example.newfakebook;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.database.MyDtabase;

import java.util.ArrayList;

public class RedFragment extends Fragment {

    MyDtabase database;
    String[] std_data;
    ListView data_list;
    EditText user_name;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        database = new MyDtabase(getContext());

        return inflater.inflate(R.layout.red_frag , container , false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        data_list = view.findViewById(R.id.one_data);
        user_name = view.findViewById(R.id.et_name);
        btn = view.findViewById(R.id.button_search);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search_name = user_name.getText().toString();

                viewOneStudent(search_name);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public RedFragment newInstance(){
        RedFragment redFragment = new RedFragment().newInstance();
        return redFragment;
    }


    public void viewOneStudent(String name) {

        Cursor cr = database.getStudent(name);
        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter<String> data_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        if ((cr.getCount()) == 0) {
            AlertDialog.Builder message = new AlertDialog.Builder(getContext());
            message.setCancelable(true);
            message.setTitle("Error");
            message.setMessage("No Records Found");
            message.show();
        }

        StringBuffer buffer = new StringBuffer();

        while (cr.moveToNext()) {
            buffer.append("Name  : " + cr.getString(0) + "\n");
            buffer.append("Age   : " + cr.getInt(1) + "\n");
            buffer.append("Mark  : " + cr.getInt(2) + "\n\n");

        }
        std_data = buffer.toString().split("\n\n");
        for (int i = 0; i < (std_data.length); i++) {
            list.add(std_data[i]);
        }
        data_list.setAdapter(data_adapter);
    }


}
