/**
* Template Name: NiceAdmin
* Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
* Updated: Apr 20 2024 with Bootstrap v5.3.3
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/

(function() {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim()
    if (all) {
      return [...document.querySelectorAll(el)]
    } else {
      return document.querySelector(el)
    }
  }

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    if (all) {
      select(el, all).forEach(e => e.addEventListener(type, listener))
    } else {
      select(el, all).addEventListener(type, listener)
    }
  }

  /**
   * Easy on scroll event listener 
   */
  const onscroll = (el, listener) => {
    el.addEventListener('scroll', listener)
  }

  /**
   * Sidebar toggle
   */
  if (select('.toggle-sidebar-btn')) {
    on('click', '.toggle-sidebar-btn', function(e) {
      select('body').classList.toggle('toggle-sidebar')
    })
  }

  /**
   * Search bar toggle
   */
  if (select('.search-bar-toggle')) {
    on('click', '.search-bar-toggle', function(e) {
      select('.search-bar').classList.toggle('search-bar-show')
    })
  }

  /**
   * Navbar links active state on scroll
   */
  let navbarlinks = select('#navbar .scrollto', true)
  const navbarlinksActive = () => {
    let position = window.scrollY + 200
    navbarlinks.forEach(navbarlink => {
      if (!navbarlink.hash) return
      let section = select(navbarlink.hash)
      if (!section) return
      if (position >= section.offsetTop && position <= (section.offsetTop + section.offsetHeight)) {
        navbarlink.classList.add('active')
      } else {
        navbarlink.classList.remove('active')
      }
    })
  }
  window.addEventListener('load', navbarlinksActive)
  onscroll(document, navbarlinksActive)

  /**
   * Toggle .header-scrolled class to #header when page is scrolled
   */
  let selectHeader = select('#header')
  if (selectHeader) {
    const headerScrolled = () => {
      if (window.scrollY > 100) {
        selectHeader.classList.add('header-scrolled')
      } else {
        selectHeader.classList.remove('header-scrolled')
      }
    }
    window.addEventListener('load', headerScrolled)
    onscroll(document, headerScrolled)
  }

  /**
   * Back to top button
   */
  let backtotop = select('.back-to-top')
  if (backtotop) {
    const toggleBacktotop = () => {
      if (window.scrollY > 100) {
        backtotop.classList.add('active')
      } else {
        backtotop.classList.remove('active')
      }
    }
    window.addEventListener('load', toggleBacktotop)
    onscroll(document, toggleBacktotop)
  }

  /**
   * Initiate tooltips
   */
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
  })

  /**
   * Initiate quill editors
   */
  if (select('.quill-editor-default')) {
    new Quill('.quill-editor-default', {
      theme: 'snow'
    });
  }

  if (select('.quill-editor-bubble')) {
    new Quill('.quill-editor-bubble', {
      theme: 'bubble'
    });
  }

  if (select('.quill-editor-full')) {
    new Quill(".quill-editor-full", {
      modules: {
        toolbar: [
          [{
            font: []
          }, {
            size: []
          }],
          ["bold", "italic", "underline", "strike"],
          [{
              color: []
            },
            {
              background: []
            }
          ],
          [{
              script: "super"
            },
            {
              script: "sub"
            }
          ],
          [{
              list: "ordered"
            },
            {
              list: "bullet"
            },
            {
              indent: "-1"
            },
            {
              indent: "+1"
            }
          ],
          ["direction", {
            align: []
          }],
          ["link", "image", "video"],
          ["clean"]
        ]
      },
      theme: "snow"
    });
  }

  /**
   * Initiate TinyMCE Editor
   */

  const useDarkMode = window.matchMedia('(prefers-color-scheme: dark)').matches;
  const isSmallScreen = window.matchMedia('(max-width: 1023.5px)').matches;

  tinymce.init({
    selector: 'textarea.tinymce-editor',
    plugins: 'preview importcss searchreplace autolink autosave save directionality code visualblocks visualchars fullscreen image link media codesample table charmap pagebreak nonbreaking anchor insertdatetime advlist lists wordcount help charmap quickbars emoticons accordion',
    editimage_cors_hosts: ['picsum.photos'],
    menubar: 'file edit view insert format tools table help',
    toolbar: "undo redo | accordion accordionremove | blocks fontfamily fontsize | bold italic underline strikethrough | align numlist bullist | link image | table media | lineheight outdent indent| forecolor backcolor removeformat | charmap emoticons | code fullscreen preview | save print | pagebreak anchor codesample | ltr rtl",
    autosave_ask_before_unload: true,
    autosave_interval: '30s',
    autosave_prefix: '{path}{query}-{id}-',
    autosave_restore_when_empty: false,
    autosave_retention: '2m',
    image_advtab: true,
    link_list: [{
        title: 'My page 1',
        value: 'https://www.tiny.cloud'
      },
      {
        title: 'My page 2',
        value: 'http://www.moxiecode.com'
      }
    ],
    image_list: [{
        title: 'My page 1',
        value: 'https://www.tiny.cloud'
      },
      {
        title: 'My page 2',
        value: 'http://www.moxiecode.com'
      }
    ],
    image_class_list: [{
        title: 'None',
        value: ''
      },
      {
        title: 'Some class',
        value: 'class-name'
      }
    ],
    importcss_append: true,
    file_picker_callback: (callback, value, meta) => {
      /* Provide file and text for the link dialog */
      if (meta.filetype === 'file') {
        callback('https://www.google.com/logos/google.jpg', {
          text: 'My text'
        });
      }

      /* Provide image and alt text for the image dialog */
      if (meta.filetype === 'image') {
        callback('https://www.google.com/logos/google.jpg', {
          alt: 'My alt text'
        });
      }

      /* Provide alternative source and posted for the media dialog */
      if (meta.filetype === 'media') {
        callback('movie.mp4', {
          source2: 'alt.ogg',
          poster: 'https://www.google.com/logos/google.jpg'
        });
      }
    },
    height: 600,
    image_caption: true,
    quickbars_selection_toolbar: 'bold italic | quicklink h2 h3 blockquote quickimage quicktable',
    noneditable_class: 'mceNonEditable',
    toolbar_mode: 'sliding',
    contextmenu: 'link image table',
    skin: useDarkMode ? 'oxide-dark' : 'oxide',
    content_css: useDarkMode ? 'dark' : 'default',
    content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:16px }'
  });

  /**
   * Initiate Bootstrap validation check
   */
  var needsValidation = document.querySelectorAll('.needs-validation')

  Array.prototype.slice.call(needsValidation)
    .forEach(function(form) {
      form.addEventListener('submit', function(event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })

  /**
   * Initiate Datatables
   */
  const datatables = select('.datatable', true)
  datatables.forEach(datatable => {
    new simpleDatatables.DataTable(datatable, {
      perPageSelect: [5, 10, 15, ["All", -1]],
      columns: [{
          select: 2,
          sortSequence: ["desc", "asc"]
        },
        {
          select: 3,
          sortSequence: ["desc"]
        },
        {
          select: 4,
          cellClass: "green",
          headerClass: "red"
        }
      ]
    });
  })

  /**
   * Autoresize echart charts
   */
  const mainContainer = select('#main');
  if (mainContainer) {
    setTimeout(() => {
      new ResizeObserver(function() {
        select('.echart', true).forEach(getEchart => {
          echarts.getInstanceByDom(getEchart).resize();
        })
      }).observe(mainContainer);
    }, 200);
  }

})();

