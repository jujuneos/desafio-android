package com.example.desafiopopcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.desafiopopcode.Controllers.SWApi;
import com.example.desafiopopcode.Models.ListaPerson;
import com.example.desafiopopcode.Models.Personagem;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Detalhes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        final TextView text = findViewById(R.id.text);

        Intent intent = getIntent();
        int peopleId = intent.getIntExtra("peopleId", 0);

        SWApi.getApi().getPeople(peopleId, new Callback<Personagem>() {
            @Override
            public void success(Personagem personagem, Response response) {
                text.setText(personagem.detalhar());
            }

            @Override
            public void failure(RetrofitError error) {
                text.setText("error kkkkkk");
            }
        });
    }
}