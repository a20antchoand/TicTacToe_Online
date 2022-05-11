package com.example.tictactoe_online.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tictactoe_online.R;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public class ListAdapterPartidas extends RecyclerView.Adapter<ListAdapterPartidas.ViewHolder> {

    private List<ListElementPartidas> mData;
    private LayoutInflater mInflater;
    private Context context;
    final onItemClickListener listener;

    public interface onItemClickListener {
        void onItemClickListener(ListElementPartidas item) throws FirebaseAuthException;
    }

    public ListAdapterPartidas(List<ListElementPartidas> itemList, Context context, onItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int ViewType) {
        View view = mInflater.from(parent.getContext()).inflate(R.layout.list_element_partidas, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElementPartidas> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView nom;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            nom = itemView.findViewById(R.id.nom);



        }

        void bindData (final ListElementPartidas item) {
            nom.setText(item.getPartida().getJugadors().get(0));
            itemView.setOnClickListener(l -> {
                try {
                    listener.onItemClickListener(item);
                } catch (FirebaseAuthException e) {
                    e.printStackTrace();
                }
            });

        }

    }

}