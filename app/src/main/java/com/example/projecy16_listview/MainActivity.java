package com.example.projecy16_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lvShow;
    private TextView tvTitle;
    private String[] fruit_name=new String[]{"Apple","Banana","Orange","Grape","Strawberry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        findViews();
        setAdapter();

        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg=fruit_name[position];
                setToast(MainActivity.this,msg);
                tvTitle.setText("" + ((TextView) view).getText());

            }
        });
    }
    public void setToast(Context context, String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    private void setAdapter() {
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruit_name);
        lvShow.setAdapter(adapter);
    }
    private void findViews() {
        lvShow=(ListView)findViewById(R.id.lvShow);
    }

}