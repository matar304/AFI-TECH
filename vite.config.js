import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    port: 5174, // Port d'écoute du serveur de développement
    strictPort: true, // Force l'utilisation de ce port
    host: true, // Accessible sur le réseau local
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // Correction: port du backend Spring
        changeOrigin: true,
        secure: false,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  },
  build: {
    outDir: 'dist',
    assetsDir: 'assets',
    rollupOptions: {
      input: {
        main: './index.html'
      }
    }
  },
  base: '/'
})
