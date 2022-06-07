package net.akb.tugasutsgenap2022akbif110119006.ui.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import net.akb.tugasutsgenap2022akbif110119006.MainActivity;
import net.akb.tugasutsgenap2022akbif110119006.R;
import net.akb.tugasutsgenap2022akbif110119006.helper.NoteDatabaseHelper;
import net.akb.tugasutsgenap2022akbif110119006.model.NoteModel;

import java.text.SimpleDateFormat;
import java.util.Date;

// 10119006 - Ilham zaki - IF1

public class AddActivity extends AppCompatActivity {

    EditText title_input, category_input, note_input;
    String date_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        category_input = findViewById(R.id.category_input);
        note_input = findViewById(R.id.note_input);
        date_input = getDateNow();
        System.out.println(date_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(view -> {
            NoteDatabaseHelper db = new NoteDatabaseHelper(AddActivity.this);
            NoteModel note = new NoteModel("id",
                    title_input.getText().toString().trim(),
                    category_input.getText().toString().trim(),
                    note_input.getText().toString().trim(),
                    date_input.trim());

            db.addNote(note);

            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }

    private String getDateNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
}