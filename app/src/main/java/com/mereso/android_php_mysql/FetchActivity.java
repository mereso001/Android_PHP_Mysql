package com.mereso.android_php_mysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FetchActivity extends AppCompatActivity {
    @BindView(R.id.inputID)
    EditText inputId;

    @BindView(R.id.textviewTitle)
    TextView txtTitle;
    @BindView(R.id.textViewAuthor)
    TextView txtAuthor;
    @BindView(R.id.inputYear)
    TextView txtYear;
    @BindView(R.id.inputCost)
    TextView txtCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        ButterKnife.bind(this);
    }
}
