package com.archimagus.magical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var option : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        option = findViewById(R.id.spinner) as Spinner
        val options = arrayOf("energie","projectil","self","touch")

        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }
        }




        save_spell.setOnClickListener() {
            val result: Double = textView4.text.toString().toDouble()
            if (result != null) {
                saver.setText(result.toString())
            }
        }
        button.setOnClickListener(){

            var test: bool = true
            test = true;

            val damage: Double = damage.text.toString().toDouble()
            val timecast: Double = timecast.text.toString().toDouble()
            val bonus_stuff: Double = bonus_stuff.text.toString().toDouble()
            val niveau: Double = niveau.text.toString().toDouble()
            val zone: Double = zone.text.toString().toDouble()
            val timeuse: Double = timeuse.text.toString().toDouble()
            val timeactivity: Double = timeactivity.text.toString().toDouble()
            val old_cost: Double = saver.text.toString().toDouble()


            if (damage != null && timecast != null && bonus_stuff != null && niveau != null && zone != null && timeuse != null && timeactivity != null){
                val result: Double = (((damage*(1-(timecast/100)))*0.7).pow(zone)*(1-((bonus_stuff.pow(0.8))/100))*((timeuse+(timeactivity*1.5))/0.75)*(1-((niveau.pow(0.9)/100)))+(old_cost*42))
                textView4.setText(result.toString())
            }
            else {
                textView4.setText("test")
            }
        }
    }
}