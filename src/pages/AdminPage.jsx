import { Typography, Box, Grid, Paper } from "@mui/material";
import AdminNav from "../components/AdminNav";

const AdminPage = () => {
  return (
    <Box sx={{ p: 3 }}>
      <Grid container spacing={3}>
        <Grid item xs={12}>
          <Typography variant="h4" component="h1" gutterBottom>
            Espace Secrétaire
          </Typography>
        </Grid>
        <Grid item xs={3}>
          <Paper elevation={2} sx={{ p: 2 }}>
            <AdminNav />
          </Paper>
        </Grid>
        <Grid item xs={9}>
          <Paper elevation={2} sx={{ p: 3, minHeight: "70vh" }}>
            <Typography variant="h5" gutterBottom>
              Bienvenue dans l'espace d'administration
            </Typography>
            <Typography>
              Sélectionnez une option dans le menu de gauche pour commencer.
            </Typography>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default AdminPage;
