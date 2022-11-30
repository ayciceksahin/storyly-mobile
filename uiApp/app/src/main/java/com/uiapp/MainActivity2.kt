package com.uiapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appsamurai.storyly.*
import com.appsamurai.storyly.analytics.StorylyEvent
import com.uiapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val secondPage = binding.root
        setContentView(secondPage)

        val action: String? = intent?.action
        val data1: Uri? = intent?.data
        Log.d("<<<<<<<data>>>>>>>","uri: {$data1} and {$action}")

        val storylyView = findViewById<StorylyView>(R.id.storyly_view)

        val userPropertiesData= mapOf(
            "user_id" to "John",
            "country_count" to "9",
            "mile_count" to "2751"
        )

        storylyView.storylyInit = StorylyInit(
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NfaWQiOjgyNTMsImFwcF9pZCI6MTMyMjcsImluc19pZCI6MTQzODZ9._CeIetiqIj_P46K_SzxditVkoRAAVtdBsRxNZ_qJW4E",
        )
        data1?.let {
            storylyView.openStory(data1)
        }


        val externalData = mutableListOf<Map<String, Any?>>(
            mapOf(
                "{name}" to "Sahin!",
                //"{surname}" to "aycicek"
                "{user_id}" to "Sahin",
                "{img}" to "https://cdn.pixabay.com/photo/2012/04/13/17/00/lcd-32872_1280.png"
            ),
            mapOf(
                "{name}" to "Alper!",
                "{user_id}" to "Alper",
                //"{surname}" to "aycicek"
                "{img}" to "https://cdn.pixabay.com/photo/2012/04/13/17/00/lcd-32872_1280.png"

            )
        )
        storylyView.setExternalData(externalData)

        storylyView.storylyListener = object : StorylyListener {

            override fun storylyEvent(storylyView: StorylyView, event: StorylyEvent,
                                      storyGroup: StoryGroup?, story: Story?,
                                      storyComponent: StoryComponent?) {


                Log.d("--------------storyly-------------------","story:${story?.seen} and ${story?.uniqueId}")
                Log.d("--------------Index-------------------","storyGroupIndex: ${storyGroup?.index} and storyIndex: ${story?.index}")

            }

        }


        binding.button2.setOnClickListener{
            val goFirstPage = Intent(applicationContext, MainActivity::class.java)
            startActivity(goFirstPage)
        }

    }
}