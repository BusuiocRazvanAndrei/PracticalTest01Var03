package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private EditText primulNr;
    private EditText doileaNr;
    private Button butonplus, butonminus,navigateToSecondaryActivityButton;
    private EditText rezultat;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();


    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int primnr = 0, doileanr = 0;
            if(isStringInt(primulNr.getText().toString()) && isStringInt(doileaNr.getText().toString()))
            {
                 primnr = Integer.valueOf(primulNr.getText().toString());
                 doileanr = Integer.valueOf(doileaNr.getText().toString());
            }
            else {
                Toast.makeText(getApplicationContext(), "nu e bine ", Toast.LENGTH_SHORT).show();
            }
            switch(view.getId()) {
                case R.id.ButtonPlus:
                    int suma = primnr + doileanr;
                    rezultat.setText(String.valueOf(suma));
                    break;
                case R.id.ButtonMinus:
                    int diferenta = primnr - doileanr;
                    rezultat.setText(String.valueOf(diferenta));
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);
                    intent.putExtra("rezultat", rezultat.toString());
                    startActivityForResult(intent, 1);
                    break;

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        primulNr = (EditText)findViewById(R.id.PrimulNumar);
        doileaNr = (EditText)findViewById(R.id.DoileaNumar);
        rezultat = (EditText)findViewById(R.id.rezultat);

        butonplus = (Button)findViewById(R.id.ButtonPlus);
        butonminus = (Button)findViewById(R.id.ButtonMinus);
        butonminus.setOnClickListener(buttonClickListener);
        butonplus.setOnClickListener(buttonClickListener);


        primulNr.setText(String.valueOf(0));
        doileaNr.setText(String.valueOf(0));

        if (savedInstanceState != null)
        {
            if (savedInstanceState.containsKey("primavaloare")) {
                primulNr.setText(savedInstanceState.getString("primavaloare"));
                Toast.makeText(getApplicationContext(), primulNr.getText().toString(), Toast.LENGTH_SHORT).show();
            } else {
                primulNr.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("adouavaloare")) {
                doileaNr.setText(savedInstanceState.getString("adouavaloare"));
                Toast.makeText(getApplicationContext(), doileaNr.getText().toString(), Toast.LENGTH_SHORT).show();

            } else {
                doileaNr.setText(String.valueOf(0));
            }
        } else {
            primulNr.setText(String.valueOf(0));
            doileaNr.setText(String.valueOf(0));
        }
        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);
    }


    public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("primavaloare", primulNr.getText().toString());
        savedInstanceState.putString("adouavaloare", doileaNr.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("primavaloare")) {
            primulNr.setText(savedInstanceState.getString("primavaloare"));
            Toast.makeText(getApplicationContext(), primulNr.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            primulNr.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("adouavaloare")) {

            doileaNr.setText(savedInstanceState.getString("adouavaloare"));
            Toast.makeText(getApplicationContext(), doileaNr.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            doileaNr.setText(String.valueOf(0));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }


}