package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Get the Extra value(s)
        val message = intent.getStringExtra(MainActivity.EXTRA_MSG)
        val lucky = intent.getIntExtra(MainActivity.EXTRA_LUCKY, 0)
        textViewMessageMess.text = String.format("%s %s %d",
            getString(R.string.message), message, lucky)


        buttonDone.setOnClickListener{
            intent = getIntent() //Who called me?

            if(!editTextReply.text.isEmpty()){
                val reply = editTextReply.text.toString()
                intent.putExtra(MainActivity.EXTRA_REPLY, reply)
                setResult(Activity.RESULT_OK, intent)
            }else{
                setResult(Activity.RESULT_CANCELED)
            }

            // terminate the Second Activity
            finish()
        }
    }
}
