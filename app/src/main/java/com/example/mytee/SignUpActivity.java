package com.example.mytee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    private ImageView backSignup;
    private TextView backtoLogin;
    private Button signUp;
    private EditText full_name, signupemail, signuppassword;
    private ImageButton signupGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        backSignup = findViewById(R.id.back_signup);
        backtoLogin = findViewById(R.id.backtologin);
        signUp = findViewById(R.id.login);
        full_name = findViewById(R.id.fullname);
        signupemail = findViewById(R.id.email_signup);
        signuppassword = findViewById(R.id.cpass_signup);
        signupGoogle = findViewById(R.id.signupgoogle);

        imgbacksignup();
        txtbacktologin();
        btnsignup();
    }

    private void imgbacksignup(){
        backSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, Welcome.class));
            }
        });
    }

    private void txtbacktologin(){
        backtoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
    }

    private void btnsignup(){
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = full_name.getText().toString();
                String email =  signupemail.getText().toString();
                String password = signuppassword.getText().toString();

                if(!(fullname.isEmpty() || email.isEmpty() || password.isEmpty())){

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, db_mytee.urlSignUp, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), SignInActivity.class ));
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    {
                        @Override
                        protected HashMap<String, String> getParams() throws AuthFailureError{
                            HashMap<String, String> params = new HashMap<>();

                            params.put("fullname", fullname);
                            params.put("email", email);
                            params.put("password", password);

                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);

                }else {
                    Toast.makeText(getApplicationContext(),"Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}