package com.example.projectuts_160420077

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_simulation.*

class Simulation : AppCompatActivity() {
    companion object{
        var terjual="terjual";
        var totalTerjual:Int=0;
        var hargaJual="hargaJual";
    }
    var terjual:Int=0;
    override fun onCreate(savedInstanceState: Bundle?) {

        var adapter :RAdapter;
        var sharedfile="com.example.projectuts_160420077"


        var shared: SharedPreferences =getSharedPreferences(sharedfile, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor=shared.edit();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulation)

        var daySimulation=shared.getInt("day",0)
        var weatherSimulation=intent.getStringExtra(MainActivity.weather);
        var jumlahCupSimulation=intent.getIntExtra(MainActivity.jumlahCup,0);
//        var cupsimulation:Int=jumlahCupSimulation.toString().toInt();
        //var hargaJualSimulation=intent.getStringExtra(MainActivity.hargaJual);

        txtDaySimulation.setText("Day "+daySimulation);
        txtCuacaSimulation.setText(weatherSimulation.toString());

        var simulWaktu=Global.waktu;
        var simulasi= emptyArray<String>();
        var result="";

        for (waktu in simulWaktu)
        {
            var randomCup=0;
            if(jumlahCupSimulation<= 5)
            {
                randomCup=(0..jumlahCupSimulation).random();
            }
            else
            {
                randomCup=(0..5).random()
            }
            if(randomCup>0&&jumlahCupSimulation>0)
            {
                result=waktu.toString() + " - " + randomCup.toString() +" Customer"
                jumlahCupSimulation-=randomCup;
                totalTerjual+=randomCup;
            }
            else if(randomCup==0 && jumlahCupSimulation>0)
            {
                result=waktu.toString() + " - " +" No Customer"
            }
            else if(jumlahCupSimulation==0)
            {
                result=waktu.toString() + " - " +"Out of stock"
            }
            simulasi=simulasi.plus(result)
        }
        adapter=RAdapter(simulasi);
        val layoutManager=LinearLayoutManager(applicationContext);
        recycleResult.layoutManager=layoutManager;
        recycleResult.adapter=adapter;

        btnResult.setOnClickListener {

            var intent= Intent(this,Result::class.java);


            //intent.putExtra(Simulation.hargaJual,hargaJualSimulation);
            intent.putExtra(Simulation.terjual, totalTerjual);
            startActivity(intent);
            finish();
            totalTerjual=0;
        }


    }
}