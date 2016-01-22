package axyz.weezyboy.services.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import axyz.weezyboy.services.MyService;
import axyz.weezyboy.services.R;

/**
 * Created by ${weezyboyaxy} on 1/8/2016.
 */
public class TorchActivity extends Activity {
    ImageView flashLightButton;
    private Camera camera;
    private Parameters parameters;
    boolean isFlashLightOn = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.torchy);
        flashLightButton = (ImageView) findViewById(R.id.btnSwitch);

        flashLightButton.setOnClickListener(new FlashOnOffListener());

        if (isFlashSupported()) {
            camera = Camera.open();
            parameters = camera.getParameters();
        } else {
            showNoFlashAlert();
        }
    }

    private class FlashOnOffListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(isFlashLightOn){
                flashLightButton.setImageResource(R.drawable.off_torch);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.stopPreview();
                isFlashLightOn = false;
                stopService(new Intent(getBaseContext(), MyService.class));
            }else{
                flashLightButton.setImageResource(R.drawable.on_torch);
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();
                startService(new Intent(getBaseContext(), MyService.class));
                isFlashLightOn = true;
            }

        }

    }

    private void showNoFlashAlert() {
        new AlertDialog.Builder(this)
                .setMessage("Your device hardware does not support flashlight!")
                .setIcon(android.R.drawable.ic_dialog_alert).setTitle("Error")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).show();
    }

    private boolean isFlashSupported() {
        PackageManager pm = getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    @Override
    protected void onDestroy() {
        if(camera != null){
            camera.stopPreview();
            camera.release();
            camera = null;
        }
        super.onDestroy();
    }




}
