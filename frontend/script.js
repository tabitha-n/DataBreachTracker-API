/*
// Use a placeholder URL for development. Replace with your actual deployed API URL.
const API_BASE_URL = "https://your-api-domain.render.com";

const websiteInput = document.getElementById('websiteInput');
const searchButton = document.getElementById('searchButton');
const loadingIndicator = document.getElementById('loadingIndicator');
const resultsContainer = document.getElementById('resultsContainer');
const messageBox = document.getElementById('messageBox');

function showMessage(message, type) {
    messageBox.textContent = message;
    messageBox.classList.remove('hidden', 'bg-red-100', 'text-red-700', 'bg-green-100', 'text-green-700');
    if (type === 'error') {
        messageBox.classList.add('bg-red-100', 'text-red-700');
    } else if (type === 'success') {
        messageBox.classList.add('bg-green-100', 'text-green-700');
    }
}

searchButton.addEventListener('click', async () => {
    const website = websiteInput.value.trim();
    if (website === "") {
        showMessage("Please enter a website.", "error");
        return;
    }

    resultsContainer.innerHTML = '';
    messageBox.classList.add('hidden');
    loadingIndicator.classList.remove('hidden');

    try {
        // The API endpoint assumes you have a GET endpoint like /api/breaches?domain=website.
        const url = `${API_BASE_URL}/api/breaches?domain=${encodeURIComponent(website)}`;
        const response = await fetch(url);

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        
        loadingIndicator.classList.add('hidden');

        if (data.length === 0) {
            resultsContainer.innerHTML = `<div class="p-4 text-center text-gray-500">No breaches found for "${website}".</div>`;
        } else {
            displayResults(data);
            showMessage(`Found ${data.length} breaches.`, "success");
        }

    } catch (error) {
        loadingIndicator.classList.add('hidden');
        console.error('Error fetching data:', error);
        showMessage('An error occurred. Please check the API URL and try again.', 'error');
        resultsContainer.innerHTML = ''; // Clear any old results
    }
});

function displayResults(breaches) {
    const html = `
        <div class="result-box p-4">
            <div class="data-header px-4 py-2 font-bold text-gray-700 rounded-t-lg">Raw JSON Response:</div>
            <div class="code-block mt-2">
                ${JSON.stringify(breaches, null, 2)}
            </div>
        </div>
    `;
    resultsContainer.innerHTML = html;
}

// Example to show a friendly greeting on load
window.addEventListener('load', () => {
    showMessage("Welcome! Enter a website to get started.", "success");
});*/

