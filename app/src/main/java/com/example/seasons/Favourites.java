package com.example.seasons;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Favourites extends Fragment {
    ListView listView;
    String ListItems[];
    ArrayList<String> ListElementsArrayList;
    ArrayAdapter<String> adapter;
    TextView print;
    Button a;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.favoritelist,container,false);
        listView = view.findViewById(R.id.list);
        //print=view.findViewById(R.id.abc);
        ListElementsArrayList = value.fave;
        adapter = new ArrayAdapter<>
                (getActivity(), android.R.layout.simple_list_item_1, ListElementsArrayList);
        listView.setAdapter(adapter);
        //a=view.findViewById(R.id.button5);
        /*print.setText("size-"+value.fave.size());
        for (String a:value.fave) {
            print.append(a+" bcd ");
            //Toast.makeText(getContext(), a, Toast.LENGTH_SHORT).show();
        }*
       /* a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // print.setText("abcd");
                print.setText("size-"+value.fave.size());
                for (String a:value.fave) {
                    print.append(a+" bcd ");
                    //Toast.makeText(getContext(), a, Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //print.setText("size-"+value.fave.size());
                for (String a:value.fave) {
                    //print.append(a+" bcd ");
                    //Toast.makeText(getContext(), a, Toast.LENGTH_SHORT).show();
                    ListElementsArrayList = value.fave;
                    adapter = new ArrayAdapter<>
                            (getActivity(), android.R.layout.simple_list_item_1, ListElementsArrayList);
                    listView.setAdapter(adapter);
                }
            }
        }, 5000);
       return view;
    }




    /*  @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            ListElementsArrayList = savedInstanceState.getStringArrayList("ARRAY");
        }
        else
            ListElementsArrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>
                (getActivity(), android.R.layout.simple_list_item_1, ListElementsArrayList);
        listView.setAdapter(adapter);



    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("ARRAY", ListElementsArrayList);
    }

    protected void displayReceivedData(String message)
    {

        ListElementsArrayList.add(message);
        adapter.notifyDataSetChanged();
    }*/

}
