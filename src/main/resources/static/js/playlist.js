const params=new URLSearchParams(window.location.search);
const playlistId=params.get("id");
console.log(playlistId);

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

load();
}

async function load() {

const res = await fetch(`http://localhost:8080/musics?playlistId=${playlistId}`);
const musics = await res.json();

const list = document.getElementById("list");
list.innerHTML = "";

musics.forEach(m => {

const div = document.createElement("div");

div.innerHTML = `
            <img src="${m.coverUrl}" width="120">
            <p><b>${m.name}</b></p>
            <p>${m.artist || ""}</p>

            <button onclick="deleteMusic(${m.id})">
                Delete
            </button>

            <button onclick='editMusic(${JSON.stringify(m)})'>
                Edit
            </button>
            <hr>
        `;

list.appendChild(div);
});
}
load();

async function deleteMusic(id) {
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