package com.rodrigo.cinema;

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
 * Use the {@link FragmentTerror#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTerror extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerPeliculasTerror;
    ArrayList<Peliculas> listaPeliculasTerror;

    public FragmentTerror() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTerror.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTerror newInstance(String param1, String param2) {
        FragmentTerror fragment = new FragmentTerror();
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
        View vista = inflater.inflate(R.layout.fragment_terror, container, false);
        listaPeliculasTerror = new ArrayList<>();

        recyclerPeliculasTerror = vista.findViewById(R.id.recyclerPeliculasTerror);
        recyclerPeliculasTerror.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        CarteleraAdapter adaptador = new CarteleraAdapter(listaPeliculasTerror, getContext());
        recyclerPeliculasTerror.setAdapter(adaptador);

        llenarLista();

        return vista;
    }

    private void llenarLista() {
        listaPeliculasTerror.add(new Peliculas("La abuela", "Director: Paco Plaza", "https://eu-static.yelmocines.es/content/img/movies/posters/3877/1/1/3877.jpg"));
        listaPeliculasTerror.add(new Peliculas("The medium", "Director:  Narilya", "https://eu-static.yelmocines.es/content/img/movies/posters/4162/1/1/4162.jpg"));
        listaPeliculasTerror.add(new Peliculas("Scream", "Director: Neve Campbell", "https://cdntmdb.xyz/p/v2/w1/qOXP6VauMfjFh623TGKtDvQgxCC4ExHUcu.jpg"));
        listaPeliculasTerror.add(new Peliculas("Fallen", "Director: Andrea Zirio", "https://cdntmdb.xyz/p/v2/w1/Pr0mo55IcdpMHnhUlUTJFeKC8UI.jpg"));
        listaPeliculasTerror.add(new Peliculas("El grito", "Director:  Sarah Michelle", "https://cdntmdb.xyz/p/v2/w1/LXNuHO03DevttpL.jpg"));
        listaPeliculasTerror.add(new Peliculas("Reunion", "Director:  Julia Ormond", "https://cdntmdb.xyz/p/v2/w1/2kJm7S0lzKWzeTehyTo7sdoAdG3xBzduKNGH.jpg"));
        listaPeliculasTerror.add(new Peliculas("El paramo", "Director:  Inma Cuesta", "https://cdntmdb.xyz/p/v2/w1/WEvTIYqjA8M2AGvFfNeM.jpg"));
        listaPeliculasTerror.add(new Peliculas("Megalodon", "Director:  Michael Madsen", "https://cdntmdb.xyz/p/v2/w1/e58eCjRv76rejV0.jpg"));
        listaPeliculasTerror.add(new Peliculas("La monja", "Director:  Demián Bichir", "https://cdntmdb.xyz/p/v2/w1/wmYnBNSJQrkGaQGYTi5M.jpg"));
    }
}
