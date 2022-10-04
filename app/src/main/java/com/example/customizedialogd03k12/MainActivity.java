package com.example.customizedialogd03k12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.customizedialogd03k12.dialog.LoginDialog;

public class MainActivity extends AppCompatActivity {

    private LoginDialog loginDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        if(loginDialog == null){
            loginDialog = new LoginDialog(this) {
                @Override
                protected void sendToMain(String email, String password) {
                    processLogin(email, password);
                }
            };
        }
        loginDialog.show();
    }

    private void processLogin(String email, String pass){
        // Trong nay xu ly login ntn?
        if(email.equals("admin@gmail.com") && pass.equals("abc123")){
            Toast.makeText(this,"Login success",Toast.LENGTH_SHORT).show();
            loginDialog.dismiss();
            return;
        }
        Toast.makeText(this,"Login fail",Toast.LENGTH_SHORT).show();

    }
}