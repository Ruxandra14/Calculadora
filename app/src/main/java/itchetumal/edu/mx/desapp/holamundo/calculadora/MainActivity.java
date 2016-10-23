package itchetumal.edu.mx.desapp.holamundo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView txtvPantalla;
    double resultado,m1=0,m2=0;
    char opAnterior='+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Botones numericos
        View boton0 = findViewById(R.id.btn0);
        boton0.setOnClickListener(this);
        View boton1 = findViewById(R.id.btn1);
        boton1.setOnClickListener(this);
        View boton2 = findViewById(R.id.btn2);
        boton2.setOnClickListener(this);
        View boton3 = findViewById(R.id.btn3);
        boton3.setOnClickListener(this);
        View boton4 = findViewById(R.id.btn4);
        boton4.setOnClickListener(this);
        View boton5 = findViewById(R.id.btn5);
        boton5.setOnClickListener(this);
        View boton6 = findViewById(R.id.btn6);
        boton6.setOnClickListener(this);
        View boton7 = findViewById(R.id.btn7);
        boton7.setOnClickListener(this);
        View boton8 = findViewById(R.id.btn8);
        boton8.setOnClickListener(this);
        View boton9 = findViewById(R.id.btn9);
        boton9.setOnClickListener(this);

        //Botones de operacion
        View botonSuma = findViewById(R.id.btnmas);
        botonSuma.setOnClickListener(this);
        View botonResta = findViewById(R.id.btnmenos);
        botonResta.setOnClickListener(this);
        View botonMultiplica = findViewById(R.id.btnmultiplicacion);
        botonMultiplica.setOnClickListener(this);
        View botonDivide = findViewById(R.id.btndivision);
        botonDivide.setOnClickListener(this);
        View botonPunto = findViewById(R.id.btndecimal);
        botonPunto.setOnClickListener(this);
        View botonBorra = findViewById(R.id.btnac);
        botonBorra.setOnClickListener(this);
        View botonIgual = findViewById(R.id.btnigual);
        botonIgual.setOnClickListener(this);
        View botonmasmenos = findViewById(R.id.btnmm);
        botonmasmenos.setOnClickListener(this);
        View botonporciento = findViewById(R.id.btnporciento);
        botonporciento.setOnClickListener(this);

        //Pantalla
        View pantalla = findViewById(R.id.txtvPantalla);
        txtvPantalla  = (TextView) pantalla;
        txtvPantalla.setText("");

    }

    @Override
    public void onClick(View v) {

        //Numericos
        if (v.getId()== R.id.btn0) txtvPantalla.append("0");
        else if (v.getId()== R.id.btn1) txtvPantalla.append("1");
        else if (v.getId()== R.id.btn2) txtvPantalla.append("2");
        else if (v.getId()== R.id.btn3) txtvPantalla.append("3");
        else if (v.getId()== R.id.btn4) txtvPantalla.append("4");
        else if (v.getId()== R.id.btn5) txtvPantalla.append("5");
        else if (v.getId()== R.id.btn6) txtvPantalla.append("6");
        else if (v.getId()== R.id.btn7) txtvPantalla.append("7");
        else if (v.getId()== R.id.btn8) txtvPantalla.append("8");
        else if (v.getId()== R.id.btn9) txtvPantalla.append("9");
        else if (v.getId()== R.id.btndecimal) txtvPantalla.append(".");

        // Operaciones
        else if (v.getId()== R.id.btnac){
            txtvPantalla.setText("");
            m1=0;
            opAnterior = '+';
        }
        else if (v.getId()== R.id.btnmas) calcular('+');
        else if (v.getId()== R.id.btnmenos) calcular('-');
        else if (v.getId()== R.id.btnmultiplicacion) calcular('*');
        else if (v.getId()== R.id.btndivision) calcular('/');
        else if (v.getId()== R.id.btnigual) calcular('=');




    }

    public void calcular (char op){
        double resultado = m1;
        String cadena = txtvPantalla.getText().toString();

        try{
            m2 = Double.parseDouble(cadena);

            if (opAnterior == '+') resultado = m1 + m2;
            else if(opAnterior == '-') resultado = m1 - m2;
            else if (opAnterior == '*') resultado = m1 * m2;
            else if (opAnterior == '/') resultado = m1 / m2;

            m1 = resultado;
            opAnterior = op;

            if (op == '='){
                txtvPantalla.setText(""+m1);
            }
            else {
                txtvPantalla.setText("");
            }
        }
        catch(NumberFormatException nfe){
            Toast.makeText(this,"numero incorrecto",Toast.LENGTH_LONG).show();
        }

    }
}
