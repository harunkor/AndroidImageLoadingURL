# AndroidImageLoadingURL

Library for url image loading  on imageview - Android.
Simple android imageView to display url image efficiently. You can load image url, clear cache url and all clear cache  url images. Example usages can be found in example project.

# Screen



# Usage

Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
dependencies {
	        implementation 'com.github.harunkor:AndroidImageLoadingURL:0.0.6'
	}
  
```
Layout : 

```
 <com.harunkor.androidimageloadingurllib.MagicImageView
        android:id="@+id/imageView"
        android:scaleType="centerCrop"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingConstraints" />
        
```

Code : 

```
       // url set progress animation-list
       magicImageView.setProgress(R.drawable.magic_progress);
       
       //url image  load set.
       magicImageView.load("https://i.imgur.com/XGbwZnb.jpg",true);

        // url image clear cache.
       magicImageView.clearCache("https://i.imgur.com/XGbwZnb.jpg");

        // url all images clear cache.
       magicImageView.allClearCache();
           

               
```
 
# Manifest 
Permission : (dependent on use)
```
  <uses-permission android:name="android.permission.INTERNET"></uses-permission>
  
  
 
```


