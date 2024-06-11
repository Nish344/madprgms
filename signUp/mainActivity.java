package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText uname, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        uname = findViewById(R.id.uid1);
        pwd = findViewById(R.id.pwd1);
    }

    public void signUp(View v) {
        if (validatepwd(pwd.getText().toString())) {
            Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, SigninActivity.class);
            Bundle b = new Bundle();
            b.putString("uid", uname.getText().toString());
            b.putString("pwd", pwd.getText().toString());
            i.putExtras(b);
            startActivity(i);
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
        }
    }

    public Boolean validatepwd(String password) {
        Pattern ptrn;
        Matcher mtr;
        String passwordptrn = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#]).{8,}$";
        ptrn = Pattern.compile(passwordptrn);
        mtr = ptrn.matcher(password);
        return mtr.matches();
    }
}
