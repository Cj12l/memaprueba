package innovasoft.memaprueba;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Camilo P on 20/11/2015.
 */
public class ActividadRelacion extends Activity{

    private int elegido1;
    private int elegido2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        elegido1 = 0;
        elegido2 = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    public void marcar(){

    }

    public void elegir(){

    }

}
