package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerContext);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);
                EditText editName = dialog.findViewById(R.id.editName);
                EditText editNumber = dialog.findViewById(R.id.editNumber);

                Button btnAction = dialog.findViewById(R.id.btnAction);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="", number="";
                        if (!editName.getText().toString().equals("")){
                                name = editName.getText().toString();
                        }else
                            Toast.makeText(MainActivity.this, "Please Enter Contact Name ", Toast.LENGTH_SHORT).show();

                        if (!editNumber.getText().toString().equals("")){
                            number = editNumber.getText().toString();
                        }
                        else Toast.makeText(MainActivity.this, "Please Enter Contact Number ", Toast.LENGTH_SHORT).show();

                        arrContacts.add(new ContactModel(R.drawable.boy5,name,number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        arrContacts.add(new ContactModel(R.drawable.girl1,"deepika","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl2,"Z","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl3,"A","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl4,"deepish","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl5,"A","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl6,"B","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl7,"C","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl8,"D","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.boy1,"E","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.boy2,"F","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.boy3,"G","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.boy4,"H","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.boy5,"I","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl4,"J","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl4,"K","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl4,"L","3977349788"));
        arrContacts.add(new ContactModel(R.drawable.girl4,"m","3977349788"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);
    }



}