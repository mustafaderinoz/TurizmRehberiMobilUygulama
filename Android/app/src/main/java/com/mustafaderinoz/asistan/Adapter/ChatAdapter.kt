package com.mustafaderinoz.asistan.Adapter

import com.mustafaderinoz.asistan.model.Message
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mustafaderinoz.asistan.R
import io.noties.markwon.Markwon

class ChatAdapter(private val messages: MutableList<Message>,
                  private val markwon: Markwon
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val USER = 1
    private val BOT = 2

    override fun getItemViewType(position: Int) =
        if (messages[position].isUser) USER else BOT

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout = if (viewType == USER) R.layout.message_user else R.layout.message_bot
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val textView = holder.itemView.findViewById<TextView>(R.id.msgText)
        val message = messages[position].text
        markwon.setMarkdown(textView, message)
    }

    override fun getItemCount() = messages.size

    fun addMessage(message: Message) {
        messages.add(message)
        notifyItemInserted(messages.size - 1)
    }
}
