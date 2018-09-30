package org.dev4u.hv.guia3_ejemplo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MensajeActivity extends AppCompatActivity {

    private Button btnEnviar;
    private EditText txtMensaje;
    private ListView lstMensajes;
    private AdaptadorMensaje adaptador;
    private ArrayList<Mensaje> mensajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        lstMensajes = (ListView) findViewById(R.id.lstMensajes);

        mensajes = new ArrayList<>();
        adaptador = new AdaptadorMensaje(this,mensajes);

        lstMensajes.setAdapter(adaptador);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm a");
                String fecha = sdf.format(new Date());
                Mensaje m = new Mensaje(fecha,txtMensaje.getText().toString());
                mensajes.add(m);
                adaptador.notifyDataSetChanged();
                txtMensaje.setText("");
            }
        });
    }
}
