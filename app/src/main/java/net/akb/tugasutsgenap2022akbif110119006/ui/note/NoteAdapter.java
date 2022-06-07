package net.akb.tugasutsgenap2022akbif110119006.ui.note;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.akb.tugasutsgenap2022akbif110119006.R;
import net.akb.tugasutsgenap2022akbif110119006.model.NoteModel;

import java.util.ArrayList;
import java.util.List;

// 10119006 - Ilham zaki - IF1

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{

    private Activity activity;
    private List<NoteModel> noteList = new ArrayList<NoteModel>();

    NoteAdapter( Activity activity, List<NoteModel> noteList){
        this.activity = activity;
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.notes, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.title.setText(String.valueOf(noteList.get(position).getTitle()));
        holder.category.setText(String.valueOf(noteList.get(position).getCategory()));
        holder.date.setText(String.valueOf(noteList.get(position).getDate()).substring(0,10));

        holder.noteItem.setOnClickListener(view -> {
            Intent intent = new Intent(activity, UpdateActivity.class);
            intent.putExtra("id", String.valueOf(noteList.get(position).getId()));
            intent.putExtra("title", String.valueOf(noteList.get(position).getTitle()));
            intent.putExtra("category", String.valueOf(noteList.get(position).getCategory()));
            intent.putExtra("note", String.valueOf(noteList.get(position).getNote()));
            intent.putExtra("date", String.valueOf(noteList.get(position).getDate()));
            activity.startActivityForResult(intent, 1);
        });

    }

    @Override
    public int getItemCount() {
        if(noteList != null) return noteList.size();
        return 0;
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView title, category, date;
        RelativeLayout noteItem;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            category = itemView.findViewById(R.id.tv_category);
            date = itemView.findViewById(R.id.tv_tanggal);
            noteItem = itemView.findViewById(R.id.notes);
        }
    }
}
