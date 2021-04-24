package com.example.zadanie2.ui.chart

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.zadanie2.R

class ChartFragment : Fragment() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_chart, container, false)
        val webView = root.findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true

        val unencodedHtml = "<html> <head> <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script> <script type=\"text/javascript\"> google.charts.load(\"current\", { packages: [\"corechart\"] }); google.charts.setOnLoadCallback(drawChart); function drawChart() { var data = google.visualization.arrayToDataTable([ ['Name', 'Numberic value'], ['Zakażenia', 10858], ['Zgony', 539], ['Wyleczenia', 20670] ]); var options = { title: 'Dzienna liczba zakażeń, wyzdrowień i zgonów 23.04.2021', is3D: true, }; var chart = new google.visualization.PieChart(document.getElementById('piechart_3d')); chart.draw(data, options); } </script> </head> <body> <div id=\"piechart_3d\" style=\"width: 400px; height: 400px;\"></div> </body> </html>"
        val encodedHtml: String =
            Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
        webView.loadData(encodedHtml, "text/html", "base64")

        return root
    }
}