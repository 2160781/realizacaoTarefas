package com.example.android_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_tarefas extends AppCompatActivity {

    boolean estadoBoton;
    Button boton;
    TextView cajadetexto;

    private DadosApp dadosApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dadosApp = new DadosApp();

        /* informação da receita */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);
        estadoBoton=true;
        boton=findViewById(R.id.Button);
        cajadetexto= findViewById(R.id.textView);
        cajadetexto.setText(dadosApp.getTextoPassoReceita());

    }

    //Metodos
    @Override
    public boolean dispatchKeyEvent( KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO

                    dadosApp.avancar();
                    cajadetexto.setText(dadosApp.getTextoPassoReceita());

                    estadoBoton= false;

                    // else{
                    //         boton.setText("Adios");
                    //      cajadetexto.setText("Adios");
                    //    estadoBoton= false;
                    // }

                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO
                    //if (estadoBoton==true){
                    dadosApp.retroceder();
                    cajadetexto.setText(dadosApp.getTextoPassoReceita());
                    estadoBoton= false;
                    //  }else{

                    //    boton.setText("Hola");
                    //  cajadetexto.setText("Hola");
                    //estadoBoton= false;
                }

                return true;
            case KeyEvent.KEYCODE_ENTER:
                if (action == KeyEvent.ACTION_DOWN) {
                    estadoBoton= false;

                    Intent inicio = new Intent(this,MainActivity.class);
                    startActivity(inicio);
                }
            default:
                return super.dispatchKeyEvent(event);
        }
    }

}