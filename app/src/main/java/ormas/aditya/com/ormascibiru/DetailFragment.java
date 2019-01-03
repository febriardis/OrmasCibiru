package ormas.aditya.com.ormascibiru;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    TextView name, address, type;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        //initial Id
        name = view.findViewById(R.id.name);
        address = view.findViewById(R.id.address);
        type = view.findViewById(R.id.type);

        //setData
        Bundle b = getArguments();
        name.setText(b.getString("name"));
        address.setText(b.getString("address"));
        type.setText(b.getString("type"));

        return view;
    }

}
