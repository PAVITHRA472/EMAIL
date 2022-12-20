EMAIL:
ACTIVITY_MAIN.XML:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <EditText
        android:id="@+id/editTextTextEmailAddress"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="174dp"
        android:ems="10"
        android:hint="EMAIL"
        android:inputType="textEmailAddress" />

    <EditText
        android:id="@+id/editTextTextPersonName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="278dp"
        android:layout_marginEnd="98dp"
        android:ems="10"
        android:hint="SUBJECT"
        android:inputType="textPersonName" />

    <EditText
        android:id="@+id/editTextTextMultiLine"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="218dp"
        android:ems="10"
        android:gravity="start|top"
        android:inputType="textMultiLine" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="90dp"
        android:text="SEND" />

</RelativeLayout>

MAINACTIVITY.JAVA:
package com.example.email;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // EditText email = (EditText)findViewById(R.id.editTextTextEmailAddress);
        EditText subject = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText message = (EditText)findViewById(R.id.editTextTextMultiLine);
        EditText to = (EditText)findViewById(R.id.editTextTextEmailAddress);
        Button click = (Button) findViewById(R.id.button);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textmess = message.getText().toString();
                String SUB = subject.getText().toString();
                String add = to.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{add});
                intent.putExtra(Intent.EXTRA_SUBJECT,SUB);
                intent.putExtra(Intent.EXTRA_TEXT,textmess);
                intent.setType("message/rfx822");
                startActivity(Intent.createChooser(intent,"choose email client"));
            }
        });
    }
}
