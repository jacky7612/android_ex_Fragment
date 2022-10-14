package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_Alert = findViewById<Button>(R.id.btnAlert)
        btn_Alert.setOnClickListener(){
            AlertDialog.Builder(this)
                .setTitle("按鍵式對話框")
                .setMessage("內容")
                .setNeutralButton("取消"){ dialog, which->
                    Toast.makeText(this,"取消", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("拒絕"){dialog, which->
                    Toast.makeText(this, "拒絕", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("確定") {dialog, which->
                    Toast.makeText(this, "確定", Toast.LENGTH_SHORT).show()
                }.show()
        }
        var position = 0
        var listItem= arrayOf("選項01", "選項02", "選項03")
        var chkItem= booleanArrayOf(false, true, false)
        val btn_Check = findViewById<Button>(R.id.btnCheck)
        val tvContent = findViewById<TextView>(R.id.tv_content)
        btn_Check.setOnClickListener(){
            AlertDialog.Builder(this)
                .setTitle("按鍵式對話框")
                /*
                .setSingleChoiceItems(listItem, 0)
                {
                    dialogInterface, i ->
                    position = i;
                }*/
                //set multichoice
                .setMultiChoiceItems(listItem, chkItem) { dialog, which, isChecked ->
                    // Update the current focused item's checked status
                    chkItem[which] = isChecked
                    // Get the current focused item
                    val currentItem = listItem[which]
                    // Notify the current action
                    Toast.makeText(applicationContext, currentItem + " " + isChecked, Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("取消") { dialog, which->
                    Toast.makeText(this,"取消", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("拒絕") { dialog, which->
                    Toast.makeText(this, "拒絕", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("確定") { dialog, which->
                    Toast.makeText(this, "確定", Toast.LENGTH_SHORT).show()
                }.show()
        }
    }
}