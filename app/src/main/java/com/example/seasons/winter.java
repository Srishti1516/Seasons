package com.example.seasons;

import android.content.Context;
import android.os.Bundle;
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

public class winter extends Fragment {
    TextView textView1, textView2, textView3, textView4;
    ImageView image1, image2, image3, image4;
    ViewFlipper viewFlipper;
    Button favourite;
    public winter(){}
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
        favourite = view.findViewById(R.id.fav);
        textView4 = view.findViewById(R.id.textView4);
        image4 = view.findViewById(R.id.imageView4);

        image1.setImageResource(R.drawable.football);
        textView1.setText("FOOTBALL");
        image2.setImageResource(R.drawable.skiing);
        textView2.setText("SKIING");
        image3.setImageResource(R.drawable.snowman);
        textView3.setText("BUILD A SNOWMAN");
        image4.setImageResource(R.drawable.campfire);
        textView4.setText("CAMPFIRE");

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
                viewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
                viewFlipper.showNext();
            }
        });
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="";
                int x = viewFlipper.getDisplayedChild();
                if(x==0)message="FOOTBALL";
                else if(x==1)message="SKIING";
                else if(x==2)message="BUILD A SNOWMAN";
                else if(x==3)message="CAMPFIRE";
                //SM.sendData(message);
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
    /*interface SendMessage {
        void sendData(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }*/
}