/**
   * Pengaturan Status
   */
document.addEventListener("DOMContentLoaded", () => {
  const statusIndicator = document.getElementById("status-indicator"); // Elemen indikator status
  const statusText = document.getElementById("status-text"); // Elemen teks status

  fetch("/status")
    .then((response) => response.json())
    .then((data) => {
      if (data.isLoggedIn) {
        statusIndicator.style.backgroundColor = "green";
        statusText.textContent = data.statusText; // Tampilkan "Aktif"
      } else {
        statusIndicator.style.backgroundColor = "red";
        statusText.textContent = data.statusText; // Tampilkan "Tidak Aktif"
      }
    })
    .catch((error) => {
      console.error("Error fetching status:", error);
    });
});

/**
   * Pengaturan Form input
   */
document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("myForm");
  const inputs = document.querySelectorAll("input, textarea");
  const errorMessages = document.querySelectorAll(".error-message");

  form.addEventListener("submit", function (e) {
    e.preventDefault(); // Mencegah form dikirim

    let isValid = true; // Status validasi
    inputs.forEach((input, index) => {
      const errorMessage = input.nextElementSibling; // Menemukan elemen .error-message di bawah input

      if (input.value.trim() === "") {
        input.classList.add("is-invalid"); // Tambahkan kelas untuk border merah
        if (errorMessage) {
          errorMessage.style.display = "block"; // Tampilkan pesan error
        }
        isValid = false;
      } else {
        input.classList.remove("is-invalid");
        if (errorMessage) {
          errorMessage.style.display = "none";
        }
      }
    });

    // Jika form valid, Anda bisa melakukan tindakan seperti mengirimkan form
    if (isValid) {
      alert("Form berhasil dikirim!");
      // form.submit(); // Uncomment untuk mengirim form
    }
  });

  // Hilangkan border merah dan pesan error saat pengguna mengetik
  inputs.forEach((input) => {
    input.addEventListener("input", () => {
      if (input.value.trim() !== "") {
        input.classList.remove("is-invalid");
        const errorMessage = input.nextElementSibling; // Menemukan elemen .error-message di bawah input
        if (errorMessage) {
          errorMessage.style.display = "none";
        }
      }
    });
  });
});

