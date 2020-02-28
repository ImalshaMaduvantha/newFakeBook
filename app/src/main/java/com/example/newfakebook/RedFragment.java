package com.example.newfakebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newfakebook.database.MyDtabase;

import java.util.ArrayList;

public class RedFragment extends Fragment {

    MyDtabase DATABASE;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        DATABASE = new MyDtabase(getContext());

        return inflater.inflate(R.layout.red_frag , container , false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public RedFragment newInstance(){
        RedFragment redFragment = new RedFragment().newInstance();
        return redFragment;
    }

}
