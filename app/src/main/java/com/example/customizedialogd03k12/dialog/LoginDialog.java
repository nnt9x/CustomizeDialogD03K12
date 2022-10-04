package com.example.customizedialogd03k12.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.customizedialogd03k12.MainActivity;
import com.example.customizedialogd03k12.R;

public abstract class LoginDialog extends Dialog {

    public LoginDialog(@NonNull Context context) {
        super(context);
    }

    protected abstract void sendToMain(String email, String password);

    private EditText edtEmail, edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_login);

        edtEmail = findViewById(R.id.edtDialogEmail);
        edtPassword = findViewById(R.id.edtDialogPassword);
        btnLogin = findViewById(R.id.btnDialogLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = edtEmail.getText().toString();
                if(strEmail.isEmpty()){
                    edtEmail.setError("Hãy nhập dữ liệu");
                    return;
                }
                String strPassword = edtPassword.getText().toString();
                if(strPassword.isEmpty()){
                    edtPassword.setError("Hãy nhập dữ liệu");
                    return;
                }
                // Hiển thi ra màn hình
                sendToMain(strEmail, strPassword);
            }
        });


    }
}
