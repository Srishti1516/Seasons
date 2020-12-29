package com.example.seasons;

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

public class rainy extends Fragment {

    TextView textView1,textView2,textView3,textView4;
    ImageView image1,image2,image3,image4;
    ViewFlipper viewFlipper;
    public rainy(){}
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

        image1.setImageResource(R.drawable.kayaking);
        textView1.setText("KAYAKING");
        image2.setImageResource(R.drawable.rafting);
        textView2.setText("RAFTING");
        image3.setImageResource(R.drawable.waterfall_trekking);
        textView3.setText("WATERFALL TREKKING");
        image4.setImageResource(R.drawable.enjoying);
        textView4.setText("ENJOYING THE RAIN");

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
        Button favourite = view.findViewById(R.id.fav);
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="";
                int x = viewFlipper.getDisplayedChild();
                if(x==0)message="KAYAKING";
                else if(x==1)message="RAFTING";
                else if(x==2)message="WATERFALL TRAINING";
                else if(x==3)message="ENJOYING THE RAIN";
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
