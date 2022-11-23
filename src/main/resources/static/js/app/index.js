console.log("this file has been opened!");
const saveBtn = document.getElementById("btn-save");

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

    const response = await fetch("http://localhost:8080/api/posts", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json",
        },
    });
    response.status === 200 ? alert("done!") : alert("wrong!");
};

const handleSave = () => {
    saveBtn.addEventListener("click", save);
};

handleSave();
