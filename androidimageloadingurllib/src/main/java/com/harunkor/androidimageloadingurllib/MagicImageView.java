package com.harunkor.androidimageloadingurllib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint("AppCompatCustomView")
public class MagicImageView extends  ImageView {

    private MagicImageTask currentTask;
    private static final int LOADING_THREADS = 4;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(LOADING_THREADS);
    private  AnimationDrawable frameAnimation;
    private int resid=0;

    public MagicImageView(Context context) {
        super(context);
    }

    public MagicImageView(Context context,  AttributeSet attrs) {
        super(context, attrs);

    }

    public MagicImageView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MagicImageView(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }



    public void load(String url,boolean isProgress) {

        setImage(new WebImage(url),isProgress);

    }

    public  void allClearCache()
    {
        new WebImageCache(getContext()).clear();
    }


    public void clearCache(String url)
    {
        new WebImageCache(getContext()).remove(url);
    }






    public void setImage(final MagicImage image,boolean isProgress) {
        setImage(image, null, isProgress);
    }

    public void setImage(final MagicImage image, final MagicImageTask.OnCompleteListener completeListener, final boolean isProgress) {
        // Cancel any existing tasks for this image view
        if(isProgress==true)
        {
            if(resid==0)
            {
              resid= R.drawable.magic_progress;
            }
            setBackgroundResource(setProgress(resid));
            frameAnimation = (AnimationDrawable) getBackground();
            // Start the animation (looped playback by default).
            frameAnimation.start();

        }



        if(currentTask != null) {
            currentTask.cancel();
            currentTask = null;
        }

        // Setup the new task
        currentTask = new MagicImageTask(getContext(), image);

        currentTask.setOnCompleteHandler(new MagicImageTask.OnCompleteHandler() {
            @Override
            public void onComplete(Bitmap bitmap) {
                if(bitmap != null) {
                    setImageBitmap(bitmap);

                    if(isProgress==true)
                    {
                        frameAnimation.stop();
                        setBackgroundResource(0);

                    }


                }

                if(completeListener != null){
                    completeListener.onComplete(bitmap);
                }
            }
        });

        // Run the task in a threadpool
        threadPool.execute(currentTask);
    }



 public int setProgress(int resid)
 {
     return this.resid=resid;



 }






}
