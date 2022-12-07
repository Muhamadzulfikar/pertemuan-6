package com.kln.image_glider_muhamadzulfikar

import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.kln.image_glider_muhamadzulfikar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ImageAdapter
    private val ListGambar = ArrayList<ImageData>()
    private lateinit var dots: ArrayList<TextView>
    private val slideHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ListGambar.add(
            ImageData(
                imgUrl = "https://th.bing.com/th/id/R.f17e6f448456aedd3f80198ec84ba38a?rik=5r8jwluEMoWehA&riu=http%3a%2f%2fww2.kqed.org%2fpop%2fwp-content%2fuploads%2fsites%2f12%2f2013%2f04%2fRogerEbert2.jpg&ehk=iDfX%2fwC%2b7NnflSJGWTsoaiKX7c44tknWSVfu5YTQ6LM%3d&risl=&pid=ImgRaw&r=0"
            )
        )
        ListGambar.add(
            ImageData(
                imgUrl = "https://th.bing.com/th/id/R.f17e6f448456aedd3f80198ec84ba38a?rik=5r8jwluEMoWehA&riu=http%3a%2f%2fww2.kqed.org%2fpop%2fwp-content%2fuploads%2fsites%2f12%2f2013%2f04%2fRogerEbert2.jpg&ehk=iDfX%2fwC%2b7NnflSJGWTsoaiKX7c44tknWSVfu5YTQ6LM%3d&risl=&pid=ImgRaw&r=0"
            )
        )
        ListGambar.add(
            ImageData(
                imgUrl = "https://th.bing.com/th/id/R.f17e6f448456aedd3f80198ec84ba38a?rik=5r8jwluEMoWehA&riu=http%3a%2f%2fww2.kqed.org%2fpop%2fwp-content%2fuploads%2fsites%2f12%2f2013%2f04%2fRogerEbert2.jpg&ehk=iDfX%2fwC%2b7NnflSJGWTsoaiKX7c44tknWSVfu5YTQ6LM%3d&risl=&pid=ImgRaw&r=0"
            )
        )
        ListGambar.add(
            ImageData(
                imgUrl = "https://th.bing.com/th/id/R.f17e6f448456aedd3f80198ec84ba38a?rik=5r8jwluEMoWehA&riu=http%3a%2f%2fww2.kqed.org%2fpop%2fwp-content%2fuploads%2fsites%2f12%2f2013%2f04%2fRogerEbert2.jpg&ehk=iDfX%2fwC%2b7NnflSJGWTsoaiKX7c44tknWSVfu5YTQ6LM%3d&risl=&pid=ImgRaw&r=0"
            )
        )
        ListGambar.add(
            ImageData(
                imgUrl = "https://th.bing.com/th/id/R.f17e6f448456aedd3f80198ec84ba38a?rik=5r8jwluEMoWehA&riu=http%3a%2f%2fww2.kqed.org%2fpop%2fwp-content%2fuploads%2fsites%2f12%2f2013%2f04%2fRogerEbert2.jpg&ehk=iDfX%2fwC%2b7NnflSJGWTsoaiKX7c44tknWSVfu5YTQ6LM%3d&risl=&pid=ImgRaw&r=0"
            )
        )

        adapter = ImageAdapter(ListGambar)
        binding.vpGambar.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.vpGambar.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectDot(position)
                super.onPageSelected(position)

                slideHandler.removeCallbacks(slideRun)
                slideHandler.postDelayed(slideRun, 3000)
            }
        })
    }

    private val slideRun = Runnable {
        binding.vpGambar.currentItem = binding.vpGambar.currentItem + 1
    }


    private fun selectDot(position: Int) {
        for (i in 0 until ListGambar.size) {
            if (i == position) {
                dots[i].setTextColor(
                    ContextCompat.getColor(
                        this, com.google.android.material.R.color.design_default_color_on_primary
                    )
                )

            } else {
                dots[i].setTextColor(
                    ContextCompat.getColor(
                        this, com.google.android.material.R.color.design_default_color_on_secondary
                    )
                )
            }
        }
    }

    private fun setIndicator() {
        for (i in 0 until ListGambar.size) {
            dots.add(TextView(this))

            dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()

            dots[i].textSize = 18f

            binding.dotsIndicator.addView(dots[i])
        }
    }
}