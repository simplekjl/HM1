package company.example.hm1;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Main";
    private EditText url;
    private String web_URL= "www.google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Chingon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.e("Callback", "entered");
        WebView wv = (WebView)findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient());
        url = (EditText) findViewById(R.id.editText);
        // Enable JavaScript
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);


        wv.loadUrl("http:\\" + web_URL);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,JSViewer.class);
            startActivity(intent);
        }
        if(id == R.id.buscador)
        {
            Snackbar.make(this.findViewById(android.R.id.content),"Ya me quedo papafish",Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void buscamela(View v){

        Log.e("Callback","entered");
        WebView wv = (WebView)findViewById(R.id.webView);
        url = (EditText) findViewById(R.id.editText);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wv.getSettings().setAppCacheEnabled(true);
        wv.loadUrl(url.getText().toString());
        wv.requestFocus();

        wv.loadDataWithBaseURL("notreal/", url.getText().toString(), "text/html", "utf-8",null);
    }


}
