package id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.Info;
import id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.R;

/**
 * Created by Shelin on 28/03/2017.
 */

public class infoAdapter extends RecyclerView.Adapter<infoAdapter.ViewHolder> {
    ArrayList<Info> InfoList;
    IInfoAdapter mInfoAdapter;


    public infoAdapter(Context context, ArrayList<Info> angkotList) {
        this.InfoList = angkotList;
        mInfoAdapter = (IInfoAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_info_detaills, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Info info = InfoList.get(position);
        holder.tvJudul.setText(info.judul);
        holder.ivFoto.setImageURI(Uri.parse(info.foto));
    }

    @Override
    public int getItemCount() {
        if (InfoList != null)
            return InfoList.size();
        return 0;
    }

    public interface IInfoAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mInfoAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}

