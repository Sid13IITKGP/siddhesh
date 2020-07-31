package com.example.siddhesh;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.example.siddhesh.R.*;

public class stage1 extends Fragment {
    private int mCount = 0;
    private TextView mShowCount;
    private TextView mstagelevel;
    private TextView mstatus;
    private TextView minfo;
    private ImageView mimage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(layout.stage1, container, false);
        final Button btn = (Button) view.findViewById(id.increasecount);
        mstagelevel = view.findViewById(id.stagelevel);
        mstatus = view.findViewById(id.status);
        minfo = view.findViewById(id.info);
        mimage = view.findViewById(id.level1image);

        //adding sound to the button on click
        final MediaPlayer mp = MediaPlayer.create(getActivity(), raw.apple);

        // use button to increase the counts

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                mp.start();
                mShowCount = view.findViewById(id.count);
                ++mCount;
                if (mShowCount != null)
                    mShowCount.setText(Integer.toString(mCount));
// when counts hit 4 it will change fragment
                if (mCount == 4){
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mp.start();
                            Fragment fragment= new stage2();
                            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                            transaction.replace(id.stage1, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
                            transaction.addToBackStack(null);  // this will manage backstack
                            transaction.commit();

                            // all the views will be gone for next child view
                            mShowCount.setVisibility(View.GONE);
                            btn.setVisibility(View.GONE);
                            mstagelevel.setVisibility(View.GONE);
                            mstatus.setVisibility(View.GONE);
                            minfo.setVisibility(View.GONE);
                            mimage.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });
        return view;
    }
}

