package ormas.aditya.com.ormascibiru;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrmasFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Ormas> ormas;
    private OrmasAdapter adapter;
    private ApiInterface apiInterface;
    ProgressBar progressBar;

    public OrmasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ormas, container, false);

        progressBar = view.findViewById(R.id.prograss);
        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchContact("users");
        return view;
    }

    public void fetchContact(String type){

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Ormas>> call = apiInterface.getBuah(type);
        call.enqueue(new Callback<List<Ormas>>() {
            @Override
            public void onResponse(Call<List<Ormas>> call, Response<List<Ormas>> response) {
                progressBar.setVisibility(View.GONE);
                ormas = response.body();
                adapter = new OrmasAdapter(ormas, getContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Ormas>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error\n"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
