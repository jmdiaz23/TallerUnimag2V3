package co.edu.unimagdalena.tallerunimag2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText n1, n2, m1, m2;
    Button puntomedio, pendiente, cuadrante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.edtUno);
        n2 = findViewById(R.id.edtDos);
        m1 = findViewById(R.id.edtTres);
        m2 = findViewById(R.id.edtCuatro);
        puntomedio = findViewById(R.id.btnpunto);
        pendiente = findViewById(R.id.btnpendiente);
        cuadrante = findViewById(R.id.btncuadrante);
        puntomedio.setOnClickListener(this);
        cuadrante.setOnClickListener(this);
        pendiente.setOnClickListener(this);
    }

    public String ccuadrante(float cx, float cy){
        if(cx >= 0 && cy >= 0){
            return "Cuadrante I";
        }else if(cx < 0 && cy < 0){
            return "Cuadrante III";
        }else if(cx >= 0 && cy < 0){
            return "Cuadrante IV";
        }else{
            return "Cuadrante II";
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();


        /*if (id==R.id.item1){
            Toast.makeText(this, "Aleatorio", Toast.LENGTH_SHORT).show();
        }else if (id==R.id.item2){
            Toast.makeText(this, "Distancia", Toast.LENGTH_SHORT).show();
        }else if (id==R.id.item3){
            Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show();
        }*/
        switch (item.getItemId()){
        case R.id.item1:    n1.setText(""+(Math.random()*(100)-50));
                            n2.setText(""+(Math.random()*(100)-50));
                            m1.setText(""+(Math.random()*(100)-50));
                            m2.setText(""+(Math.random()*(100)-50));
        break;
        case R.id.item2:
                             if(TextUtils.isEmpty(n1.getText().toString()) ||
                                TextUtils.isEmpty(n2.getText().toString()) ||
                                TextUtils.isEmpty(m1.getText().toString()) ||
                                TextUtils.isEmpty(m2.getText().toString()) ){
                                 Toast.makeText(this, "Datos Invalidos", Toast.LENGTH_SHORT).show();
                            }else {
                                     float xx1 = Float.parseFloat(n1.getText().toString());
                                     float xx2 = Float.parseFloat(n2.getText().toString());
                                     float yy1 = Float.parseFloat(m1.getText().toString());
                                     float yy2 = Float.parseFloat(m2.getText().toString());

                                    Toast.makeText(this, "Distancia" +Math.sqrt(Math.pow((xx2 - xx1), 2) + Math.pow((yy2 - yy1), 2)), Toast.LENGTH_SHORT).show();
                             }
        break;

            case R.id.item3: Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show();
            break;



        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(n1.getText().toString()) ||
                TextUtils.isEmpty(n2.getText().toString()) ||
                TextUtils.isEmpty(m1.getText().toString()) ||
                TextUtils.isEmpty(m2.getText().toString()) ){
            Toast.makeText(this, "Datos Invalidos", Toast.LENGTH_SHORT).show();
        }else {
            float xx1 = Float.parseFloat(n1.getText().toString());
            float xx2 = Float.parseFloat(n2.getText().toString());
            float yy1 = Float.parseFloat(m1.getText().toString());
            float yy2 = Float.parseFloat(m2.getText().toString());
            switch (v.getId()){
                case R.id.btnpunto: Toast.makeText(this, "Punto medio" +(+ ((xx1+xx2)/2)+((yy1+yy2)/2)), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnpendiente: Toast.makeText(this, "Punto medio" +((yy2-yy1)/(xx2-xx1)), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btncuadrante: Toast.makeText(this, "Cuadrante" +ccuadrante(xx1,yy1)+ ccuadrante(xx2,yy2), Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }
}