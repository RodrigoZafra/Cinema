package com.rodrigo.cinema;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rodrigo.cinema.Adapter.Peliculas;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAccion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAccion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerPeliculasAccion;
    ArrayList<Peliculas> listaPeliculasAccion;

    public FragmentAccion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_accion.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAccion newInstance(String param1, String param2) {
        FragmentAccion fragment = new FragmentAccion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_accion, container, false);
        listaPeliculasAccion = new ArrayList<>();
        recyclerPeliculasAccion = vista.findViewById(R.id.recyclerPeliculasAccion);
        recyclerPeliculasAccion.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        CarteleraAdapter adaptador = new CarteleraAdapter(listaPeliculasAccion, getContext(), this);
        recyclerPeliculasAccion.setAdapter(adaptador);

        llenarLista();

        return vista;
    }

    private void llenarLista() {
        listaPeliculasAccion.add(new Peliculas("SpiderMan", "Director: Jon Watts", "https://eu-static.yelmocines.es/content/img/movies/posters/3633/1/1/3633.jpg"));
        listaPeliculasAccion.add(new Peliculas("Uncharted", "Director: Ruben Fleischer", "https://eu-static.yelmocines.es/content/img/movies/posters/4091/1/1/4091.jpg"));
        listaPeliculasAccion.add(new Peliculas("Pursuit", "Director: Brian Skiba", "https://image.tmdb.org/t/p/w185/wYihSXWYqN8Ejsdut2P1P0o97N0.jpg"));
        listaPeliculasAccion.add(new Peliculas("Indemnity", "Director: Travis Taute", "https://image.tmdb.org/t/p/w185/tVbO8EAbegVtVkrl8wNhzoxS84N.jpg"));
        listaPeliculasAccion.add(new Peliculas("La intervención", "Director: Fred Grivois", "https://image.tmdb.org/t/p/w185/yyhigFBUp0uqPztHwIB4IolQjA5.jpg"));
        listaPeliculasAccion.add(new Peliculas("La quinta ola", "Director: Gail Hunter", "https://www.hdfull-v1.com/wp-content/uploads/2020/10/la-quinta-ola-12344-poster-193x288.jpg?x28658"));
        listaPeliculasAccion.add(new Peliculas("Baby driver", "Director: Darrin Prescott", "https://image.tmdb.org/t/p/w185/o2YToge3eBhxC89m87zkWKVEx2O.jpg"));
        listaPeliculasAccion.add(new Peliculas("La soga salvation", "Director: Manny Pérez", "https://image.tmdb.org/t/p/w185/wRk6hwsEIIO0BqGH8FIc1Zbf7Wv.jpg"));
        listaPeliculasAccion.add(new Peliculas("El redentor", "Director:  Steven Knight", "https://image.tmdb.org/t/p/w185/7y9HJW8qgcqEZuT9Ioj1CwpArD7.jpg"));
    }

    public void abrirFormulario() {
        Intent intent = new Intent(getActivity(), FormularioActivity.class);
        startActivity(intent);
    }
}