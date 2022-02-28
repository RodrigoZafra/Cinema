package com.rodrigo.cinema;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rodrigo.cinema.Adapter.Peliculas;

import java.util.ArrayList;
import java.util.List;

public class CarteleraAdapter extends RecyclerView.Adapter<CarteleraAdapter.ViewHolder> {

    private ArrayList<Peliculas> peliculas;
    private Context context;
    private FragmentAccion fragmentAccion;
    private FragmentComedia fragmentComedia;
    private FragmentTerror fragmentTerror;
    private FragmentDrama fragmentDrama;

    public CarteleraAdapter(ArrayList<Peliculas> peliculas, Context context, FragmentAccion fragmentAccion) {
        this.peliculas = peliculas;
        this.context = context;
        this.fragmentAccion = fragmentAccion;
    }

    public CarteleraAdapter(ArrayList<Peliculas> peliculas, Context context, FragmentComedia fragmentComedia) {
        this.peliculas = peliculas;
        this.context = context;
        this.fragmentComedia = fragmentComedia;
    }

    public CarteleraAdapter(ArrayList<Peliculas> peliculas, Context context, FragmentTerror fragmentTerror) {
        this.peliculas = peliculas;
        this.context = context;
        this.fragmentTerror = fragmentTerror;
    }

    public CarteleraAdapter(ArrayList<Peliculas> peliculas, Context context, FragmentDrama fragmentDrama) {
        this.peliculas = peliculas;
        this.context = context;
        this.fragmentDrama = fragmentDrama;
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
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentAccion != null) {
                    fragmentAccion.abrirFormulario();
                } else if (fragmentComedia != null) {
                    fragmentComedia.abrirFormulario();
                } else if (fragmentDrama != null) {
                    fragmentDrama.abrirFormulario();
                } else {
                    fragmentTerror.abrirFormulario();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_pelicula;
        private TextView tvTitulo;
        private TextView tvDesc;
        private CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_pelicula = itemView.findViewById(R.id.img_pelicula);
            tvTitulo = itemView.findViewById(R.id.tvTituloPelicula);
            tvDesc = itemView.findViewById(R.id.tvDescPelicula);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }

}
