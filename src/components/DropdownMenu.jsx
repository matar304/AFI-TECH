import { useState } from "react";
import { List, ListItem, Collapse, ListItemText } from "@mui/material";
import { ExpandLess, ExpandMore } from "@mui/icons-material";

const DropdownMenu = ({ title, children }) => {
  const [open, setOpen] = useState(false);

  return (
    <>
      <ListItem button onClick={() => setOpen(!open)}>
        <ListItemText primary={title} />
        {open ? <ExpandLess /> : <ExpandMore />}
      </ListItem>
      <Collapse in={open} timeout="auto" unmountOnExit>
        <List component="div" disablePadding>
          {children}
        </List>
      </Collapse>
    </>
  );
};

export default DropdownMenu;
