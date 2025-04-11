import { Routes, Route } from "react-router-dom";
import PrivateRoute from "./components/PrivateRoute";
import { CssBaseline, ThemeProvider, createTheme } from "@mui/material";
import ConnexionPage from "./pages/ConnexionPage";
import DashboardPage from "./pages/DashboardPage";
import HomePage from "./pages/HomePage";
import AdminPage from "./pages/AdminPage";
import EtudiantsPage from "./pages/admin/EtudiantsPage";
import NotesPage from "./pages/admin/NotesPage";
import ParametresPage from "./pages/admin/ParametresPage";
import Layout from "./components/Layout";
import authService from "./services/authService";

const theme = createTheme({
  palette: {
    primary: {
      main: "#1976d2",
    },
    secondary: {
      main: "#dc004e",
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/connexion" element={<ConnexionPage />} />
        <Route
          path="/dashboard"
          element={
            <PrivateRoute requiredRole="ROLE_ETUDIANT">
              <Layout>
                <DashboardPage />
              </Layout>
            </PrivateRoute>
          }
        />
        <Route
          path="/admin"
          element={
            <PrivateRoute requiredRole="ROLE_SECRETAIRE">
              <Layout>
                <AdminPage />
              </Layout>
            </PrivateRoute>
          }
        />
        <Route
          path="/admin/etudiants"
          element={
            <PrivateRoute requiredRole="ROLE_SECRETAIRE">
              <Layout>
                <EtudiantsPage />
              </Layout>
            </PrivateRoute>
          }
        />
        <Route
          path="/admin/notes"
          element={
            <PrivateRoute requiredRole="ROLE_SECRETAIRE">
              <Layout>
                <NotesPage />
              </Layout>
            </PrivateRoute>
          }
        />
        <Route
          path="/admin/parametres"
          element={
            <PrivateRoute requiredRole="ROLE_SECRETAIRE">
              <Layout>
                <ParametresPage />
              </Layout>
            </PrivateRoute>
          }
        />
      </Routes>
    </ThemeProvider>
  );
}

export default App;
