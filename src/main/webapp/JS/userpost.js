fetch('/data')
  .then(response => response.json())
  .then(data => {
    
  })
  .catch(error => {
    console.error('Error fetching data:', error);
  });