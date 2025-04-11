import {
  Typography,
  Box,
  Paper,
  TextField,
  Button,
  Stack,
} from "@mui/material";

const ParametresPage = () => {
  return (
    <Box>
      <Typography variant="h5" gutterBottom>
        Paramètres
      </Typography>
      <Paper elevation={2} sx={{ p: 3 }}>
        <Stack spacing={3}>
          <TextField
            label="Année scolaire"
            variant="outlined"
            defaultValue="2023-2024"
            fullWidth
          />
          <TextField
            label="Seuil de validation"
            variant="outlined"
            type="number"
            defaultValue={10}
            fullWidth
          />
          <TextField
            label="Nombre maximal d'absences"
            variant="outlined"
            type="number"
            defaultValue={5}
            fullWidth
          />
          <Box sx={{ display: "flex", justifyContent: "flex-end" }}>
            <Button variant="contained" color="primary">
              Enregistrer les modifications
            </Button>
          </Box>
        </Stack>
      </Paper>
    </Box>
  );
};

export default ParametresPage;
