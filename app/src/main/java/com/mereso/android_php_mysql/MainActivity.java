package com.mereso.android_php_mysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.inputTitle)
    EditText inputTitle;

    @BindView(R.id.inputAuthor)
    EditText inputAuthor;

    @BindView(R.id.inputYear)
    EditText inputYear;

    @BindView(R.id.inputCost)
    EditText inputCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.buttonSave)
    public void save ()
    {
        String title = inputTitle.getText().toString().trim();
        String author = inputAuthor.getText().toString().trim();
        String year = inputYear.getText().toString().trim();
        String cost = inputCost.getText().toString().trim();
        if (title.isEmpty()||author.isEmpty()||year.isEmpty()||cost.isEmpty())
        {
            Toast.makeText(this, "Fill All Values", Toast.LENGTH_SHORT).show();
        }
        RequestParams params = new RequestParams();
        params.put("title",title);
        params.put("author",author);
        params.put("year",year);
        params.put("cost",cost);

        String url ="http://82239c70.ngrok.io/apis/save.php";
        AsyncHttpClient client = new AsyncHttpClient();

        client.post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Failed To Send Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Toast.makeText(MainActivity.this, "Book Saved Successfully", Toast.LENGTH_SHORT).show();
                inputAuthor.setText("");
                inputCost.setText("");
                inputYear.setText("");
                inputTitle.setText("");

            }
        });
    }
    @OnClick(R.id.buttonFetch)
    public void fetch() {
        Intent x = new Intent(this,FetchActivity.class);
        startActivity(x);
        }
}
