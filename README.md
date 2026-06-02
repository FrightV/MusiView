# 🎵 MusiView

MusiView is a web application for music playlist management developed with Java, Spring Boot, and JavaScript.

The project allows users to create playlists, add songs through YouTube links, and organize their music library in a simple and intuitive way.

---

## 🚀 Features

### 📂 Playlist Management

* Create playlists
* Edit playlist names
* Delete playlists
* Navigate between playlists

### 🎵 Music Management

* Add songs through YouTube links
* Automatically retrieve:

  * song title
  * video thumbnail/cover
* Edit:

  * song name
  * artist
  * custom cover image
* Delete songs

### 🌐 YouTube API Integration

When a YouTube link is added, the system:

1. Detects the platform
2. Extracts the video ID
3. Queries the YouTube API
4. Retrieves the title and thumbnail automatically
5. Saves the song to the selected playlist

---

## 🛠 Technologies Used

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* REST API

### Frontend

* HTML5
* CSS3
* JavaScript (Fetch API)

### Database

* JPA/Hibernate
* H2 Database

### APIs

* YouTube Data API v3

---

## 📸 Screenshots

### Playlists Screen

![Playlists](assets/playlists.png)

### Songs Screen

![Musics](assets/musics.png)

---

## 🏗 Project Structure

```text
src
├── controller
│   ├── MusicController
│   └── PlaylistController
│
├── service
│   ├── MusicService
│   ├── PlaylistService
│   └── YoutubeService
│
├── repository
│   ├── MusicRepository
│   └── PlaylistRepository
│
├── model
│   ├── Music
│   └── Playlist
│
└── util
    └── LinkUtils
```

---

## 🎮 How to Use

### 1. Create a Playlist

On the home screen:

* Enter the playlist name
* Click **Create Playlist**

### 2. Open a Playlist

Click **Open** on the desired playlist.

### 3. Add a Song

Paste a YouTube link:

```text
https://www.youtube.com/watch?v=XXXXXXXXXXX
```

Click **Add**.

The system will automatically retrieve:

* Video title
* Thumbnail

### 4. Edit a Song

Click **Edit** to change:

* Name
* Artist
* Cover image URL

### 5. Delete a Song

Click **Delete**.

---

## ⚙️ Setup

### Clone the project

```bash
git clone https://github.com/your-username/musiview.git
```

### Enter the project directory

```bash
cd musiview
```

### Configure the YouTube API Key

Create the following file:

```properties
src/main/resources/essential.properties
```

For security reasons, the YouTube API key is not included in the repository.

Each user must create their own API key and configure it in the `essential.properties` file.

To create an API key:

1. Create a key in Google Cloud Console.
2. Enable the YouTube Data API v3.

Official documentation:

https://developers.google.com/youtube/v3/getting-started

Add the following content:

```properties
youtube.api.key=YOUR_API_KEY_HERE
```

### Run the application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

## 📌 Future Features

* Song ranking system
* Custom cover image upload
* Playlist statistics

---

## 👨‍💻 Project Goal

This project was developed with a focus on Full Stack learning, practicing:

* Backend development with Spring Boot
* REST APIs
* Relational databases
* External API integration
* DOM manipulation with JavaScript
* Frontend ↔ Backend communication
* Real-world project organization

```
```
* Organização de projetos reais

```
```
