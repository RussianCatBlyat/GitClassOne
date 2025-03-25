const apiUrl = 'http://localhost:8081/cliente';

document.getElementById('getDataBtn').addEventListener('click', function(){
    const id = document.getElementById('id').value;

    if(id.length != 0){

    fetch(`${apiUrl}/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error(`cliente não encontrado, favor inserir um id valido.`);
            }
            return response.json();
        })
        .then(data => {
            document.getElementById('result').value = JSON.stringify(data,null,2);
            document.getElementById('nmclienteDisplay').value = data.nmcliente;
            document.getElementById('cdempresaDisplay').value = data.cdempresa;
            document.getElementById('idclienteDisplay').value = data.id;
        })
        .catch(error => {
            document.getElementById('result').value = `Erro: ${error.message}`;
        });
    }else if(id.length == 0){
    
    fetch(`${apiUrl}`)
        .then(response => {
            if(!response.ok){
                throw new Error(`Não existe nenhum cliente disponivel no momento ${response.status}`);
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
    const nmcliente = document.getElementById('nmcliente').value;
    const cdempresa = document.getElementById('cdempresa').value;

    if(nmcliente && cdempresa){
        const payload = {
            nmcliente: nmcliente,
            cdempresa: parseInt(cdempresa, 10)
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
    const id = document.getElementById('idclienteDisplayatt').value;
    const nmcliente = document.getElementById('nmclienteDisplayatt').value;
    const cdempresa = document.getElementById('cdempresaDisplayatt').value;

    if(id && nmcliente && cdempresa){
        const payload = {
            nmcliente: nmcliente,
            cdempresa: parseInt(cdempresa, 10)
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
                throw new Error(`Erro ao atualizar cliente: ${response.status}`);
            }
            return response.json(); 
        })
    }
});

document.getElementById('deleteDataBtn').addEventListener('click', function(){
    const id = document.getElementById('idclienteDisplaydel').value;

    if(id){
        if(confirm(`Tem certeza que deseja excluir o cliente com ID ${id}?`)){
            fetch(`${apiUrl}/${id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type':'application/json'
                }
            })
            .then(response => {
                if(!response.ok){
                    throw new Error(`Erro ao deletar cliente: ${response.status}`);
                }
                alert('cliente deletado com sucesso!');
            })
            .catch(error => {
                alert(`Erro: ${error.message}`);
            });
        }
    }else{
        
    }
})