package com.gustavoBiasi.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.ClearValues();
    }

    private void ClearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) { //verifica se o id que foi feito o clique é referente ao botao calculate

            String value = this.mViewHolder.editValue.getText().toString(); //pegando valor do editvalue

            if ("".equals(value)) {//verifica se o valor no edit é igual a vazio
                //mostra mensagem para o usuário
                this.ClearValues();
                Toast.makeText(this, this.getString(R.string.informe_valor),Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 4)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 5)));

            }
        }
    }

    /*criado static para o mesmo ser criado somente 1 vez se o OnCreate for destruido e criado novamente
    Otimiza a aplicação*/
    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }


}