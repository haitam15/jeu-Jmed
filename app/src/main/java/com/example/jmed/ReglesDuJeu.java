package com.example.jmed;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ReglesDuJeu extends AppCompatActivity {
    private Button retourne;
    private ImageButton back;
    private ImageButton next;
    private TextView reglesText;
    private ImageView reglesImage;
    int scroll = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_regles_du_jeu);

        retourne = findViewById(R.id.retourne4);
        back = findViewById(R.id.next);
        next = findViewById(R.id.back);
        back.setImageResource(R.drawable.empty);
        reglesText = findViewById(R.id.reglestext);
        reglesImage = findViewById(R.id.imageView4);

        retourne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWelcomeAcitivy();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scroll<=0)back.setImageResource(R.drawable.empty);
                else {
                    if(scroll>=5)next.setImageResource(R.drawable.next);
                    scroll--;
                }
                if(scroll==0)back.setImageResource(R.drawable.empty);
                setReglesText();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scroll>=5) next.setImageResource(R.drawable.empty);
                else {
                    if(scroll<=0)back.setImageResource(R.drawable.back);
                    scroll++;
                }
                if(scroll==5)next.setImageResource(R.drawable.empty);
                setReglesText();
            }
        });
    }
    public void openWelcomeAcitivy(){
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }
    public void setReglesText(){
        switch (scroll){
            case 0:
                reglesText.setText("Le joueur joue tout seul contre la machine avec des niveaux (facile, moyen, difficile).");
                reglesImage.setImageResource(R.drawable.regle1);
                break;
            case 1:
                reglesText.setText("Le jeu commence par un signal vert du point de départ A vers le point d’arrivé B.");
                reglesImage.setImageResource(R.drawable.capture);
                break;
            case 2:
                reglesText.setText("Tant que le signal est vert, le joueur avance en faisant des clics sur l'écran. ");
                reglesImage.setImageResource(R.drawable.regle2_3);
                break;
            case 3:
                reglesText.setText("Il doit arrêter son mouvement quand le signal devient rouge sinon il sera éliminé.");
                reglesImage.setImageResource(R.drawable.regle3);
                break;
            case 4:
                reglesText.setText("Le mouvement à base des clics permet d'avancer son corps vers la destination.");
                reglesImage.setImageResource(R.drawable.regle5);
                break;
            case 5:
                reglesText.setText("Il continue à jouer jusqu'à ce qu'il atteint sa destination finale dans un intervalle de temps donné en respectant ces règles, sinon il est déclaré perdant.");
                reglesImage.setImageResource(R.drawable.regle5);
                break;
            default:break;
        }
    }
}