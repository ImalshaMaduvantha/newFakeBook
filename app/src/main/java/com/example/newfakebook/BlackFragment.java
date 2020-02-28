package com.example.newfakebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class BlackFragment extends Fragment {

    public String[] names;
    public String[] ages;
    public ListView studentList;
    public int count;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.black_frag, null);

        createListView(root);

        return inflater.inflate(R.layout.black_frag , container , false);
    }

    public BlackFragment newInstance(){

        BlackFragment blackFragment = new BlackFragment().newInstance();
        return blackFragment;
    }

    public void createListView(ViewGroup root){
        names = new String[]{"akila","nimal","kamal"};
        ages = new String[]{"18","20","15"};

        count = names.length;

        studentList = root.findViewById(R.id.all_data);

        CustomAdapter ca = new CustomAdapter();

        studentList.setAdapter(ca);
    }

    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.listviewdatalayout,null);

            TextView name_view = (TextView)view.findViewById(R.id.textView_Name);
            TextView age_view = (TextView)view.findViewById(R.id.textView_Age);

            name_view.setText(names[1]);
            age_view.setText(ages[1]);

            return view;
        }
    }

}
