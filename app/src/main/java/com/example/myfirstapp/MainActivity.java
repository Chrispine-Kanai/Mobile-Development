package com.example.myfirstapp;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myfirstapp.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE =
            "com.example.myfirstapp.MESSAGE";
    private Button login;
    EditText usernameET;
    EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.loginButton);

        usernameET = (EditText) findViewById(R.id.username);
        passwordET = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                // myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);

//                SignIn(View);
            }
        }); //closing the setOnClickListener method


        //code added
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);

//        Button b1;
//        b1=(Button)findViewById(R.id.button1);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView txtView = (TextView) findViewById(R.id.textView);
//                txtView.setTextSize(25);
//            }
//        });
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void SignIn(View view) {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();

        if(username.equals("chris") && password.equals("123456789")){
            Toast.makeText(this, "You Signed In", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
        }
    }
}