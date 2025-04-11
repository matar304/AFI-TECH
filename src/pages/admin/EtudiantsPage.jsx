import {
  Typography,
  Box,
  Paper,
  Button,
  TextField,
  Stack,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  IconButton,
  CircularProgress,
  Alert,
} from "@mui/material";
import { useState, useEffect } from "react";
import DeleteIcon from "@mui/icons-material/Delete";
import authService from "../../services/authService";

const EtudiantsPage = () => {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [addError, setAddError] = useState(null);

  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const data = await authService.getStudents();
        setStudents(data);
      } catch (error) {
        setError("Erreur lors du chargement des étudiants");
        console.error("Error fetching students:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchStudents();
  }, []);
  const [newStudent, setNewStudent] = useState({
    nom: "",
    prenom: "",
    email: "",
    matricule: "",
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewStudent((prev) => ({ ...prev, [name]: value }));
  };

  const handleAddStudent = async () => {
    if (
      newStudent.nom &&
      newStudent.prenom &&
      newStudent.email &&
      newStudent.matricule
    ) {
      try {
        setAddError(null);
        const addedStudent = await authService.addStudent(newStudent);
        setStudents([...students, addedStudent]);
        setNewStudent({ nom: "", prenom: "", email: "", matricule: "" });
      } catch (error) {
        setAddError("Erreur lors de l'ajout de l'étudiant");
        console.error("Error adding student:", error);
      }
    }
  };

  const handleDeleteStudent = async (studentId) => {
    try {
      await authService.deleteStudent(studentId);
      setStudents(students.filter((student) => student.id !== studentId));
    } catch (error) {
      console.error("Error deleting student:", error);
    }
  };

  return (
    <Box>
      <Typography variant="h5" gutterBottom>
        Gestion des étudiants
      </Typography>

      <Paper elevation={2} sx={{ p: 3, mb: 3 }}>
        <Typography variant="h6" gutterBottom>
          Ajouter un étudiant
        </Typography>
        <Stack spacing={2} direction="row" sx={{ mb: 2 }}>
          <TextField
            name="nom"
            label="Nom"
            value={newStudent.nom}
            onChange={handleInputChange}
            fullWidth
          />
          <TextField
            name="prenom"
            label="Prénom"
            value={newStudent.prenom}
            onChange={handleInputChange}
            fullWidth
          />
        </Stack>
        <Stack spacing={2} direction="row" sx={{ mb: 2 }}>
          <TextField
            name="email"
            label="Email"
            type="email"
            value={newStudent.email}
            onChange={handleInputChange}
            fullWidth
          />
          <TextField
            name="matricule"
            label="Matricule"
            value={newStudent.matricule}
            onChange={handleInputChange}
            fullWidth
          />
        </Stack>
        <Button
          variant="contained"
          onClick={handleAddStudent}
          disabled={
            !newStudent.nom ||
            !newStudent.prenom ||
            !newStudent.email ||
            !newStudent.matricule
          }
        >
          Ajouter l'étudiant
        </Button>
        {addError && (
          <Alert severity="error" sx={{ mt: 2 }}>
            {addError}
          </Alert>
        )}
      </Paper>

      <Paper elevation={2} sx={{ p: 3 }}>
        <Typography variant="h6" gutterBottom>
          Liste des étudiants
        </Typography>
        {loading ? (
          <Box display="flex" justifyContent="center" p={3}>
            <CircularProgress />
          </Box>
        ) : error ? (
          <Alert severity="error">{error}</Alert>
        ) : students.length > 0 ? (
          <TableContainer>
            <Table>
              <TableHead>
                <TableRow>
                  <TableCell>Matricule</TableCell>
                  <TableCell>Nom</TableCell>
                  <TableCell>Prénom</TableCell>
                  <TableCell>Email</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {students.map((student) => (
                  <TableRow key={student.id}>
                    <TableCell>{student.matricule}</TableCell>
                    <TableCell>{student.nom}</TableCell>
                    <TableCell>{student.prenom}</TableCell>
                    <TableCell>{student.email}</TableCell>
                    <TableCell>
                      <IconButton
                        onClick={() => handleDeleteStudent(student.id)}
                        color="error"
                        aria-label="supprimer"
                      >
                        <DeleteIcon />
                      </IconButton>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
        ) : (
          <Typography>Aucun étudiant enregistré</Typography>
        )}
      </Paper>
    </Box>
  );
};

export default EtudiantsPage;
