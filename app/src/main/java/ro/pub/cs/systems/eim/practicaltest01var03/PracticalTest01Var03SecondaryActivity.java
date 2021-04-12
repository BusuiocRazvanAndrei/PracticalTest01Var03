package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {


    private Button buttoncorect, buttonincorect;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ButtonCorrect:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.ButtonFals:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        EditText mesaj = (EditText) findViewById(R.id.mesaj);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("rezultat"))
        {
            String rezultat = intent.getStringExtra("rezultat");
            mesaj.setText(String.valueOf(rezultat));
        }

        buttoncorect = (Button)findViewById(R.id.ButtonCorrect);
        buttoncorect.setOnClickListener(buttonClickListener);
        buttonincorect = (Button)findViewById(R.id.ButtonFals);
        buttonincorect.setOnClickListener(buttonClickListener);
    }
}
