// ================================
// M.J ACADEMY - MAIN JAVASCRIPT
// ================================


// ================================
// MOBILE MENU
// ================================

const menuBtn = document.querySelector(".menu-btn");
const navMenu = document.querySelector(".nav-menu");

menuBtn.addEventListener("click", function () {

    navMenu.classList.toggle("active");

    const icon = menuBtn.querySelector("i");

    if (navMenu.classList.contains("active")) {
        icon.classList.remove("fa-bars");
        icon.classList.add("fa-xmark");
    } else {
        icon.classList.remove("fa-xmark");
        icon.classList.add("fa-bars");
    }

});


// ================================
// CLOSE MENU AFTER CLICK
// ================================

const navLinks = document.querySelectorAll(".nav-menu a");

navLinks.forEach(function (link) {

    link.addEventListener("click", function () {

        navMenu.classList.remove("active");

        const icon = menuBtn.querySelector("i");

        icon.classList.remove("fa-xmark");
        icon.classList.add("fa-bars");

    });

});


// ================================
// SCROLL ANIMATION
// ================================

const animatedElements = document.querySelectorAll(
    ".about-card, .course-card, .gallery-item, .contact-card, .admission-box"
);

const observer = new IntersectionObserver(
    function (entries) {

        entries.forEach(function (entry) {

            if (entry.isIntersecting) {

                entry.target.classList.add("show");

                observer.unobserve(entry.target);

            }

        });

    },
    {
        threshold: 0.15
    }
);


animatedElements.forEach(function (element) {

    element.classList.add("animate");

    observer.observe(element);

});


// ================================
// ACTIVE NAVIGATION
// ================================

const sections = document.querySelectorAll("section[id]");

window.addEventListener("scroll", function () {

    let currentSection = "";

    sections.forEach(function (section) {

        const sectionTop = section.offsetTop - 150;
        const sectionHeight = section.offsetHeight;

        if (
            window.scrollY >= sectionTop &&
            window.scrollY < sectionTop + sectionHeight
        ) {
            currentSection = section.getAttribute("id");
        }

    });


    navLinks.forEach(function (link) {

        link.classList.remove("active");

        if (link.getAttribute("href") === "#" + currentSection) {

            link.classList.add("active");

        }

    });

});


// ================================
// BACK TO TOP
// ================================

window.addEventListener("scroll", function () {

    if (window.scrollY > 500) {

        document.body.classList.add("scrolled");

    } else {

        document.body.classList.remove("scrolled");

    }

});

// ================================
// DARK MODE
// ================================

const darkModeToggle = document.getElementById("darkModeToggle");

if (darkModeToggle) {

    const icon = darkModeToggle.querySelector("i");

    // Check saved dark mode
    const savedMode = localStorage.getItem("darkMode");

    if (savedMode === "enabled") {

        document.body.classList.add("dark-mode");

        icon.classList.remove("fa-moon");
        icon.classList.add("fa-sun");

    }


    // Toggle dark mode
    darkModeToggle.addEventListener("click", function () {

        document.body.classList.toggle("dark-mode");


        if (document.body.classList.contains("dark-mode")) {

            localStorage.setItem("darkMode", "enabled");

            icon.classList.remove("fa-moon");
            icon.classList.add("fa-sun");

        } else {

            localStorage.setItem("darkMode", "disabled");

            icon.classList.remove("fa-sun");
            icon.classList.add("fa-moon");

        }

    });

}

// ================================
// ADMISSION SUCCESS POPUP
// ================================

document.addEventListener("DOMContentLoaded", function () {

    const successModal = document.getElementById("successModal");
    const successCloseBtn = document.getElementById("successCloseBtn");

    if (successModal) {

        successModal.classList.add("show");

        if (successCloseBtn) {

            successCloseBtn.addEventListener("click", function () {

                successModal.classList.remove("show");

            });

        }

    }

});