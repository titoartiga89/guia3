package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;



public class AdaptadorMensaje extends ArrayAdapter<Mensaje> {

    public AdaptadorMensaje(Context context, List<Mensaje> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        Mensaje mensaje = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje,parent,false);
        }

        TextView txtMensaje = (TextView) convertView.findViewById(R.id.txtMensaje);
        TextView txtFecha = (TextView) convertView.findViewById(R.id.txtFecha);

        txtMensaje.setText(mensaje.contenido);
        txtFecha.setText(mensaje.fecha);

        return convertView;
    }
}
