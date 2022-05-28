package programacao.mobile.lista02deexercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bt = null;
    private EditText login = null;
    private EditText password = null;
    private Button limpar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.login = findViewById(R.id.login);
        this.password = findViewById(R.id.password);
        this.limpar = findViewById(R.id.limpar);

        this.bt = findViewById(R.id.button);
        bt.setEnabled(false);
        //limpar.setVisibility(View.INVISIBLE);


        // QUANDO CLICKAR AQUI CHAMA ATUALIZAENABLEBOTAO();
        this.login.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                atualizaEnableBotao();
                return true;
            }
        });

        this.password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                atualizaEnableBotao();
                return true;
            }
        });
    }

    public void atualizaEnableBotao(){
        String valorLogin = login.getText().toString().trim();
        String valorPassword = password.getText().toString().trim();
        boolean habilitaBotao = !valorLogin.isEmpty() && !valorPassword.isEmpty();
        this.bt.setEnabled(habilitaBotao);
    }

    public void autenticar(){
        String loginTxt = this.login.getText().toString();
        String passwordTxt = this.password.getText().toString();
        String menssagem = "";
        int color = 0;

        if (loginTxt.equals("admin") && passwordTxt.equals("1234")){
            menssagem = "Autenticação OK! ";
            color = Color.rgb(0,255,0);
        }else {
            menssagem = "Autenticação falhou!";
            color = Color.rgb(255,0,0);
        }

        TextView tv = findViewById(R.id.feedback);
        tv.setTextSize(40);
        tv.setText(menssagem);
        tv.setTextColor(color);
    }

    public void limparTela(){
        this.login.setText("");
        this.password.setText("");
        atualizaEnableBotao();
    }
}