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

public class stage2 extends Fragment {
    private int mCount = 5;
    private TextView mShowCount;
    private TextView mstagelevel;
    private TextView mstatus;
    private TextView minfo;
    private ImageView mimage;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.stage2, container, false);
        final Button btn = (Button) view.findViewById(R.id.increasecount);
        mstagelevel = view.findViewById(R.id.stagelevel);
        mstatus = view.findViewById(R.id.status);
        minfo = view.findViewById(R.id.info);
        mimage = view.findViewById(R.id.level2image);
        final MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.apple);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                mp.start();
                mShowCount = view.findViewById(R.id.count);
                ++mCount;
                if (mShowCount != null)
                    mShowCount.setText(Integer.toString(mCount));
                if (mCount == 9){
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mp.start();
                            Fragment fragment= new stage3();
                            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                            transaction.replace(R.id.stage2, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
                            transaction.addToBackStack(null);  // this will manage backstack
                            transaction.commit();
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

