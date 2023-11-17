/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
      "./src/app/core/components/**/*.html",
  ],
  theme: {
    extend: {
      backgroundColor: {
        'custom-teal': '#69a599',
      }
    },
  },
  plugins: [],
}

