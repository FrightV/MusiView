async function loadPlaylists() {

    const res = await fetch("http://localhost:8080/playlists");
    const playlists = await res.json();

    const div = document.getElementById("playlists");

    div.innerHTML = "";

    playlists.forEach(p => {

        const btn = document.createElement("button");

        btn.textContent = p.name;

        btn.onclick = () => {
            window.location.href = `playlist.html?id=${p.id}`;
        };

        const editBtn = document.createElement("button");

        editBtn.textContent = "Edit";
        editBtn.onclick = async () => {
            const newName = prompt("New playlist name", p.name);
            if (!newName) return;
            await fetch(`http://localhost:8080/playlists/${p.id}`, {
                method: "PUT",
                headers: {
                    "Content-type": "application/json"
                },
                body: JSON.stringify({
                    name: newName
                })
            });
            loadPlaylists();
        };

        const deleteBtn = document.createElement("button");

        deleteBtn.textContent = "Delete";
        deleteBtn.onclick = async () => {
            await fetch(`http://localhost:8080/playlists/${p.id}`, {
                method: "DELETE"
            });
            loadPlaylists();
        };

        const card=document.createElement("div");
        card.className="playlist-card";

        card.appendChild(btn);
        card.appendChild(editBtn);
        card.appendChild(deleteBtn);

        div.appendChild(card);
    });
}
loadPlaylists();

function createPlaylist() {

    const name=document.getElementById("playlistName").value;
    fetch("http://localhost:8080/playlists", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name
        })
    })
    .then(res => res.json())
    .then(data => {
        console.log("Playlist created:",data);
        loadPlaylists();
        document.getElementById("playlistName").value="";
    })
    .catch(err => console.error(err));
}