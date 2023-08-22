package com.example.jeomjamoon;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

//이미지 저장 필요

public class MainActivity2 extends AppCompatActivity {

    private TextToSpeech tts;
    private ImageButton btn_Speak;
    private TextView txtText;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private String currentPhotoPath;

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Button select = findViewById(R.id.select_picture);
        ImageView selectImg = findViewById(R.id.select);
        Button upload = findViewById(R.id.translate_pic);

        ActivityResultLauncher<Intent> activityResultLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            Uri uri = data.getData();
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                                selectImg.setImageBitmap(bitmap);
                            } catch (IOException e) {
                                e.printStackTrace();
                                // throw new RuntimeException(e);
                            }

                        }
                    }
                });

        selectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);
            }
        });

        upload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ByteArrayOutputStream byteArrayOutputStream;
                byteArrayOutputStream = new ByteArrayOutputStream();
                if(bitmap != null){
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    final String base64Image = Base64.encodeToString(bytes, Base64.DEFAULT);

                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    String url ="http://172.30.1.51:5000/model"; //각자 컴퓨터에 맞게 ip주소 바꿔서 실행

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    txtText.setText(response);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        }
                    }){
                        protected Map<String, String> getParams(){
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("f", base64Image);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);
                }
                else Toast.makeText(getApplicationContext(), "이미지를 먼저 선택하세요", Toast.LENGTH_LONG).show();
            }

        });

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=android.speech.tts.TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        btn_Speak = findViewById(R.id.voice);
        txtText = findViewById(R.id.result);

        btn_Speak.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override public void onClick(View v) {
                String text = txtText.getText().toString();

                tts.setPitch(1.0f);
                tts.setSpeechRate(1.0f);
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    private static final int REQUEST_GALLERY = 2;
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, REQUEST_GALLERY);
    }

    @Override public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
        super.onDestroy();
    }
}