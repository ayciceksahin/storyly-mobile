package com.uiapp

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uiapp.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import com.appsamurai.storyly.*
import android.util.Log
import android.view.View
import com.appsamurai.storyly.analytics.StorylyEvent
import com.appsamurai.storyly.exoplayer2.hls.playlist.HlsMediaPlaylist
import com.appsamurai.storyly.styling.StoryGroupListStyling
import java.util.*


class MainActivity : AppCompatActivity() {
    companion object {
        const val segmentData = "french"
        const val customData = "1"
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val lang = Locale.getDefault().getLanguage()
        Log.d("<<<<<<<Lang>>>>>>>","Lang: {$lang}")
        binding = ActivityMainBinding.inflate(layoutInflater)
        val firstPage = binding.root
        setContentView(firstPage)
        val padVal_1 = 1000f
        val padVal_2 = 100000000f
        val storylyView = findViewById<StorylyView>(R.id.storyly_view)
        storylyView.setStoryGroupIconBackgroundColor(color = android.graphics.Color.parseColor("#FF0000"))
        storylyView.storylyInit = StorylyInit(
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NfaWQiOjgyNTMsImFwcF9pZCI6MTMyMjcsImluc19pZCI6MTQzODZ9._CeIetiqIj_P46K_SzxditVkoRAAVtdBsRxNZ_qJW4E"
        )
        Log.d("Init", "Init ${storylyView.storylyInit}")
        //storylyView.visibility = View.GONE
        //storylyView.setStoryInteractiveTextTypeface(Typeface.MONOSPACE)
        storylyView.setStoryGroupSize(StoryGroupSize.Small)

        //storylyView.setStoryGroupIconBackgroundColor(color = android.graphics.Color.parseColor("#FF0000"))

        //storylyView.setStoryItemTextTypeface(Typeface.MONOSPACE)
        //storylyView.openStory("62376", "542324")

        /*storylyView.setStoryGroupListStyling(
            StoryGroupListStyling(
                padVal_1,
                padVal_2
            )
        )*/

        binding.button.setOnClickListener{
            val goSecondPage = Intent(applicationContext, MainActivity2::class.java)
            startActivity(goSecondPage)
            //storylyView.openStory("51351", "444704") // --------Open Story--------
        }



        storylyView.storylyListener = object : StorylyListener {
            var initialLoad = true

            override fun storylyActionClicked(storylyView: StorylyView, story: Story) {

                story.media.actionUrl.let { url ->
                    Log.d("-----------[storyly]--------", "IntegrationActivity:storylyActionClicked - forwarding to url {$url} and ${story.media.type} ")
                    startActivity(
                        Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse("$url")
                        }
                    )
                }

                /*val goSecondPage = Intent(applicationContext, MainActivity2::class.java)
                startActivity(goSecondPage) */ // go to other page

                /* val fragment = DemoFragment()
                 fragment.onCloseClick = {
                     removeFragments()
                 }
                 showExternalFragment(fragment) */
            }

            override fun storylyLoaded(
                storylyView: StorylyView,
                storyGroupList: List<StoryGroup>,
                dataSource: StorylyDataSource
            ) {
                //Log.d("[storyly]", "IntegrationActivity:storylyLoaded - storyGroupList size {${storyGroupList.size}} - source {$dataSource}")

                /*if (initialLoad && storyGroupList.isNotEmpty()) {
                    initialLoad = false
                    storylyView.visibility = View.VISIBLE
                    Log.d("customParameter", "-----> {${customData}}" )
                }*/

                if (dataSource == StorylyDataSource.Local) {
                    Log.d("[Local]", "IntegrationActivity:storylyLoaded - storyGroupList size {${storyGroupList.size}} - source {$dataSource}")
                }

                /*if (dataSource == StorylyDataSource.API) {
                    storylyView.openStory("62376", "542324")
                }*/
            }

            override fun storylyLoadFailed(
                storylyView: StorylyView,
                errorMessage: String
            ) {
                Log.d("[storyly]", "IntegrationActivity:storylyLoadFailed - error {$errorMessage}")

            }

            override fun storylyUserInteracted(
                storylyView: StorylyView,
                storyGroup: StoryGroup,
                story: Story,
                storyComponent: StoryComponent
            ) {
                Log.d("--------------storyly-------------------", "StoryComponent{${storyComponent}} and {${story}}")
            }

            override fun storylyEvent(storylyView: StorylyView, event: StorylyEvent,
                                      storyGroup: StoryGroup?, story: Story?,
                                      storyComponent: StoryComponent?) {

                Log.d("Storyly","StoryEvent:${storyComponent?.type} ")
                Log.d("event----->","StoryViewed:${StorylyEvent.StoryViewed} ") // You can track StoryViewed event.





                Log.d("--------------storyly-------------------","story:${story?.seen} and ${story?.uniqueId}")
                Log.d("--------------Index-------------------","storyGroupIndex: ${storyGroup?.index} and storyIndex: ${story?.index}")

            }

        }

        //binding.storylyView.storylyListener = storylyListener

    }



    fun showExternalFragment(fragment : Fragment) {
        binding.storylyView.showExternalFragment(fragment)
    }

    fun removeFragments() {
        binding.storylyView.dismissAllExternalFragment()
    }
}