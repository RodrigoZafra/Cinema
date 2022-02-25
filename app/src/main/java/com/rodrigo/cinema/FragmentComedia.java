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
 * Use the {@link FragmentComedia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentComedia extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerPeliculasComedia;
    ArrayList<Peliculas> listaPeliculasComedia;

    public FragmentComedia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentComedia.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentComedia newInstance(String param1, String param2) {
        FragmentComedia fragment = new FragmentComedia();
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
        View vista = inflater.inflate(R.layout.fragment_comedia, container, false);
        listaPeliculasComedia = new ArrayList<>();

        recyclerPeliculasComedia = vista.findViewById(R.id.recyclerPeliculasComedia);
        recyclerPeliculasComedia.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        CarteleraAdapter adaptador = new CarteleraAdapter(listaPeliculasComedia, getContext());
        recyclerPeliculasComedia.setAdapter(adaptador);

        llenarLista();

        return vista;
    }

    private void llenarLista() {
        listaPeliculasComedia.add(new Peliculas("Dame paciencia", "Director: Benjamín Herranz", "https://image.tmdb.org/t/p/w185/9oIcKDhNXpi6wVdLhQQApdp9YLz.jpg"));
        listaPeliculasComedia.add(new Peliculas("Kun fu panda", "Director: John Stevenson", "https://image.tmdb.org/t/p/w185/wzOERnvuM3c2mbAvCu5pw1QIaZX.jpg"));
        listaPeliculasComedia.add(new Peliculas("Ahora o nunca", "Director: Brian Relyea", "https://image.tmdb.org/t/p/w185/bBgc1F5o6PMOxTPrOoZ3oIkP2KT.jpg"));
        listaPeliculasComedia.add(new Peliculas("Entre rosas", "Director: Pierre Pinaud", "https://image.tmdb.org/t/p/w185/w9nP4DisTtdynffsRAzXdXyvsCo.jpg"));
        listaPeliculasComedia.add(new Peliculas("The afterparty", "Director: Christopher Miller", "https://image.tmdb.org/t/p/w185/qkyggVNng4tTNe6I6TwIwOWSVEi.jpg"));
        listaPeliculasComedia.add(new Peliculas("Mi profesora favorita", "Director: Michael Elias", "https://image.tmdb.org/t/p/w185/fxqSX1hyErStQBO0SdkV7fu5jOp.jpg"));
        listaPeliculasComedia.add(new Peliculas("Amor artificial", "Director: David Asavanond", "https://image.tmdb.org/t/p/w185/cIJzuZpCzsCTcHISMWbAwDt2LGc.jpg"));
        listaPeliculasComedia.add(new Peliculas("Tammy", "Director: Ben Falcone", "https://image.tmdb.org/t/p/w185/nRPPVx9x5vqlDAQIB6WlZZ4Vq3B.jpg"));
        listaPeliculasComedia.add(new Peliculas("Flashback", "Director: Caroline Vigneaux", "https://image.tmdb.org/t/p/w185/wLJEwWOUmHHBW2HxkP8LEoqvq1L.jpg"));
    }
}