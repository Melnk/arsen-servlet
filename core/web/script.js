// Навигационное меню
const menuToggle = document.getElementById('menuToggle');
const mainNav = document.getElementById('mainNav');
const overlay = document.getElementById('overlay');
const closeBtn = document.querySelector('.close-btn');

// Функция открытия меню
function openMenu() {
    mainNav.classList.add('active');
    overlay.classList.add('active');
    document.body.style.overflow = 'hidden';
}

// Функция закрытия меню
function closeMenu() {
    mainNav.classList.remove('active');
    overlay.classList.remove('active');
    document.body.style.overflow = '';
}

// Обработчики событий для меню
if (menuToggle) {
    menuToggle.addEventListener('click', openMenu);
}

if (closeBtn) {
    closeBtn.addEventListener('click', closeMenu);
}

if (overlay) {
    overlay.addEventListener('click', closeMenu);
}

// Закрытие по ESC
document.addEventListener('keydown', (e) => {
    if (e.key === 'Escape') {
        closeMenu();
    }
});

// Функционал багажника
const trunkButton = document.getElementById('trunk-button');
const trunkImage = document.getElementById('trunk-image');

if (trunkButton && trunkImage) {
    function toggleTrunk() {
        if (trunkImage.src.includes('images/trunk_closed.jpg') || trunkImage.src.includes('images/trunk_closed.jpg')) {
            trunkImage.src = 'images/trunk_open.jpg';
            trunkImage.alt = 'Открытый багажник';
            trunkButton.textContent = 'Закрыть багажник!';
        } else {
            trunkImage.src = 'images/trunk_closed.jpg';
            trunkImage.alt = 'Закрытый багажник';
            trunkButton.textContent = 'Открыть багажник!';
        }
    }

    trunkButton.addEventListener('click', toggleTrunk);
}

// Обработка формы обратной связи
const contactForm = document.getElementById('contact-form');

if (contactForm) {
    contactForm.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const name = document.getElementById('name-input').value;
        const email = document.getElementById('email-input').value;
        const message = document.querySelector('textarea').value;
        const isFan = document.querySelector('input[name="is-fan"]').checked;
        
        if (name && email && message) {
            alert(`Спасибо, ${name}! Ваше сообщение отправлено.${isFan ? ' Рады, что вы фанат Арсена!' : ''}`);
            contactForm.reset();
        } else {
            alert('Пожалуйста, заполните все обязательные поля.');
        }
    });
}

// Добавляем класс для плавного появления контента
document.addEventListener('DOMContentLoaded', function() {
    document.body.classList.add('loaded');
});

const themeToggle = document.getElementById('theme-toggle');

if (themeToggle) {
  themeToggle.addEventListener('click', () => {
    document.body.classList.toggle('dark');

    // сохраняем выбор в localStorage, чтобы после перезагрузки помнить
    if (document.body.classList.contains('dark')) {
      localStorage.setItem('theme', 'dark');
    } else {
      localStorage.setItem('theme', 'light');
    }
  });

  // при загрузке страницы читаем сохранённое
  const savedTheme = localStorage.getItem('theme');
  if (savedTheme === 'dark') {
    document.body.classList.add('dark');
  }
}
