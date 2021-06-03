package vn.com.codeesp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private TextView mResponseTv;
     private ImageButton up;
     private ImageButton down;
     private ImageButton left;
     private ImageButton right;
     private SeekBar seekBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        final EditText titleEt = (EditText) findViewById(R.id.et_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        mResponseTv = (TextView) findViewById(R.id.tv_response);
        up = (ImageButton)findViewById(R.id.up1);
        down = (ImageButton)findViewById(R.id.down);
        left = (ImageButton)findViewById(R.id.left);
        right = (ImageButton)findViewById(R.id.right);
        seekBar1 = (SeekBar)findViewById(R.id.seekBar1);
        final String[] pwm5 = {"300"};
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i == 0) {
                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","30");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","300");

                    }
                } else if (i <= 10) {
                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","350");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","350");

                    }

                } else if (i <= 20) {
                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","400");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","400");

                    }
                } else if (i <= 30) {

                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","450");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","450");

                    }
                } else if (i <= 40) {

                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","500");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","500");

                    }
                } else if (i <= 50) {

                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","550");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","550");

                    }
                } else if (i <= 60) {

                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","600");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","600");

                    }
                } else if (i <= 70) {
                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","650");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","650");

                    }
                } else if (i <= 80) {
                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","700");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","700");

                    }
                } else if (i <= 90) {
                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","750");

                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","750");

                    }
                } else {
                    if(SharedPref.check(MainActivity.this,"keypwm")==true){
                        SharedPref.remove(MainActivity.this,"keypwm");
                        SharedPref.putKey(MainActivity.this,"keypwm","800");
                    }else {
                        SharedPref.putKey(MainActivity.this,"keypwm","800");

                    }

                }
                pwm5[0] = SharedPref.getKey(MainActivity.this,"keypwm");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() ==MotionEvent.ACTION_DOWN){
                    senddatatoserver("1", pwm5[0]);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    senddatatoserver("0", pwm5[0]);

                }
                return false;
            }
        });
//        up.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });
        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() ==MotionEvent.ACTION_DOWN){
                    senddatatoserver("2", pwm5[0]);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    senddatatoserver("0", pwm5[0]);

                }
                return false;
            }
        });
//        down.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                senddatatoserver("2",pwm5[0]);
//
//            }
//        });
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() ==MotionEvent.ACTION_DOWN){
                    senddatatoserver("4", pwm5[0]);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    senddatatoserver("0", pwm5[0]);

                }
                return false;
            }
        });
//        left.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                senddatatoserver("4",pwm5[0]);
//
//            }
//        });
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() ==MotionEvent.ACTION_DOWN){
                    senddatatoserver("3", pwm5[0]);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    senddatatoserver("0", pwm5[0]);

                }

                return false;
            }
        });
//        right.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                senddatatoserver("3",pwm5[0]);
//
//            }
//        });




        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dir = titleEt.getText().toString().trim();
                String pwm = bodyEt.getText().toString().trim();
                if(!TextUtils.isEmpty(dir) && !TextUtils.isEmpty(pwm)) {
                // sendPost(Integer.valueOf(dir),Integer.valueOf(pwm));
                Log.d("checkipa", "post submitted to API." +"Dcdcdcd" );
//                JSONObject payLoad = new JSONObject();
//                try {
//                    payLoad.put("dir", "3");
//                    payLoad.put("pwm", "400");
//
//                    new SendPostRequest().execute("http://192.168.1.101:8080/", payLoad.toString());
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
                     senddatatoserver(dir,pwm);
                }


            }
            //}
        });
    }
    public void senddatatoserver(String dir,String pwm) {
        //function in the activity that corresponds to the layout button
        JSONObject post_dict = new JSONObject();

        try {
            post_dict.put("dir", dir);
            post_dict.put("pwm", pwm);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (post_dict.length() > 0) {
            new SendJsonDataToServer().execute(String.valueOf(post_dict));

        }
    }
}
