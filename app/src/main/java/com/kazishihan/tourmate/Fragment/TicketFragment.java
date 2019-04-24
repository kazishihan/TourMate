package com.kazishihan.tourmate.Fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kazishihan.tourmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicketFragment extends Fragment {
    WebView Wview;



    public TicketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_ticket, container, false);
        Wview = (WebView) view.findViewById(R.id.webView);


        Wview.getSettings().setJavaScriptEnabled(true);
        Wview.setWebViewClient(new MyBrowser());
        Wview.loadUrl("http://shohoz.com/");

        Wview.setWebChromeClient(new WebChromeClient());



        return view;
    }


    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView Wview, String url) {
            Wview.loadUrl(url);
            return true;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && Wview.canGoBack()) {
            Wview.goBack();
            return true;
        }
        return super.getView().onKeyDown(keyCode, event);
    }

}