package com.example.android_resource;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    boolean estadoBotao;
    TextView CaixadeTexto;
    ImageView ver_imagem;
    Button botao;
    private DadosApp dadosApp;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview();

    }



    public boolean listview(){

        listView = findViewById(R.id.listview);

        String[] values = new String[] {
                "1. Qr CODE", "2. Microfone", "3. Tarefas"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent passo1 = new Intent(view.getContext(),Q_R_CODE.class);
                    startActivity(passo1);

                }
                if(position == 1){
                    Intent passo2 = new Intent(view.getContext(),AtivaRechonecimentoVoz.class);
                    startActivity(passo2);
                }
                if(position == 2){
                listview2();
                }
            }
        });
        return true;
    }

    public boolean listview2(){

        setContentView( R.layout.activity_listview);


        listView = findViewById(R.id.listview);

        String[] values = new String[] {
                "1. Receita de bolo", "2. exemplo"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dadosApp = new DadosApp();

                if(position == 0){
                    Intent Tarefa1 = new Intent(view.getContext(),activity_tarefas.class);
                    startActivity(Tarefa1);
                }
                if(position == 1){

                }
            }
        });
        return true;
    }


    public void Anterior( View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

    ///mudar
    @Override
    public boolean dispatchKeyEvent( KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {

                    listview();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO

                    Intent anterior = new Intent(this, MainActivity.class);
                    startActivity(anterior);

                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    private void siguiente( Intent siguiente ) {

        startActivity( siguiente );

    }
    private void anterior( Intent anterior ) {

        startActivity( anterior );
    }



}
