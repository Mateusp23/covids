package com.example.corona.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.corona.R
import com.example.corona.model.Covid
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private var listInfo = arrayListOf<Covid>()
    private var adapter = CovidAdapter(listInfo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readJson(this)
        rv_list.layoutManager = LinearLayoutManager(applicationContext)
        rv_list.itemAnimator = DefaultItemAnimator()
        rv_list.adapter = adapter
    }

    private fun readJson(context: Context) {
        var json: String?
        try {
            val inputStream: InputStream = context.assets.open("data.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonArray = JSONArray(json)

            for (i in 0 until jsonArray.length()) {
                var jsonObject = jsonArray.getJSONObject(i)
                val day = dateFormater(jsonObject.getString("boletim").substring(0, 10))

                var info = Covid(
                    jsonObject.getString("Suspeitos").toInt(),
                    jsonObject.getString("Confirmados").toInt(),
                    jsonObject.getString("Descartados").toInt(),
                    jsonObject.getString("Monitoramento").toInt(),
                    jsonObject.getString("Curados").toInt(),
                    jsonObject.getString("Sdomiciliar").toInt(),
                    jsonObject.getString("Shopitalar").toInt(),
                    jsonObject.getString("Chospitalar").toInt(),
                    jsonObject.getString("mortes").toInt(),
                    day,
                    jsonObject.getString("boletim").substring(11, 16)
                )
                listInfo.add(info)
            }
        } catch (e: IOException) {
            Log.e("Erro", "Não foi possivel ler o JSON")
        }
    }

    private fun dateFormater(data: String): String {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        var date = LocalDate.parse(data)
        return date.format(formatter)
    }
}