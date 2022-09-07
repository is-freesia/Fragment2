package com.example.fragment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class OtherFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView;
        contentView = inflater.inflate(R.layout.other_fragment, container, false);
        return contentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button ToButton = (Button) getActivity().findViewById(R.id.to_button);
        ToButton.setOnClickListener(new View.OnClickListener() {
            /*4、从一个Activity的Fragment跳转到另外一个Activity的Fragment上
            这种跳转与第三种跳转极为类似，我们只需要将
            Intent intent = new Intent(OtherActivity.this, MainActivity.class);
            书写在对应的Fragment中，将OtherActivity.this更改为getActivity()，其他不用改变，几个完成跳转.
            */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
    }
}