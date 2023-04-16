package com.example.sanskarinvitation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SendMail extends AppCompatActivity {
    Button send;
    EditText mail,nameE;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        send  = (Button)this.findViewById(R.id.send);
        mail = findViewById(R.id.pasteEmail);
        nameE = findViewById(R.id.name);

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String email = mail.getText().toString();
                String s = email;
                name = nameE.getText().toString();
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(SendMail.this, s, Toast.LENGTH_SHORT).show();
                        try
                        {
                            sendEmail(s);
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(SendMail.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },3000);

            }
        });
    }

    private void sendEmail(String email) throws Exception
    {
        Intent emailSend = new Intent(Intent.ACTION_SEND);
        String message = "Hello,\n" +
                "Greetings from Training and Placement Cell Sanskar College Of Engineering And Technology, Ghaziabad!\n" +
                "I am "+name+", Training and Placement Coordinator, SCET Ghaziabad.\n" +
                "We are happy to extend you the invitation for the Campus Placement Drive of our institute. We are open to internship opportunities(2024,2025) and placement opportunities(2023 Batch), and we have a good strength of skilled students. We look forward to having a fruitful association with your organization.\n" +
                "Kindly connect with us and share the Job Description at-  rakhi.verma@sanskar.org ,  ashish19-cs@sanskar.org & shrishti19-cs@sanskar.org\n" +
                "\n" +
                "\n" +
                "Thanks & Regards,\n" +
                "\n" +
                "Rakhi Verma (T&P)\n" +
                "Mob. 7251000109\n" +
                "\n" +
                "Shrishti Garg\n" +
                "Coordinator T&P\n" +
                "Mob. 9811768086\n" +
                "\n" +
                "Ashish Rai\n" +
                "Coordinator T&P\n" +
                "Mob. 7310131004\n" +
                "\n" +
                "Training and Placement Cell\n" +
                "SCET, Ghaziabad";

        emailSend.setData(Uri.parse("mailto:"));
        emailSend.setType("message/rfc822");
        emailSend.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        emailSend.putExtra(Intent.EXTRA_SUBJECT,"Invitation for Campus/Virtual Placement Drive");
        emailSend.putExtra(Intent.EXTRA_TEXT,message);
        try
        {
            startActivity(Intent.createChooser(emailSend,"Email via"));
        }
        catch(Exception e)
        {
            throw e;
        }
    }

}