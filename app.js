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