package com.example.seasons;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.prefs.Preferences;

public class summer extends Fragment {
    TextView textView1,textView2,textView3,textView4;
    ImageView image1,image2,image3,image4;
    ViewFlipper viewFlipper;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public summer(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.seasonfragment, container, false);


        viewFlipper = view.findViewById(R.id.viewflipper);
        textView1 = view.findViewById(R.id.textView1);
        image1 = view.findViewById(R.id.imageView1);

        textView2 = view.findViewById(R.id.textView2);
        image2 = view.findViewById(R.id.imageView2);
        textView3 = view.findViewById(R.id.textView3);
        image3 = view.findViewById(R.id.imageView3);

        textView4 = view.findViewById(R.id.textView4);
        image4 = view.findViewById(R.id.imageView4);

        image1.setImageResource(R.drawable.summer);
        textView1.setText("BEACHES");
        image2.setImageResource(R.drawable.swimming);
        textView2.setText("SWIMMING");
        image3.setImageResource(R.drawable.ice_cream);
        textView3.setText("ICE CREAM");
        image4.setImageResource(R.drawable.themepark);
        textView4.setText("THEME PARK");

        Button previous = view.findViewById(R.id.previous);
        Button next = view.findViewById(R.id.next);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(getActivity(), R.anim.slide_right_in);
                viewFlipper.setOutAnimation(getActivity(), R.anim.slide_left_out);
                viewFlipper.showPrevious();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               viewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
                viewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
                viewFlipper.showNext();
            }
        });
        Button favourite = view.findViewById(R.id.fav);
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="";
                int x = viewFlipper.getDisplayedChild();
                if(x==0)message="BEACHES";
                else if(x==1)message="SWIMMING";
                else if(x==2)message="ICE CREAM";
                else if(x==3)message="THEME PARK";
                int flag = 0;
                for (String a:value.fave)
                {
                    if(a.equals(message)){
                        Toast.makeText(getActivity(),"Removed from favourites",Toast.LENGTH_SHORT).show();
                        value.fave.remove(a);
                        flag = 1;
                        break;
                    }
                }
                if(flag==0) {
                    Toast.makeText(getActivity(),"Added to favourites",Toast.LENGTH_SHORT).show();
                    value.fave.add(message);
                }


            }
        });

        return view;
    }

}
