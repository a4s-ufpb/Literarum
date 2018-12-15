package br.ufpb.dcx.sisalfa.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rynzler.literarum.R;

import java.util.List;

import br.ufpb.dcx.sisalfa.adapter.ContextAdapter;
import br.ufpb.dcx.sisalfa.database.SisalfaRepository;
import br.ufpb.dcx.sisalfa.models.SisContext;

public class ContextsList extends AppCompatActivity {
    private SisalfaRepository db;
    private ListView listViewContext;
    private ContextAdapter contextAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contexts_list);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        this.listViewContext = findViewById(R.id.listViewContexts);
        this.db = new SisalfaRepository(this);
        populateListView();

    }

    public void populateListView(){
        this.contextAdapter = new ContextAdapter(this, db.getAllContexts());
        listViewContext.setAdapter(contextAdapter);
        listViewContext.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*SisContext item = (SisContext) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), EventDetail.class);
                intent.putExtra("event", item);
                startActivity(intent);*/
            }


        });
    }
}
