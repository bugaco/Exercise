package com.zanyzephyr.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var msgList = ArrayList<Msg>()
    lateinit var msgAdapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMsgList()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        if (!::msgAdapter.isInitialized) {
            msgAdapter = MsgAdapter(msgList)
        }
        recyclerView.adapter = msgAdapter
        sendButton.setOnClickListener(this)
    }

    private fun initMsgList() {
        val msg1 = Msg("你好 | Hello | Hola | Talofa |你好 | Hello | Hola | Talofa 你好 | " +
                "Hello | Hola | Talofa 你好 | Bonjour | Hola | Talofa 你好 | Hello | Hola | " +
                "Talofa 你好 | Hello | Hola | Talofa ", Msg.TYPE_RECEIVED)
        val msg2 = Msg("你好啊", Msg.TYPE_SENT)
        val msg3 = Msg("你叫什么名字？", Msg.TYPE_RECEIVED)
        msgList.addAll((listOf(msg1, msg2, msg3)))
    }

    override fun onClick(v: View?) {
        when (v) {
            sendButton -> {
                val content = editText.text.toString()
                if (content.isNotEmpty()) {
                    val msgSent = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msgSent)
                    msgAdapter.notifyItemInserted(msgList.size - 1)
                    recyclerView.scrollToPosition(msgList.size - 1)
                    editText.setText("")
                }
            }
        }
    }
}
