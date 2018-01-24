package binarygeek.unixtimestampcounter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by uy on 1/22/2018.
 */

public class Adapter extends RecyclerView.Adapter<ModelViewHolder> {
    private ArrayList<model> list;
    private RecyclerItemClickListener recyclerItemClickListener;
    public Adapter(ArrayList<model> Data) {
        list = Data;
    }

    @Override
    public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_items, parent, false);
        final  ModelViewHolder holder = new ModelViewHolder(view);

        //CLICK LISTENER
        holder.itemView.findViewById(R.id.model_items).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = holder.getAdapterPosition();
                if (adapterPos != RecyclerView.NO_POSITION) {
                    if (recyclerItemClickListener != null) {
                        recyclerItemClickListener.onItemClick(adapterPos, holder.itemView.findViewById(R.id.model_items));
                    }
                }
            }
        });
        return holder;
    }



    public void setOnItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    //TODO:set saved icon on onBindViewHolder not onCreateViewHolder
    @Override
    public void onBindViewHolder(final ModelViewHolder holder, int position) {
        Long tsLong = System.currentTimeMillis();

        //for remaining time;
        for(int i=0;i<list.size();i++){
            String date = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date ((list.get(i).getUnixTime()/1000)-tsLong));
            holder.name.setText(list.get(position).getName());
            holder.remainingTime.setText(date.toString());
        }

    }



    @Override
    public int getItemCount() {
        return list.size();
    }


}


class ModelViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView remainingTime;

    public ModelViewHolder(View v) {
        super(v);
        name = (TextView) v.findViewById(R.id.name);
        remainingTime=(TextView)v.findViewById(R.id.time);
    }
}
