package com.example.fragment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MyFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView;
        contentView = inflater.inflate(R.layout.my_fragment, container, false);

        return contentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button myButton = (Button) getActivity().findViewById(R.id.my_button);

        Button myOther = (Button) getActivity().findViewById(R.id.my_other);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** 一、从同一个Activity的一个Fragment跳到另外一个Fragment*/
                //压栈式跳转
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new YourFragment(), null)
                        .addToBackStack(null)
                        .commit();

            }
        });
        myOther.setOnClickListener(new View.OnClickListener() {
            /**
             二、从一个Activity的Fragment跳转到另外一个Activity(等同于Activity之间的跳转（上下文是getActivity）)
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),OtherActivity.class);
                startActivity(intent);
            }
        });
    }
}