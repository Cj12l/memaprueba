package innovasoft.memaprueba;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;


public class FormularioActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener{

    private Spinner dia;
    private Spinner diaactual;
    private Spinner mes;
    private EditText nombre;
    private EditText numId;
    private EditText fecha;
    private ImageButton calendar;
    private ImageButton btnIniciar;

    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        setDateTimeField();

        String[] listaDiasSemana = getResources().getStringArray(R.array.dias);
        ArrayList<String> list1=new ArrayList<String>(Arrays.asList(listaDiasSemana));
        dia=(Spinner)findViewById(R.id.diasem);
        SpinnerAdapter adapter=new SpinnerAdapter(this, R.layout.spinner_layout,R.id.texto_spinner,list1);
        dia.setAdapter(adapter);

        String[] listaMeses = getResources().getStringArray(R.array.meses);
        ArrayList<String> list2=new ArrayList<String>(Arrays.asList(listaMeses));
        mes=(Spinner)findViewById(R.id.mes);
        SpinnerAdapter adapterMes=new SpinnerAdapter(this, R.layout.spinner_layout,R.id.texto_spinner,list2);
        mes.setAdapter(adapterMes);

        String[] listaDiasAc = getResources().getStringArray(R.array.dias_actuales);
        ArrayList<String> list3=new ArrayList<String>(Arrays.asList(listaDiasAc));
        diaactual=(Spinner)findViewById(R.id.diaact);
        SpinnerAdapter adapterA=new SpinnerAdapter(this, R.layout.spinner_layout,R.id.texto_spinner,list3);
        diaactual.setAdapter(adapterA);

        nombre=(EditText)findViewById(R.id.nombre);
        numId=(EditText)findViewById(R.id.numid);
        fecha=(EditText)findViewById(R.id.fecha);
        calendar=(ImageButton)findViewById(R.id.setfecha);
        btnIniciar=(ImageButton)findViewById(R.id.iniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next=new Intent(FormularioActivity.this,MenuActivity.class);
                startActivity(next);
                finish();
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog.show();
            }
        });

        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
            }
        });

        numId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numId.setText("");
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fecha.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
}
