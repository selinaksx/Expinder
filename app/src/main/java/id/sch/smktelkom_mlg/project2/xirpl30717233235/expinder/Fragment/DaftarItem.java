package id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.IntentInput;
import id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarItem extends Fragment {


    public DaftarItem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_daftar_item2, container, false);
        v.findViewById(R.id.fabAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
        return v;
    }

    private void addItem() {

        Intent i = new Intent(getActivity(), IntentInput.class);
        startActivity(i);
    }

}
