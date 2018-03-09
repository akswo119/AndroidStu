package com.example.chap03_03_pdfsample;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView txtView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        txtView1 = findViewById(R.id.txtView1);

        btn1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {

                String sdCardFolder = Environment.getExternalStorageDirectory().getAbsolutePath();
                String fileName = "testPdf.pdf";

                File file = new File(sdCardFolder + File.separator + fileName);

                if (file.exists()){
//                    Uri uri = Uri.fromFile(file);

                    MimeTypeMap mime = MimeTypeMap.getSingleton();
                    String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String type = mime.getMimeTypeFromExtension(ext);

                    Uri uri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".fileProvider", file);

                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    intent.setDataAndType(uri, "application/pdf");
                    intent.setDataAndType(uri, type);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                    try{
                        startActivity(intent);
                    }catch (ActivityNotFoundException e){
                        Toast.makeText(getApplicationContext(), "pdf를 못열어요", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "파일이 없어요", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
