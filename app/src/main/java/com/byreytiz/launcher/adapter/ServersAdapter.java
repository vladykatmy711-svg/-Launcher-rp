package com.byreytiz.launcher.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byreytiz.game.R;
import com.byreytiz.launcher.model.Servers;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.List;

public class ServersAdapter extends RecyclerView.Adapter<ServersAdapter.ServersViewHolder> {
    private Context context;
    private List<Servers> serversList;

    public ServersAdapter(Context context, List<Servers> serversList) {
        this.context = context;
        this.serversList = serversList;
    }

    @NonNull
    @Override
    public ServersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_server, parent, false);
        return new ServersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServersViewHolder holder, int position) {
        Servers server = serversList.get(position);
        holder.serverName.setText(server.getName());
        holder.serverPlayers.setText(server.getPlayers() + "/" + server.getMaxPlayers());
        
        int progress = (int) ((float) server.getPlayers() / server.getMaxPlayers() * 100);
        holder.progressBar.setProgress(progress);
    }

    @Override
    public int getItemCount() {
        return serversList.size();
    }

    public static class ServersViewHolder extends RecyclerView.ViewHolder {
        TextView serverName;
        TextView serverPlayers;
        CircularProgressBar progressBar;

        public ServersViewHolder(@NonNull View itemView) {
            super(itemView);
            serverName = itemView.findViewById(R.id.server_name);
            serverPlayers = itemView.findViewById(R.id.server_players);
            progressBar = itemView.findViewById(R.id.server_progress);
        }
    }
  }
