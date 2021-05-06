package sg.edu.np.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sg.edu.np.madpractical.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Debug","OnCreate");

        Intent receivingEnd = getIntent();
        String message = receivingEnd.getStringExtra("number");
        TextView profileTitle = (TextView) findViewById(R.id.profileTitle);
        if (!TextUtils.isEmpty(message)){
            profileTitle.setText("MAD_"+message);
        }else{
            profileTitle.setText("MAD_"+"<<null>>");
        }



        User user = new User(false);

        Button followBtn = (Button) findViewById(R.id.followBtn);

        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.i("Debug",followBtn.getText().toString());
//                if (followBtn.getText().toString() == "Follow"){
//                    Log.i("DebugTrue",followBtn.getText().toString());
//                    followBtn.setText("Unfollow");
//                }else{
//                    Log.i("DebugFalse",followBtn.getText().toString());
//                    followBtn.setText("Follow");
//                }
                    user.setFollowed(!user.isFollowed());
                    Context context = getApplicationContext();
                    if (user.isFollowed()){
                        followBtn.setText("Unfollow");
                        CharSequence text = "Followed";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                    } else{
                        followBtn.setText("Follow");
                        CharSequence text = "Unfollowed";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                    }
            }
        });
    }
    @Override
    protected void onStart( ) {
        super.onStart();
    }
    @Override
    protected void onResume( ) {
        super.onResume();
        Log.i("Debug","onResume");
    }
    @Override
    protected void onPause( ) {
        super.onPause();
        Log.i("Debug","onPaused");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Debug","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Debug","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Debug","onRestart");
    }
}