/**
   * Pengaturan Form input tangal lahir 
   */
$(document).ready(function () {
  // Inisialisasi Datepicker
  $("#dateInput").datepicker({
    dateFormat: "dd-mm-yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "1900:2100",
  });

  const dateInput = $("#dateInput");
  const dateError = dateInput.next(".error-message");

  // Event untuk validasi real-time
  dateInput.on("input change", function () {
    if (dateInput.val().trim() === "") {
      // Jika kosong, tampilkan error
      dateError.text("Kolom ini harus diisi!").show();
      dateInput.addClass("is-invalid");
    } else {
      // Jika ada nilai, sembunyikan error
      dateError.hide();
      dateInput.removeClass("is-invalid");
    }
  });

  // Validasi saat submit
  $("#myForm").on("submit", function (e) {
    e.preventDefault(); // Mencegah submit form

    let isValid = true;

    // Validasi kolom tanggal
    if (dateInput.val().trim() === "") {
      dateError.text("Kolom ini harus diisi !").show();
      dateInput.addClass("is-invalid");
      isValid = false;
    }

  });
});

/**
   * Pengaturan Form input agama 
   */
const religionSelect = document.getElementById("religion");
const religionError =
  religionSelect.parentElement.querySelector(".error-message");

// Fungsi untuk validasi kolom saat perubahan pilihan
religionSelect.addEventListener("change", function () {
  if (religionSelect.value === "") {
    religionError.style.display = "block"; // Tampilkan pesan error
    religionSelect.classList.add("is-invalid"); // Menambahkan kelas untuk border merah
  } else {
    religionError.style.display = "none"; // Sembunyikan pesan error
    religionSelect.classList.remove("is-invalid"); // Menghapus kelas border merah
  }
});

// Validasi pada form submit
document.getElementById("myForm").addEventListener("submit", function (e) {
  if (religionSelect.value === "") {
    e.preventDefault(); // Hentikan pengiriman form
    religionError.style.display = "block"; // Tampilkan pesan error
    religionSelect.classList.add("is-invalid"); // Menambahkan kelas untuk border merah
    religionSelect.focus(); // Fokus pada kolom agama
  }
});


/**
   * Pengaturan Form input perkawinan 
   */
const maritalSelect = document.getElementById("maritalStatus");
const maritalError =
  maritalSelect.parentElement.querySelector(".error-message");

// Fungsi untuk validasi kolom saat perubahan pilihan
maritalSelect.addEventListener("change", function () {
  if (maritalSelect.value === "") {
    maritalError.style.display = "block"; // Tampilkan pesan error
    maritalSelect.classList.add("is-invalid"); // Menambahkan kelas untuk border merah
  } else {
    maritalError.style.display = "none"; // Sembunyikan pesan error
    maritalSelect.classList.remove("is-invalid"); // Menghapus kelas border merah
  }
});

// Validasi pada form submit
document.getElementById("myForm").addEventListener("submit", function (e) {
  if (maritalSelect.value === "") {
    e.preventDefault(); // Hentikan pengiriman form
    maritalError.style.display = "block"; // Tampilkan pesan error
    maritalSelect.classList.add("is-invalid"); // Menambahkan kelas untuk border merah
    maritalSelect.focus(); // Fokus pada kolom agama
  }
});





