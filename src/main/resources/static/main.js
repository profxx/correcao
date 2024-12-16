function convertCursoToLi(curso){
    return `
    <li>
        <h2>${curso.nome}</h2>
        <div class="info">
            <div class="textos">
                <h3>${curso.categoria}</h3>
                <p>${curso.carga}</p>
            </div>
            <button type="button" class="btn btn-primary">Excluir</button>
        </div>
    </li>
    `
}
function cadastrar(){

    const nome = document.getElementById("nome").value.trim();
    const categoria = document.getElementById("categoria").value.trim();
    const carga = document.getElementById("carga").value.trim();

    if (!nome || !categoria || !carga){
        alert("Todos os campos devem ser preenchidos");
        return;
    }


    fetch("/cursos", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            "nome": nome,
            "categoria": categoria,
            "horas": carga
        })
    }).then(() => {
        alert("Cadastrado com sucesso!");
        document.getElementById("nome").value = "";
        document.getElementById("carga").value = "";
        document.getElementById("categoria").value = "";
        listar();
    }
    )
}

function listar(){
let lista = document.getElementById("lista");
fetch("/cursos")
    .then((response) => response.json())
    .then((jsonresponse) => lista.innerHTML = jsonresponse.map(convertCursoToLi).join(""))
}

listar();