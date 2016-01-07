package axyz.weezyboy.services;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by amungara on 1/7/2016.
 */
public class Service extends android.app.Service {
    int mStartMode;
    IBinder mBinder;
    boolean mAllowRebind;

    /* creating service */

    @Override
    public void onCreate() {

    }


    /** starting the service **/

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return mStartMode;
    }

    /** A client can bind to the service with bindService() */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /* A client calls it when he wants to unbind the service unbindService()*/
    @Override
    public boolean onUnbind(Intent intent){
        return mAllowRebind;
    }

    /*Called when a client is binding to the service with bindService()*/
    @Override
    public  void onRebind(Intent intent){

    }


    /**called when the service is no longer used & is being destroyed **/
    @Override
    public void onDestroy(){

    }
}
