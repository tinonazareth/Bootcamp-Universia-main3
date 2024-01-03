document.addEventListener('DOMContentLoaded', function() {
    const appointmentDateInput = document.getElementById('appointmentDate');
    const appointmentTimeSelect = document.getElementById('appointmentTime');

    appointmentDateInput.addEventListener('change', function() {
        const selectedDate = new Date(this.value);
        const availableTimes = getAvailableTimes(selectedDate);
        appointmentTimeSelect.innerHTML = '';
        availableTimes.forEach(time => {
            const option = document.createElement('option');
            option.value = time;
            option.text = time;
            appointmentTimeSelect.appendChild(option);
        });
    });
});

function getAvailableTimes(date) {
    // Suponho que o estabelecimento funcione das 09:00 às 18:00
    const startHour = 9;
    const endHour = 18;
    const lunchStartHour = 12;
    const lunchEndHour = 13;

    const availableTimes = [];
    let currentHour = startHour;

    // Loop para todos os horários disponíveis
    while (currentHour < endHour) {
        // Ignora o intervalo de almoço
        if (currentHour !== lunchStartHour) {
            availableTimes.push(`${String(currentHour).padStart(2, '0')}:00`);
            availableTimes.push(`${String(currentHour).padStart(2, '0')}:30`);
        }

        currentHour++;

        // Salta a hora do almoço
        if (currentHour === lunchStartHour) {
            currentHour = lunchEndHour;
        }
    }

    return availableTimes;
}

document.addEventListener('DOMContentLoaded', function() {
    // Validação para número de telefone com DDD
    const phoneInput = document.getElementById('clientPhone');
    phoneInput.addEventListener('input', function() {
        const regex = /^\([1-9]{2}\) [2-9][0-9]{3,4}-[0-9]{4}$/;
        if (!regex.test(phoneInput.value)) {
            phoneInput.setCustomValidity('Insira um número de telefone válido com DDD.');
        } else {
            phoneInput.setCustomValidity('');
        }
    });

    // Validação para endereço de e-mail
    const emailInput = document.getElementById('clientEmail');
    emailInput.addEventListener('input', function() {
        const regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        if (!regex.test(emailInput.value)) {
            emailInput.setCustomValidity('Insira um endereço de e-mail válido.');
        } else {
            emailInput.setCustomValidity('');
        }
    });
});