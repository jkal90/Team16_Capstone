package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetIDActivity extends AppCompatActivity {
    private final static String PREFERENCES = "preferences";
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_id);
    }

    public void onConfirm(View view) {
        settings = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        EditText editId = findViewById(R.id.editID);
        String userId = editId.getText().toString();
        editor.putString("ID", userId);

        editId = findViewById(R.id.editBirthday);
        String birthday = editId.getText().toString();
        editor.putString("birthday", birthday);

        editor.apply();

        DatabaseTool tool = new DatabaseTool(settings);
        if (!tool.isValidUser()) {
            Intent intent = new Intent(this, ReEnterActivity.class);
            startActivity(intent);
            return;
        }

        Intent intent = new Intent(this, MyInfoActivity.class);
        startActivity(intent);
    }
}