package org.aplas.servis_mobil;

import android.app.Activity;
import android.media.MediaPlayer;

public class SoundBtn {
    public static void soundBtn (Activity activity) {
        MediaPlayer mpSound1 = MediaPlayer.create(activity, R.raw.tok);
        mpSound1.start();
    }
}