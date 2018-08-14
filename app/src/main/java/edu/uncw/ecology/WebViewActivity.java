package edu.uncw.ecology;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        getIntent();
        Location location = Parcels.unwrap(getIntent().getParcelableExtra(getString(R.string.intent_location_to_open)));
        getSupportActionBar().setTitle(String.format(getResources().getString(R.string.title_activity_web_view), location.getTitle()));
        webView.loadUrl(location.url);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        if ((keyCode == KeyEvent.KEYCODE_FORWARD) && webView.canGoForward()) {
            webView.goForward();
            return true;
        }


        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }


    private class MyWebViewClient extends WebViewClient {
    }
}
