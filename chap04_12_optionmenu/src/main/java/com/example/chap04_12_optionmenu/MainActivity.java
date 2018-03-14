package com.example.chap04_12_optionmenu;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    
    android.support.v7.app.ActionBar abar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //abar = getActionBar();
        abar = this.getSupportActionBar();

        abar.setSubtitle("액션바");

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abar.setLogo(R.drawable.exploer);
                abar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        View v = menu.findItem(R.id.menu_search).getActionView();
        
        if(v != null){
            editText = v.findViewById(R.id.editText);
            
            if (editText != null){

                editText.setOnEditorActionListener(onSearchListener);
            }
        }

        
        //return super.onCreateOptionsMenu(menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        int curId = item.getItemId();
//
//
//        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
//
        return super.onOptionsItemSelected(item);
    }

    private TextView.OnEditorActionListener onSearchListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (event == null || event.getAction() == KeyEvent.ACTION_UP) {

                search();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }

            return (true);
        }
    };


    private void search() {
        String searchString = editText.getEditableText().toString();
        Toast.makeText(this, searchString, Toast.LENGTH_SHORT).show();
    }

}
