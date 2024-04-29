package com.Limpag.implementcustomlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import com.Limpag.implementcustomlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = intArrayOf(
            R.drawable.aaliyah,
            R.drawable.jesuro,
            R.drawable.girl1,
            R.drawable.jayson,
            R.drawable.renee,
            R.drawable.robi,
            R.drawable.girl2,
            R.drawable.boy1,
            R.drawable.girl3,
            R.drawable.boy2,
            R.drawable.girl4,
            R.drawable.boy3,
            R.drawable.girl5,
            R.drawable.boy4,
            R.drawable.girl6,
            R.drawable.boy5,
            R.drawable.girl7,
            R.drawable.boy6,
            R.drawable.girl8,
            R.drawable.boy7
        )
        val idlist = intArrayOf(
            R.string.id1,
            R.string.id2,
            R.string.id3,
            R.string.id4,
            R.string.id5,
            R.string.id6,
            R.string.id7,
            R.string.id8,
            R.string.id9,
            R.string.id10,
            R.string.id11,
            R.string.id12,
            R.string.id13,
            R.string.id14,
            R.string.id15,
            R.string.id16,
            R.string.id17,
            R.string.id18,
            R.string.id19,
            R.string.id20

        )
        val courseList = arrayListOf("BSIT","BSIS","BSCRM","BSCS","BBA","BSECE","BSME","BSCpE","BSED","BSN","BSPsych","BSHRM","BSA","BFA",
            "BSEd", "BSCE", "BSBA", "BSBio", "BSTourism", "BSEng")

        val nameList = arrayOf("Aaliyah S. Quezon", "Jesuro T. Quezon ","Olivia E. Williams", "jayson L. Mendez", "Renee Rose R. Oyao",
            "Robiricharl M. Cabahug","Sophia N. Taylor","Benjamin J. Thompson", "Emma L. Hernandez","Lucas A. Rodriguez","Ava M. Davis",
            "Elijah D. Martinez", "Mia A. Brown", "Alexander M. Sullivan", "Isabella C. Garcia","Christopher L. Nguyen","Charlotte H. Lewis",
            "William K. Johnson","Amelia J. Clark","Samuel R. Patel")


        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                idlist[i],
                courseList[i],
                imageList[i],

            )
            dataArrayList.add(listData)
        }

        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true
        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("id", idlist[i])
            intent.putExtra("course", courseList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)
        }

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}
