#  LifeCycle Anton Stansgård

Min app är ett Android-projekt skapat i språket **Kotlin**. I appen används aktivitetshantering, formulärhantering, menyer för att logga ut samt datalagring med **SharedPreferences**.  

##  Funktioner

-  **Login-sida** med hårdkodade credentials (användarnamn & lösenord).  
-  **Profilformulär** med 5 olika UI-komponenter:  
  - EditText för ålder  
  - Checkbox för körkort  
  - Radiogroup för kön  
  - EditText för e-post  
  - Spinner för land  
-  **Sparar data** lokalt via `SharedPreferences` och laddar in igen även efter appen stängts.  
-  **Meny i Toolbar** som låter användaren navigera eller logga ut.  
-  **Custom ikon** för appen (går att ersätta i `mipmap/`).  
-  Skriven med minst **50% Kotlin-kod**.

##  Tekniker

- **Språk:** Kotlin   
- **IDE:** Android Studio  
- **Min SDK-version:** 24  
- **UI-komponenter:**  
  - EditText  
  - Button  
  - CheckBox  
  - RadioGroup  
  - Spinner  
  - Toolbar  


##  Hur du använder appen

1. Starta appen → du hamnar på **LoginActivity**.  
2. Logga in med följande uppgifter:  
   - **Användarnamn:** `admin`  
   - **Lösenord:** `1234`  
3. Vid korrekt inloggning → skickas du vidare till **ProfileActivity**.  
4. Fyll i formuläret och tryck på **Spara uppgifter**.  
5. Data lagras och visas igen nästa gång du öppnar appen.  
6. Via menyn (uppe i högra hörnet) kan du:  
   - Gå till **Profil**  
   - **Logga ut** → skickas tillbaka till login-sidan  
