const apiUrl = 'http://localhost:8081/produto';

document.getElementById('getDataBtn').addEventListener('click', function(){
    const id = document.getElementById('id').value;

    if(id.length != 0){

    fetch(`${apiUrl}/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error(`produto não encontrado, favor inserir um id valido.`);
            }
            return response.json();
        })
        .then(data => {
            document.getElementById('result').value = JSON.stringify(data,null,2);
            document.getElementById('nmprodutoDisplay').value = data.nmproduto;
            document.getElementById('vlprodutoDisplay').value = data.vlproduto;
            document.getElementById('idprodutoDisplay').value = data.id;
        })
        .catch(error => {
            document.getElementById('result').value = `Erro: ${error.message}`;
        });
    }else if(id.length == 0){
    
    fetch(`${apiUrl}`)
        .then(response => {
            if(!response.ok){
                throw new Error(`Não existe nenhum produto disponivel no momento ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            document.getElementById('result').value = JSON.stringify(data,null,2);
        })
        .catch(error => {
            document.getElementById('result').value = `Erro: ${error.message}`;
        });
    }
});

document.getElementById('sendDataBtn').addEventListener('click', function(){
    const nmproduto = document.getElementById('nmproduto').value;
    const vlproduto = document.getElementById('vlproduto').value;

    if(nmproduto && vlproduto){
        const payload = {
            nmproduto: nmproduto,
            vlproduto: parseInt(vlproduto, 10)
        };
        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify(payload)
        })
        .then(response => {
            if(!response.ok){
                throw new Error(`Erro ao enviar dados: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            alert('Dados enviados com sucesso!');
            console.log('Resposta da API:', data);
        })
        .catch(error => {
            alert(`Erro: ${error.message}`);
        });
    }else{
        alert('Por favor, preencha todos os campos.');
    }
});

document.getElementById('updateDataBtn').addEventListener('click',function(){
    const id = document.getElementById('idprodutoDisplayatt').value;
    const nmproduto = document.getElementById('nmprodutoDisplayatt').value;
    const vlproduto = document.getElementById('vlprodutoDisplayatt').value;

    if(id && nmproduto && vlproduto){
        const payload = {
            nmproduto: nmproduto,
            vlproduto: parseInt(vlproduto, 10)
        };
        fetch(`${apiUrl}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify(payload)
        })
        .then(response => {
            if(!response.ok){
                throw new Error(`Erro ao atualizar produto: ${response.status}`);
            }
            return response.json(); 
        })
    }
});

document.getElementById('deleteDataBtn').addEventListener('click', function(){
    const id = document.getElementById('idprodutoDisplaydel').value;

    if(id){
        if(confirm(`Tem certeza que deseja excluir o produto com ID ${id}?`)){
            fetch(`${apiUrl}/${id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type':'application/json'
                }
            })
            .then(response => {
                if(!response.ok){
                    throw new Error(`Erro ao deletar produto: ${response.status}`);
                }
                alert('produto deletado com sucesso!');
            })
            .catch(error => {
                alert(`Erro: ${error.message}`);
            });
        }
    }else{
        
    }
})