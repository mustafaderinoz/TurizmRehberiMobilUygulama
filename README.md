# ✈️🌍🗺️ Akıllı Turizm Rehberi Mobil Uygulaması

Akıllı Turizm Rehberi, Türkiye'deki şehirler, tarihi yerler, yöresel yemekler ve tatil önerileri hakkında kullanıcıya interaktif ve samimi bilgi sağlayan bir mobil uygulamadır. Uygulamanın arka planında **Python / Flask** tabanlı bir backend çalışmakta olup, kullanıcı mesajları **Google Gemini 2.5 Flash Lite** modeli üzerinden yapay zekâ tarafından yanıtlanmaktadır. Ayrıca, uygulama **LangChain** ile hafıza yönetimi yaparak, kullanıcıyla yapılan önceki konuşmaları hatırlayabilir ve sohbeti daha doğal ve bağlamlı hâle getirir.

---

## 🚀 Özellikler

- 👤 Kullanıcı ve bot arasında gerçek zamanlı sohbet
- 💬 Sohbet geçmişini hatırlayan yapay zeka
- 🤖 Gemini 2.5 Flash lite modeli ile yanıt üretme
- 🧠 LangChain ConversationBufferMemory kullanımı
- 🔗 Retrofit kullanılarak Flask tabanlı backend ile iletişim
- 📄 Markdown desteği ile mesajları zengin biçimde gösterme

---
## 🛠 Kullanılan Teknolojiler
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=flat&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white)
![Flask](https://img.shields.io/badge/Flask-000000?style=flat&logo=flask&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=flat&logo=python&logoColor=white)
![Retrofit](https://img.shields.io/badge/Retrofit-007AFF?style=flat&logo=retrofit&logoColor=white)
![LangChain](https://img.shields.io/badge/LangChain-FF6F61?style=flat&logo=ghost&logoColor=white)
![Google Gemini](https://img.shields.io/badge/Google%20Gemini-4285F4?style=flat&logo=google&logoColor=white)

---

## 📦 Proje Yapısı
```
📦 Backend
│
├── venv/                    # Sanal ortam 
├── .env                     # API anahtarı 
└── turizm_rehberi.py      # Uygulama dosyası
```
```
📦 Android
│
├── Adapter/
│ └── ChatAdapter.kt
├── model/
│ └── Message.kt
├── Services/
│ ├── ApiService.kt
│ └── RetrofitClient.kt
└── view/
└── MainActivity.kt
```
## 🛠️ Gerekli Kurulumlar

### 1️⃣ Sanal Ortam Oluşturma

Proje klasörünüzü açtıktan sonra aşağıdaki komutları sırayla çalıştırın:
```bash
python -m venv venv
```

### 2️⃣ Sanal Ortamı Aktif Etme 

```bash
Windows için:
.\venv\Scripts\activate
```
```bash
Mac / Linux için:
source venv/bin/activate
```
### 3️⃣ Gerekli Kütüphanelerin Kurulumu
```bash
pip install google-generativeai langchain langchain-google-genai python-dotenv flask flask-cors
```
### 🔑 API Anahtarı Ekleme

Proje klasörüne .env adında bir dosya oluşturun ve içine aşağıdaki satırı ekleyin:
```bash
API_KEY="YOUR_API_KEY"
```
### ▶️ Uygulamayı Çalıştırma
```bash
python turizm_rehberi.py
```
---

## 📱 Ekran Görüntüleri

| Chatbot Ekranı | Ana Sayfa        | 
|----------------------|------------------|
| ![Login](screenshots/chatbot.png) | ![Feed](screenshots/chatbot2.png) |





---

