import { useState, useEffect } from "react";
import {
  Box,
  Typography,
  CircularProgress,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Drawer,
  List,
  ListItem,
  ListItemIcon,
  ListItemText,
} from "@mui/material";
import {
  School as SchoolIcon,
  Book as BookIcon,
  Assessment as NotesIcon,
  People as PeopleIcon,
} from "@mui/icons-material";
import DropdownMenu from "../components/DropdownMenu";
import axios from "axios";

const DashboardPage = () => {
  const [notes, setNotes] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchNotes = async () => {
      try {
        const token = localStorage.getItem("token");
        const response = await axios.get("/api/notes/etudiant", {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setNotes(response.data);
      } catch (err) {
        setError("Erreur lors du chargement des notes");
        console.error("Erreur API:", err);
      } finally {
        setLoading(false);
      }
    };

    fetchNotes();
  }, []);

  if (loading) {
    return (
      <Box sx={{ display: "flex", justifyContent: "center", mt: 4 }}>
        <CircularProgress />
      </Box>
    );
  }

  if (error) {
    return (
      <Box sx={{ display: "flex", justifyContent: "center", mt: 4 }}>
        <Typography color="error">{error}</Typography>
      </Box>
    );
  }

  return (
    <Box display="flex" minHeight="100vh">
      {/* Menu latéral */}
      <Drawer
        variant="permanent"
        sx={{
          width: 240,
          flexShrink: 0,
          "& .MuiDrawer-paper": {
            width: 240,
            boxSizing: "border-box",
            backgroundColor: "#f5f5f5",
          },
        }}
      >
        <List>
          <DropdownMenu title="Étudiants" icon={<PeopleIcon />}>
            <ListItem button>
              <ListItemText primary="Liste" />
            </ListItem>
            <ListItem button>
              <ListItemText primary="Ajouter" />
            </ListItem>
          </DropdownMenu>

          <DropdownMenu title="Notes" icon={<NotesIcon />}>
            <ListItem button>
              <ListItemText primary="Consulter" />
            </ListItem>
            <ListItem button>
              <ListItemText primary="Saisir" />
            </ListItem>
          </DropdownMenu>

          <DropdownMenu title="Cours" icon={<BookIcon />}>
            <ListItem button>
              <ListItemText primary="Emploi du temps" />
            </ListItem>
          </DropdownMenu>
        </List>
      </Drawer>

      {/* Contenu principal */}
      <Box component="main" flexGrow={1} p={3}>
        <Typography variant="h4" gutterBottom>
          Mes Notes
        </Typography>

        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Matière</TableCell>
                <TableCell align="right">Note</TableCell>
                <TableCell>Commentaire</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {notes.map((note) => (
                <TableRow key={note.id}>
                  <TableCell>{note.matiere}</TableCell>
                  <TableCell align="right">{note.valeur}</TableCell>
                  <TableCell>{note.commentaire}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
    </Box>
  );
};

export default DashboardPage;
