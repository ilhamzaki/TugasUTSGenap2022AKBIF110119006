package net.akb.tugasutsgenap2022akbif110119006.ui.note;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.akb.tugasutsgenap2022akbif110119006.R;
import net.akb.tugasutsgenap2022akbif110119006.helper.NoteDatabaseHelper;
import net.akb.tugasutsgenap2022akbif110119006.model.NoteModel;

import java.util.ArrayList;
import java.util.List;

// 10119006 - Ilham zaki - IF1

public class NoteFragment extends Fragment  {

    RecyclerView rv_note;
    FloatingActionButton add_note;

    NoteDatabaseHelper db;
    List<NoteModel> noteList;
    NoteAdapter noteAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_note, container, false);

        rv_note = view.findViewById(R.id.rv_note);
        add_note = view.findViewById(R.id.add_note);
        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

//        storeDataInListModel();
//
//        noteAdapter = new NoteAdapter(getActivity(), noteList);
//        rv_note.setAdapter(noteAdapter);
//        rv_note.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void storeDataInListModel() {
        Cursor cursor = db.getAllData();
        while (cursor.moveToNext()) {

            System.out.println(cursor.getString(0));
            System.out.println(cursor.getString(1));
            System.out.println(cursor.getString(2));
            System.out.println(cursor.getString(3));
            System.out.println(cursor.getString(4));

            NoteModel note = new NoteModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );

            noteList.add(note);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}