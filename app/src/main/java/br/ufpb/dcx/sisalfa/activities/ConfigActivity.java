package br.ufpb.dcx.sisalfa.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rynzler.literarum.R;

import br.ufpb.dcx.sisalfa.connection.ConnectionAPI;


public class ConfigActivity extends AppCompatActivity implements View.OnClickListener {
    private Button importarTemas;
    private ProgressDialog pd;
    private Context context;
    private ConnectionAPI connectionAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        this.importarTemas = findViewById(R.id.impTemas);
        importarTemas.setOnClickListener(this);
        this.connectionAPI = new ConnectionAPI(this);
        this.context = this;
    }

    @Override
    protected void onDestroy() {
        if (pd != null) {
            pd.dismiss();
            importarTemas.setEnabled(true);
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        v.setEnabled(false);
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                pd = new ProgressDialog(context);
                pd.setTitle("Importando contextos e desafios");
                pd.setMessage("Aguarde um momento.");
                pd.setCancelable(false);
                pd.setIndeterminate(true);
                pd.show();
            }

            @Override
            protected Void doInBackground(Void... arg0) {
                try {
                    connectionAPI.startContexts();
                    connectionAPI.startChallenges();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                if (pd != null) {
                    pd.dismiss();
                    importarTemas.setEnabled(true);
                }
            }

        };
        task.execute((Void[]) null);
    }
}