package com.example.first

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.first.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

         binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
 */
        val ebName          = findViewById<EditText>(R.id.ebName)
        val tvName          = findViewById<TextView>(R.id.tvName)
        val rgSelect        = findViewById<RadioGroup>(R.id.rgContext)
        val btStart         = findViewById<Button>(R.id.btStart)
        val tvShowName      = findViewById<TextView>(R.id.tvShowName)
        val tvShowVictory   = findViewById<TextView>(R.id.tvShowVictory)
        val tvShowMe        = findViewById<TextView>(R.id.tvShowMe)
        val tvShowPC        = findViewById<TextView>(R.id.tvShowPC)
        val rbScissor       = findViewById<RadioButton>(R.id.rbScissor)
        val rbStone       = findViewById<RadioButton>(R.id.rbStone)
        val rbPaper       = findViewById<RadioButton>(R.id.rbPaper)

        btStart.setOnClickListener()
        {
            if (ebName.length() < 0)
            {
                tvName.text="請輸入玩家的姓名"
            }
            else
            {
                tvShowName.text = "名字\n${ebName.text}"
                tvShowMe.text   = "我方出拳\n${if (rbScissor.isChecked) "剪刀" else if (rbStone.isChecked) "石頭" else "布"}"
                val PCselect = (Math.random() * 3).toInt()
                tvShowPC.text   = "電腦出拳\n${if (PCselect == 0) "剪刀" else if (PCselect == 1) "石頭" else "布"}"

                when {
                    rbScissor.isChecked && PCselect == 2 ||
                    rbStone.isChecked   && PCselect == 0 ||
                    rbPaper.isChecked   && PCselect == 1 ->
                    {
                        tvShowVictory.text = "勝利者\n${ebName.text}"
                    }

                    rbScissor.isChecked && PCselect == 1 ||
                    rbStone.isChecked   && PCselect == 2 ||
                    rbPaper.isChecked   && PCselect == 0 ->
                    {
                        tvShowVictory.text = "勝利者\n電腦"
                    }

                    else ->
                    {
                        tvShowVictory.text = "勝利者\n平局"
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}