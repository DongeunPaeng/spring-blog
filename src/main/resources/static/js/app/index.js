const saveBtn = document.getElementById("btn-save");

const successRedirect = () => {
    alert("success!");
    window.location.href = "/";
};

const failureRedirect = () => {
    alert("failure!");
};

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

    const response = await fetch("http://localhost:8080/api/v1/posts", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json",
        },
    });
    response.status === 200 ? successRedirect() : failureRedirect();
};

const handleSave = () => {
    saveBtn.addEventListener("click", save);
};

if (saveBtn) handleSave();
