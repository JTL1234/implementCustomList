package com.Limpag.implementcustomlistview

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.Limpag.implementcustomlistview.databinding.ActivityDetailedBinding
import kotlin.random.Random

class DetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding
    private lateinit var listAdapter: ListgradeAdapter
    private lateinit var listData: ListDataGrade
    var dataArrayList = ArrayList<ListDataGrade>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val id = intent.getIntExtra("id", R.string.id1)
            val course = intent.getStringExtra("course")
            val image = intent.getIntExtra("image", R.drawable.aaliyah)
            binding.detailName.text = name
            binding.detailID.setText(id)
            binding.detailCourse.text = course
            binding.detailImage.setImageResource(image)
        }

        val subjectlist = arrayOf("HCI31","FREPM","RESCOM31","ELDNET1","NETWORK31","IMDBSYS31","IMDBSYS32","TESTQUA31","TECHNO","INTPROG")
        val gradeList = FloatArray(subjectlist.size) {
            val integerPart = Random.nextInt(1, 5)
            val decimalPart = Random.nextInt(1, 10)
            "$integerPart.$decimalPart".toFloat()
        }

        val resultList = arrayListOf<String>()

        for (grade in gradeList) {
            val result = if (grade <  3.0) "passed" else "failed"
            resultList.add(result)
        }

        for (i in subjectlist.indices) {
            listData = ListDataGrade(subjectlist[i], gradeList[i], resultList[i])
            dataArrayList.add(listData)
        }

        listAdapter = ListgradeAdapter(this@DetailedActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true
        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@DetailedActivity, DetailedActivity::class.java)
            intent.putExtra("subject", subjectlist[i])
            intent.putExtra("grades", gradeList[i])
            intent.putExtra("result", resultList[i])
            startActivity(intent)
        }

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}

