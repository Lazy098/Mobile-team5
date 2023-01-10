package vn.edu.usth.nutrition_recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteChoiceActivity extends AppCompatActivity {
    Button deletebtn;
    EditText username, password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_choice);

        View back_btn = findViewById(R.id.arrow_delete_account);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeleteChoiceActivity.this, SettingsActivity.class));
            }
        });

        username = (EditText) findViewById(R.id.username_txt);
        password = (EditText) findViewById(R.id.password_txt);
        deletebtn = (Button) findViewById(R.id.delete_account_btn);
        DB = new DBHelper(this);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(DeleteChoiceActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(DeleteChoiceActivity.this, "Account deleted successfully", Toast.LENGTH_SHORT).show();
                        DB.deleteAccount(user,pass);
                        Intent intent = new Intent(DeleteChoiceActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(DeleteChoiceActivity.this, "InvalidCredentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}