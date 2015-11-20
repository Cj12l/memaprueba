package innovasoft.memaprueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class FirstFragment extends Fragment {
    // Store instance variables
    private boolean activos;
    private int page;

    ImageButton btnGenosias;
    ImageButton btnMemSemantica;
    ImageButton btnMemEpisodica;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, boolean activos) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putBoolean("someBoolean", activos);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0)+1;
        activos=getArguments().getBoolean("someBoolean");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ImageButton btnGenosias = (ImageButton) view.findViewById(R.id.btngenosias);
        ImageButton btnMemSemantica = (ImageButton) view.findViewById(R.id.btnsemantica);
        ImageButton btnMemEpisodica = (ImageButton) view.findViewById(R.id.btnepisodica);

        btnGenosias.setEnabled(activos);
        btnMemSemantica.setEnabled(activos);
        btnMemEpisodica.setEnabled(activos);

        btnGenosias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent("innovasoft.memaprueba.EjercicioGeniosiasActivity");
                startActivity(next);
            }
        });

        return view;
    }

}
