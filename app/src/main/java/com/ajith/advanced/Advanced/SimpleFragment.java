package com.ajith.advanced.Advanced;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ajith.advanced.R;

import static com.ajith.advanced.MainActivity.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    private static final int YES = 0;
    private static final int NO = 1;
    private static final int NONE = 2;

    private static final String CHOICE = "choice";

    private int mRadioButtonChoice = NONE;

    interface OnFragmentInteractionListener{
        void onRadioButtonChoice(int choice);
    }

    OnFragmentInteractionListener mListener;

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + getResources().getString(R.string.exception_message));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_simple, container, false);

        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);

        Log.d(TAG, "onCreateView: Fragment");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);

                TextView textView = rootView.findViewById(R.id.fragment_header);

                switch (index){
                    case YES:
                        textView.setText(R.string.yes_message);
                        mRadioButtonChoice = YES;
                        Log.d(TAG, mRadioButtonChoice+"onCheckedChanged: "+ mListener);
                        mListener.onRadioButtonChoice(mRadioButtonChoice);
                        break;
                    case NO:
                        textView.setText(R.string.no_message);
                        mRadioButtonChoice = NO;
                        mListener.onRadioButtonChoice(mRadioButtonChoice);
                        break;
                        default:
                            mRadioButtonChoice = NONE;
                            mListener.onRadioButtonChoice(mRadioButtonChoice);
                            break;
                }
            }
        });

        return rootView;
    }

}
