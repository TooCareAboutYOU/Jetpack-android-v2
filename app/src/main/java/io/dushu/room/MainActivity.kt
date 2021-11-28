package io.dushu.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val province = arrayOf("江西", "湖南")
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner

    private var provinceindex = 0
    private val city = arrayOf(arrayOf("南昌", "赣州"), arrayOf("长沙", "湘潭"))
    private val counstryside = arrayOf(
        arrayOf(arrayOf("青山湖区", "南昌县"), arrayOf("章贡区", "赣县")),
        arrayOf(arrayOf("长沙县", "沙县"), arrayOf("湘潭县", "象限"))
    )
    private lateinit var adapter1: ArrayAdapter<String?>
    private lateinit var adapter2: ArrayAdapter<String?>
    private lateinit var adapter3: ArrayAdapter<String?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner1 = findViewById<View>(R.id.spn) as Spinner
        adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, province)
        spinner1.adapter = adapter1

        spinner2 = findViewById<View>(R.id.city) as Spinner
        adapter2 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, city[0])
        spinner2.adapter = adapter2

        spinner3 = findViewById<View>(R.id.counstryside) as Spinner
        adapter3 = ArrayAdapter(
            this, android.R.layout.simple_dropdown_item_1line,
            counstryside[0][0]
        )
        spinner3.adapter = adapter3
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?,position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "点击了：${province[position]}", Toast.LENGTH_SHORT).show()

                provinceindex = position
                adapter2 = ArrayAdapter(
                    this@MainActivity, android.R.layout.simple_dropdown_item_1line,
                    city[position]
                )
                spinner2.adapter = adapter2
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "什么也没选中", Toast.LENGTH_SHORT).show()

            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?,
                position: Int, id: Long
            ) {

                adapter3 = ArrayAdapter(
                    this@MainActivity, android.R.layout.simple_dropdown_item_1line,
                    counstryside[provinceindex][position]
                )
                //adapter3.notifyDataSetChanged();
                spinner3.adapter = adapter3
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //当时据为空的时候触发的
            }
        }

        val acBtnViewAnimator = findViewById<AppCompatButton>(R.id.acBtn_ViewAnimator)
        acBtnViewAnimator.setOnClickListener {
            ViewAnimator.animate(it).apply {
                bounce()
                textColor(R.color.colorAccent)
                backgroundColor(R.color.colorWhite)
                duration(500)
                start()
            }
        }
    }

    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

}