import {
  Typography,
  Box,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";

const NotesPage = () => {
  return (
    <Box>
      <Typography variant="h5" gutterBottom>
        Gestion des notes
      </Typography>
      <Paper elevation={2} sx={{ p: 3 }}>
        <TableContainer>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Étudiant</TableCell>
                <TableCell>Matière</TableCell>
                <TableCell>Note</TableCell>
                <TableCell>Actions</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {/* Exemple de données - à remplacer par un appel API */}
              <TableRow>
                <TableCell>Jean Dupont</TableCell>
                <TableCell>Mathématiques</TableCell>
                <TableCell>15/20</TableCell>
                <TableCell>Modifier</TableCell>
              </TableRow>
            </TableBody>
          </Table>
        </TableContainer>
      </Paper>
    </Box>
  );
};

export default NotesPage;
