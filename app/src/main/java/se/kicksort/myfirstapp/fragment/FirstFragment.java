package se.kicksort.myfirstapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import se.kicksort.myfirstapp.R;


public class FirstFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    private EditText mEditText;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mEditText = (EditText) view.findViewById(R.id.editText);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            String text = mEditText.getText().toString();
            mListener.onFragmentInteraction(text);
        }
    }

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String text);
    }
}
