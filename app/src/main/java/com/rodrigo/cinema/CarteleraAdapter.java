package com.rodrigo.cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rodrigo.cinema.Adapter.Peliculas;

import java.util.ArrayList;
import java.util.List;

public class CarteleraAdapter extends RecyclerView.Adapter<CarteleraAdapter.ViewHolder> {

    private ArrayList<Peliculas> peliculas;
    private Context context;

    public CarteleraAdapter(ArrayList<Peliculas> peliculas, Context context) {
        this.peliculas = peliculas;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartelera, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitulo.setText(peliculas.get(position).getTitulo());
        holder.tvDesc.setText(peliculas.get(position).getDescripcion());
        Glide.with(context).load(peliculas.get(position).getImagen())
                .centerCrop()
                .into(holder.img_pelicula);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_pelicula;
        private TextView tvTitulo;
        private TextView tvDesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_pelicula = itemView.findViewById(R.id.img_pelicula);
            tvTitulo = itemView.findViewById(R.id.tvTituloPelicula);
            tvDesc = itemView.findViewById(R.id.tvDescPelicula);
        }
    }
}
