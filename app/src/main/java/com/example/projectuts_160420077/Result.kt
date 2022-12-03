package com.example.projectuts_160420077

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    var hargaJual="hargaJual";
    var day="day";



    var sharedfile="com.example.projectuts_160420077"
    override fun onCreate(savedInstanceState: Bundle?) {

        var shared: SharedPreferences =getSharedPreferences(sharedfile, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor=shared.edit();

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var dayResult=shared.getInt(day,0);
        var resultTerjual=intent.getIntExtra(Simulation.terjual,0)
        var resultHargaJual=shared.getInt(hargaJual,0)
        var totalPenjualan:Int=(resultTerjual*resultHargaJual)
        var expenses=shared.getInt("Modal",0)
        var profit=totalPenjualan-expenses;
        var balanceOld=shared.getInt("balance",0);
        txtDayResult.setText("Day "+dayResult.toString())
        txtJumlahStokResult.setText(resultTerjual.toString());
        txtTotalResultPenjualan.setText(totalPenjualan.toString());
        txtExpenses.setText(expenses.toString());
        txtProfit.setText(profit.toString());
        var balanceNew=profit+balanceOld;
        var dayTerbaru=dayResult+1;
        if(balanceNew<100000)
        {
            Toast.makeText(this,"Saldo anda tidak cukup silahkan mengulang game dari awal", Toast.LENGTH_SHORT).show()
            btnNewDay.isEnabled=false
        }
        btnNewDay.setOnClickListener {
            editor.putInt("balance",balanceNew);
            editor.putInt("day",dayTerbaru);
            editor.apply();

            var intent= Intent(this,MainActivity::class.java);
            startActivity(intent);
            finish();


        }


    }
}