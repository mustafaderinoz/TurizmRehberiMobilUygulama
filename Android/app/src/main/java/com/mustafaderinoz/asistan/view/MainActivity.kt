package com.mustafaderinoz.asistan.view
import com.mustafaderinoz.asistan.Adapter.ChatAdapter
import ChatRequest
import ChatResponse
import com.mustafaderinoz.asistan.model.Message
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mustafaderinoz.asistan.Services.RetrofitClient
import com.mustafaderinoz.asistan.databinding.ActivityMainBinding
import io.noties.markwon.Markwon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ChatAdapter
    private val messages = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val markwon = Markwon.create(this)

        adapter = ChatAdapter(messages, markwon)
        binding.chatRecyclerView.adapter = adapter
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(this)


        binding.btnSend.setOnClickListener {
            val msg = binding.inputMessage.text.toString()
            if (msg.isNotEmpty()) {

                adapter.addMessage(Message(msg, true))
                binding.inputMessage.text.clear()

                RetrofitClient.apiService.sendMessage(ChatRequest(msg))
                    .enqueue(object : Callback<ChatResponse> {
                        override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                            response.body()?.let {
                                adapter.addMessage(Message(it.reply, false))
                                binding.chatRecyclerView.scrollToPosition(messages.size - 1)
                            }
                        }

                        override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                            adapter.addMessage(Message("Hata: ${t.message}", false))
                        }
                    })
            }
        }
    }
}
