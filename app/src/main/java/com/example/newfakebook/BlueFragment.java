package com.example.newfakebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.database.MyDtabase;

public class BlueFragment extends Fragment {

    MyDtabase dbManager;
    Button insert;
    EditText name;
    EditText age;
    EditText mark;
    TextView status;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.blue_frag, container, false);

        name = view.findViewById(R.id.te_name);
        age = view.findViewById(R.id.te_age);
        mark = view.findViewById(R.id.te_mark);
        insert = view.findViewById(R.id.data_insert);

        status = view.findViewById(R.id.tv_status);

        insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!(name.getText().toString().equals("") || age.getText().toString().equals("") || mark.getText().toString().equals(""))){
                    String s_name = name.getText().toString();
                    int s_age = Integer.parseInt(age.getText().toString()) ;
                    int s_mark = Integer.parseInt(mark.getText().toString());

                    insertStudent(s_name, s_age, s_mark);
                }
                else {
                    status.setText("Fill the all field..");
                }
            }
        });
        return view;
    }

    public BlueFragment newInstance(){
        BlueFragment blueFragment = new BlueFragment().newInstance();
        return blueFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dbManager = new MyDtabase(getContext());

    }

    public void insertStudent(String st_name , int st_age , int st_mark ){
        String answer = dbManager.insertStudent(st_name,st_age,st_mark);
        if (answer.equals("pass")){
            status.setText("Success fully added.!");
            name.setText("");
            age.setText("");
            mark.setText("");
        }
        else{
            status.setText("Fail to added data.!");
        }
    }

}
