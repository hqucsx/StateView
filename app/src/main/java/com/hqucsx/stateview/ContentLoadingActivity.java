package com.hqucsx.stateview;/**
 * Created by PCPC on 2015/11/17.
 */

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hqucsx.library.StateView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 描述: TODO
 * 名称: ContentLoadingActivity
 * User: csx
 * Date: 11-17
 */
public class ContentLoadingActivity extends AppCompatActivity {

    @Bind(R.id.email)
    EditText email;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.email_sign_in_button)
    Button emailSignInButton;
    @Bind(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @Bind(R.id.mStateView)
    StateView mStateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_loading);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.email_sign_in_button})
    protected void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_sign_in_button:
                mStateView.setCurrentState(StateView.STATE_CONTENT_LOADING);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mStateView.setCurrentState(StateView.STATE_CONTENT);
                        Toast.makeText(ContentLoadingActivity.this, "Login Sucsses", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
                break;
        }
    }
}
