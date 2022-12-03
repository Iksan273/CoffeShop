package com.example.projectuts_160420077

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{

        var day="day";
        var weather="weather";
        var jumlahCup="jumlahCup";

    }
    var modalExpenses="Modal";
    var hargaJual="hargaJual";
    var Unama="username"
    var Upass="password"
    var balance="balance";
    var sharedfile="com.example.projectuts_160420077"
    var rando=(0..3).random();
    var weatherPrep=Global.weather[rando];

    var dayPrep:Int=0;
    var coffeTerjual:Int=0;




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var shared: SharedPreferences =getSharedPreferences(sharedfile, Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor=shared.edit();
        var balanceNow=shared.getInt(balance,1);
        var nama=shared.getString("username","yuhu");
        txtNama.setText(nama.toString());
        dayPrep=shared.getInt(day,0);
        txtBalance.setText("IDR. "+balanceNow.toString())
        txtCuaca.text=weatherPrep.toString();
        txtDay.setText("Day  "+dayPrep.toString());

        var coffe:Int=500;
        var milk:Int=1000;
        var water:Int=200;
        var bahanCoffe:Int=1;
        var bahanMilk:Int=1;
        var bahanWater:Int=1;
        var hargaSatuan:Int=1;
        var stokAwal:Int=1;
        var harga:Int=1;
        var totalModal:Int=0;
        var hargaTempat:Int=0;
        var tempat="";
        var modalKeseluruhan:Int=0;


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Global.location)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLocation.adapter=adapter;

        spinnerLocation.onItemSelectedListener= object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var location=spinnerLocation.selectedItem as Location;
                hargaTempat=location.harga;
                tempat=location.name;
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        txtCoffe.setText(bahanCoffe.toString());
        txtMilk.setText(bahanMilk.toString());
        txtWater.setText(bahanWater.toString());
        txtJumlahStok.setText(stokAwal.toString());
        txtHargaJual.setText(harga.toString());
        hargaSatuan=((bahanCoffe*coffe)+(bahanMilk*milk)+(bahanWater*water));
        txtHargaPcs.setText(hargaSatuan.toString());
        txtHargaModal.setText(hargaSatuan.toString());
        totalModal=stokAwal*hargaSatuan;
        txtTotalHargaCoffe.setText(totalModal.toString())
        txtJumlahStokAwal.setText(stokAwal.toString());
        txtHargaModal.setText(hargaSatuan.toString());

        txtTotalHargaCoffe.setText(totalModal.toString())




        spinnerLocation.onItemSelectedListener= object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var location=spinnerLocation.selectedItem as Location;
                hargaTempat=location.harga;
                tempat=location.name;
                txtTempatJualan.setText(tempat.toString());
                txtHargaRent.setText(hargaTempat.toString());
                modalKeseluruhan=totalModal+hargaTempat;
                txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnUpCoffe.setOnClickListener {
            bahanCoffe++;
            txtCoffe.setText(bahanCoffe.toString());
            hargaSatuan=((bahanCoffe*coffe)+(bahanMilk*milk)+(bahanWater*water));
            txtHargaPcs.setText(hargaSatuan.toString());
            txtHargaModal.setText(hargaSatuan.toString());
            totalModal=stokAwal*hargaSatuan;
            txtTotalHargaCoffe.setText(totalModal.toString())
            modalKeseluruhan=totalModal+hargaTempat;
            txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())

        }
        btnDownCoffe.setOnClickListener {
            bahanCoffe--;
            if(bahanCoffe<0)
            {
                bahanCoffe=0
            }
            txtCoffe.setText(bahanCoffe.toString());
            hargaSatuan=((bahanCoffe*coffe)+(bahanMilk*milk)+(bahanWater*water));
            txtHargaPcs.setText(hargaSatuan.toString());
            txtHargaModal.setText(hargaSatuan.toString());
            totalModal=stokAwal*hargaSatuan;
            txtTotalHargaCoffe.setText(totalModal.toString())
            modalKeseluruhan=totalModal+hargaTempat;
            txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())

        }
        btnUpMilk.setOnClickListener {
            bahanMilk++;
            txtMilk.setText(bahanMilk.toString());
            hargaSatuan=((bahanCoffe*coffe)+(bahanMilk*milk)+(bahanWater*water));
            txtHargaPcs.setText(hargaSatuan.toString());
            txtHargaModal.setText(hargaSatuan.toString());
            totalModal=stokAwal*hargaSatuan;
            txtTotalHargaCoffe.setText(totalModal.toString())
            modalKeseluruhan=totalModal+hargaTempat;
            txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())

        }
        btnDownMilk.setOnClickListener {
            bahanMilk--;
            if(bahanMilk<0)
            {
                bahanMilk=0
            }
            txtMilk.setText(bahanMilk.toString());
            hargaSatuan=((bahanCoffe*coffe)+(bahanMilk*milk)+(bahanWater*water));
            txtHargaPcs.setText(hargaSatuan.toString());
            txtHargaModal.setText(hargaSatuan.toString());
            totalModal=stokAwal*hargaSatuan;
            txtTotalHargaCoffe.setText(totalModal.toString())
            modalKeseluruhan=totalModal+hargaTempat;
            txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())

        }
        btnUpWater.setOnClickListener {
            bahanWater++;
            txtWater.setText(bahanWater.toString());
            hargaSatuan=((bahanCoffe*coffe)+(bahanMilk*milk)+(bahanWater*water));
            txtHargaPcs.setText(hargaSatuan.toString());
            txtHargaModal.setText(hargaSatuan.toString());
            totalModal=stokAwal*hargaSatuan;
            txtTotalHargaCoffe.setText(totalModal.toString())
            modalKeseluruhan=totalModal+hargaTempat;
            txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())

        }
        btnDownWater.setOnClickListener {
            bahanWater--;
            if(bahanWater<0)
            {
                bahanWater=0
            }
            txtWater.setText(bahanWater.toString());
            hargaSatuan=((bahanCoffe*coffe)+(bahanMilk*milk)+(bahanWater*water));
            txtHargaPcs.setText(hargaSatuan.toString());
            txtHargaModal.setText(hargaSatuan.toString());
            totalModal=stokAwal*hargaSatuan;
            txtTotalHargaCoffe.setText(totalModal.toString())
            modalKeseluruhan=totalModal+hargaTempat;
            txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())

        }

        txtJumlahStokAwal.addTextChangedListener() {
            if (txtJumlahStokAwal.text.isNotEmpty()) {
                stokAwal = txtJumlahStokAwal.text.toString().toInt();
                txtJumlahStok.setText(stokAwal.toString());
                txtTempatJualan.setText(tempat.toString());
                totalModal=stokAwal*hargaSatuan;
                txtTotalHargaCoffe.setText(totalModal.toString())
                var location = spinnerLocation.selectedItem as Location;
                hargaTempat = location.harga;
                tempat = location.name;
                modalKeseluruhan=totalModal+hargaTempat;
                txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())
            } else {
                stokAwal = 1;
                txtJumlahStok.setText(stokAwal.toString());
                var location = spinnerLocation.selectedItem as Location;
                totalModal=stokAwal*hargaSatuan;
                txtTotalHargaCoffe.setText(totalModal.toString())
                hargaTempat = location.harga;
                tempat = location.name;
                modalKeseluruhan=totalModal+hargaTempat;
                txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())
            }

        }





        txtHargaJual.addTextChangedListener() {
            if(txtHargaJual.text.isNotEmpty())
            {
               harga=txtHargaJual.text.toString().toInt();

               txtHargaModal.setText(hargaSatuan.toString());
               totalModal=stokAwal*hargaSatuan;
               txtTotalHargaCoffe.setText(totalModal.toString())
               txtHargaRent.setText(hargaTempat.toString());
               modalKeseluruhan=totalModal+hargaTempat;
               txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())
                modalKeseluruhan=totalModal+hargaTempat;
                txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())

            }
            else
            {
                harga=1;
                txtHargaModal.setText(hargaSatuan.toString());
                txtTotalHargaCoffe.setText(totalModal.toString())
                txtHargaRent.setText(hargaTempat.toString());
                modalKeseluruhan=totalModal+hargaTempat;
                txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())
                var location=spinnerLocation.selectedItem as Location;
                hargaTempat=location.harga;
                tempat=location.name;
                modalKeseluruhan=totalModal+hargaTempat;
                txtTotalModalKeseluruhan.setText(modalKeseluruhan.toString())
            }

        }
        var balanceUpdate=balanceNow-modalKeseluruhan;
        btnStartDay.setOnClickListener {

            if(balanceNow < modalKeseluruhan)
            {
                Toast.makeText(this,"Saldo anda tidak cukup", Toast.LENGTH_SHORT).show()
            }
            else if ( bahanCoffe ==0 || bahanMilk==0 || bahanWater==0)
            {
                Toast.makeText(this,"bahan baku tidak boleh ad yang 0", Toast.LENGTH_SHORT).show()
            }
            else if(stokAwal==0 || harga==0)

            {
                Toast.makeText(this,"Harga jual dan stok tidak boleh 0", Toast.LENGTH_SHORT).show()
            }
            else
            {
                editor.putInt(hargaJual,harga);
                editor.putInt(balance,balanceUpdate)
                editor.putInt(modalExpenses,modalKeseluruhan)
                editor.apply();
                var intent=Intent(this,Simulation::class.java);
                intent.putExtra(day,dayPrep);
                intent.putExtra(weather,weatherPrep.toString());
                intent.putExtra(jumlahCup,stokAwal);
                intent.putExtra(modalExpenses,modalKeseluruhan)
                intent.putExtra(hargaJual,harga);
                startActivity(intent);
                finish();
            }


        }



    }
}