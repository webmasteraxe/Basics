package axyz.weezyboy.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.imageButton);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == b1)
        {
            imageView.setImageResource(R.drawable.torch);
        } else if(v == b2){
            imageView.setImageResource(R.drawable.off_torch);
        }

    }

    // Method to start the service
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
