package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        //Input validation
        if(editTextMessage.text.isEmpty()){
            editTextMessage.setError("Value required")
            return
        }
        //Explicit Intent : Component name must be provided
        val intent = Intent(this, SecondActivity::class.java)
        //Insert extra to the Intent
        val message = editTextMessage.text.toString()
        val lucky = editTextLucky.text.toString().toInt()
        intent.putExtra(EXTRA_MSG, message)
        intent.putExtra(EXTRA_LUCKY, lucky)



        startActivityForResult(intent, REQUEST_CODE)



    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int,
                                  data: Intent?) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
               val reply = data?.getStringExtra(EXTRA_REPLY)
                //Display reply here
                textViewReplyMess.text = String.format("%s %s",
                    getString(R.string.reply), reply)
            }
        }

    }

    companion object{
        const val EXTRA_MSG = "com.example.intent.EXTRA_MSG"
        const val EXTRA_LUCKY = "com.example.intent.EXTRA_LUCKY"
        const val EXTRA_REPLY = "com.example.intent.EXTRA_REPLY"
        const val REQUEST_CODE = 1
    }

}
