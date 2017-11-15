package com.fragments;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.widget.Toast;

public class BaseFragment extends Fragment {

    public void showToast(Context context, String Message) {
        Toast toast = Toast.makeText(context, Message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
