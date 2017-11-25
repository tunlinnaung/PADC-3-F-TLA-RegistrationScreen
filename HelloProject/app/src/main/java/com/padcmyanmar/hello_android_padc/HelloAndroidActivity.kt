package com.padcmyanmar.hello_android_padc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_hello_android.*
import kotlinx.android.synthetic.main.content_hello_android.*
import java.util.*

class HelloAndroidActivity : AppCompatActivity() {

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, HelloAndroidActivity::class.java)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_android)
        setSupportActionBar(toolbar)

        btn_click_me.setOnClickListener { view ->
            /* Snackbar.make(view, "Learning from PADC", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show() */

            /* Toast.makeText(view.context, "Leaning from PADC", Toast.LENGTH_SHORT)
                    .show(); */

            Log.d("TAG", "Click Me button clicked.")
            var timeStamp = Calendar.getInstance().time.toString()
            tv_user_click_timestamp.setText("You clicked at {" + timeStamp + "}.")
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_hello_android, menu)
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
}
