package pl.jawegiel.mymvpapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.jawegiel.mymvpapp.model.RestDataModel;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    Context context;
    List<RestDataModel> restDataModelList;

    public UsersAdapter(Context context, List<RestDataModel> restDataModelList) {
        this.restDataModelList = restDataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, final int position) {
        // set the data
        holder.idTextView.setText("Id: " + restDataModelList.get(position).getId());
        holder.titleTextView.setText("Title: " + restDataModelList.get(position).getTitle());
        holder.itemView.setOnClickListener(view -> {
            // display a toast with user name
            Toast.makeText(context, restDataModelList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return restDataModelList.size();
    }

    static class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView idTextView, titleTextView;

        public UsersViewHolder(View item) {
            super(item);
            idTextView = item.findViewById(R.id.id);
            titleTextView = item.findViewById(R.id.title);
        }
    }
}