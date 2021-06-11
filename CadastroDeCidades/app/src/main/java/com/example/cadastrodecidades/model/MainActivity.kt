package com.example.desafioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.cadastrodecidades.DAO.Cidade
import com.example.cadastrodecidades.DAO.CidadeDAO
import com.example.cadastrodecidades.R
import com.example.cadastrodecidades.adapter.Cadastro
import com.example.cadastrodecidades.adapter.CidadeAdpter
import com.example.cadastrodecidades.model.FormActivity

import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val CREATE_ITEM = 1
    val UPDATE_ITEM = 2

    private lateinit var cidadeDAO: CidadeDAO
    private lateinit var cadastro: Cadastro
    private lateinit var listView: ListView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.cidadeDAO = CidadeDAO(this)
        this.cadastro = Cadastro()

        this.listView = findViewById(R.id.mainCid)
        this.listView.adapter = CidadeAdpter(cadastro, this)
        this.listView.onItemClickListener = ClickListItem()
        this.listView.onItemLongClickListener = LongClickListItem()

        val cid = this.cidadeDAO.findAll()
        (this.listView.adapter as CidadeAdpter).setList(cid)

        this.floatingActionButton = findViewById(R.id.mainCidAdd)
        this.floatingActionButton.setOnClickListener(ClickFloatingActionButton())
    }

    inner class ClickListItem: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val cid = this@MainActivity.listView.adapter.getItem(position) as Cidade
            val intent = Intent(this@MainActivity, FormActivity::class.java)
            intent.putExtra("CIDADE", cid)

            startActivityForResult(intent, UPDATE_ITEM)
        }
    }

    inner class ClickFloatingActionButton: View.OnClickListener {
        override fun onClick(v: View?) {
            val intent = Intent(this@MainActivity, FormActivity::class.java)
            startActivityForResult(intent, CREATE_ITEM)
        }
    }

    inner class LongClickListItem: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
            val cid = this@MainActivity.listView.adapter.getItem(position) as Cidade
            this@MainActivity.cidadeDAO.delete(cid.id)
            (this@MainActivity.listView.adapter as CidadeAdpter).removeItem(position)
            (this@MainActivity.listView.adapter as CidadeAdpter).notifyDataSetChanged()

            return true
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            if (requestCode == CREATE_ITEM) {
                val cid = data?.getSerializableExtra("CIDADE") as Cidade

                (this.listView.adapter as CidadeAdpter).add(cid)
                (this.listView.adapter as CidadeAdpter).notifyDataSetChanged()
                Toast.makeText(this, "Cidade criada com sucesso", Toast.LENGTH_SHORT).show()
            }

            if (requestCode == UPDATE_ITEM) {
                val cid = data?.getSerializableExtra("CIDADE") as Cidade
                val index = data?.getIntExtra("LIST_VIEW_ITEM_INDEX", 0)

                (this.listView.adapter as CidadeAdpter).updateItem(cid)
                (this.listView.adapter as CidadeAdpter).notifyDataSetChanged()
                Toast.makeText(this, "Cidade atualizada com sucesso", Toast.LENGTH_SHORT).show()
            }
        }
    }
}