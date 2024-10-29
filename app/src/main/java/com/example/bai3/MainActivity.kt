package com.example.bai3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editTextSearch: EditText
    private lateinit var listView: ListView
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextSearch = findViewById(R.id.editTextSearch)
        listView = findViewById(R.id.listView)

        // Khởi tạo adapter với danh sách sinh viên mẫu
        adapter = StudentAdapter(this)
        listView.adapter = adapter

        // Thêm danh sách sinh viên mẫu
        val sampleStudents = listOf(
            Student("Nguyễn Văn A", "20201234"),
            Student("Trần Thị B", "20205678"),
            Student("Lê Văn C", "20209012"),
            Student("Phạm Thị D", "20203456"),
            Student("Hoàng Văn E", "20207890")
        )
        adapter.setStudents(sampleStudents)

        // Xử lý sự kiện tìm kiếm
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                adapter.filter(s.toString())
            }
        })
    }
}