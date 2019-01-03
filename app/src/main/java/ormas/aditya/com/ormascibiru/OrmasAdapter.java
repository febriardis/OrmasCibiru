package ormas.aditya.com.ormascibiru;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class OrmasAdapter extends RecyclerView.Adapter<OrmasAdapter.OrmasViewHolder>{
    private List<Ormas> ormas;
    private Context context;

    public OrmasAdapter(List<Ormas> ormas, Context context) {
        this.ormas = ormas;
        this.context = context;
    }

    @NonNull
    @Override
    public OrmasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new OrmasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrmasViewHolder holder, int position) {
        final Ormas d = ormas.get(position);
        holder.name.setText(d.getName());

        //event click menampilkan detail cardview
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Here goes your desired onClick behaviour. Like:
                Toast.makeText(view.getContext(), "Show ormas details" , Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putString("name", d.getName());
                bundle.putString("address", d.getAddress());
                bundle.putString("type", d.getType());

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                DetailFragment myFragment = new DetailFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, myFragment).addToBackStack(null).commit();

                myFragment.setArguments(bundle);/////
            }
        });

    }

    @Override
    public int getItemCount() {
        return ormas.size();
    }

    class OrmasViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView cardView;

        public OrmasViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_ormas);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
