import {
  List,
  ListItem,
  ListItemButton,
  ListItemText,
  ListItemIcon,
} from "@mui/material";
import { Link } from "react-router-dom";
import {
  People as PeopleIcon,
  School as SchoolIcon,
  Settings as SettingsIcon,
} from "@mui/icons-material";

const AdminNav = () => {
  return (
    <List>
      <ListItem disablePadding>
        <ListItemButton component={Link} to="/admin/etudiants">
          <ListItemIcon>
            <PeopleIcon />
          </ListItemIcon>
          <ListItemText primary="Gestion des étudiants" />
        </ListItemButton>
      </ListItem>
      <ListItem disablePadding>
        <ListItemButton component={Link} to="/admin/notes">
          <ListItemIcon>
            <SchoolIcon />
          </ListItemIcon>
          <ListItemText primary="Gestion des notes" />
        </ListItemButton>
      </ListItem>
      <ListItem disablePadding>
        <ListItemButton component={Link} to="/admin/parametres">
          <ListItemIcon>
            <SettingsIcon />
          </ListItemIcon>
          <ListItemText primary="Paramètres" />
        </ListItemButton>
      </ListItem>
    </List>
  );
};

export default AdminNav;
