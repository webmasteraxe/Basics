package weezyboy.axyz.basix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String msg = "Im Alive :) ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg," OnCreate has been called");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(msg," OnStart() has been called");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(msg, " OnResume() has been called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(msg," OnPause() has been called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(msg," OnStop() has been called");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(msg," OnDestroy() has been called :( ");
    }

}
