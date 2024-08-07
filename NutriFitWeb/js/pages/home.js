const savedUserId = localStorage.getItem('userId');

if (!savedUserId) {
    window.location.href = './index.html';
}

const userId = savedUserId;
let currentDate = new Date(); // Usamos um let para permitir a atualização da data

const dataElement = document.getElementById('data');
const mealsContainer = document.getElementById('meals');

function formatDate(date) {
    return date.toISOString().split('T')[0];
}

function updateDateDisplay(date) {
    dataElement.textContent = formatDate(date);
}

function fetchAndDisplayMeals(userId, date) {
    const apiUrl = 'http://100.110.133.79:8080/meal/listallusermeals';

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            userId: userId,
            date: formatDate(date)
        })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        console.log('Dados recebidos da API:', data);
        mealsContainer.innerHTML = '';

        data.forEach(item => {
            const detailUrl = `http://100.110.133.79:8080/meal/${item.id}/detail`;

            fetch(detailUrl, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(detailResponse => {
                if (!detailResponse.ok) {
                    throw new Error('Network response was not ok ' + detailResponse.statusText);
                }
                return detailResponse.json();
            })
            .then(detailData => {
                console.log(`Detalhes para o ID ${item.id}:`, detailData);
                displayMealDetails(detailData);
            })
            .catch(detailError => {
                console.error(`Houve um problema com a requisição fetch para detalhes do ID ${item.id}:`, detailError);
            });
        });
    })
    .catch(error => {
        console.error('Houve um problema com a requisição fetch:', error);
    });
}

function displayMealDetails(meal) {
    const mealDiv = document.createElement('div');
    mealDiv.classList.add('meal');

    const mealInfo = `
        <h3>${meal.mealName}</h3>
        <p>ID: ${meal.mealId}</p>
        <p>Data e Hora: ${meal.dateTime}</p>
        <p>ID do Usuário: ${meal.userId}</p>
        <h4>Alimentos:</h4>
    `;

    mealDiv.innerHTML = mealInfo;

    const foodsList = document.createElement('ul');
    meal.foods.forEach(food => {
        const foodItem = document.createElement('li');
        foodItem.innerHTML = `
            <p>Nome: ${food.foodName}</p>
            <p>Gramas: ${food.grams}</p>
            <p>Carboidratos: ${food.carbos}</p>
            <p>Proteínas: ${food.Proteins}</p>
            <p>Gorduras: ${food.fats}</p>
            <p>Fibras: ${food.fibers}</p>
            <p>Medição em Gramas: ${food.measureInGrams}</p>
            
        `;
        foodsList.appendChild(foodItem);
    });

    mealDiv.appendChild(foodsList);
    mealsContainer.appendChild(mealDiv);
}

function changeDate(days) {
    currentDate.setDate(currentDate.getDate() + days);
    updateDateDisplay(currentDate);
    fetchAndDisplayMeals(userId, currentDate);
}

document.getElementById('previousDay').addEventListener('click', () => changeDate(-1));
document.getElementById('nextDay').addEventListener('click', () => changeDate(1));

document.addEventListener('DOMContentLoaded', function() {
    updateDateDisplay(currentDate);
    fetchAndDisplayMeals(userId, currentDate);

    const logoutButton = document.getElementById('logout');
    logoutButton.addEventListener('click', function() {
        localStorage.removeItem('userId');
        window.location.href = './home.html';
        console.log('Cache limpo e redirecionado para home.html');
    });
});
