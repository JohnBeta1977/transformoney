// Registrar Service Worker
if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('sw.js').then(() => {
    console.log('Service Worker registrado.');
  });
}

// Manejar instalación de la PWA
window.addEventListener('beforeinstallprompt', event => {
  event.preventDefault();
  const installPrompt = event;
  const installButton = document.createElement('button');
  installButton.textContent = 'Instalar TransforMoney';
  installButton.classList.add('install-btn');
  document.body.appendChild(installButton);

  installButton.addEventListener('click', () => {
    installPrompt.prompt();
    installPrompt.userChoice.then(choice => {
      if (choice.outcome === 'accepted') {
        console.log('PWA instalada.');
      }
      installButton.remove();
    });
  });
});
// Botón Compartir
document.getElementById('share-btn').addEventListener('click', () => {
  if (navigator.share) {
    navigator.share({
      title: 'TransforMoney',
      text: 'Convierte monedas fácilmente con TransforMoney',
      url: window.location.href,
    }).catch(console.error);
  } else {
    alert('La funcionalidad de compartir no es compatible con este navegador.');
  }
});

// Botón LinkedIn
document.getElementById('linkedin-btn').addEventListener('click', () => {
  window.open('https://www.linkedin.com', '_blank');
});

// Botón GitHub
document.getElementById('github-btn').addEventListener('click', () => {
  window.open('https://github.com', '_blank');
});