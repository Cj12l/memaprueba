package innovasoft.memaprueba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 'Santiago on 20/11/2015.
 */
public class SpinnerAdapter extends ArrayAdapter<String>{
    int grupoId;
    Activity context;
    ArrayList<String> list;
    LayoutInflater inflater;

    public SpinnerAdapter(Activity con,int grId, int id, ArrayList<String> lis){
        super(con,id,lis);
        list=lis;
        inflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        grupoId=grId;
    }

    public View getView(int position, View contextView, ViewGroup parent){
        View itemView=inflater.inflate(grupoId,parent,false);
        TextView text=(TextView)itemView.findViewById(R.id.texto_spinner);
        text.setText(list.get(position));

        ImageView img=(ImageView)itemView.findViewById(R.id.img);
        img.setImageResource(R.drawable.spinner_triangle);
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getView(position,convertView,parent);
    }
}
