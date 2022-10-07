package com.example.turco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewPontosNos, textViewPontosEles, textViewVitoriasNos, textViewVitoriaEles;
    Button buttonMaisUmNos, buttonMaisTresNos, buttonMenosUmNos, buttonMaisUmEles, buttonMaisTresEles, buttonMenosUmEles, buttonReiniciar;
    int pontoN = 0;
    int pontoE = 0;
    int i = 0;
    int vN = 0;
    int vE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textViewVitoriasNos = findViewById(R.id.textViewVitoriasNos);
        textViewVitoriaEles = findViewById(R.id.textViewVitoriaEles);
        textViewPontosNos = findViewById(R.id.textViewPontosNos);
        textViewPontosEles = findViewById(R.id.textViewPontosEles);
        buttonMaisUmNos = findViewById(R.id.buttonMaisUmNos);
        buttonMaisTresNos = findViewById(R.id.buttonMaisTresNos);
        buttonMenosUmNos = findViewById(R.id.buttonMenosUmNos);
        buttonMaisUmEles = findViewById(R.id.buttonMaisUmEles);
        buttonMaisTresEles = findViewById(R.id.buttonMaisTresEles);
        buttonMenosUmEles = findViewById(R.id.buttonMenosUmEles);
        buttonReiniciar = findViewById(R.id.buttonReiniciar);

        buttonMaisUmNos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
                adicionarPonto();
                maisVitoria();
                verificaFinal();
                textViewPontosNos.setText(String.valueOf(pontoN));
            }
        });

        buttonMaisTresNos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
                adicionarPontos();
                maisVitoria();
                verificaFinal();
                textViewPontosNos.setText(String.valueOf(pontoN));
            }
        });

        buttonMaisUmEles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                adicionarPonto();
                maisVitoria();
                verificaFinal();
                textViewPontosEles.setText(String.valueOf(pontoE));
            }
        });

        buttonMaisTresEles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                adicionarPontos();
                maisVitoria();
                verificaFinal();
                textViewPontosEles.setText(String.valueOf(pontoE));
            }
        });

        buttonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               resetarJogo();
                textViewPontosEles.setText(String.valueOf(pontoE));
                textViewPontosNos.setText(String.valueOf(pontoN));
            }
        });

        buttonMenosUmEles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                menosPonto();
                textViewPontosEles.setText(String.valueOf(pontoE));
            }
        });

        buttonMenosUmNos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
                menosPonto();
                textViewPontosNos.setText(String.valueOf(pontoN));
            }
        });

    }
    private void adicionarPonto(){
        if(i == 0){
            pontoN++;
        }
        else{
            pontoE++;
        }

    }

    private void adicionarPontos(){
        if(i == 0){
            pontoN = pontoN + 3;
        }
        else{
            pontoE = pontoE + 3;
        }

    }

    private void verificaFinal(){
        if(pontoN>=12){
            pontoN = 0;
            textViewPontosNos.setText(String.valueOf(pontoN));
            pontoE = 0;
            textViewPontosEles.setText(String.valueOf(pontoE));
        }
        else if(pontoE>=12){
            pontoN = 0;
            textViewPontosNos.setText(String.valueOf(pontoN));
            pontoE = 0;
            textViewPontosEles.setText(String.valueOf(pontoE));
        }
    }

    private void resetarJogo(){
        pontoN = 0;
        pontoE = 0;
        vN = 0;
        vE = 0;
        textViewPontosNos.setText(String.valueOf(pontoN));
        textViewPontosEles.setText(String.valueOf(pontoE));
        textViewVitoriasNos.setText(String.valueOf(vN));
        textViewVitoriaEles.setText(String.valueOf(vE));
    }

    private void menosPonto() {
        if (i == 0) {
            if (pontoN > 0) {
                pontoN--;
            } else {
                Toast.makeText(MainActivity.this,
                        "Não existe pontuação negativa", Toast.LENGTH_LONG).show();
            }
        } else if (i == 1) {
            if (pontoE > 0) {
                pontoE--;
            } else {
                Toast.makeText(MainActivity.this,
                        "Não existe pontuação negativa", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void maisVitoria() {
        if (pontoN == 12) {
            vN ++;
            textViewVitoriasNos.setText(String.valueOf(vN));
            Toast.makeText(MainActivity.this,
                    "Você ganhou!", Toast.LENGTH_LONG).show();
        }
        else if (pontoE == 12) {
            vE ++;
            textViewVitoriaEles.setText(String.valueOf(vE));
            Toast.makeText(MainActivity.this,
                    "Você ganhou!", Toast.LENGTH_LONG).show();
        }
    }




}