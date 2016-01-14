package company.example.hm1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class JSViewer extends AppCompatActivity {

    private static final String TAG = "Main";
    private EditText url;
    private String web_URL= "www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsviewer);
    }
    public void buscamela(View v){

        Log.e("Callback", "entered");
        WebView wv = (WebView)findViewById(R.id.webView);
        url = (EditText) findViewById(R.id.editText);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wv.getSettings().setAppCacheEnabled(true);
        wv.loadUrl(url.getText().toString());
        wv.requestFocus();

        wv.loadDataWithBaseURL("notreal/", url.getText().toString(), "text/html", "utf-8", null);
        /*
        <!DOCTYPE html>
<html>
<body>

<script>
document.write("Hello World!");
</script>

</body>
</html>
         */
    }
}
