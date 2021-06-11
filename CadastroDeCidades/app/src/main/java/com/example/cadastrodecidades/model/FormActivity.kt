package com.example.cadastrodecidades.model

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cadastrodecidades.DAO.Cidade
import com.example.cadastrodecidades.DAO.CidadeDAO
import com.example.cadastrodecidades.R

class FormActivity {
    private lateinit var cidadeDAO: CidadeDAO
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button
    private lateinit var nomeEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.cidadeDAO = CidadeDAO(this)

        this.nomeEditText = findViewById(R.id.formEt)
        this.saveButton = findViewById(R.id.formSaveButton)
        this.cancelButton = findViewById(R.id.formCancelButton)

        inner class SaveButtonOnClickListener : View.OnClickListener {
            override fun onClick(v: View?) {
                val cidadeNome = this@FormActivity.nomeEditText.text.toString()
                val cidade = Cidade(cidadeNome, codigo )
                val newIntent = Intent()

                if (intent.hasExtra("CIDADE") && intent.hasExtra("LIST_VIEW_ITEM_INDEX")) {
                    val intentColorId = (intent.getSerializableExtra("COR") as Cidade).id
                    newIntent.putExtra("LIST_VIEW_ITEM_INDEX", intent.getIntExtra("LIST_VIEW_ITEM_INDEX", 0))
                    cidade.id = intentColorId

                    this@FormActivity.cidadeDAO.update(cidade)
                } else {
                    val colorId = this@FormActivity.cidadeDAO.insert(cidade)
                    cidade.id = cidadeId.toInt()
                }

                newIntent.putExtra("CIDADE", cidade)

                setResult(AppCompatActivity.RESULT_OK, newIntent)
                finish()
            }
        }
    }
}
