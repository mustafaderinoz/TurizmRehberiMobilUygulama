from flask import Flask, request, jsonify
from flask_cors import CORS
from langchain_google_genai import ChatGoogleGenerativeAI
from langchain.chains import ConversationChain
from langchain.memory import ConversationBufferMemory
import os
from dotenv import load_dotenv


load_dotenv()
api_key = os.getenv("API_KEY")


app = Flask(__name__)
CORS(app)

llm = ChatGoogleGenerativeAI(
    model="gemini-2.5-flash-lite",
    temperature=0.7,
    google_api_key=api_key
)

memory = ConversationBufferMemory(return_messages=True)
conversation = ConversationChain(llm=llm, memory=memory, verbose=True)

intro = (
    "Sen bir akıllı turizm rehberisin. "
    "Kullanıcılara Türkiye'deki şehirler, tarihi yerler, yöresel yemekler, "
    "ulaşım ve tatil önerileri hakkında yardımcı ol. "
    "Konuşmaların samimi ve açıklayıcı olsun. Eğer kullanıcı alakasız sorular sorarsa turizm rehberi" 
    "olduğunu söyle ve cevap veremeyeceğini söyle."
)
memory.chat_memory.add_user_message(intro)

@app.route("/chat", methods=["POST"])
def chat():
    data = request.json
    user_message = data.get("message", "")

    response = conversation.predict(input=user_message)
    return jsonify({"reply": response})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
