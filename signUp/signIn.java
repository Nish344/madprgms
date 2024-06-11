package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SigninActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.uid2);
        password = findViewById(R.id.pwd2);
    }

    public void signIn(View v) {
        Bundle b = getIntent().getExtras();
        String passwd = b.getString("pwd");
        String uname = b.getString("uid");

        if (username.getText().toString().equals(uname) && password.getText().toString().equals(passwd)) {
            Toast.makeText(this, "SIGNIN SUCCESSFUL", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, success.class);  // Change to SuccessActivity.class
            startActivity(intent);
        } else {
            Toast.makeText(this, "UNSUCCESSFUL", Toast.LENGTH_LONG).show();
        }
    }
}
