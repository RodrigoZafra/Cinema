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
 * Use the {@link FragmentDrama#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDrama extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerPeliculasDrama;
    ArrayList<Peliculas> listaPeliculasDrama;

    public FragmentDrama() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAventura.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDrama newInstance(String param1, String param2) {
        FragmentDrama fragment = new FragmentDrama();
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
        View vista = inflater.inflate(R.layout.fragment_drama, container, false);
        listaPeliculasDrama = new ArrayList<>();
        recyclerPeliculasDrama = vista.findViewById(R.id.recyclerPeliculasDrama);
        recyclerPeliculasDrama.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        CarteleraAdapter adaptador = new CarteleraAdapter(listaPeliculasDrama, getContext());
        recyclerPeliculasDrama.setAdapter(adaptador);

        llenarLista();
        return vista;
    }

    private void llenarLista() {
        listaPeliculasDrama.add(new Peliculas("Las ilusiones perdidas", "Director: Xavier Giannoli", "https://eu-static.yelmocines.es/content/img/movies/posters/4160/1/1/4160.jpg"));
        listaPeliculasDrama.add(new Peliculas("Un pequeño mundo", "Director: Laura Wandel", "https://eu-static.yelmocines.es/content/img/movies/posters/4163/1/1/4163.jpg"));
        listaPeliculasDrama.add(new Peliculas("Great freedom", "Director: ", "https://eu-static.yelmocines.es/content/img/movies/posters/4165/1/1/4165.jpg"));
        listaPeliculasDrama.add(new Peliculas("Muerte en el nilo", "Director: ", "https://eu-static.yelmocines.es/content/img/movies/posters/3295/1/1/3295.jpg"));
        listaPeliculasDrama.add(new Peliculas("Entrevias", "Director: Aitor Gabilondo", "https://image.tmdb.org/t/p/w185/flHgD6YyZ6MGY64nAmCtK5pXrBd.jpg"));
        listaPeliculasDrama.add(new Peliculas("From", "Director: John Griffin", "https://image.tmdb.org/t/p/w185/h2XVccFQMQSBb6ZhyXOHMtAwrMP.jpg"));
        listaPeliculasDrama.add(new Peliculas("Monday", "Director: Argyris Papadimitropoulos", "https://image.tmdb.org/t/p/w185/o4Gc5quiCBtiW6mgkPvDWKAiFVs.jpg"));
        listaPeliculasDrama.add(new Peliculas("Joe Bell", "Director: Reinaldo Marcus", "https://image.tmdb.org/t/p/w185/9HfQD60w6f6PPkfdiI6ipJSw0bD.jpg"));
        listaPeliculasDrama.add(new Peliculas("Belfast", "Director: Anna Brabbins", "https://image.tmdb.org/t/p/w185/dRjbdzmiypTGDktRCfcMsjqqGud.jpg"));
    }
}