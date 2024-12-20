package com.pmdm.notas.NotasAdapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pmdm.notas.NotasAdapter.Entities.Nota;
import com.pmdm.notas.R;

import java.util.List;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.NotasAdapterHolder> {

    private List<Nota> lNota;
    private Context cxt;
    private final OnItemClickListener notaListener;
    private final OnItemLongClickListener notaLongListener;

    public NotasAdapter(List<Nota> dataSet, Context contexto, OnItemClickListener listener, OnItemLongClickListener longListener){
        this.lNota = dataSet;
        this.cxt = contexto;
        this.notaListener = listener;
        this.notaLongListener = longListener;
    }
    @NonNull
    public NotasAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.nota,parent,false);
        return new NotasAdapterHolder(inflate);
    }

    public void onBindViewHolder(@NonNull NotasAdapterHolder holder, int position){
        holder.mitem = lNota.get(position);
        holder.tvTitulo.setText(holder.mitem.getTitulo());
        holder.tvData.setText(holder.mitem.getData());
        holder.tvModulo.setText(holder.mitem.getModulo());
        // holder.
        holder.itemView.setOnClickListener(view -> {
            if(notaListener != null){
                notaListener.onItemClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(view -> {
            if(notaLongListener != null){
                notaLongListener.onItemLongClick(position);
                return true;
            } else
                return false;
        });

//        if(){
//
//        }

        if (holder.tvModulo.getText().equals("acda")){
            holder.ivImaxe.setImageResource(R.drawable.acda);
        }
        else if(holder.tvModulo.getText().equals("pmdm")){
            holder.ivImaxe.setImageResource(R.drawable.pmdm);
        }
        else if(holder.tvModulo.getText().equals("dein")){
            holder.ivImaxe.setImageResource(R.drawable.dein);
        }
        else if(holder.tvModulo.getText().equals("psp")){
            holder.ivImaxe.setImageResource(R.drawable.psp);
        }
        else{
            holder.ivImaxe.setImageResource(R.drawable.negacion);
        }

    }
    @Override
    public int getItemCount(){
        return lNota.size();
    }
    public class NotasAdapterHolder extends RecyclerView.ViewHolder {
        public final View vista;
        public final TextView tvTitulo;
        public final TextView tvData;
        public final TextView tvModulo;
        public final ImageView ivImaxe;
        public Nota mitem = null;

        public NotasAdapterHolder(View view){
            super(view);
            vista = view;
            ivImaxe = (ImageView) view.findViewById(R.id.imaxe);
            tvTitulo = (TextView) view.findViewById(R.id.tvTitulo);
            tvData = (TextView) view.findViewById(R.id.tvData);
            tvModulo = (TextView) view.findViewById(R.id.tvModulo);
        }
        @Override
        public String toString() {
            return super.toString() + "\t" + tvTitulo.getText() + "\t";
        }


    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public interface OnItemLongClickListener{
        void onItemLongClick(int position);
    }
}
