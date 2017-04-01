package id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.Fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.DataHelper;
import id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritItem extends Fragment {
    public static DaftarItem di;
    protected Cursor cursor;
    String[] daftar;
    ListView ListView01;
    DataHelper dbcenter;

    public FavoritItem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favorit_item, container, false);
        dbcenter = new DataHelper(getActivity());
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM item where favorite=" + true + "", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = (ListView) getView().findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2]; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"See Item", "Update Item"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Options");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getActivity().getApplicationContext(), SeeItem.class);
                                i.putExtra("item", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getActivity().getApplicationContext(), UpdateItem.class);
                                in.putExtra("item", selection);
                                startActivity(in);
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();

        return v;
    }


}
