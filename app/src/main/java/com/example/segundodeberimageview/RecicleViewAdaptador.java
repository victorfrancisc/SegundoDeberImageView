package com.example.segundodeberimageview;

import android.content.Context;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.bumptech.glide.Glide;

import org.json.JSONArray;

import java.util.List;

public class RecicleViewAdaptador extends RecyclerView.Adapter<RecicleViewAdaptador.ViemHoder>  {
    private Context Ctx;
    public List<ListadeModelo>ModeloLista;
    public    class ViemHoder extends  RecyclerView.ViewHolder
    {
        private TextView issue_id;
        private TextView volumen;
        private TextView number;
        private TextView ano;
        private TextView date_published;
        private TextView title;
        private ImageView coverImagen;


        public ViemHoder(View itemView)
        {
            super(itemView);
            issue_id=(TextView)itemView.findViewById(R.id.textissue_id);
            volumen=(TextView)itemView.findViewById(R.id.textvolume);
            number=(TextView)itemView.findViewById(R.id.textnumber);
            ano=(TextView)itemView.findViewById(R.id.textano);
            date_published=(TextView)itemView.findViewById(R.id.textdate_published);
            title=(TextView)itemView.findViewById(R.id.texttitle);
           coverImagen=(ImageView)itemView.findViewById(R.id.imageView);

        }

    }
    public RecicleViewAdaptador(Context mCtx, List<ListadeModelo> ModeloLista)
    {
        this.ModeloLista=ModeloLista;
        Ctx=mCtx;

    }

    @Override
    public ViemHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view=inflater.inflate(R.layout.item_elementos,null);
                //LayoutInflater.from(parent.getContext()).inflate(R.layout.item_elementos, parent, false);
        ViemHoder viewHoder=new ViemHoder(view);

        return viewHoder;
    }

    @Override
    public void onBindViewHolder(ViemHoder holder, int position) {



        holder.issue_id.setText(ModeloLista.get(position).getIssue_id());
        holder.volumen.setText(ModeloLista.get(position).getVolumen());
        holder.number.setText(ModeloLista.get(position).getNumber());
        holder.ano.setText(ModeloLista.get(position).getAno());
        holder.date_published.setText(ModeloLista.get(position).getDate_published());
        holder.title.setText(ModeloLista.get(position).getTitle());
        Glide.with(Ctx)
                .load(ModeloLista.get(position).getCover())
                .into(holder.coverImagen);
      //  holder.coverImagen.setImageResource(ModeloLista.get(position).getCover());

    }


    @Override
    public int getItemCount()
    {
        return ModeloLista.size();
    }

}
