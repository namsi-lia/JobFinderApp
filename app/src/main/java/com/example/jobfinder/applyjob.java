package com.example.jobfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class applyjob extends AppCompatActivity {
    TextView jobtitletv, companytv, locationtv, experiencetv, salarytv, sectortv, descriptiontv;
    String jobtitlest, companyst, locationst, experiencest, salaryst, sectorst, descriptionst,jobidst,companyidst;
    //String skillst,skill="",newline=System.getProperty("line.separator");
    Intent intent;
    MaterialButton applyjobbutton;
    FirebaseDatabase fd;
    DatabaseReference ref;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyjob);
        jobtitletv = findViewById(R.id.job_title);
        companytv = findViewById(R.id.company);
        locationtv = findViewById(R.id.location);
        experiencetv = findViewById(R.id.experience);
        salarytv = findViewById(R.id.salary);
        sectortv = findViewById(R.id.sector);
        descriptiontv = findViewById(R.id.description);
        applyjobbutton = findViewById(R.id.applyforjobbtn);
        intent = getIntent();
        jobtitletv.setText(jobtitlest = intent.getStringExtra("jobtitle"));
        companytv.setText(companyst = intent.getStringExtra("company"));
        locationtv.setText(locationst = intent.getStringExtra("location"));
        experiencetv.setText(experiencest = intent.getStringExtra("experience"));
        salarytv.setText(salaryst = intent.getStringExtra("salary"));
        sectortv.setText(sectorst = intent.getStringExtra("sector"));
        descriptiontv.setText(descriptionst = intent.getStringExtra("description"));
        jobidst=intent.getStringExtra("jobid");
        companyst=intent.getStringExtra("companyid");
        System.out.println("Company id is "+companyst+"job id "+jobidst);
        firebaseAuth=FirebaseAuth.getInstance();
        applyjobbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Test.class);
                intent.putExtra("compid",companyst);
                intent.putExtra("jobid",jobidst);
                intent.putExtra("jobtitle",jobtitlest);
                intent.putExtra("companyname",companytv.getText().toString().trim());
                intent.putExtra("experience",experiencest);
                intent.putExtra("location",locationst);
                intent.putExtra("salary",salaryst);
                intent.putExtra("desc",descriptionst);
                intent.putExtra("sector",sectorst);
                startActivity(intent);
            }
        });
    }
}
/*  fd=FirebaseDatabase.getInstance();
                ref=fd.getReference().child("Companies").child(companyst).child("Job Openings").child(jobidst);
                String uid=firebaseAuth.getCurrentUser().getUid();
                Map<Object,String> ob=new HashMap<>();
                ob.put("uid",uid);
                ref.child(uid).setValue(ob);*/
