# 🥗 NutriAI

> An Android nutrition tracking application with cloud backend support.

NutriAI is a mobile application developed for Android devices that helps users manage their daily nutrition by tracking meals, calories, and macronutrients. The app provides a simple yet effective way to monitor weekly eating habits and daily nutritional intake.

This project was developed as part of the **Advanced Topics in Computer Science (CN6008_1)** course.

---

## 📱 Features

- 🔐 **User Authentication** — Secure registration and login with JWT tokens
- 🍽️ **Meal Tracking** — Add meals with calories, protein, carbs, and fats
- 📅 **Weekly Diet View** — See all meals organized by day of the week
- 📊 **Daily Summary** — View total daily intake of calories and macros
- ☁️ **Cloud Sync** — All data is stored securely in the cloud
- 💾 **Session Persistence** — Stay logged in across app restarts

---

## 🛠️ Tech Stack

### Frontend
- **Java** — Core programming language
- **XML** — UI layouts
- **Android Studio** — Development environment
- **Material Design** — UI components

### Backend
- **Supabase** — Backend-as-a-Service platform
  - Authentication (JWT)
  - PostgreSQL database
  - REST API
  - Row Level Security

### Networking
- **Retrofit 2** — Type-safe HTTP client
- **OkHttp 3** — HTTP & HTTP/2 client
- **Gson** — JSON serialization/deserialization
- **Logging Interceptor** — HTTP request debugging

### Storage
- **SharedPreferences** — Local session management

---

## 🏗️ Architecture

The application follows a **three-tier architecture**:

```
┌─────────────────────────────────────────┐
│  Presentation Layer (Android UI)        │
│  Activities + XML Layouts               │
└─────────────────┬───────────────────────┘
                  │ method calls
┌─────────────────▼───────────────────────┐
│  Logic Layer                            │
│  SupabaseClient, UserSession, Config    │
└─────────────────┬───────────────────────┘
                  │ HTTPS / REST + JWT
┌─────────────────▼───────────────────────┐
│  Data Layer (Supabase Cloud)            │
│  Auth + REST API + PostgreSQL           │
└─────────────────────────────────────────┘
```

---

## 📂 Project Structure

```
NutriAI/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/.../
│   │   │   ├── LoginActivity.java
│   │   │   ├── RegisterActivity.java
│   │   │   ├── MainActivity.java
│   │   │   ├── AddMealActivity.java
│   │   │   ├── WeekDietActivity.java
│   │   │   ├── DailySummaryActivity.java
│   │   │   ├── SupabaseClient.java
│   │   │   ├── SupabaseConfig.java
│   │   │   └── UserSession.java
│   │   ├── res/layout/
│   │   │   ├── activity_login.xml
│   │   │   ├── activity_register.xml
│   │   │   ├── activity_main.xml
│   │   │   ├── activity_add_meal.xml
│   │   │   ├── activity_week_diet.xml
│   │   │   └── activity_daily_summary.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
└── README.md
```

---

## 🗄️ Database Schema

The app uses two main tables in Supabase (PostgreSQL):

### `profiles`
| Column | Type | Description |
|--------|------|-------------|
| id | UUID | Primary key (linked to auth.users) |
| full_name | TEXT | User's full name |
| email | TEXT | User's email |
| created_at | TIMESTAMPTZ | Account creation date |

### `meals`
| Column | Type | Description |
|--------|------|-------------|
| id | INT8 | Primary key |
| user_id | UUID | Foreign key → profiles.id |
| meal_name | TEXT | Name of the meal |
| calories | INT4 | Calories (kcal) |
| protein | FLOAT8 | Protein (g) |
| carbs | FLOAT8 | Carbohydrates (g) |
| fats | FLOAT8 | Fats (g) |
| day | TEXT | Day of the week |
| meal_type | TEXT | Breakfast / Lunch / Dinner / Snack |
| created_at | TIMESTAMPTZ | Record creation date |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest version recommended)
- Android SDK 24+
- A Supabase account ([supabase.com](https://supabase.com))

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/climSy69/NutriAI.git
   ```

2. Open the project in Android Studio

3. Configure your Supabase credentials in `SupabaseConfig.java`:
   ```java
   public static final String SUPABASE_URL = "your-supabase-url";
   public static final String SUPABASE_API_KEY = "your-api-key";
   ```

4. Sync Gradle and build the project

5. Run the app on an emulator or physical device

---

## 🧪 Testing

The application has been tested across the following scenarios:

- ✅ User registration with valid/invalid input
- ✅ Login with correct/incorrect credentials
- ✅ Meal addition with all required fields
- ✅ Form validation for empty fields
- ✅ Weekly diet view rendering
- ✅ Daily summary calculations
- ✅ Logout functionality
- ✅ Session persistence after app restart

---

## 🔮 Future Improvements

This project is currently at **80% completion**. Planned features for future versions include:

- 🤖 **AI Nutrition Assistant** (Google Gemini integration)
- ✏️ Edit and delete existing meals
- 📈 Progress charts for calories and macros
- ⏰ Meal reminders and notifications
- 🎯 Daily calorie goals
- 📷 Barcode scanner for food products
- 🏪 Google Play Store deployment

---

## 👨‍💻 Author

**Student ID:** 2678458  
**Course:** Advanced Topics in Computer Science (CN6008_1)  
**Academic Year:** 2025-2026  
**Supervisor:** Panagiotis Kosmidis  

GitHub: [@climSy69](https://github.com/climSy69)

---

## 📄 License

This project was developed for academic purposes as part of a university coursework assignment.

---

*Built with ☕ Java, 📱 Android Studio, and ☁️ Supabase*
