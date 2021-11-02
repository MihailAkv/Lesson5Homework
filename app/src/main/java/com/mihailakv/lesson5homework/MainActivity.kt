package com.mihailakv.lesson5homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private const val TAG = "MainActivity"
private const val MY_OWN_LOG_TAG = "MyOwnLog"
private const val VALUE = "Value"

class MainActivity : AppCompatActivity() {

    private lateinit var helloTextView: TextView
    private lateinit var randomizeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloTextView=findViewById(R.id.hello_text_view)
        randomizeButton = findViewById(R.id.randomize_button)
        if (savedInstanceState!=null)
            helloTextView.text=savedInstanceState.getString(VALUE)
        else
            randomize()
        randomizeButton.setOnClickListener{randomize()}
        Log.d(MY_OWN_LOG_TAG,"Ты видел деву на скале\n" +
                "В одежде белой над волнами")
    }

    private fun randomize() {
        val randomValue=Random.nextInt(100)
        helloTextView.text=randomValue.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d(MY_OWN_LOG_TAG, "Когда, бушуя в бурной мгле,\n" +
                "Играло море с берегами,")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MY_OWN_LOG_TAG, "Когда луч молний озарял\n" +
                "Ее всечасно блеском алым")
    }

    override fun onPause() {
        super.onPause()
        Log.d(MY_OWN_LOG_TAG, "И ветер бился и летал\n" +
                "С ее летучим покрывалом?")
    }

    override fun onStop() {
        super.onStop()
        Log.d(MY_OWN_LOG_TAG, "Прекрасно море в бурной мгле\n" +
                "И небо в блесках без лазури;")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MY_OWN_LOG_TAG,"onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MY_OWN_LOG_TAG, "Но верь мне: дева на скале\n" +
                "Прекрасней волн, небес и бури.")
    }

/*    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(VALUE,helloTextView.text.toString())
    }
**/
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALUE,helloTextView.text.toString())
    }
}