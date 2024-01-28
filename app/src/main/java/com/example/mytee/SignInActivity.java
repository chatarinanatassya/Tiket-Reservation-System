package com.example.mytee;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SignInActivity extends AppCompatActivity {
    private ImageView backButton;
    private TextView signUpText;
    private EditText emailsignin, passwordsignin;
    private Button SignInbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();

        emailsignin = findViewById(R.id.email_signin);
        passwordsignin = findViewById(R.id.confirmpass_signin);
        backButton = findViewById(R.id.back_login);
        signUpText = findViewById(R.id.btnsignup);
        SignInbtn = findViewById(R.id.butn_login);

        imgbackbutton();
        txtbtnsignup();
        btnsignin();
    }

    private void imgbackbutton(){
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, Welcome.class));
            }
        });
    }

    private void btnsignin(){
        SignInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =  emailsignin.getText().toString();
                String password = passwordsignin.getText().toString();

                if (! (email.isEmpty() || password.isEmpty())){

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, db_mytee.urlSignIn + "?email=" + email + "&password=" + password, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("login berhasil")){
                                Toast.makeText(getApplicationContext()," selamat datang", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            }else{
                                Toast.makeText(getApplicationContext()," gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(stringRequest);
                }else{
                    Toast.makeText(getApplicationContext(),"email atau password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void txtbtnsignup(){
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }
}