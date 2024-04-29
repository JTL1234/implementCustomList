package com.Limpag.implementcustomlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.Limpag.implementcustomlistview.R

class ListgradeAdapter(context: Context, dataArrayList: ArrayList<ListDataGrade>) :
    ArrayAdapter<ListDataGrade>(context, R.layout.list_grade, dataArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val listData = getItem(position)

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_grade, parent, false)
        }

        val listSubject = convertView!!.findViewById<TextView>(R.id.listSubject)
        val listGrade = convertView.findViewById<TextView>(R.id.listgrade)
        val listResult = convertView.findViewById<TextView>(R.id.listresult)

        listSubject.text = listData?.subject

        // Retrieve the grade value from the gradeList array using the position
        val grade = listData?.grades.toString()
        // Using ?: 0 to handle null case

        listGrade.text = grade

        // Set text color based on result
        when (listData?.result) {
            "passed" -> {
                listResult.text = listData.result
                listResult.setTextColor(context.resources.getColor(R.color.blue))
            }
            "failed" -> {
                listResult.text = listData.result
                listResult.setTextColor(context.resources.getColor(R.color.red))
            }
            else -> listResult.text = listData?.result
        }

        return convertView
    }

}
