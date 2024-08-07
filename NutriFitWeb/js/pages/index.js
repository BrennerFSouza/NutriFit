const savedUserId = localStorage.getItem('userId');

if(savedUserId){
    console.log('UserId encontrado no localStorage:', savedUserId);
    window.location.href = './home.html';
}


document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('loginForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Previne o envio do formulário

        const userId = document.getElementById('userId').value;
        

        // Fazendo a requisição à API
        const apiUrl = `http://100.110.133.79:8080/user/${userId}`;

        fetch(apiUrl)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                console.log('Dados recebidos da API:', data);

                // Salvando userId no localStorage
                localStorage.setItem('userId', userId);
                window.location.href = './home.html';
                // Aqui você pode manipular os dados recebidos da API
            })
            .catch(error => {
                console.error('Houve um problema com a requisição fetch:', error);
            });
    });
});
