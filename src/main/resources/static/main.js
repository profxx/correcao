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
    alert("Cadastrado com sucesso!");
}

function listar(){
let lista = document.getElementById("lista");
fetch("/cursos")
    .then((response) => response.json())
    .then((jsonresponse) => lista.innerHTML = jsonresponse.map(convertCursoToLi).join(""))
}