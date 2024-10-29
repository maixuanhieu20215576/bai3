package com.example.bai3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentAdapter(private val context: Context) : BaseAdapter() {
    private var students = listOf<Student>()
    private var filteredStudents = listOf<Student>()

    fun setStudents(newStudents: List<Student>) {
        students = newStudents
        filteredStudents = newStudents
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        if (query.length <= 2) {
            filteredStudents = students
        } else {
            filteredStudents = students.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.studentId.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    override fun getCount(): Int = filteredStudents.size

    override fun getItem(position: Int): Student = filteredStudents[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.student_item, parent, false)

        val student = getItem(position)
        view.findViewById<TextView>(R.id.textViewName).text = student.name
        view.findViewById<TextView>(R.id.textViewId).text = student.studentId

        return view
    }
}