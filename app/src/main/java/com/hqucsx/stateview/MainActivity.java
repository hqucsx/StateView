package com.hqucsx.stateview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hqucsx.library.StateView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.mStateView)
    StateView mStateView;
    @Bind(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        String[] data = new String[100];
        for (int i = 0; i < 100; i++) {
            data[i] = "list data " + i;
        }
        listview.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.item, data));


        mStateView.setCurrentState(StateView.STATE_LOADING);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mStateView.setCurrentState(StateView.STATE_ERROR);
                Toast.makeText(MainActivity.this, "Net Error", Toast.LENGTH_SHORT).show();
            }
        }, 3000);

    }

    @OnClick({R.id.btn_retry})
    protected void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_retry:
                mStateView.setCurrentState(StateView.STATE_LOADING);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mStateView.setCurrentState(StateView.STATE_CONTENT);
                        Toast.makeText(MainActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.error:
                mStateView.setCurrentState(StateView.STATE_ERROR);
                return true;

            case R.id.empty:
                mStateView.setCurrentState(StateView.STATE_EMPTY);
                return true;

            case R.id.content:
                mStateView.setCurrentState(StateView.STATE_CONTENT);
                return true;

            case R.id.loading:
                mStateView.setCurrentState(StateView.STATE_LOADING);
                return true;
            case R.id.content_loading:
                startActivity(new Intent(MainActivity.this, ContentLoadingActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
