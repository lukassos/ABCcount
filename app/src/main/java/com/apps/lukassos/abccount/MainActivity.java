package com.apps.lukassos.abccount;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        int counta = 0;
        int countb = 0;
        int countc = 0;
        int countAll = 0;

        TextView tv ;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button a = (Button) rootView.findViewById(R.id.button);
            a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countAll ++;
                    counta ++ ;
                    refreshText();
                }
            });
            Button b = (Button) rootView.findViewById(R.id.button2);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countAll ++;
                    countb ++ ;
                    refreshText();
                }
            });
            Button c = (Button) rootView.findViewById(R.id.button3);
            c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countAll ++;
                    countc ++ ;
                    refreshText();
                }
            });
            tv = (TextView) rootView.findViewById(R.id.textView);

            refreshText();

            return rootView;
        }

        private void refreshText(){
            tv.setText("A : "+counta+" B: "+countb+" c: "+countc+" all:" + countAll);
        }
    }
}
