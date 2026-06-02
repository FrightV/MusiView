const params=new URLSearchParams(window.location.search);
const playlistId=params.get("id");
console.log(playlistId);

async function loadPlaylistInfo() {
    const res=await fetch("http://localhost:8080/playlists");
    const playlists=await res.json();
    const playlist=playlists.find(
        p => p.id == playlistId
    );
    if (!playlist) return;
    document.title=playlist.name;
    document.getElementById("playlistTitle")
        .textContent=playlist.name;
}
loadPlaylistInfo();
load();

async function add() {

const link = document.getElementById("link").value;

if (!link.trim()) {
alert("Paste a music link")
return;
}

await fetch(`http://localhost:8080/musics?playlistId=${playlistId}`, {
method: "POST",
headers: {
"Content-Type": "application/json"
},
body: JSON.stringify({ link })
});
alert("Music added!")
load();
}

async function load() {

const res = await fetch(`http://localhost:8080/musics?playlistId=${playlistId}`);
const musics = await res.json();

const list = document.getElementById("list");
list.innerHTML = "";

musics.forEach(m => {

const card = document.createElement("div");
card.className="music-card";

card.innerHTML = `
            <img src="${m.coverUrl}" width="120">
            <p><b>${m.name}</b></p>
            <p>${m.artist || ""}</p>

            <button onclick='editMusic(${JSON.stringify(m)})'>
                Edit
            </button>
            <button onclick="deleteMusic(${m.id})">
                Delete
            </button>
            <hr>
        `;

list.appendChild(card);
});
}
load();

async function deleteMusic(id) {
    if (!confirm("Delete this music?")) return;
await fetch(`http://localhost:8080/musics/${id}`,{
    method: "DELETE"
});
load();
}

async function editMusic(music) {
const newName=prompt("New name:", music.name);
if(!newName) return;

const newArtist=prompt("New artist:", music.artist || "");
const newCover=prompt("New cover URL:", music.coverUrl || "");

await fetch(`http://localhost:8080/musics/${music.id}`, {
method: "PUT",
headers: {
"Content-Type": "application/json"
},
body: JSON.stringify({
name: newName,
artist: newArtist,
coverUrl: newCover
})
});
load();
}

function goBack() {
    window.location.href = "index.html";
}