// DOM
const saveBtn = document.getElementById("btn-save");
const updateBtn = document.getElementById("btn-update");
const removeBtn = document.getElementById("btn-delete");

// utils
const successRedirect = () => {
    alert("success!");
    window.location.href = "/";
};
const failureRedirect = () => {
    alert("failure!");
};

// remove
const remove = async (e) => {
    e.preventDefault();
    const id = document.getElementById("id").value;

    const response = await fetch("/api/v1/posts/" + id, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
    });
    response.status === 200 ? successRedirect() : failureRedirect();
};

// update
const update = async (e) => {
    e.preventDefault();
    const id = document.getElementById("id").value;
    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const content = document.getElementById("content").value;

    const body = {
        title,
        author,
        content,
    };

    const response = await fetch("/api/v1/posts/" + id, {
        method: "PUT",
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json",
        },
    });
    response.status === 200 ? successRedirect() : failureRedirect();
};

// save
const save = async (e) => {
    e.preventDefault();
    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const content = document.getElementById("content").value;

    const body = {
        title,
        author,
        content,
    };

    const response = await fetch("/api/v1/posts", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json",
        },
    });
    response.status === 200 ? successRedirect() : failureRedirect();
};

// main functions
const handleRemove = () => {
    removeBtn.addEventListener("click", remove);
};
const handleUpdate = () => {
    updateBtn.addEventListener("click", update);
};
const handleSave = () => {
    saveBtn.addEventListener("click", save);
};

// init
if (saveBtn) handleSave();
if (updateBtn) handleUpdate();
if (removeBtn) handleRemove();
