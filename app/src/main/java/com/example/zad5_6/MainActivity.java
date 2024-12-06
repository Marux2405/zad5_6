package com.example.zad5_6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView likes;
    private Button like;
    private Button delete;
    private int count;
    private Button save;
    private EditText email;
    private EditText pass;
    private EditText cpass;
    private TextView info;
    private String zapis;
    private Button show;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    likes=findViewById(R.id.count);
    like=findViewById(R.id.like);
    delete=findViewById(R.id.delete);
    save=findViewById(R.id.Save);
    email=findViewById(R.id.email);
    pass=findViewById(R.id.haslo);
    cpass=findViewById(R.id.phaslo);
    info=findViewById(R.id.info);
    show=findViewById(R.id.show);
    count=0;
    like.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
        count++;
        likes.setText(count+" polubień");
        }
    });
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            if(count>0){
                count--;
                likes.setText(count+" polubień");
            }
            }
        });

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String semail = email.getText().toString().trim();
                String spass = pass.getText().toString().trim();
                String scpass = cpass.getText().toString().trim();
                zapis = semail;
                info.setText("");
                if (semail.isEmpty()) {
                info.append("Nie wprowadzono email'a ");
                }
                 if(!semail.contains("@")){
                    info.append("\nWprowadzono zły email");
                }
                if(spass.isEmpty()){
                    info.append("\nNie wprowadzono hasła");
                }
                if(scpass.isEmpty()){
                    info.append("\nNie powtórzono hasła");
                }
                if(!spass.equals(scpass)){
                    info.append("\nHasła sie różnią");
                }
                if(!semail.isEmpty() && semail.contains("@") && !spass.isEmpty() && !scpass.isEmpty() && spass.equals(scpass)){
                    info.setText("Zajerestrowano "+semail);
                }
            };
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    info.setText(zapis);
            }
        });
    };
}