// FileViewer.java

package com.example.project_acadeamease1;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class FileViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_viewer);

        WebView webView = findViewById(R.id.webView);

        String url = getIntent().getStringExtra("uploads");
        if (url != null) {
            loadPDF(webView, url);
        }
    }

    private void loadPDF(WebView webView, String url) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        // Load PDF.js viewer with the PDF file as parameter
        webView.loadUrl("file:///android_asset/pdfjs/web/viewer.html?file=" + url);
    }
}
