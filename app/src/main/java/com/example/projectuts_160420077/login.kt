package com.example.projectuts_160420077

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    companion object{
        var balance:Int=350000;
        var player="";
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        var Unama="username"
        var Upass="password"
        var balance="balance";
        var day="day";
        var sharedfile="com.example.projectuts_160420077"

        var shared:SharedPreferences=getSharedPreferences(sharedfile,Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor=shared.edit();
        editor.putString(Unama,"ikhsan")
        editor.putString(Upass,"1234")
        editor.putInt(balance,350000)
        editor.putInt(day,1);
        editor.apply();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var username=shared.getString(Unama,"tes").toString()
        var password=shared.getString(Upass,"tes").toString()



        btnLogin.setOnClickListener {
            var getUsername=txtUsername.text.toString();
            var getPassword=txtPassword.text.toString();
            if(getUsername==username && getPassword==password){
                var intent= Intent(this,MainActivity::class.java);

                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(this,"Username atau password salah!",Toast.LENGTH_SHORT).show()
            }

        }
    }
}